package faa.cucumber.pages;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.Flags.Flag;
public class ReadGmailMessagePage {
	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	private String userName = "mynewfaadrone@gmail.com";
	private String password = "Dummy$11";
	public void readGmail(String newEmail, String eMailFrom, String eMailSubject, String tmpEmailMessageFile) {
		properties = new Properties();
		properties.setProperty("mail.host", "imap.gmail.com");
		properties.setProperty("mail.port", "995");
		properties.setProperty("mail.transport.protocol", "imaps");
		properties.setProperty("mail.imaps.ssl.enable", "true");
		properties.setProperty("mail.imaps.connectiontimeout", "600000");
		properties.setProperty("mail.imaps.timeout", "600000");
		try {
			System.setOut(new PrintStream(new FileOutputStream(tmpEmailMessageFile)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		try {
			store = session.getStore("imaps");
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.search(new FlagTerm(
					new Flags(Flag.SEEN), false));
			Arrays.sort( messages, ( m1, m2 ) -> {
				try {
					return m2.getSentDate().compareTo( m1.getSentDate() );
				} catch ( MessagingException e ) {
					throw new RuntimeException( e );
				}
			} );
			System.out.println("Number of unread email(s) in INBOX = " + messages.length);
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				Address[] from = message.getFrom();
				Address[] to = message.getAllRecipients();
				String eMailTo = newEmail;
				Pattern p = Pattern.compile(eMailFrom);
				Matcher m = p.matcher(from[0].toString());
				boolean fromMatches = m.find();
				if (to[0].toString().equals(eMailTo) && fromMatches == true &&
						message.getSubject().toString().equals(eMailSubject)) { i=messages.length;
						System.out.println("*******************************************************************");
						System.out.println("Date : " + message.getSentDate());
						System.out.println("From : " + from[0]);
						System.out.println("To : " + to[0]);
						System.out.println("Subject: " + message.getSubject());
						System.out.println("Content :");
						processMessageBody(message);}
			}
			inbox.close(true);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public void processMessageBody(Message message) {
		try {
			Object content = message.getContent();
			if (content instanceof String) {
				System.out.println(content);
			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				@SuppressWarnings("resource")
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					System.out.write(ch);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public void procesMultiPart(Multipart content) throws FileNotFoundException {
		try {
			int multiPartCount = content.getCount();
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;
				o = bodyPart.getContent();
				if (o instanceof String) {
					System.out.println(o);
				} else if (o instanceof Multipart) {
					procesMultiPart((Multipart) o);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
