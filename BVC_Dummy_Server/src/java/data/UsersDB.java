/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import org.fixprotocol.fixml_5_0.UserRequestMessageT;
import org.fixprotocol.fixml_5_0.UserResponseMessageT;

/**
 *
 * @author macrux
 */
public class UsersDB {

    private static Map<Integer, String> repliesLoginMap;
    private static Map<Integer, String> repliesLogoutMap;
    private static Map<Integer, String> repliesChangePassMap;
    private static Map<String, Long> activesSessionIds;
    private static UsersDB instance;
    private static Map<String, User> users;

    private UsersDB() {
        users = new HashMap<String, User>();
        repliesLoginMap = new HashMap<Integer, String>();
        repliesLogoutMap = new HashMap<Integer, String>();
        repliesChangePassMap = new HashMap<Integer, String>();
        activesSessionIds = new HashMap<String, Long>();

        users.put("abuelito", new User("abuelito", "agonia"));
        users.put("pana", new User("pana", "agonia"));
        users.put("pez", new User("pez", "agonia"));

        repliesLoginMap.put(4, "Su usuario o password esta incorrecto, por favor intente de nuevo");
        repliesLoginMap.put(3, "Su usuario o password esta incorrecto, por favor intente de nuevo");
        repliesLoginMap.put(6, "Usted ha excedido el numero de sesiones permitidas por usuario");

        repliesLogoutMap.put(2, "Se ha cerrado la sesion exitosamente");
        repliesLogoutMap.put(6, "La sesion ya habia sido cerrada");

        repliesChangePassMap.put(2, "Su password no se pudo cambiar correctamente por favor veirifique sus datos de entrada");
        repliesChangePassMap.put(5, "Su password se ha cambiado exitosamente");
    }

    public static UsersDB getInstance() {
        if (instance == null) {
            instance = new UsersDB();
        }
        return instance;
    }

    public String getLoginMessage(int key) {
        return repliesLoginMap.get(key);
    }

    public String getLogoutMessage(int key) {
        return repliesLogoutMap.get(key);
    }

    public String getChangePassMessage(int key) {
        return repliesChangePassMap.get(key);
    }

    public int validateUser(String username, String password) {

        User user = users.get(username);

        if (user == null) {
            return 3;
        }
        if (user.isLogged()) {
            return 6;
        }
        if (user.getPassword().equals(password)) {
            return 1;
        }

        return 4;
    }

    public void setCommonValues(UserResponseMessageT reply, UserRequestMessageT parameters) {
        reply.setUsername(parameters.getUsername());
        reply.setUserReqID(" ");
    }

    public void setLoggedState(String username, boolean state) {

        User user = users.get(username);

        if (user != null) {
            user.setLogged(state);
        }
    }

    public boolean userIsLogged(String username) {

        User user = users.get(username);

        if (user != null) {
            return user.isLogged();
        }
        return false;
    }

    //genera el sessionId para el usuario y lo asigna
    public String generateSessionId(String username) {

        User user = users.get(username);
        String sessionId = "?";

        if (user != null) {
            if (user.getSessionId().equals("?")) {
                SecureRandom random = new SecureRandom();
                sessionId = new BigInteger(50, random).toString(32) + "-" + new BigInteger(30, random).toString(32);
                user.setSessionId(sessionId);
                sessionIdRegister(sessionId);
                return sessionId;
            } else {
                sessionIdRegister(user.getSessionId());
                return user.getSessionId();
            }
        }

        return sessionId;
    }

    public void setSessionId(String username, String sessionId) {

        User user = users.get(username);

        if (user != null) {
            user.setSessionId(sessionId);
        }
    }

    public String getSessionId(String username) {

        User user = users.get(username);

        if (user != null) {
            return user.getSessionId();
        }

        return "?";
    }

    // registra el sessionId en un mapa especial para este proposito, donde le asigna al sessionId el tiempo de inicio
    public void sessionIdRegister(String sessionId) {
        Long time = System.currentTimeMillis() / 1000;
        activesSessionIds.put(sessionId, time);
    }

    public boolean sessionIdIsActive(String sessionId) {

        if (activesSessionIds.containsKey(sessionId)) {
            long timeNow = System.currentTimeMillis() / 1000;
            long sessionIdTime = activesSessionIds.get(sessionId);

            if (((timeNow - sessionIdTime) / 60) <= 4) {
                return true;
            }
        }

        return false;
    }

    public boolean sessionIdIsRegistered(String sessionId) {
        return activesSessionIds.containsKey(sessionId);
    }

    public void sessionIdUnregister(String sessionId) {

        if (activesSessionIds.containsKey(sessionId)) {
            activesSessionIds.remove(sessionId);
        }
    }

    public void setPassword(String username, String newPassword) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.setPassword(newPassword);
        }
    }
}
