package prj.cardealershipnew.MailService;

import prj.cardealershipnew.projectUtils.Xeger;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtils {
    private final String CONTA_PADRAO = "ran100Motors@hotmail.com";
    private final String SENHA_CONTA_PADRAO = "R4!Noo12022";

    private static String currentTempToken ;

    final String emailsubject = "Ran100 Motors  Email Verification";
    //Note: you can use the date function just like these strings
   // final String msg = " this email from a java program.";

    public void Email(String emailReceiver) {

        //Set the session of email
        final Session newsession = Session.getInstance(this.Eprop(), new Authenticator() {
            @Override
            //password authenication
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);
            }
        });
        //MimeMessage to take user input
        try {
            final Message newmes = new MimeMessage(newsession);
            newmes.setRecipient(Message.RecipientType.TO, new InternetAddress(emailReceiver));
            String sender = "ran100Motors@hotmail.com";
            newmes.setFrom(new InternetAddress(sender));
            newmes.setSubject(emailsubject); //Takes email subject
            newmes.setText(structMessage ());
            newmes.setSentDate(new Date()); //You can set the date of the email here
            Transport.send(newmes);// Transfort the email

            System.out.println("Email sent!");
        } catch (final MessagingException ex) { //exception to catch the errors
            ex.printStackTrace();
        }
    }
    //The permenant set of prperties containg string keys, the following configuration enables the SMPTs to function
    public Properties Eprop() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        //Define contstant strings and set properties of the email
        String SERVIDOR_SMTP = "smtp.office365.com";
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        int PORTA_SERVIDOR_SMTP = 587;
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        return config;
    }

    private String generateVerificationToken(){

        String vinGen = "[0-9]{4}";
        Xeger vinGenByRegex = new Xeger(vinGen);
        String t = vinGenByRegex.generate();
        SendMailUtils.currentTempToken = t;
        return t;
    }


    private String structMessage () {
        return    "                      Verify your email address\n" +
                "  To verify your email address, enter this code in your browser.\n" +
                "        \n" +
                "                       Code: [ " + generateVerificationToken() +" ]\n" +
                "\n" +
                "  If you did not request a code, you can safely ignore this email.\n" +
                "\n" +
                "                                      Questions? Contact us"

                ;

    }

    public static  String getVerificationToken() {

        return  SendMailUtils.currentTempToken;
    }

}