package com.example.android_practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_practica9.models.Equipo;

public class MainActivity4 extends AppCompatActivity {

    ImageView escudo;
    TextView equipoescudo,descripcionequipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ImageView escudo = findViewById(R.id.escudo);
        TextView equipoescudo = findViewById(R.id.equipoescudo);
        TextView descripcionequipo = findViewById(R.id.descripcionequipo);
        Equipo equipo = (Equipo) getIntent().getSerializableExtra("Equipo");

        if(equipo != null){
            escudo.setImageResource(equipo.getImagen());
            equipoescudo.setText(equipo.getNombre());
            if(equipo.getNombre().equals("Santos")){
                descripcionequipo.setText("El Club Santos Laguna S.A. de C.V., más conocido como Santos Laguna o simplemente Santos, es un club de fútbol profesional con sede en Torreón, Coahuila, México. ");
            }
            else if(equipo.getNombre().equals("Chivas")){
                descripcionequipo.setText("El Club Deportivo Guadalajara S. A. de C. V., más conocido como Guadalajara, Chivas Rayadas del Guadalajara o simplemente Chivas, es un club de fútbol profesional con sede en Guadalajara, Jalisco, México");
            }
            else{
                descripcionequipo.setText("EQUIPO CHICO XDDDDDDDD");
            }
        }
        else{
            escudo.setImageResource(R.drawable.santos);
            equipoescudo.setText("Santos");
            descripcionequipo.setText("Torreón");
        }

    }
}