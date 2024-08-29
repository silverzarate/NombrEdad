package com.utic.nombredad;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;
    //arreglos
    private String nombres [] = {"Samuel", "Valentina", "Santiago", "Alejandro", "Valeria",
            "Benjamin",
            "Gerardo", "Carlos", "David", "Sofía"};
    private String edades [] = {"18", "25", "32", "17", "24", "20", "27", "15", "19",
            "23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //intrucciones
        tv1=findViewById(R.id.tv1);
        lv1=findViewById(R.id.lv1);
        ArrayAdapter adactador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres);
        lv1.setAdapter(adactador);

        //eventos
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                tv1.setText("La Edad de  "+lv1.getItemAtPosition(position)+" es: "+edades[position]);

            }
        });

    }
}