package com.marca.folcloricas;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class Biografias extends Activity {
    MediaPlayer diazSound, farySound, floresSound, juradoSound, montielSound, pantojaSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biografias);

        GridLayout mainGrid = (GridLayout) findViewById(R.id.maingrid);
        diazSound = MediaPlayer.create(this,R.raw.marujitadiaz);
        farySound = MediaPlayer.create(this, R.raw.fary);
        floresSound = MediaPlayer.create(this, R.raw.lolaflores);
        juradoSound = MediaPlayer.create(this, R.raw.rociojurado);
        montielSound = MediaPlayer.create(this, R.raw.saramontiel);
        pantojaSound = MediaPlayer.create(this, R.raw.isabelpantoja);

        lanzarEvento(mainGrid);

    }

    private void lanzarEvento(GridLayout mainGrid){
        // Se recogen los hijos del gridview
        for(int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI ==0){
                        diazSound.start();
                        Intent intent = new Intent(Biografias.this, DiazActivity.class);
                        startActivity(intent);
                    }else if(finalI==1){
                        farySound.start();
                        Intent intent = new Intent(Biografias.this, FaryActivity.class);
                        startActivity(intent);
                    }else if(finalI==2){
                        floresSound.start();
                        Intent intent = new Intent(Biografias.this, FloresActivity.class);
                        startActivity(intent);
                    }else if(finalI==3){
                        juradoSound.start();
                        Intent intent = new Intent(Biografias.this, JuradoActivity.class);
                        startActivity(intent);
                    }else if(finalI==4){
                        montielSound.start();
                        Intent intent = new Intent(Biografias.this, MontielActivity.class);
                        startActivity(intent);
                    }else if(finalI==5){
                        pantojaSound.start();
                        Intent intent = new Intent(Biografias.this, PantojaActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }
}
