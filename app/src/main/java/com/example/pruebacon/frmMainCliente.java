package com.example.pruebacon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class frmMainCliente extends AppCompatActivity {

    MainActivity mainActivity = new MainActivity();
    String user;

    TextView txtBien;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_main_cliente);
        txtBien=findViewById(R.id.txtBienvenida);
        recibirDatos();


    }

    public  void prueba(View v)
    {
        Intent i = new Intent(this,frmOperPedidoIni.class);
        startActivity(i);
        Toast.makeText(this, "Esto:"+user+"!", Toast.LENGTH_SHORT).show();
    }

    public  void recibirDatos()
    {
        Bundle extras = getIntent().getExtras();
        String datoUsuario = extras.getString("datoUsuario");
        txtBien.setText("Bienvenido "+datoUsuario);
        this.user=datoUsuario;
    }

}