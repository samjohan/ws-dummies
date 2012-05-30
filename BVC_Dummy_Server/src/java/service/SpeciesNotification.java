/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.fixprotocol.fixml_5_0.*;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0107", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0107.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0107", wsdlLocation = "META-INF/wsdl/SpeciesNotification/Service0107.wsdl")
@Stateless
public class SpeciesNotification {

    public org.fixprotocol.fixml_5_0.SecurityDefinitionMessageT notificacionEspeciesRqstOp(co.com.bvc.bus.Firm parameters1) {
         SecurityDefinitionMessageT reply = new SecurityDefinitionMessageT();
        
        MessageHeaderT header = new MessageHeaderT();
        header.setSID("BO");
        header.setSSub("061020");
        header.setTSub("000");
        header.setSnt(XMLGregorianCalendarImpl.parse("2011-06-10T06:00:33.868"));
        header.setOrigSnt(XMLGregorianCalendarImpl.parse("2011-06-10T06:00:33.529"));
        header.setTID("BOF");
        header.setMdlMsg("NOTIF_ESPECIES");
        reply.setHdr(header);
        
        InstrumentBlockT instrmt = new InstrumentBlockT();
        instrmt.setSym("BAC");    
        instrmt.setID("ACC");
        instrmt.setSecTyp("CS");      
        instrmt.setStatus("2");
        instrmt.setIssr("BOA");
        instrmt.setDated(XMLGregorianCalendarImpl.parse("2010-12-13"));
        instrmt.setDesc("");        
        
        EvntGrpBlockT evnt = new EvntGrpBlockT();
        evnt.setEventTyp("4003");
        evnt.setTxt("0");
        instrmt.getEvnt().add(evnt);
                
        EvntGrpBlockT evnt2 = new EvntGrpBlockT();
        evnt2.setEventTyp("4013");
        evnt2.setTxt("00");
        instrmt.getEvnt().add(evnt2);
        
        EvntGrpBlockT evnt3 = new EvntGrpBlockT();
        evnt3.setEventTyp("4015");
        evnt3.setTxt("");
        instrmt.getEvnt().add(evnt3);
        
        EvntGrpBlockT evnt4 = new EvntGrpBlockT();
        evnt4.setEventTyp("4018");
        evnt4.setTxt("0000-00-00 00:00:00");
        instrmt.getEvnt().add(evnt4);
        
        reply.setInstrmt(instrmt);
        
        InstrumentExtensionBlockT instrmtExt = new InstrumentExtensionBlockT();
        AttrbGrpBlockT attrb = new AttrbGrpBlockT();
        attrb.setTyp("4001");
        attrb.setVal("+0000000000.0000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4003");
        attrb.setVal("0000000000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4004");
        attrb.setVal("0000000000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4009");
        attrb.setVal(" ");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4005");
        attrb.setVal("");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4010");
        attrb.setVal("");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4006");
        attrb.setVal("000000000000.00");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4007");
        attrb.setVal("00000000000000.010");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4012");
        attrb.setVal("N");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4013");
        attrb.setVal("0000000000000000.00");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4014");
        attrb.setVal("00000000000000.000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4015");
        attrb.setVal("");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4016");
        attrb.setVal("A");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4017");
        attrb.setVal("00000000000026.760");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4018");
        attrb.setVal("00000000000000.000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4019");
        attrb.setVal("F");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4020");
        attrb.setVal("S");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4021");
        attrb.setVal("N");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4022");
        attrb.setVal("A");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4024");
        attrb.setVal("N");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4025");
        attrb.setVal("N");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4026");
        attrb.setVal("000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4027");
        attrb.setVal("000.00");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4028");
        attrb.setVal("000.00");        
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4029");
        attrb.setVal("+00000000021220.0000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4030");
        attrb.setVal("+00000000025900.0000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4064");
        attrb.setVal("N");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4065");
        attrb.setVal("0000000000");
        instrmtExt.getAttrb().add(attrb);
        
        attrb = new AttrbGrpBlockT();
        attrb.setTyp("4066");
        attrb.setVal("+00.00");
        instrmtExt.getAttrb().add(attrb);
        
        reply.setInstrmtExt(instrmtExt);       
        
        return reply;
    }
    
}
