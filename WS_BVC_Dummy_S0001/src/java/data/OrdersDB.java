/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;
import org.fixprotocol.fixml_5_0.NewOrderSingleMessageT;

/**
 *
 * @author macrux
 */
public class OrdersDB {
    
    private static OrdersDB instance;
    Map<String, NewOrderSingleMessageT> orders;
    
    private OrdersDB(){
        orders = new HashMap<String, NewOrderSingleMessageT>();
    }
    
    public static OrdersDB getInstance() {
        if (instance == null) {
            instance = new OrdersDB();
        }
        return instance;
    }

    public String getRandomId() {
        SecureRandom random = new SecureRandom();
        String randomId = new BigInteger(50, random).toString(32); 
        return randomId;
    }

    public void insertOrder(String orderID, NewOrderSingleMessageT parameters1) {
        orders.put(orderID, parameters1);
    }

    public String getCurrentTime() {
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat hora = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String currentTime = fecha.format(cal.getTime()) + "T"
                + hora.format(cal.getTime());
        return currentTime;
    }
    
}
