/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.fixprotocol.fixml_5_0.BatchT;
import org.fixprotocol.fixml_5_0.NewOrderSingleMessageT;

/**
 *
 * @author macrux
 */
public class OrdersDB {
    
    private static OrdersDB instance;
    private BatchT batch;
    
    private OrdersDB(){
        batch = new BatchT();
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

    public void insertOrder(NewOrderSingleMessageT order){
        //TODO completar orden para que quede de acuerdo al FOI de s0106
        QName qname = new QName("http://www.fixprotocol.org/FIXML-5-0", "Order");
        JAXBElement<NewOrderSingleMessageT> item = new JAXBElement<NewOrderSingleMessageT>(qname, NewOrderSingleMessageT.class, order);
        batch.getMessage().add(item);
    }

    public BatchT getBatch() {
        return batch;
    }
    
    /**
     * Convierte una fecha tipo Calendar en XMLGregorianCalendar normalizado a formato "yyyy-MM-dd'T'HH:mm:ss"
     * @param date fecha
     * @return XMLGregorianCalendar normalizado
     */
    public XMLGregorianCalendar convertToXMLGregorianCalendar(Calendar date) {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String dateInFormat = formatDate.format(date.getTime());
        XMLGregorianCalendar fechaXMLGregorian = XMLGregorianCalendarImpl.parse(dateInFormat);
        return fechaXMLGregorian;
    }
   
}