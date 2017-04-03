package es.tamareo.s4petagram.activity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import es.tamareo.s4petagram.R;


public class ContactoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;
    private TextView contactName;
    private TextView contactEmail;
    private TextView contactBody;

    Session session;

    private String correo;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        correo = "cga@tamareo.es";
        pass = "XXXXXX";


        toolbar = (Toolbar) findViewById(R.id.toolBarNoFragment);

        if (toolbar != null){

            toolbar.setLogo(R.drawable.logo);
            toolbar.setTitle(getResources().getString(R.string.contactLabel));
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        button = (Button) findViewById(R.id.contactBtnSendEmail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactName = (TextView) findViewById(R.id.contactName);
                String cname = "Nombre: " + contactName.getText().toString() + "\r";

                contactEmail = (TextView) findViewById(R.id.contactEmail);
                String cemail = "Email: " + contactEmail.getText().toString() + "\r";

                contactBody = (TextView) findViewById(R.id.contactBody);
                String cbody = "Body: " + contactBody.getText().toString() + "\r";

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");


                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, pass);
                        }
                    });


                    if (session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Correo desde Android!");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pacomont@gmail.com"));
                        message.setContent(cname + cemail + cbody, "text/html;charset=utf-8");
                        Transport.send(message);
                        Toast.makeText(ContactoActivity.this, getResources().getString(R.string.alertSendMail), Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ContactoActivity.this, getResources().getString(R.string.alertSendMailKO), Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
