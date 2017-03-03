import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;
import java.util.Date;

import org.joda.time.DateTime;
//import org.joda.convert.FromString;
//import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;


public class FetchGmail {


    public static void main(String[] args) throws MessagingException, IOException {
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flag flag = null;
        try 
        {
          Properties props = System.getProperties();
          props.setProperty("mail.store.protocol", "imaps");
          Session session = Session.getDefaultInstance(props, null);
          store = session.getStore("imaps");
          store.connect("imap.googlemail.com","mynewfaadrone@gmail.com", "Dummy$11");

          //folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work for other email account
          folder = (IMAPFolder) store.getFolder("inbox"); //This works for both email account

        //html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]/p[2]

          DateTime dateTime = new DateTime();
          System.out.println(dateTime);
          DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
          System.out.println("Current DateTime 1 is-->" + dtf.print(dateTime));
        
          
       //String dateTime2 =  new DateTime();   //"10/28/2016 07:00:00";
       // Format for input
       //DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
       // Parsing the date
       //DateTime jodatime = dtf.parseDateTime(dateTime);
       // Format for output
       //DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
       // Printing the date
       System.out.println("Current DateTime is 2-->" + dtf.print(dateTime));
       
          
          if(!folder.isOpen())
          folder.open(Folder.READ_WRITE);
          Message[] messages = folder.getMessages();
          int messageCount = folder.getMessageCount();
          System.out.println("No of Messages : " + folder.getMessageCount());
          System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
          System.out.println(messages.length);
          
//          for(int i=0; i=messageCount; i++){
//      		if(emailInbox.getMessage(i).getSubject().equals("Please enter the verification code to complete your primary email change.")){
//      		System.out.println("Subject: " + emailInbox.getMessage(i).getSubject());
//      		}
//      	}
          
          
//          for (int i=0; i < messages.length;i++) 
//          {

            System.out.println("*****************************************************************************");
//            System.out.println("MESSAGE " + (i + 1) + ":");
//            Message msg =  messages[i];
            //System.out.println(msg.getMessageNumber());
            //Object String;
            //System.out.println(folder.getUID(msg)

//            subject = msg.getSubject();
//
//            System.out.println("Subject: " + subject);
//            System.out.println("From: " + msg.getFrom()[0]);
//           System.out.println("To: "+msg.getAllRecipients()[0]);
//            System.out.println("Date: "+msg.getReceivedDate());
//            System.out.println("Size: "+msg.getSize());
//            System.out.println(msg.getFlags());
//            System.out.println("Body: \n"+ msg.getContent());
//            System.out.println(msg.getContentType());
//
//          }
        }
        finally 
        {
          if (folder != null && folder.isOpen()) { folder.close(true); }
          if (store != null) { store.close(); }
        }

    }



}