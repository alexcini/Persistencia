package com.example.logonrm.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class   LoginspActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenha;
    private CheckBox cbManterConectado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsp);

        // Recuperar o valor do login
        etUsuario = (EditText) findViewById(R.id.etusuario);
        etSenha = (EditText) findViewById(R.id.etsenha);
        cbManterConectado = (CheckBox) findViewById(R.id.cbcheckBox);
        ler();
    }

    //Click do logon
    public void logar(View v) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        //Recuperar os valore de usuario e senha
        SharedPreferences.Editor e = sp.edit();
        String login = etUsuario.getText().toString();
        String senha = etSenha.getText().toString();
        if (cbManterConectado.isChecked()) {
            e.putString("usuario", login);
            e.putString("senha", senha);
            e.putBoolean("manterConectado", cbManterConectado.isChecked());
        }else{
            e.putString("usuario", "");
            e.putString("senha", "");
            e.putBoolean("manterConectado", false);
        }
        e.apply();
    }

    public void ler(){
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        etUsuario.setText(sp.getString("usuario", ""));
        etSenha.setText(sp.getString("senha", ""));
        cbManterConectado.setChecked(sp.getBoolean("manterConectado", false));

    }
}
