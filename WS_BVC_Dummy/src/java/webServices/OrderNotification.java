/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import data.UsersDB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.bind.JAXBElement;
import org.fixprotocol.fixml_5_0.BatchHeaderT;
import org.fixprotocol.fixml_5_0.BatchT;
import org.fixprotocol.fixml_5_0.FIXML;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0106", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0106.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0106", wsdlLocation = "META-INF/wsdl/OrderNotification/Service0106.wsdl")
@Stateless
public class OrderNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionOrdenesRqstOp(co.com.bvc.bus.Firm parameters1) {
        
        FIXML reply = new FIXML();
        UsersDB query = UsersDB.getInstance();
        String sessionId = parameters1.getId();
        boolean registeredSession = query.sessionIdIsRegistered(sessionId);
        
        if (registeredSession) {
            
            boolean activeSession = query.sessionIdIsActive(sessionId);
            
            if (activeSession) {
                
            } else {
            //TODO Implementar else si es necesarrio
            }
            
        } else {
            //TODO Implementar else si es necesarrio
        }
        
        //JAXBElement
        
//        BatchT batch = new BatchT();
//        BatchHeaderT bh = new BatchHeaderT();
//        JAXBElement jaxbel = new JAXBElement(null, null, batch);
        
        
        
        reply.getBatch();
        
                
                
        
        
                
        
        return reply;
        
    }
    
}
