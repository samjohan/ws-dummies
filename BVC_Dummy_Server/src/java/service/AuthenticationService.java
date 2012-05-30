/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import data.UsersDB;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.fixprotocol.fixml_5_0.UserResponseMessageT;

/**
 *
 * @author macrux
 */
@WebService(serviceName = "Service9999", portName = "portTypeEndpoint", endpointInterface = "co.com.bvc.services.service9999.PortType", targetNamespace = "http://www.bvc.com.co/Services/Service9999", wsdlLocation = "META-INF/wsdl/AuthenticationService/Service9999.wsdl")
@Stateless
public class AuthenticationService {

 public org.fixprotocol.fixml_5_0.UserResponseMessageT cambioContrasenaOp(org.fixprotocol.fixml_5_0.UserRequestMessageT parameters1) {

        UserResponseMessageT reply = new UserResponseMessageT();
        UsersDB query = UsersDB.getInstance();
        query.setCommonValues(reply, parameters1);

        int validationReply = query.validateUser(parameters1.getUsername(), parameters1.getPassword());
        
        if (validationReply == 1 || validationReply == 6) {
            query.setPassword(parameters1.getUsername(), parameters1.getNewPassword());            
            reply.setUserStat(5);
            reply.setUserStatText(query.getChangePassMessage(5));
        
        } else {
            reply.setUserStat(2);
            reply.setUserStatText(query.getChangePassMessage(2));
        
        }        

        return reply;

    }

    public org.fixprotocol.fixml_5_0.UserResponseMessageT logInOp(org.fixprotocol.fixml_5_0.UserRequestMessageT parameters3) {

        UserResponseMessageT reply = new UserResponseMessageT();
        UsersDB query = UsersDB.getInstance();
        query.setCommonValues(reply, parameters3);

        // revisa si el usuario y la contraseña son correctos. validationReply es 1 si ambos datos son correctos
        int validationReply = query.validateUser(parameters3.getUsername(), parameters3.getPassword());
        reply.setUserStat(validationReply);

        if (validationReply == 1) {
            // activa el usuario como logged
            query.setLoggedState(parameters3.getUsername(), true);
            // genera el sessionId para el usuario
            String sessionId = query.generateSessionId(parameters3.getUsername());
            reply.setUserStatText(sessionId);

        } else {
            reply.setUserStatText(query.getLoginMessage(validationReply));
        }

        showSessionID();
        
        return reply;
    }

    public org.fixprotocol.fixml_5_0.UserResponseMessageT logOutOp(org.fixprotocol.fixml_5_0.UserRequestMessageT parameters5) {

        UserResponseMessageT reply = new UserResponseMessageT();
        UsersDB query = UsersDB.getInstance();
        query.setCommonValues(reply, parameters5);

        String sessionId = query.getSessionId(parameters5.getUsername());
        boolean registeredSession = query.sessionIdIsRegistered(sessionId);

        if (registeredSession) {

            boolean activeSession = query.sessionIdIsActive(sessionId);

            //ticket activo
            if (activeSession) {

                query.setLoggedState(parameters5.getUsername(), false);
                //elimina el sessionIf del mapa de sessiones activas
                query.sessionIdUnregister(sessionId);
                reply.setUserStat(2);
                reply.setUserStatText(query.getLogoutMessage(2));
                //ticket vencido    
            } else {
                query.setLoggedState(parameters5.getUsername(), false);
                query.sessionIdUnregister(sessionId);
                reply.setUserStat(6);
                reply.setUserStatText(query.getLogoutMessage(6));
            }
            //ticket invalido 
        } else {
            query.setLoggedState(parameters5.getUsername(), false);
            query.sessionIdUnregister(sessionId);
            reply.setUserStat(6); // deberia tener un valor = 6, pero se pone 8 para diferenciar que entro por aqui
            reply.setUserStatText(query.getLogoutMessage(6));
        }

        return reply;
    }
    
    @Resource
    WebServiceContext wsctx;    
    private void showSessionID() {
        MessageContext mctx = (MessageContext) wsctx.getMessageContext();
        Map httpHeaders = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        System.out.println("****  List of headers: " + httpHeaders.toString());
        List sessionIDList = (List) httpHeaders.get("SessionID");

        if(sessionIDList != null && !sessionIDList.isEmpty()) {
            String sessionID = (String)sessionIDList.get(0);
            System.out.println("********  este es el header SessionID: " + sessionID);
        } else {
            System.out.println("********  header SessionID es null");
        }
    }    
}
