package com.example.mobileuninga;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Alterar extends MainActivity {
    EditText Nome;
    EditText CPF;
    EditText telefone;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        Nome = (EditText)findViewById(R.id.editText4);
        CPF = (EditText)findViewById(R.id.editText5);
        telefone = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        Nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME)));
        CPF.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CPF)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TELEFONE)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo),
                        Nome.getText().toString(),CPF.getText().toString(),
                        telefone.getText().toString());
                Intent intent = new Intent(Alterar.this,ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(Alterar.this,ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
