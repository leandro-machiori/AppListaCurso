package com.leandro.applistacurso0033.View;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.leandro.applistacurso0033.Controller.Controller;
import com.leandro.applistacurso0033.Model.Pessoa;
import com.leandro.applistacurso0033.R;
public class MainActivity extends AppCompatActivity {
    private EditText Nome, Sobrenome, Curso, Telefone;
    private Button Salvar, Limpar, Finalizar;
    String primeiroNome, sobrenome, curso, telefone;
    Controller controller;
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
        controller = new Controller(this);
        // Botão SALVAR
        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                primeiroNome = Nome.getText().toString().trim();
                sobrenome = Sobrenome.getText().toString().trim();
                curso = Curso.getText().toString().trim();
                telefone = Telefone.getText().toString().trim();
                Pessoa pessoa = new Pessoa(primeiroNome, sobrenome, curso, telefone);
                controller.Salvar(pessoa);
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
                controller.Limpar();
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