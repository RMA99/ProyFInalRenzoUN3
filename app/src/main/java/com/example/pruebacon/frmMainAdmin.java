package com.example.pruebacon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class frmMainAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_main_admin);
    }
    public void ManUser(View v) {
        Intent i = new Intent(this, frmManTipoUser.class);
        startActivity(i);

    }
}