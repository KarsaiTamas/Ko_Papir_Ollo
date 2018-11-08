package com.example.karsa.ko_papir_ollo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView Player_Kep;
    private ImageView Gep_Kep;
    private TextView Eredmeny_Text;
    private TextView Valasztasod_Text;
    private TextView Gep_Valasztas_Text;
    private Button Ko_Gomb;
    private Button Papir_Gomb;
    private Button Ollo_Gomb;
    private int valasztott_ertek=0;
    private Random rnd=new Random();
    private int gep_ertek=0;
    private int player_eredmeny=0;
    private int gep_eredmeny=0;

    public void Valtozok(){

        Player_Kep=(ImageView)findViewById(R.id.Player_Kep);
        Gep_Kep=(ImageView)findViewById(R.id.Gep_Kep);
        Eredmeny_Text=(TextView)findViewById(R.id.Eredmeny_Text);
        Valasztasod_Text=(TextView)findViewById(R.id.Valasztasod_Text);
        Gep_Valasztas_Text=(TextView)findViewById(R.id.Gep_Valasztas_Text);
        Ko_Gomb=(Button)findViewById(R.id.Ko_Gomb);
        Papir_Gomb=(Button)findViewById(R.id.Papir_Gomb);
        Ollo_Gomb=(Button)findViewById(R.id.Ollo_Gomb);

    }
    public void Nyertes(){
        if (gep_ertek==valasztott_ertek){
            Toast.makeText(MainActivity.this, "Senki nem nyert", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==0 && valasztott_ertek==1){
            player_eredmeny++;
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==1 && valasztott_ertek==2){
            player_eredmeny++;
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==2 && valasztott_ertek==0){
            player_eredmeny++;
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==1 && valasztott_ertek==0){
            gep_eredmeny++;
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==2 && valasztott_ertek==1){
            gep_eredmeny++;
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
        }else if(gep_ertek==0 && valasztott_ertek==2){
            gep_eredmeny++;
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Senki nem nyert", Toast.LENGTH_SHORT).show();
        }

    }

    public void Gep_Valaszt(){
        gep_ertek=(int)rnd.nextInt(3);
        if (gep_ertek==0){
            Gep_Kep.setImageResource(R.drawable.rock);
        }else
        if (gep_ertek==1){
            Gep_Kep.setImageResource(R.drawable.paper);
        }else
        if (gep_ertek==2){
            Gep_Kep.setImageResource(R.drawable.scissors);
        }else{
            Gep_Kep.setImageResource(R.drawable.rock);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Valtozok();

        Ko_Gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player_Kep.setImageResource(R.drawable.rock);
                valasztott_ertek=0;
                Gep_Valaszt();
                Nyertes();
                Eredmeny_Text.setText("Eredmény: Ember: "+player_eredmeny+" pont Gép: "+gep_eredmeny+" pont");

            }
        });
        Papir_Gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player_Kep.setImageResource(R.drawable.paper);
                valasztott_ertek=1;

                Gep_Valaszt();
                Nyertes();
                Eredmeny_Text.setText("Eredmény: Ember: "+player_eredmeny+" pont Gép: "+gep_eredmeny+" pont");
            }
        });
        Ollo_Gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player_Kep.setImageResource(R.drawable.scissors);
                valasztott_ertek=2;

                Gep_Valaszt();
                Nyertes();
                Eredmeny_Text.setText("Eredmény:\n Ember: "+player_eredmeny+" pont Gép: "+gep_eredmeny+" pont");
            }
        });



    }
}
