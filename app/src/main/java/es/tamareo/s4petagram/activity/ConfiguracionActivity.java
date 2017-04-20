package es.tamareo.s4petagram.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import es.tamareo.s4petagram.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private Button button;
    private TextInputEditText textInputEditText;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        toolbar = (Toolbar) findViewById(R.id.toolBarNoFragment);

        if (toolbar != null){

            toolbar.setLogo(R.drawable.logo);
            toolbar.setTitle(getResources().getString(R.string.contactLabel));
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        textInputEditText = (TextInputEditText) findViewById(R.id.username_instagram);

        SharedPreferences miPreferenciaCompartida = getSharedPreferences("Configuracion", Context.MODE_PRIVATE);
        String username = miPreferenciaCompartida.getString("usernameInstagram", "");

        textInputEditText.setText(username);


        button = (Button) findViewById(R.id.btn_username_instagram);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences miPreferenciaCompartida = getSharedPreferences("Configuracion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = miPreferenciaCompartida.edit();

                textInputEditText = (TextInputEditText) findViewById(R.id.username_instagram);
                String username = textInputEditText.getText().toString();

                editor.putString("usernameInstagram", username);

                editor.commit();




            }
        });



    }
}
