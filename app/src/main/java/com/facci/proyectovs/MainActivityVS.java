package com.facci.proyectovs;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityVS extends AppCompatActivity {
    DBHelper dbSQLITE;

    EditText lblNombre,lblApellido,lblRecientoElectoral,lblAnoNacimiento,lblId;

    Button lblIngresar,lblElminar,lblModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_vs);

        dbSQLITE = new DBHelper(this);

    }
    public void ingresarClick(View v){

        lblNombre = (EditText) findViewById(R.id.lblNombre);
        lblApellido = (EditText) findViewById(R.id.lblApellido);
        lblRecientoElectoral =(EditText) findViewById(R.id.lblRecientoElectoral);
        lblAnoNacimiento =(EditText) findViewById(R.id.lblAnoNacimiento);

        boolean estaIngresando = dbSQLITE.INGRESAR(lblNombre.getText().toString(),lblApellido.getText().toString(),lblRecientoElectoral.getText().toString(),Integer.parseInt(lblAnoNacimiento.getText().toString()));

        if(estaIngresando)
            Toast.makeText(MainActivityVS.this,"Ingresado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivityVS.this,"Error",Toast.LENGTH_SHORT).show();

    }

    public void modificarRegistroClick(View v){


        lblNombre = (EditText) findViewById(R.id.lblNombre);
        lblApellido = (EditText) findViewById(R.id.lblApellido);
        lblRecientoElectoral = (EditText) findViewById(R.id.lblRecientoElectoral);
        lblAnoNacimiento = (EditText) findViewById(R.id.lblAnoNacimiento);
        lblId=(EditText) findViewById(R.id.lblId);


        boolean estaAcutalizado = dbSQLITE.MODIFICAR(lblId.getText().toString(),lblNombre.getText().toString(),lblApellido.getText().toString(),lblRecientoElectoral.getText().toString(),Integer.parseInt(lblAnoNacimiento.getText().toString()));
        if (estaAcutalizado == true){
            Toast.makeText(MainActivityVS.this," Actualizado",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivityVS.this," Error",Toast.LENGTH_SHORT).show();
        }

    }
    public void eliminarRegistroClick(View v){

        lblId = (EditText) findViewById(R.id.lblId);


        Integer registrosEliminados = dbSQLITE.ELIMINAR(lblId.getText().toString());

        if(registrosEliminados > 0 ){
            Toast.makeText(MainActivityVS.this," Eliminado(s)",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivityVS.this,"ERROR ",Toast.LENGTH_SHORT).show();
        }


    }

}
