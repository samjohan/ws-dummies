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
@WebService(serviceName = "Service0072", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0072.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0072", wsdlLocation = "META-INF/wsdl/MarketPricesNotification/Service0072.wsdl")
@Stateless
public class MarketPricesNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionPreciosMercadoRqstOp(co.com.bvc.bus.Firm parameters1) {
       FIXML reply = new FIXML();
        
        BatchT batch = new BatchT(); 
         
        MarketDataSnapshotFullRefreshMessageT mktDataFull = new MarketDataSnapshotFullRefreshMessageT();    
        mktDataFull.setTrdDt(XMLGregorianCalendarImpl.parse("2007-08-01"));
        
        MessageHeaderT header = new MessageHeaderT();
        header.setSID("AyD");
        header.setSSub("PM");
        header.setTSub("");
        header.setSnt(XMLGregorianCalendarImpl.parse("2007-07-17T09:30:47.0Z"));
        header.setOrigSnt(XMLGregorianCalendarImpl.parse("2007-07-17T09:30:47.0Z"));
        header.setTID("");
        header.setMdlMsg("PRECIO_MERCADO");
        mktDataFull.setHdr(header);
        
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("ISA");
        instrmt.setBoard("12345");
        instrmt.setSecTyp("CS");      
        instrmt.setInstr("AAA");
        instrmt.setStrkPx(BigDecimal.valueOf(1092.771));
        instrmt.setMatDt(XMLGregorianCalendarImpl.parse("2007-07-17"));
        instrmt.setStatus("1");
        instrmt.setFctr(BigDecimal.valueOf(12.3));
        EvntGrpBlockT evnt = new EvntGrpBlockT();
        evnt.setEventTyp("1");
        instrmt.getEvnt().add(evnt);
        mktDataFull.setInstrmt(instrmt);
                
        UndInstrmtGrpBlockT undly = new UndInstrmtGrpBlockT();
        undly.setSym("BBB");
        undly.setBoard("XXX");
        mktDataFull.getUndly().add(undly);
        
        InstrmtLegGrpBlockT leg = new InstrmtLegGrpBlockT();
        leg.setSym("XXX");
        leg.setBoard("ABBB");
        mktDataFull.getLeg().add(leg);
        
        MDFullGrpBlockT full = new MDFullGrpBlockT();
        full.setTyp("2");
        full.setPx(BigDecimal.valueOf(1626.0));
        full.setHighPx(BigDecimal.valueOf(2000));
        full.setLowPx(BigDecimal.valueOf(1233.0));
        full.setDt(XMLGregorianCalendarImpl.parse("2007-07-17"));
        full.setTm(XMLGregorianCalendarImpl.parse("09:30:47"));
        full.setPxDelta(BigDecimal.valueOf(1.0));
        full.setSettlDt(XMLGregorianCalendarImpl.parse("2007-07-17"));
        full.setSesID("ASDF");
        full.setPrevDt("2007-07-17");
        full.setLastQty(10234f);
        full.setTrdQty(999f);
        mktDataFull.getFull().add(full);
        
        MDFullGrpBlockT full2 = new MDFullGrpBlockT();
        full2.setTyp("0");
        full2.setPx(BigDecimal.valueOf(1023.999));
        full2.setNumOfOrds(10);
        full2.setBuyer("AAA");
        full2.setYieldPx(123.02f);
        full2.setDepth(12f);
        full2.setBalance(9876.982f);
        full2.setAutoPx(123.23f);
        full2.setShrd("N");
        full2.setManPx(1234.3f);
        full2.setLvlPx(123f);
        full2.setLvlLength(12f);
        mktDataFull.getFull().add(full2); 
        
        MDFullGrpBlockT full3 = new MDFullGrpBlockT();
        full3.setTyp("1");
        full3.setPx(BigDecimal.valueOf(1023.999));
        full3.setNumOfOrds(10);
        full3.setYieldPx(123.02f);
        full3.setDepth(12f);
        full3.setBalance(9876.982f);
        full3.setAutoPx(123.23f);
        full3.setShrd("N");
        full3.setManPx(1234.3f);
        full3.setLvlPx(123f);
        full3.setLvlLength(12f);
        mktDataFull.getFull().add(full3); 
        
        MDFullGrpBlockT full4 = new MDFullGrpBlockT();
        full4.setTyp("4");
        full4.setPx(BigDecimal.valueOf(2000));
        mktDataFull.getFull().add(full4);
        
        MDFullGrpBlockT full5 = new MDFullGrpBlockT();
        full5.setTyp("5");
        full5.setPx(BigDecimal.valueOf(1500));
        mktDataFull.getFull().add(full5);
        
        MDFullGrpBlockT full6 = new MDFullGrpBlockT();
        full6.setTyp("B");
        full6.setPx(BigDecimal.valueOf(200000));
        full6.setTrdVol(BigDecimal.valueOf(100));
        mktDataFull.getFull().add(full6);
        
        MDFullGrpBlockT full7 = new MDFullGrpBlockT();
        full7.setTyp("E");
        full7.setPx(BigDecimal.valueOf(1500));
        mktDataFull.getFull().add(full7);    
        
        MDFullGrpBlockT full9 = new MDFullGrpBlockT();
        full9.setTyp("H");
        full9.setPx(BigDecimal.valueOf(2000));
        full9.setLowPx(BigDecimal.valueOf(123.212));
        full9.setHighPx(BigDecimal.valueOf(2323.92));
        full9.setYieldPx(334.3f);
        full9.setDepth(333f);
        full9.setYieldLow(12.22f);
        full9.setYieldHigh(44.2f);
        mktDataFull.getFull().add(full9); 
        
        MDFullGrpBlockT full10 = new MDFullGrpBlockT();
        full10.setTyp("100");
        full10.setOpenPx(123f);
        full10.setHighPx(BigDecimal.valueOf(123));
        full10.setLowPx(BigDecimal.valueOf(32));
        full10.setPxDelta(BigDecimal.valueOf(100));
        full10.setClosePx(123f);
        full10.setLastPx(123.22f);        
        mktDataFull.getFull().add(full10);
        
        MDFullGrpBlockT full11 = new MDFullGrpBlockT();
        full11.setTyp("101");
        full11.setPx(BigDecimal.valueOf(123));
        full11.setLastPx(123f);
        full11.setLastQty(10f);
        full11.setTrdVol(BigDecimal.valueOf(1230));
        mktDataFull.getFull().add(full11);   
        
        InfoBlockT info = new InfoBlockT();
        info.setInfoTyp(97);
        info.setInfoID("AAA");
        mktDataFull.getInfo().add(info);
                
        InfoBlockT info2 = new InfoBlockT();
        info2.setInfoTyp(98);
        info2.setInfoID("CCC");
        mktDataFull.getInfo().add(info2);
        
        InfoBlockT info3 = new InfoBlockT();
        info3.setInfoTyp(99);
        info3.setInfoID("DDD");
        mktDataFull.getInfo().add(info3);
        
        InfoBlockT info4 = new InfoBlockT();
        info4.setInfoTyp(100);
        info4.setInfoID("EEE");
        mktDataFull.getInfo().add(info4);
        
        InfoBlockT info5 = new InfoBlockT();
        info5.setInfoTyp(101);
        info5.setInfoID("FFF");
        mktDataFull.getInfo().add(info5);
        
        InfoBlockT info6 = new InfoBlockT();
        info6.setInfoTyp(102);
        info6.setInfoID("GGG");
        mktDataFull.getInfo().add(info6);
        
        InfoBlockT info7 = new InfoBlockT();
        info7.setInfoTyp(103);
        info7.setInfoID("HHH");
        mktDataFull.getInfo().add(info7);
        
        InfoBlockT info8 = new InfoBlockT();
        info8.setInfoTyp(54);
        info8.setInfoID("N");
        mktDataFull.getInfo().add(info7);
        
        InfoBlockT info9 = new InfoBlockT();
        info9.setInfoTyp(69);
        info9.setInfoID("0");
        mktDataFull.getInfo().add(info9);
        
        InfoBlockT info10 = new InfoBlockT();
        info10.setInfoTyp(104);
        info10.setInfoID("123.2");
        mktDataFull.getInfo().add(info10);
        
        InfoBlockT info11 = new InfoBlockT();
        info11.setInfoTyp(107);
        info11.setInfoID("01010010111100001");
        mktDataFull.getInfo().add(info11);
        
        InfoBlockT info12 = new InfoBlockT();
        info12.setInfoTyp(117);
        info12.setInfoID("2007-01-01");
        mktDataFull.getInfo().add(info12);
        
        InfoBlockT info13 = new InfoBlockT();
        info13.setInfoTyp(139);
        info13.setInfoID("2008-05-07T10:30:00.000");
        mktDataFull.getInfo().add(info13);
        
        QName qname = new QName("http://www.fixprotocol.org/FIXML-5-0", "MktDataFull");
        JAXBElement<MarketDataSnapshotFullRefreshMessageT> item = new JAXBElement<MarketDataSnapshotFullRefreshMessageT>(qname, MarketDataSnapshotFullRefreshMessageT.class, mktDataFull);
        batch.getMessage().add(item);
                
        reply.getBatch().add(batch);
        return reply;
    }
    
}
