package com.example.pruebacon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private EditText txtUsu, txtPass;
    public String usuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsu = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtPassword);
    }

    public Connection conexionBD() {
        Connection cnn = null;
        try {
            StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(pol);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.4:1433/FinalRenzoUN3;" +
                    "instance=SQL2019;user=sa;password=123456");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return cnn;
    }

    public void Consulta(View view) {
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios" +
                    " where logeo='" + txtUsu.getText().toString() + "' and clave='" + txtPass.getText().toString() + "'");


            if (rs.next()) {

                Toast.makeText(getApplicationContext(), "Conexion establecida" + rs.getString("clave") + "!", Toast.LENGTH_SHORT).show();

                if ("USU01".compareTo(rs.getString("codigo")) == 0) {
                    usuario = rs.getString("logeo");
                    Intent i = new Intent(this, frmMainCliente.class);
                    i.putExtra("datoUsuario", usuario);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Lo logró" + this.usuario + "!", Toast.LENGTH_SHORT).show();
                }
                if ("USU02".compareTo(rs.getString("codigo")) == 0) {
                    usuario = rs.getString("logeo");
                    Intent i = new Intent(this, frmMainAdmin.class);
                    i.putExtra("datoUsuario", usuario);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Lo logró" + this.usuario + "!", Toast.LENGTH_SHORT).show();
                }
                if ("USU03".compareTo(rs.getString("codigo")) == 0) {
                    usuario = rs.getString("logeo");
                    Intent i = new Intent(this, frmMainInvitado.class);
                    i.putExtra("datoUsuario", usuario);

                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Lo logró" + this.usuario + "!", Toast.LENGTH_SHORT).show();
                }

            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}