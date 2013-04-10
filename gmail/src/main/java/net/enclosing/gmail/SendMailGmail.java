package net.enclosing.gmail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailGmail {

    private String gmailAccount;
    private String gmailPassword;
    private String mailTo;
    private String mailSubject;
    private String mailBody;

    private static final Properties PROP;
    static {
        PROP = new Properties();
        PROP.put("mail.smtp.host", "smtp.gmail.com");
        PROP.put("mail.smtp.port", "587");
        PROP.put("mail.smtp.auth", "true");
        PROP.put("mail.smtp.starttls.enable", "true");
    }

    /**
     * 
     */
    public SendMailGmail() {

    }
    
    /**
     * Gmailアカウントをセットする。
     * @param str
     */
    public void setGmailAccount(String str) {
        this.gmailAccount = str;
    }

    /**
     * Gmailパスワードをセットする。
     * @param str
     */
    public void setGmailPassword(String str) {
        this.gmailPassword = str;
    }

    /**
     * メールの宛先をセットする。
     * @param str
     */
    public void setMailTo(String str) {
        this.mailTo = str;
    }

    /**
     * メールの件名をセットする。
     * @param str
     */
    public void setMailSubject(String str) {
        this.mailSubject = str;
    }

    /**
     * メールの本文をセットする。
     * @param str
     */
    public void setMailBody(String str) {
        this.mailBody = str;
    }

    /**
     * メールを送信する。
     * @throws MessagingException
     */
    public void send() throws MessagingException {

        Transport transport = null;

        try {
            Session sess = Session.getInstance(PROP);
            MimeMessage mm = new MimeMessage(sess);

            mm.setFrom(new InternetAddress(this.gmailAccount));
            mm.setSubject(this.mailSubject, "ISO-2022-JP");
            mm.setRecipient(Message.RecipientType.TO, new InternetAddress(
                    this.mailTo));
            mm.setContent(this.mailBody, "text/plain; charset=iso-2022-jp");
            mm.setHeader("Content-Transfer-Encoding", "7bit");

            transport = sess.getTransport("smtp");
            transport.connect(this.gmailAccount, this.gmailPassword);
            transport.sendMessage(mm, mm.getAllRecipients());
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }
}