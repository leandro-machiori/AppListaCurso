package com.leandro.applistacurso0033.View;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    private EditText Nome, Sobrenome, Telefone;
    private Button Salvar, Limpar, Finalizar;
    String primeiroNome, sobrenome, telefone, selectedItem;
    Controller controller;
    Spinner spinner;


    @SuppressLint("MissingInflatedId")
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

        Pessoa pessoa = new Pessoa();
        controller = new Controller(this);

        controller.Buscar(pessoa);
        controller.toStrign();

        Nome = findViewById(R.id.Nome);
        Sobrenome = findViewById(R.id.Sobrenome);
        spinner = findViewById(R.id.Spinner_Curso);
        Telefone = findViewById(R.id.Telefone);
        Salvar = findViewById(R.id.Salvar);
        Limpar = findViewById(R.id.Limpar);
        Finalizar = findViewById(R.id.Finalizar);

        Nome.setText(pessoa.getNome());
        Sobrenome.setText(pessoa.getSobrenome());
        Telefone.setText(pessoa.getTelefone());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Spinner_Curso,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (pessoa.getCurso() != null && !pessoa.getCurso().isEmpty()) {
            int spinnerPosition = adapter.getPosition(pessoa.getCurso());
            spinner.setSelection(spinnerPosition);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), "Selecionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Botão SALVAR
        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setNome(primeiroNome = Nome.getText().toString());
                pessoa.setSobrenome(sobrenome = Sobrenome.getText().toString());
                pessoa.setCurso(selectedItem);
                pessoa.setTelefone(telefone = Telefone.getText().toString());
                pessoa.setCurso(selectedItem);
                controller.Salvar(pessoa);
            }
        });
        // Botão LIMPAR
        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nome.setText("");
                Sobrenome.setText("");
                spinner.setSelection(0);
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
