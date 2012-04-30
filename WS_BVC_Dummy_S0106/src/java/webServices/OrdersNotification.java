/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.fixprotocol.fixml_5_0.*;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0106", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0106.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0106", wsdlLocation = "META-INF/wsdl/OrdersNotification/Service0106.wsdl")
@Stateless
public class OrdersNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionOrdenesRqstOp(co.com.bvc.bus.Firm parameters1) {
    
        FIXML reply = new FIXML();             
        BatchT batch = new BatchT();

        XMLGregorianCalendar xmlgreg = XMLGregorianCalendarImpl.parse("2011-06-10");
        
        //setting order
        NewOrderSingleMessageT order = new NewOrderSingleMessageT();
        order.setID("20110610-000000007188");
        
        order.setTrdDt(xmlgreg);
        order.setHandlInst("3");
        order.setSide("2");        
        order.setTxnTm(xmlgreg);        
        order.setPx(BigDecimal.valueOf(8));
        order.setUnmatchQty("533");
        order.setTmInForce("7");
        order.setActionOnLogoff("0");
        order.setTrackingTyp("4");
        order.setTrdQty("0");
        order.setMatchQty("0");
        order.setTyp("2");

        //setting header of order
        MessageHeaderT header = new MessageHeaderT();
        header.setOrigSnt(XMLGregorianCalendarImpl.parse("2011-06-10T15:12:41"));
        header.setSID("AyD");
        header.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T15:12:41.861"));
        header.setMdlMsg("NOTIFICACION_ORDENES");
        order.setHdr(header);

        //setting pty of order
        PartiesBlockT pty = new PartiesBlockT();
        pty.setID("045");
        pty.setR("1");
        PtysSubGrpBlockT sub = new PtysSubGrpBlockT();
        sub.setID("N");
        sub.setTyp("28");
        pty.getSub().add(sub);
        order.getPty().add(pty);
        
        PartiesBlockT pty2 = new PartiesBlockT();
        pty2.setID("045004");
        pty2.setR("12");
        PtysSubGrpBlockT sub2 = new PtysSubGrpBlockT();
        sub2.setID("29533350");
        sub2.setTyp("4007");
        PtysSubGrpBlockT sub22 = new PtysSubGrpBlockT();
        sub22.setID("CC");
        sub22.setTyp("4001");
        pty2.getSub().add(sub2);
        pty2.getSub().add(sub22);
        order.getPty().add(pty2);
        
        PartiesBlockT pty3 = new PartiesBlockT();
        pty3.setID("045004");
        pty3.setR("4012");
        order.getPty().add(pty3);
        
        PartiesBlockT pty4 = new PartiesBlockT();
        pty4.setR("17");
        order.getPty().add(pty4);
        
        PartiesBlockT pty5 = new PartiesBlockT();
        pty5.setR("14");
        PtysSubGrpBlockT sub5 = new PtysSubGrpBlockT();
        sub5.setTyp("4023");
        
        //setting DsplyInstr of pty
        DisplayInstructionBlockT dsplyInstr = new DisplayInstructionBlockT();
        dsplyInstr.setDisplayQty(BigDecimal.valueOf(533));
        order.setDsplyInstr(dsplyInstr);

        //setting Instrmt of order
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("EEB_S0E3C");
        instrmt.setCFI("RPEEB");
        instrmt.setSecTyp("REPO");
        instrmt.setBoard("REPO");
        order.setInstrmt(instrmt);

        //
        TriggeringInstructionBlockT trgrIntru = new TriggeringInstructionBlockT();
        order.setTrgrInstr(trgrIntru);

        //setting yield of order
        YieldDataBlockT yield = new YieldDataBlockT();
        order.setYield(yield);

        //
        OrderQtyDataBlockT ordQty = new OrderQtyDataBlockT();
        ordQty.setQty(BigDecimal.valueOf(533));
        order.setOrdQty(ordQty);

        //
        StrategyParametersGrpBlockT strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("sessDurationId");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("positionType");
        strpPrmGrp.setStrtPrmVal("0");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("mktPriceData");
        order.getStrpPrmGrp().add(strpPrmGrp);

        strpPrmGrp.setStrtPrmNme("externalOrderId");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("crossing");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("orderType");
        strpPrmGrp.setStrtPrmVal("N");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("shared");
        strpPrmGrp.setStrtPrmVal("N");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("futurePrice");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("enteredFuturePrice");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("CancelReason");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp.setStrtPrmNme("Short_Sell");
        strpPrmGrp.setStrtPrmVal("N");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("Pre_Arrange");
        strpPrmGrp.setStrtPrmVal("N");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("Repo_days");
        strpPrmGrp.setStrtPrmVal("3");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("Repo_Settlement_Days");
        strpPrmGrp.setStrtPrmVal("2011-06-13");
        order.getStrpPrmGrp().add(strpPrmGrp);
        
        strpPrmGrp = new StrategyParametersGrpBlockT();
        strpPrmGrp.setStrtPrmNme("Custom Order Id");
        order.getStrpPrmGrp().add(strpPrmGrp);        
        
        //setting TrdRegTS of order
        TrdRegTimestampsBlockT trdRegTS = new TrdRegTimestampsBlockT();
        trdRegTS.setTS(XMLGregorianCalendarImpl.parse("2011-06-10T15:12:41"));
        trdRegTS.setTyp("100");
        order.getTrdRegTS().add(trdRegTS);

        //setting first info
        InfoBlockT info1 = new InfoBlockT();
        info1.setInfoID("1");
        info1.setInfoTyp(63);
        order.getInfo().add(info1);

        //setting second info
        InfoBlockT info2 = new InfoBlockT();
        info2.setInfoID("N");
        info2.setInfoTyp(95);
        order.getInfo().add(info2);

        InfoBlockT info3 = new InfoBlockT();
        info3.setInfoTyp(95);
        order.getInfo().add(info3);
        
        InfoBlockT info4 = new InfoBlockT();
        info4.setInfoID("");
        info4.setInfoTyp(91);
        order.getInfo().add(info4);
  
        //setting batch
        batch.getOrder().add(order);
        reply.getBatch().add(batch);

        showSessionID();
        return reply;
    }
    
    
    @Resource
    WebServiceContext wsctx;
    
    private void showSessionID() {
        MessageContext mctx = (MessageContext) wsctx.getMessageContext();
        Map httpHeaders = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        System.out.println("****  List of headers: " + httpHeaders.toString());
        List sessionIDList = (List) httpHeaders.get("SessionID");

        if (sessionIDList != null && !sessionIDList.isEmpty()) {
            String sessionID = (String) sessionIDList.get(0);
            System.out.println("********  este es el header SessionID: " + sessionID);
        } else {
            System.out.println("********  header SessionID es null");
        }
    }    
}
