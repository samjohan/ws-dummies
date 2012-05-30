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
@WebService(serviceName = "Service0074", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0074.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0074", wsdlLocation = "META-INF/wsdl/IndicesNotification/Service0074.wsdl")
@Stateless
public class IndicesNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionIndicesFirmasRqstOp(co.com.bvc.bus.Firm parameters) {
        FIXML reply = new FIXML();
        BatchT batch = new BatchT(); 
         
        // PRIMER INDICE        
        MarketDataSnapshotFullRefreshMessageT mktDataFull = new MarketDataSnapshotFullRefreshMessageT();    
        mktDataFull.setTrdDt(XMLGregorianCalendarImpl.parse("2011-06-10"));        
        
        MessageHeaderT header = new MessageHeaderT();
        header.setSID("AyD");
        header.setSSub("IB");
        header.setTSub("");
        header.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T11:45:10.514-05:00"));
        header.setMdlMsg("INDICE_BOLSA");
        
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("ICAP");
        instrmt.setSecTyp("CS");        
      
        MDFullGrpBlockT full = new MDFullGrpBlockT();
        full.setTyp("3");
        full.setPx(BigDecimal.valueOf(1741.2));
        full.setDt(XMLGregorianCalendarImpl.parse("2011-06-10"));
        full.setTm(XMLGregorianCalendarImpl.parse("11:45:07"));
        full.setPxDelta(BigDecimal.valueOf(0.32));
        full.setTxt("ICAP");
        
        mktDataFull.setHdr(header);
        mktDataFull.setInstrmt(instrmt);
        mktDataFull.getFull().add(full);
        
        QName qname = new QName("http://www.fixprotocol.org/FIXML-5-0", "MktDataFull");
        JAXBElement<MarketDataSnapshotFullRefreshMessageT> item = new JAXBElement<MarketDataSnapshotFullRefreshMessageT>(qname, MarketDataSnapshotFullRefreshMessageT.class, mktDataFull);
        batch.getMessage().add(item);
        
        //SEGUNDO INDICE
        
        MarketDataSnapshotFullRefreshMessageT mktDataFull2 = new MarketDataSnapshotFullRefreshMessageT();    
        mktDataFull2.setTrdDt(XMLGregorianCalendarImpl.parse("2011-06-10"));        
        
        MessageHeaderT header2 = new MessageHeaderT();
        header2.setSID("AyD");
        header2.setSSub("IB");
        header2.setTSub("");
        header2.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T11:45:10.514-05:00"));
        header2.setMdlMsg("INDICE_BOLSA");
        
        InstrumentBlockT instrmt2 = new InstrumentBlockT();
        instrmt2.setSym("IGBC");
        instrmt2.setSecTyp("CS");        
      
        MDFullGrpBlockT full2 = new MDFullGrpBlockT();
        full2.setTyp("3");
        full2.setPx(BigDecimal.valueOf(14352.99));
        full2.setDt(XMLGregorianCalendarImpl.parse("2011-06-10"));
        full2.setTm(XMLGregorianCalendarImpl.parse("11:45:07"));
        full2.setPxDelta(BigDecimal.valueOf(5.78));
        full2.setTxt("IGBC");
        
        mktDataFull2.setHdr(header);
        mktDataFull2.setInstrmt(instrmt);
        mktDataFull2.getFull().add(full);
        
        QName qname2 = new QName("http://www.fixprotocol.org/FIXML-5-0", "MktDataFull");
        JAXBElement<MarketDataSnapshotFullRefreshMessageT> item2 = new JAXBElement<MarketDataSnapshotFullRefreshMessageT>(qname2, MarketDataSnapshotFullRefreshMessageT.class, mktDataFull2);
        batch.getMessage().add(item2);
        
        
        reply.getBatch().add(batch);
        return reply;
    }
    
}
