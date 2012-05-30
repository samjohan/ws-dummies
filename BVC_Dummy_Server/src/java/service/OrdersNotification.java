/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import data.OrdersDB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.fixprotocol.fixml_5_0.FIXML;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service0106", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service0106.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service0106", wsdlLocation = "META-INF/wsdl/OrdersNotification/Service0106.wsdl")
@Stateless
public class OrdersNotification {

    public org.fixprotocol.fixml_5_0.FIXML notificacionOrdenesRqstOp(co.com.bvc.bus.Firm parameters1) {
      
       FIXML reply = new FIXML();
       OrdersDB query = OrdersDB.getInstance();
       reply.getBatch().add(query.getBatch());
       
       return reply;
    }
    
}
