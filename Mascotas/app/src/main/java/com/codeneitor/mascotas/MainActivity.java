package com.codeneitor.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas ;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Agregamos nuestro ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
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


        /*
        ArrayList<String> nombreMascotas= new ArrayList<>();
        for(Mascota mascota : mascotas){
            nombreMascotas.add(mascota.getNombre());
        }
        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);
        lstMascotas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreMascotas ));

        lstMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MascotaDetalle.class);
                intent.putExtra("Foto",mascotas.get(position).getFoto());
                intent.putExtra("Nombre",mascotas.get(position).getNombre());
                intent.putExtra("Likes",mascotas.get(position).getLikes());
                startActivity(intent);
                //finish();
            }
        });
        */
    }

    public MascotaAdaptador adaptador;
    public void iniciarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.garfield,"Gardfield",5));
        mascotas.add(new Mascota(R.drawable.oddie,"Oddie",9));
        mascotas.add(new Mascota(R.drawable.gyo,"Oddye",4));
        mascotas.add(new Mascota(R.drawable.gyo2,"Gardfield y Oddye",8));
        mascotas.add(new Mascota(R.drawable.gato,"Gardfield",3));
        mascotas.add(new Mascota(R.drawable.garfield,"Gardfield",2));
        mascotas.add(new Mascota(R.drawable.oddie,"Oddie",4));
        mascotas.add(new Mascota(R.drawable.gyo,"Oddye",9));
        mascotas.add(new Mascota(R.drawable.gyo2,"Gardfield y Oddye",8));
        mascotas.add(new Mascota(R.drawable.gato,"Gardfield",3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mfav:
            case R.id.mFavoritos:
                Intent favs = new Intent(MainActivity.this, MascotaFavoritos.class);
                startActivity(favs);
            break;

            case R.id.mAbout:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
