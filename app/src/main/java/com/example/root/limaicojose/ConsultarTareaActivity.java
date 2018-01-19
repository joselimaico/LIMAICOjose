package com.example.root.limaicojose;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ConsultarTareaActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    Tarea tarea = new Tarea();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_tarea);

    }

    public void consultar(View view){
        EditText EditTextNombreTarea = (EditText) findViewById(R.id.editTextNombreTarea);
        tarea.setTarea(EditTextNombreTarea.getText().toString());
        Tarea t = db.getTarea(tarea.getTarea());
        String message = t.getFechaLimite();
        System.out.println(message);
        TextView textView = (TextView) findViewById(R.id.textViewMostrarFechaLimite);
        textView.setText(message);
        /*SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.fecha_limite), message);
        editor.commit();

        SharedPreferences sharedPref1 = getPreferences(Context.MODE_PRIVATE);
        String valorfechaLimite = sharedPref.getString(getString(R.string.fecha_limite),
                "fechaLimite");
        TextView textView = (TextView) findViewById(R.id.textViewMostrarFechaLimite);
        textView.setText(valorfechaLimite);*/


    }
}
