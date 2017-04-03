package es.tamareo.s4petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.tamareo.s4petagram.R;

public class ContactoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

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



                Toast.makeText(ContactoActivity.this, "Contacto!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
