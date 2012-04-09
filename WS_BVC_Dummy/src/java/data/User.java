/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author macrux
 */
public class User {
    
    private String username;
    private String password;
    private boolean logged;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.logged = false;
        this.sessionId = "?";
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean state) {
        this.logged = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }    
}
