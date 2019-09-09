package com.example.library;

import android.os.Bundle;

import com.example.library.Fragment.CategoriasFragment;
import com.example.library.Fragment.ConfiguracionFragment;
import com.example.library.Fragment.FavoritosFragment;
import com.example.library.Fragment.HistorialFragment;
import com.example.library.Fragment.PrestamosFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private HistorialFragment historialFragment = new HistorialFragment();
    private ConfiguracionFragment configuracionFragment = new ConfiguracionFragment();
    private FavoritosFragment favoritosFragment = new FavoritosFragment();
    private PrestamosFragment prestamosFragment = new PrestamosFragment();
    private CategoriasFragment categoriasFragment = new CategoriasFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //TOOLBAR
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //BOTON FLOTANTE
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //ASIGNAR XML A LA CLASE DRAW :v
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //NO SE QUE ES PERO NO LO TOQUEN :v
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //ESTO ACTIVA LOS BOTONES DEL DRAW :v
        navigationView.setNavigationItemSelectedListener(this);
    }

    // NO TOCAR
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // NO TOCAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    // NO TOCAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_historial) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, historialFragment).commit();
        } else if (id == R.id.nav_prestamos) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, prestamosFragment).commit();
        } else if (id == R.id.nav_favoritos) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, favoritosFragment).commit();
        } else if (id == R.id.nav_categorias) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, categoriasFragment).commit();
        } else if (id == R.id.nav_configuracion) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, configuracionFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
