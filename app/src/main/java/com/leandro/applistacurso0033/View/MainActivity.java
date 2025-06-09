package com.leandro.applistacurso0033.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.leandro.applistacurso0033.Model.Pessoa;
import com.leandro.applistacurso0033.R;

public class MainActivity extends AppCompatActivity {
    private EditText Nome, Sobrenome, Curso, Telefone;
    private Button Salvar, Limpar, Finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Nome = findViewById(R.id.Nome);
        Sobrenome = findViewById(R.id.Sobrenome);
        Curso = findViewById(R.id.Curso);
        Telefone = findViewById(R.id.Telefone);

        Salvar = findViewById(R.id.Salvar);
        Limpar = findViewById(R.id.Limpar);
        Finalizar = findViewById(R.id.Finalizar);

        // Botão SALVAR
        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String primeiroNome = Nome.getText().toString().trim();
                String sobrenome = Sobrenome.getText().toString().trim();
                String curso = Curso.getText().toString().trim();
                String telefone = Telefone.getText().toString().trim();

                if (primeiroNome.isEmpty() || sobrenome.isEmpty() || curso.isEmpty() || telefone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    Pessoa pessoa = new Pessoa(Nome, sobrenome, curso, telefone);
                    Toast.makeText(MainActivity.this, "Dados salvos:\n" + pessoa.toString(), Toast.LENGTH_LONG).show();
                    Nome.setText("");
                    Sobrenome.setText("");
                    Curso.setText("");
                    Telefone.setText("");

                }
            }
        });

        // Botão LIMPAR
        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nome.setText("");
                Sobrenome.setText("");
                Curso.setText("");
                Telefone.setText("");
                Nome.requestFocus();

            }
        });

        // Botão FINALIZAR
        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Encerra o aplicativo
            }
        });
    }
}
