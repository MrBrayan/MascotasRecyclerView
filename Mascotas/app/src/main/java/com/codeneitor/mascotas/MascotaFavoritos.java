package com.codeneitor.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MascotaFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas ;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_favoritos);
        //Agregamos nuestro ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        //Agregamos soporte al botón de navegación hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Agregamos la huella en nuestro Toolbar
        getSupportActionBar().setIcon(R.drawable.huella);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //listaMascotas.setLayoutManager(glm);

        iniciarListaContactos();
        iniciarAdaptador();

    }

    public MascotaAdaptador adaptador;
    public void iniciarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarListaContactos(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.gyo2,"Gardfield y Oddye 2",8));
        mascotas.add(new Mascota(R.drawable.oddie,"Oddie",9));
        mascotas.add(new Mascota(R.drawable.garfield,"Gardfield",5));
        mascotas.add(new Mascota(R.drawable.gyo,"Gardfield y Oddye 1",4));
        mascotas.add(new Mascota(R.drawable.gato,"Gato",3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_favoritos, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent about = new Intent(MascotaFavoritos.this, AboutActivity.class);
                startActivity(about);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
