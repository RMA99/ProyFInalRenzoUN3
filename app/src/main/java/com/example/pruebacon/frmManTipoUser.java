package com.example.pruebacon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class frmManTipoUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_man_tipo_user);
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

    public void Insertar(View view) {
        try {
            Statement st = conexionBD().createStatement();
            st.executeUpdate("insert into tipo_usuarios values('TU06','PRUEBAX3')");
            Toast.makeText(this, "Se agregaron los datos correctamente", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}