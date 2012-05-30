/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import data.OrdersDB;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.fixprotocol.fixml_5_0.InstrumentBlockT;
import org.fixprotocol.fixml_5_0.MessageHeaderT;
import org.fixprotocol.fixml_5_0.OrderStatusRequestMessageT;

/**
 *
 * @author James
 */
@WebService(serviceName = "Service0001", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0001.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0001", wsdlLocation = "META-INF/wsdl/AutomaticOrderInsertion/Service0001.wsdl")
//@WebService(serviceName = "Service0001", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0001.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0001", wsdlLocation = "META-INF/wsdl/Service0001.wsdl")
@Stateless
public class AutomaticOrderInsertion {

    public org.fixprotocol.fixml_5_0.OrderStatusRequestMessageT ingresoAutomaticoOrdenesRqRpOp(org.fixprotocol.fixml_5_0.NewOrderSingleMessageT parameters1) {
        
        OrdersDB query = OrdersDB.getInstance();
        String orderID = query.getRandomId();
        
        parameters1.setID(orderID);
        
        query.insertOrder(parameters1);
        
        OrderStatusRequestMessageT reply = new OrderStatusRequestMessageT();
        
        
        //TODO revisar que este totalmente deacuerdo al FOI
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
        hdr.setOrigSnt(query.convertToXMLGregorianCalendar(Calendar.getInstance()));
        hdr.setSID(parameters1.getHdr().getSID());
        hdr.setSnt(query.convertToXMLGregorianCalendar(Calendar.getInstance()));
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