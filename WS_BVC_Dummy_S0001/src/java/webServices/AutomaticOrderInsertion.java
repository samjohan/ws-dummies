/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import data.OrdersDB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.fixprotocol.fixml_5_0.InstrumentBlockT;
import org.fixprotocol.fixml_5_0.MessageHeaderT;
import org.fixprotocol.fixml_5_0.OrderStatusRequestMessageT;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0001", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0001.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0001", wsdlLocation = "META-INF/wsdl/AutomaticOrderInsertion/Service0001.wsdl")
@Stateless
public class AutomaticOrderInsertion {

    public org.fixprotocol.fixml_5_0.OrderStatusRequestMessageT ingresoAutomaticoOrdenesRqRpOp(org.fixprotocol.fixml_5_0.NewOrderSingleMessageT parameters1) {
        
        OrdersDB query = OrdersDB.getInstance();
        String orderID = query.getRandomId();
        query.insertOrder(orderID, parameters1);
        
        OrderStatusRequestMessageT reply = new OrderStatusRequestMessageT();
        
        // setting order status request message
        reply.setOrdID(orderID);
        reply.setID(query.getRandomId());
        reply.setSide(parameters1.getSide());
        reply.setStatReqID(query.getRandomId());
        reply.setAction(parameters1.getAction());
        
        // setting header
        MessageHeaderT hdr = new MessageHeaderT();
        hdr.setSSub(parameters1.getHdr().getSSub());
        hdr.setTSub(parameters1.getHdr().getTSub());
        hdr.setOrigSnt(XMLGregorianCalendarImpl.parse(query.getCurrentTime()));
        hdr.setSID(parameters1.getHdr().getSID());
        hdr.setSnt(XMLGregorianCalendarImpl.parse(query.getCurrentTime()));
        hdr.setMdlMsg("CONFIRMACION_ORDEN");
        
        reply.setHdr(hdr);
        
        //setting InstrumentBlock
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym(parameters1.getInstrmt().getSym());
        instrmt.setSecTyp(parameters1.getInstrmt().getSecTyp());
         
        reply.setInstrmt(instrmt);
        
        return reply;
        
    }    
}
