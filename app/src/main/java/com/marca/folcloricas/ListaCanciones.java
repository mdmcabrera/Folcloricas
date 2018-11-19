package com.marca.folcloricas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaCanciones extends AppCompatActivity {

        ArrayList<Cancion> dataModels;
        ListView listView;
        private static Adapter adapter;
        String nombre ="fary";

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_list_canciones);


            listView=(ListView)findViewById(R.id.list);
            dataModels= new ArrayList<>();
            dataModels.add(new Cancion("EL FARY", "MANDANGA"));
            dataModels.add(new Cancion("ISABEL PANTOJA", "SE ME ENAMORA EL ALMA"));
            dataModels.add(new Cancion("SARA MONTIEL", "LOS NARDOS"));
            dataModels.add(new Cancion("ROCIO JURADO", "COMO UNA OLA"));
            dataModels.add(new Cancion("LOLA FLORES", "TORBELLINO DE COLORES"));
            dataModels.add(new Cancion("MARUJITA DIAZ", "LA TARANTULA"));



            adapter= new Adapter(dataModels,getApplicationContext());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Cancion dataModel= dataModels.get(position);

                    if(dataModel.getName()=="EL FARY"){
                        nombre="fary";
                        Intent Fary = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Fary.putExtra("name", nombre);
                        startActivity(Fary);

                    }
                    if(dataModel.getName()=="ISABEL PANTOJA"){
                        nombre="isabel";
                        Intent Isabel = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Isabel.putExtra("name", nombre);
                        startActivity(Isabel);

                    }
                    if(dataModel.getName()=="SARA MONTIEL"){
                        nombre="sara";
                        Intent Sara = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Sara.putExtra("name", nombre);
                        startActivity(Sara);

                    }
                    if(dataModel.getName()=="ROCIO JURADO"){
                        nombre="rocio";
                        Intent Rocio = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Rocio.putExtra("name", nombre);
                        startActivity(Rocio);

                    }
                    if(dataModel.getName()=="LOLA FLORES"){
                        nombre="lola";
                        Intent Lola = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Lola.putExtra("name", nombre);
                        startActivity(Lola);

                    }
                    if(dataModel.getName()=="MARUJITA DIAZ"){
                        nombre="marujita";
                        Intent Marujita = new Intent(ListaCanciones.this, reproductor_musica.class);
                        Marujita.putExtra("name", nombre);
                        startActivity(Marujita);

                    }
                }
            });
        }

    }

