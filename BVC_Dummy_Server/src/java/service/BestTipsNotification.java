/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.fixprotocol.fixml_5_0.*;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0128", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0128.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0128", wsdlLocation = "META-INF/wsdl/BestTipsNotification/Service0128.wsdl")
@Stateless
public class BestTipsNotification {

    public org.fixprotocol.fixml_5_0.FIXML mejoresPuntasRqstOp(co.com.bvc.bus.Firm parameters) {
       FIXML reply = new FIXML();
        BatchT batch = new BatchT(); 
         
        MarketDataSnapshotFullRefreshMessageT mktDataFull = new MarketDataSnapshotFullRefreshMessageT();
    
        MessageHeaderT header = new MessageHeaderT();
        header.setSID("AyD");
        header.setTID("FIRM");
        header.setSSub("Afiliados");
        header.setTSub("MEJORES PUNTAS");
        header.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T10:03:12-05:00"));
        header.setOrigSnt(XMLGregorianCalendarImpl.parse("2011-06-10T10:03:12-05:00"));
        header.setMdlMsg("MEJORES PUNTAS");
        
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("ECOPETROL");
        
        MDFullGrpBlockT full = new MDFullGrpBlockT();
        full.setTyp("2");
        full.setID("");
        
        MDFullGrpBlockT full1 = new MDFullGrpBlockT();
        full1.setTyp("0");
        full1.setDepth(Float.parseFloat("145081"));
        
        MDFullGrpBlockT full2 = new MDFullGrpBlockT();
        full2.setTyp("1");        
        
        mktDataFull.getFull().add(full);
        mktDataFull.getFull().add(full1);
        mktDataFull.getFull().add(full2);
        
        mktDataFull.setHdr(header);
        mktDataFull.setInstrmt(instrmt);        
                
        QName qname = new QName("http://www.fixprotocol.org/FIXML-5-0", "MktDataFull");
        JAXBElement<MarketDataSnapshotFullRefreshMessageT> item = new JAXBElement<MarketDataSnapshotFullRefreshMessageT>(qname, MarketDataSnapshotFullRefreshMessageT.class, mktDataFull);
        batch.getMessage().add(item);
        
        // SEGUNDA PUNTA
       
        MarketDataSnapshotFullRefreshMessageT mktDataFull2 = new MarketDataSnapshotFullRefreshMessageT();
    
        MessageHeaderT header2 = new MessageHeaderT();
        header2.setSID("AyD");
        header2.setTID("FIRM");
        header2.setSSub("Afiliados");
        header2.setTSub("MEJORES PUNTAS");
        header2.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T14:15:28.926-05:00"));
        header2.setOrigSnt(XMLGregorianCalendarImpl.parse("2011-06-10T14:15:28.926-05:00"));
        header2.setMdlMsg("MEJORES PUNTAS");
        
        InstrumentBlockT instrmt2 = new InstrumentBlockT();
        instrmt2.setSym("ECOPETROL");
        
        MDFullGrpBlockT full3 = new MDFullGrpBlockT();
        full3.setTyp("2");
        full3.setID("");
        
        MDFullGrpBlockT full4 = new MDFullGrpBlockT();
        full4.setTyp("0");
        full4.setDepth(Float.parseFloat("142938"));
        
        MDFullGrpBlockT full5 = new MDFullGrpBlockT();
        full5.setTyp("1");
        
        mktDataFull2.getFull().add(full3);
        mktDataFull2.getFull().add(full4);
        mktDataFull2.getFull().add(full5);
                
        mktDataFull2.setHdr(header2);
        mktDataFull2.setInstrmt(instrmt2);  
        
        QName qname2 = new QName("http://www.fixprotocol.org/FIXML-5-0", "MktDataFull");
        JAXBElement<MarketDataSnapshotFullRefreshMessageT> item2 = new JAXBElement<MarketDataSnapshotFullRefreshMessageT>(qname2, MarketDataSnapshotFullRefreshMessageT.class, mktDataFull2);
        batch.getMessage().add(item2);
            
        reply.getBatch().add(batch);        
        return reply;
    }
    
}
