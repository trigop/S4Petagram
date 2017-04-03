package es.tamareo.s4petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import es.tamareo.s4petagram.activity.AboutActivity;
import es.tamareo.s4petagram.activity.ContactoActivity;
import es.tamareo.s4petagram.activity.MascotasFavoritasActivity;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.nuevaToolbar);

        if (toolbar != null) {

            toolbar.setLogo(R.drawable.logo);
            //toolbar.setTitleMarginStart(20);
            toolbar.setTitle("Petagram");
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);

            //getSupportActionBar().setTitle("Texto");

        }


    }




    //Menu de Opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;

            case R.id.mFavoritos:
                Intent ii = new Intent(this, MascotasFavoritasActivity.class);
                startActivity(ii);
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
