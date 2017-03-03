import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

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

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class FetchGmail3 {

	
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div[2]/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]/p[2]") private WebElementFacade verificationCode;
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[2]") private static CharSequence inboxMessageSubjectPrimaryEmailChange;

		
    public static void main(String[] args) throws MessagingException, IOException {
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flag flag = null;
 		String userName = System.getProperty("user.name");
		String outputFile = "C:\\Users\\" + userName + "\\Desktop\\FetchGmail.txt";
		String eMailFrom = "UAS.Registry@faa.gov";
		String eMailSubject = "sUAS Primary Email Change";
		String originalEmail =  "mynewfaadrone+nh1100@gmail.com";  
		Random rand = new Random();
		int randNumber = rand.nextInt(10000);
		String newEmail = "mynewfaadrone+CPE" + randNumber +  "@gmail.com"; // New Email
		
        try 
        {
          Properties props = System.getProperties();
          props.setProperty("mail.store.protocol", "imaps");
          Session session = Session.getDefaultInstance(props, null);
          store = session.getStore("imaps");
          store.connect("imap.googlemail.com","mynewfaadrone@gmail.com", "Dummy$11");
          folder = (IMAPFolder) store.getFolder("inbox"); //This works for both email account
          DateTime dateTime = new DateTime();
          System.out.println(dateTime);
          
			readGmailMessage sample = new readGmailMessage();
			sample.readGmail(newEmail, eMailFrom, eMailSubject, outputFile);
			File file = new File(outputFile);
			String searchCriteria = "<p> ";
			final Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				if(lineFromFile.contains(searchCriteria)) { 
					System.out.println(lineFromFile);
					//validationNumber = lineFromFile.substring(0, lineFromFile.length()-4).substring(3).trim();
					//System.out.println(validationNumber);
					break;}}
			scanner.close();
          
          DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
          System.out.println("Current DateTime 1 is-->" + dtf.print(dateTime));
          System.out.println("Current DateTime is 2-->" + dtf.print(dateTime));
          if(!folder.isOpen())
          folder.open(Folder.READ_ONLY);
          Message[] messages = folder.getMessages(); //  .toString().contains("Please enter the verification code to complete your primary email change");
//          getContent().toString().contains("Please enter the verification code to complete your primary email change"));
//          Message[] messages = folder.getMessages().getContent().toString().contains("Please enter the verification code to complete your primary email change"));;
          
          
          System.out.println("No of Messages : " + folder.getMessageCount());
          System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
          for(int i = 1; i < messages.length +1; i++){
//          System.out.println("Specific Messages : " +  folder.getMessages(i).getSubject().equals("Please enter the verification code to complete your primary email change."));
//          System.out.print("Specific Message -->" + folder.getMessage(i).getSubject().equals("Please enter the verification code to complete your primary email change."));
          System.out.println(messages.length);
          int unreadMsgCount = folder.getUnreadMessageCount();
//          Message emailMessage = folder.getMessage(i).getSubject().equals("Please enter the verification code to complete your primary email change."));

          
          int messageCount = folder.getMessageCount();
          System.out.println("Message Count: " + i);
          System.out.println("Total Message Count: " + messageCount);
          System.out.println("Total Unread Message Count: " + unreadMsgCount);
///          for(int i = 0; i < messageCount; i++){folder.getMessageCount()
          System.out.println("Specific Messages Subject : " +  folder.getMessage(i).getSubject().contains("sUAS Primary Email Change"));
          System.out.println("Specific Messages Subject : " +  folder.getMessage(i).getSubject().toString());
          System.out.println("Specific Messages Content : " +  folder.getMessage(i).getContent().toString().contains("Please enter the verification code to complete your primary email change"));
          System.out.println("Specific Messages Content : " +  folder.getMessage(i).getContent().toString());
          
          
//          if (inboxMessageSubjectPrimaryEmailChange.isCurrentlyVisible()) {
//              System.out.println("Inbox Messages Subjecg : " +  folder.getMessage(i).getContent().toString().contains(inboxMessageSubjectPrimaryEmailChange));
//        	  
//          }
          
          
          
          System.out.println("Specific Messages Content : " +  folder.getMessage(i).getContent().toString().contains("Please enter the verification code to complete your primary email change"));

          
          
//          Please enter the verification code to complete your primary email change.
//
//          691620
          
          //          System.out.print("Specific message--> " + folder.getMessage(i).getSubject().equals("Please enter the verification code to complete your primary email change.")));
          //int unreadMsgCount = folder.getUnreadMessageCount();
          //Message emailMessage = folder.getMessage(0);
//          	int i=0;
///////////          for(int i = 0; i < messageCount; i++){
//          	if(folder.getMessage(i).getSubject().equals("Please enter the verification code to complete your primary email change."));
//          	System.out.println("Subject: " + folder.getMessage(i).getSubject());
//            System.out.println("Subject: " + subject);
//            System.out.println("From: " + folder.getMessage(i).getFrom()[0]);
//           System.out.println("To: "+folder.getMessage(i).getAllRecipients()[0]);
//            System.out.println("Date: "+folder.getMessage(i).getReceivedDate());
//            System.out.println("Size: "+folder.getMessage(i).getSize());
//            System.out.println(folder.getMessage(i).getFlags());
//            System.out.println("Body: \n"+ folder.getMessage(i).getContent());
//            System.out.println(folder.getMessage(i).getContentType());
//          	}
///////////////          }
 //         System.out.println("Email Subject: " + emailMessage.getSubject());
//          emailMessage.setFlag(Flags.Flag.SEEN, true);
//          folder.close(true);
//          store.close();
          System.out.println("*****************************************************************************");
////            System.out.println("MESSAGE " + (i + 1) + ":");
//            Message msg =  messages[i];
//            //System.out.println(msg.getMessageNumber());
//            //Object String;
//            //System.out.println(folder.getUID(msg)
//
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
//        }
        }
        }   
        finally 
        {
          if (folder != null && folder.isOpen()) { folder.close(true); }
          if (store != null) { store.close(); }
        }

    }



}