package es.tamareo.s4petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import es.tamareo.s4petagram.activity.AboutActivity;
import es.tamareo.s4petagram.activity.ContactoActivity;
import es.tamareo.s4petagram.activity.MascotasFavoritasActivity;
import es.tamareo.s4petagram.adapter.PageAdapter;
import es.tamareo.s4petagram.fragment.PerfilFragment;
import es.tamareo.s4petagram.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.nuevaToolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        if (toolbar != null) {

            toolbar.setLogo(R.drawable.logo);
            //toolbar.setTitleMarginStart(20);
            toolbar.setTitle("Petagram");
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);

            setupViewPager();

            //getSupportActionBar().setTitle("Texto");

        }


    }


    //Método nuestro que devulve un array con los fragments
    private ArrayList<Fragment> addFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }

    private void setupViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile_icon);

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
