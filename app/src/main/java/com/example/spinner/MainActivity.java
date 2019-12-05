package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText escrito;
    TextView texto;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        escrito = (EditText) findViewById(R.id.Texto);
        spinner = findViewById(R.id.spinner2);
        texto = (TextView) findViewById(R.id.Texto2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.phone, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                switch (position) {
                    case 0:
                        texto.setText("Has escrito: " + escrito.getText() + parent.getItemAtPosition(position).toString());
                        escrito.setInputType(InputType.TYPE_CLASS_TEXT);
                        escrito.setText("");
                        break;
                    case 1:
                        texto.setText("El correo escrito es: " + escrito.getText() + parent.getItemAtPosition(position).toString());
                        escrito.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                        escrito.setText("");
                        break;
                    case 2:
                        texto.setText("El telefono escrito es: " + escrito.getText() + parent.getItemAtPosition(position).toString());
                        escrito.setInputType(InputType.TYPE_CLASS_PHONE);
                        escrito.setText("");
                        break;
                    case 3:
                        texto.setText("El numero escrito es: " + escrito.getText() + parent.getItemAtPosition(position).toString());
                        escrito.setInputType(InputType.TYPE_CLASS_NUMBER);
                        escrito.setText("");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }
}