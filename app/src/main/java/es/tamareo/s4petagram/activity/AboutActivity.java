package es.tamareo.s4petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import es.tamareo.s4petagram.R;

public class AboutActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = (Toolbar) findViewById(R.id.toolBarNoFragment);

        if (toolbar != null){

            toolbar.setLogo(R.drawable.logo);
            toolbar.setTitle(getResources().getString(R.string.aboutLabel));
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
}
