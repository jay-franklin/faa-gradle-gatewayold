import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.*;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class JavaMailSearchInbox {

	@FindBy(css = "div[class*='a3s aXjCH'] div p:nth-child(2)") static WebElementFacade gmailChangePrimaryEmailVerificationCode;
	String a = "Please enter the verification code to complete your primary email change.";
	String b = "If your primary email was changed without";
	

  public static void main(String args[]) throws Exception {

    // mail server info
	  //        store.connect("imap.googlemail.com","mynewfaadrone@gmail.com", "Dummy$11");
    String host = "imap.googlemail.com";
    String user = "mynewfaadrone@gmail.com";
    String password = "Dummy$11";
    
	//div[class^='a3s aXjCH'] div p:nth-child(2)


    // connect to my pop3 inbox in read-only mode
    Properties properties = System.getProperties();
    Session session = Session.getDefaultInstance(properties);
    Store store = session.getStore("imaps");
    store.connect(host, user, password);
    Folder inbox = store.getFolder("inbox");
    inbox.open(Folder.READ_ONLY);

    // search for all "unseen" messages
    Flags seen = new Flags(Flags.Flag.SEEN);
    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
    Message messages[] = inbox.search(unseenFlagTerm);
    //By.cssSelector("div[class*='a3s aXjCH'] div p:nth-child(2)");
    
    //Message messages[] = inbox.search(sUAS Primary Email Change);
    
    if (messages.length == 0) System.out.println("No messages found.");

    //messages[i].getSubject().contains("sUAS Primary Email Change");
    for (int i = 0; i < messages.length; i++) {
      // stop after listing ten messages
      if (i > 20) {
        System.exit(0);
        inbox.close(true);
        store.close();
      }
      if (messages[i].getSubject().contains("sUAS Primary Email Change")){
      System.out.println("Message " + (i + 1));
      System.out.println("From : " + messages[i].getFrom()[0]);
      System.out.println("Subject : " + messages[i].getSubject());
//      System.out.println("Subject : " + getVerificationNumber()); 
      System.out.println("Content : " + messages[i].getContent().toString());   // substring("<p> 131674 </p>"));//  gmailChangePrimaryEmailVerificationCode.));
//      System.out.println("Subject : " + gmailChangePrimaryEmailVerificationCode.getText());
      //By.cssSelector("div[class*='a3s aXjCH'] div p:nth-child(2)").toString());
      System.out.println("Sent Date : " + messages[i].getSentDate());
      System.out.println();
    }
    }
    inbox.close(true);
    store.close();
  }
}