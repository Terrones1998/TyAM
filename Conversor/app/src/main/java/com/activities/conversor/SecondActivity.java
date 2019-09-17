package com.activities.conversor;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.Locale;
import android.content.res.Configuration;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.ajustes);
        setSupportActionBar(toolbar);

        Spinner idiomas = findViewById(R.id.lenguajes);
        Spinner decimales = findViewById(R.id.puntodec);
        Spinner temas = findViewById(R.id.colores);


        ArrayAdapter lenguajes = ArrayAdapter.createFromResource(getApplicationContext(), R.array.idiomas, android.R.layout.simple_spinner_dropdown_item);
        idiomas.setAdapter(lenguajes);
        ArrayAdapter puntodec = ArrayAdapter.createFromResource(getApplicationContext(), R.array.decimales, android.R.layout.simple_spinner_dropdown_item);
        decimales.setAdapter(puntodec);
        ArrayAdapter colores = ArrayAdapter.createFromResource(getApplicationContext(), R.array.colores, android.R.layout.simple_spinner_dropdown_item);
        temas.setAdapter(colores);

        idiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        Locale espanol = new Locale("es", "MX");
                        Locale.setDefault(espanol);
                        Configuration config_es = new Configuration();
                        config_es.locale = espanol;
                        getBaseContext().getResources().updateConfiguration(config_es, getBaseContext().getResources().getDisplayMetrics());
                        Intent intent = new Intent (getBaseContext (), MainActivity.class);
                        startActivity (intent);
                        Intent intent2 = new Intent (getBaseContext (), SecondActivity.class);
                        startActivity (intent2);
                        finish();
                        break;
                    case 2:
                        Locale ingles = new Locale("en", "US");
                        Locale.setDefault(ingles);
                        Configuration config_en = new Configuration();
                        config_en.locale = ingles;
                        getBaseContext().getResources().updateConfiguration(config_en, getBaseContext().getResources().getDisplayMetrics());
                        intent = new Intent (getBaseContext (), MainActivity.class);
                        startActivity (intent);
                        intent2 = new Intent (getBaseContext (), SecondActivity.class);
                        startActivity (intent2);
                        finish();
                        break;
                    case 3:
                        Locale frances = new Locale("fr", "FR");
                        Locale.setDefault(frances);
                        Configuration config_fr = new Configuration();
                        config_fr.locale = frances;
                        getBaseContext().getResources().updateConfiguration(config_fr, getBaseContext().getResources().getDisplayMetrics());
                        intent = new Intent (getBaseContext (), MainActivity.class);
                        startActivity (intent);
                        intent2 = new Intent (getBaseContext (), SecondActivity.class);
                        startActivity (intent2);
                        finish();
                        break;
                    case 4:
                        Locale aleman = new Locale("de", "DE");
                        Locale.setDefault(aleman);
                        Configuration config_ge = new Configuration();
                        config_ge.locale = aleman;
                        getBaseContext().getResources().updateConfiguration(config_ge, getBaseContext().getResources().getDisplayMetrics());
                        intent = new Intent (getBaseContext (), MainActivity.class);
                        startActivity (intent);
                        intent2 = new Intent (getBaseContext (), SecondActivity.class);
                        startActivity (intent2);
                        finish();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

}
