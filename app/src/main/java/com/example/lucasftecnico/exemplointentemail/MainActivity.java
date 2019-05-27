package com.example.lucasftecnico.exemplointentemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmails, edtAssunto, edtMensagem;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmails = (EditText) findViewById(R.id.edtEmails);
        edtAssunto = (EditText) findViewById(R.id.edtAssunto);
        edtMensagem = (EditText) findViewById(R.id.edtMensagem);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void enviarEmail() {
        String emails = edtEmails.getText().toString();
        String[] listEmails = emails.split(",");
        String assunto = edtAssunto.getText().toString();
        String mensagem = edtMensagem.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, listEmails);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensagem);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Escolha um cliente de e-mail!"));
    }

}
