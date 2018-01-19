package com.example.root.limaicojose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class IngresarTareaActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    Tarea tarea = new Tarea();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_tarea);
    }

    public void ingresarCaso(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText editTextNombreTarea = (EditText) findViewById(R.id.editTextNombreTarea);
        EditText editTextfechaLimite = (EditText) findViewById(R.id.editTextFechaLimite);

        tarea.setTarea( editTextNombreTarea.getText().toString());
        tarea.setFechaLimite(editTextfechaLimite.getText().toString());

        db.addTarea(new Tarea(tarea.getTarea(), tarea.getFechaLimite()));
        startActivity(intent);


    }
}
