package com.example.matinal.material11;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Material11 extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material11);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigator);
        titulo = getResources().getString(R.string.menu1_1);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (navigationView !=null){
            configuraDrawer(navigationView);
        }

        if(savedInstanceState == null){
            respuesta(titulo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)){
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this, "OPCION 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(this, "OPCION 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                Toast.makeText(this, "OPCION 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion4:
                Toast.makeText(this, "OPCION 4", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void configuraDrawer (NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                titulo = menuItem.getTitle().toString();
                respuesta(titulo);
                return false;
            }
        });
    }

    private void respuesta (String titulo){
        //Toast.makeText(this, titulo, Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawers();
        Fragment fragment = Fragmentos.newInstance(titulo);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenido, fragment).commit();
        //setTitle(titulo);

    }
}
