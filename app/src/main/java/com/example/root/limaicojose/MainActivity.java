package com.example.root.limaicojose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        */
        setContentView(R.layout.activity_main);
        String message = db.getNumeroTareas();
        System.out.println(message);
        TextView textView = (TextView) findViewById(R.id.textViewNumeroTareas);
        textView.setText(message);
    }

    public void ingresarTarea(View view){
        Intent intent = new Intent(this,IngresarTareaActivity.class);
        startActivity(intent);
    }

    public void consultarTareas(View view){
        Intent intent = new Intent(this,ConsultarTareaActivity.class);
        startActivity(intent);
    }
}
