/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.fixprotocol.fixml_5_0.*;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0002", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0002.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0002", wsdlLocation = "META-INF/wsdl/OperationsNotification/Service0002.wsdl")
@Stateless
public class OperationsNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionOperacionesRqstOp(co.com.bvc.bus.Firm parameters1) {
       FIXML reply = new FIXML();
        BatchT batch = new BatchT();
        
        AllocationInstructionMessageT allocInstrctn = new AllocationInstructionMessageT();
        allocInstrctn.setID("000022");
        allocInstrctn.setTransTyp("0");
        allocInstrctn.setTyp("9");
        allocInstrctn.setSide("1");
        allocInstrctn.setAvgPx(BigDecimal.valueOf(106.995));
        allocInstrctn.setTrdDt(XMLGregorianCalendarImpl.parse("2011-06-10"));
        allocInstrctn.setTxnTm(XMLGregorianCalendarImpl.parse("2011-06-10T10:03:12-05:00"));
        allocInstrctn.setGrossTrdAmt(BigDecimal.valueOf(222311));
        allocInstrctn.setIntAtMat(BigDecimal.valueOf(6.961));
        
        MessageHeaderT header = new MessageHeaderT();
        header.setSID("BO");
        header.setTID("BOF");
        header.setSSub("061019");
        header.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T10:03:12-05:00"));
        header.setOrigSnt(XMLGregorianCalendarImpl.parse("2011-06-10T10:03:12-05:00"));
        header.setMdlMsg("NOTIFICACION_CALCE_RESUMIDO");
        allocInstrctn.setHdr(header);
        
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("BAAA1039VA");        
        instrmt.setSecTyp("DPUB");
        allocInstrctn.setInstrmt(instrmt);
        
        PartiesBlockT pty = new PartiesBlockT();
        pty.setID("TRD");
        pty.setR("76");
        allocInstrctn.getPty().add(pty);
        
        InfoBlockT info = new InfoBlockT();
        info.setInfoID("T");
        info.setInfoTyp(60);
        allocInstrctn.getInfo().add(info);
        
        InfoBlockT info1 = new InfoBlockT();
        info1.setInfoID("N");
        info1.setInfoTyp(63);
        allocInstrctn.getInfo().add(info1);
                
        InfoBlockT info2 = new InfoBlockT();
        info2.setInfoID("O");
        info2.setInfoTyp(7);       
        allocInstrctn.getInfo().add(info2);   
        
        QName qname = new QName("http://www.fixprotocol.org/FIXML-5-0", "AllocInstrctn");
        JAXBElement<AllocationInstructionMessageT> item = new JAXBElement<AllocationInstructionMessageT>(qname, AllocationInstructionMessageT.class, allocInstrctn);
        batch.getMessage().add(item);
      
        reply.getBatch().add(batch);
        return reply;
    }
    
}
