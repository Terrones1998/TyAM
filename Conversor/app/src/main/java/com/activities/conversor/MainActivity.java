package com.activities.conversor;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner0 = findViewById(R.id.my_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.select,android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(adapter);

        List<String> temperatura = new ArrayList<>();
        temperatura.add("Seleccionar");
        temperatura.add("Centigrados > Farenheit");
        temperatura.add("Farenheit > Centigrados");

        List<String> longitud = new ArrayList<>();
        longitud.add("Seleccionar");
        longitud.add("Metros > Yardas");
        longitud.add("Yardas > Metros");
        longitud.add("Kilometros > Millas");
        longitud.add("Millas > Kilometros");

        List<String> volumen = new ArrayList<>();
        volumen.add("Seleccionar");
        volumen.add("Litros > Galones (US)");
        volumen.add("Galones (US) > Litros");

        List<String> aceleracion = new ArrayList<>();
        aceleracion.add("Seleccionar");
        aceleracion.add("KM/H > Millas/H");
        aceleracion.add("Millas/H > KM/H");

        List<String> peso = new ArrayList<>();
        peso.add("Seleccionar");
        peso.add("Kilos > Libras");
        peso.add("Libras > Kilos");
        peso.add("Gramos > Onzas");
        peso.add("Onzas > Gramos");

        List<String> area = new ArrayList<>();
        area.add("Seleccionar");
        area.add("Metros Cuadrados > Hectáreas");
        area.add("Hectáreas > Metros Cuadrados");

        final EditText editText = findViewById(R.id.edt_destino);
        editText.setEnabled(false);

        RadioGroup radioGroup = findViewById(R.id.rg_medidas);

        final ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, temperatura);

        final ArrayAdapter<String> b = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, longitud);

        final ArrayAdapter<String> c = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, volumen);

        final ArrayAdapter<String> d = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, aceleracion);

        final ArrayAdapter<String> e = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, peso);

        final ArrayAdapter<String> f = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, area);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                if (i == R.id.temp) {
                    Spinner spinner = findViewById(R.id.my_spinner);
                    spinner.setAdapter(a);
                }
                if (i == R.id.longi) {
                    Spinner spinner2 = findViewById(R.id.my_spinner);
                    spinner2.setAdapter(b);
                }
                if (i == R.id.vol) {
                    Spinner spinner3 = findViewById(R.id.my_spinner);
                    spinner3.setAdapter(c);
                }
                if (i == R.id.acel) {
                    Spinner spinner4 = findViewById(R.id.my_spinner);
                    spinner4.setAdapter(d);
                }
                if (i == R.id.peso) {
                    Spinner spinner5 = findViewById(R.id.my_spinner);
                    spinner5.setAdapter(e);
                }
                if (i == R.id.area) {
                    Spinner spinner6 = findViewById(R.id.my_spinner);
                    spinner6.setAdapter(f);
                }


            }
        });


        Button convierte = findViewById(R.id.bt_convertir);
        convierte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                EditText edtOrigen = findViewById(R.id.edt_origen);
                EditText edtDestino = findViewById(R.id.edt_destino);

                Spinner op = findViewById(R.id.my_spinner);
                String med = op.getSelectedItem().toString();
                float resul;
                float resul2;

                if (edtOrigen.getText().toString().isEmpty()) {
                    Toast msj = Toast.makeText(getApplicationContext(),"Ingrese un valor", Toast.LENGTH_SHORT);
                    msj.setGravity(Gravity.CENTER_HORIZONTAL,0,500);
                    msj.show();
                } else {
                    switch (med) {
                        case "Centigrados > Farenheit":

                            resul = ((Float.parseFloat(edtOrigen.getText().toString()) * 9) / 5) + 32;
                            edtDestino.setText("" + resul);
                            break;
                        case "Farenheit > Centigrados":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString()) - 32) * 5) / 9;
                            edtDestino.setText("" + resul);
                            break;
                        case "Metros > Yardas":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 1.094f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Yardas > Metros":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 1.094f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Kilometros > Millas":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 1.609f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Millas > Kilometros":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 1.609f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Litros > Galones (US)":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 3.785f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Galones (US) > Litros":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 3.785f);
                            edtDestino.setText("" + resul);
                            break;
                        case "KM/H > Millas/H":
                            resul2 = ((Float.parseFloat(edtOrigen.getText().toString())) / 1.609f);
                            edtDestino.setText("" + resul2);
                            break;
                        case "Millas/H > KM/H":
                            resul2 = ((Float.parseFloat(edtOrigen.getText().toString())) * 1.609f);
                            edtDestino.setText("" + resul2);
                            break;
                        case "Kilos > Libras":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 2.205f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Libras > Kilos":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 2.205f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Gramos > Onzas":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 28.35f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Onzas > Gramos":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 28.35f);
                            edtDestino.setText("" + resul);
                            break;
                        case "Metros Cuadrados > Hectáreas":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) / 10000);
                            edtDestino.setText("" + resul);
                            break;
                        case "Hectáreas > Metros Cuadrados":
                            resul = ((Float.parseFloat(edtOrigen.getText().toString())) * 10000);
                            edtDestino.setText("" + resul);
                            break;
                        default:
                            Toast msj = Toast.makeText(getApplicationContext(),"Elija una conversion", Toast.LENGTH_SHORT);
                            msj.setGravity(Gravity.CENTER_HORIZONTAL,0,500);
                            msj.show();
                            break;

                    }
                }


            }


        });

        Button clear=findViewById(R.id.bt_limpiar);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtOrigen = findViewById(R.id.edt_origen);
                edtOrigen.setText("");
                EditText edtDestino = findViewById(R.id.edt_destino);
                edtDestino.setText("");
                RadioGroup rg=findViewById(R.id.rg_medidas);
                rg.clearCheck();
                Spinner spinner = findViewById(R.id.my_spinner);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.select,android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        });


    }

}
