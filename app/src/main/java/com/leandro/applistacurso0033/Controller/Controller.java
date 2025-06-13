package com.leandro.applistacurso0033.Controller;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import com.leandro.applistacurso0033.Model.Pessoa;
import com.leandro.applistacurso0033.View.MainActivity;
public class Controller {
    MainActivity mainActivity;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
     public static final String NOME_PREFERENCE = "Lista_Curso_0033";
     public Controller(MainActivity mainActivity){
         sp = mainActivity.getSharedPreferences(NOME_PREFERENCE, 0);
         editor = sp.edit();
     }
     public void Salvar(Pessoa pessoa){
         editor.putString("Nome", pessoa.getNome());
         editor.putString("Sobrenome", pessoa.getSobrenome() );
         editor.putString("Curso", pessoa.getCurso() );
         editor.putString("Telefone", pessoa.getTelefone() );
         editor.commit();
         Log.d("MVC_Controller", "Dados Salvos: " + pessoa.toString());
     }
     public void Limpar(){
         editor.clear();
         editor.commit();
     }
     public Pessoa Buscar(Pessoa pessoa) {
         pessoa.setNome(sp.getString("Nome", "NA"));
         pessoa.setSobrenome(sp.getString("Sobrenome", "NA"));
         pessoa.setCurso(sp.getString("Curso", "NA"));
         pessoa.setTelefone(sp.getString("Telefone", "NA"


         ));
         return pessoa;
     }
     public void toStrign(){
         Log.d("MVC_Controller", "Controller Iniciado ");
     }
}
