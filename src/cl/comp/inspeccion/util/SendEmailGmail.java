package cl.comp.inspeccion.util;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cl.comp.inspeccion.vo.Alerta;

/*
 * clase utilitaria para el envio de correos
 */
public class SendEmailGmail
{   
		
	public static String sendAlert (Alerta alerta, String smtp) {		
		return sendEmailSMTP(alerta, smtp);
	}
	

	
	private static String sendEmailSMTP(Alerta alerta, String smtp) {
		  String resString = null;
		  
		  final String username = Utils.getProperty("smtp.origen.correo");
		  final String password = Utils.getProperty("smtp.origen.pass");

	      // Sender's email ID needs to be mentioned
	      String from = alerta.getEmailFrom();

	      // Assuming you are sending email from localhost
	      String host = smtp; //smtp.gmail.com

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server	      
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.transport.protocol","smtp");
	      //properties.put("mail.smtp.auth", "false");
	      //properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");
	      properties.put("mail.smtp.user", username);
	      properties.put("mail.smtp.password", password);
	      properties.put("mail.smtp.port", "587");
	      properties.setProperty("mail.user", alerta.getEmailFrom());


	      // Get the default Session object.
	      Session session = Session.getInstance(properties, null);
	      
	      /*Session session = Session.getInstance(properties,
	    		  new javax.mail.Authenticator() {
	    			protected PasswordAuthentication getPasswordAuthentication() {
	    				return new PasswordAuthentication(username, password);
	    			}
	    		  });*/

	      try{
	    	// Recipient's email ID needs to be mentioned.
			 String address = alerta.getEmailTo();
			 InternetAddress[] iAdressArray = InternetAddress.parse(address);
			 
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO, iAdressArray);

	         // Set Subject: header field
	         message.setSubject(alerta.getSubject());

	         // Now set the actual message
	         //message.setText(alerta.getText());
	         message.setContent(alerta.getText(), "text/html; charset=utf-8");

	         // Send message
	         //Transport.send(message);
	         Transport transport = session.getTransport("smtp");
	         transport.connect("smtp.gmail.com", username, password);
	         //System.out.println("Transport: "+transport.toString());
	         transport.sendMessage(message, message.getAllRecipients());
	         
	         resString= "Sent message successfully....";
	      }catch (MessagingException mex) {
	    	  resString = mex.getMessage();
	         mex.printStackTrace();
	      }
	      
	      return resString;
	   }
		
	
	
	}
	
	
	
	

