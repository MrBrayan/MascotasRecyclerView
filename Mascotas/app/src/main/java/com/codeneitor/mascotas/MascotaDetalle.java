package com.codeneitor.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by b41n on 2/01/19.
 */

public class MascotaDetalle extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mascota);
        //Agregamos nuestro ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        //Agregamos soporte al botón de navegación hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Agregamos la huella en nuestro Toolbar
        getSupportActionBar().setIcon(R.drawable.huella);

        Bundle parametros = getIntent().getExtras();
        int foto = parametros.getInt(getResources().getString(R.string.pfoto));
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String likes = parametros.getString(getResources().getString(R.string.plikes));

        ImageView imvMascota = (ImageView) findViewById(R.id.imvMascota);
        TextView tvMascotaNombre = (TextView) findViewById(R.id.tvMascotaNombre);
        TextView tvMascotaLikes = (TextView) findViewById(R.id.tvMascotaLikes);

        imvMascota.setImageResource(foto);
        tvMascotaNombre.setText(nombre);
        tvMascotaLikes.setText(likes);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MascotaDetalle.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
