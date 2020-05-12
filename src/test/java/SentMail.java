

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SentMail {

	public static void main(String[] args) throws UnsupportedEncodingException {
		 Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication("roboticautomation2019@gmail.com","Ayushman1!");  
          }    
         });    
         //compose message    
         try {    
          /*MimeMessage message = new MimeMessage(session);    
          message.addRecipient(Message.RecipientType.TO,new InternetAddress("roboticautomation2019@gmail.com"));    
          message.setSubject("hello Test");    
          message.setText("My test");    
          //send message  
          Transport.send(message);    
          System.out.println("message sent successfully");  */  
        	 
        	 MimeMessage msg = new MimeMessage(session);
             msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
    	     msg.addHeader("format", "flowed");
    	     msg.addHeader("Content-Transfer-Encoding", "8bit");
    	      
    	     msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

    	     msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

    	     msg.setSubject("Test mail with Image", "UTF-8");

    	     msg.setSentDate(new Date());

    	     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("roboticautomation2019@gmail.com"));
    	      
             // Create the message body part
             BodyPart messageBodyPart = new MimeBodyPart();

             messageBodyPart.setText("find mail as report");
             
             // Create a multipart message for attachment
             Multipart multipart = new MimeMultipart();

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

             // Second part is image attachment
             messageBodyPart = new MimeBodyPart();
             String filename = System.getProperty("user.dir")+"/target/cucumber-JVM-reports/cucumber-html-reports/overview-features.html";
             DataSource source = new FileDataSource(filename);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName(filename);
             //Trick is to add the content-id header here
             messageBodyPart.setHeader("Content-ID", "image_id");
             multipart.addBodyPart(messageBodyPart);

             //third part for displaying image in the email body
             messageBodyPart = new MimeBodyPart();
             messageBodyPart.setContent("<h1>Attached Image</h1>" +
            		     "<img src= filename>", "text/html");
             multipart.addBodyPart(messageBodyPart);
             
             //Set the multipart message to the email message
             msg.setContent(multipart);

             // Send message
             Transport.send(msg);
             System.out.println("EMail Sent Successfully with image!!");
         } catch (MessagingException e) {throw new RuntimeException(e);}    
            
   
	}

}
