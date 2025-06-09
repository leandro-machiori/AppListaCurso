package com.leandro.applistacurso0033.Model;

import android.widget.EditText;
import android.widget.EditText;

public class Pessoa {
        private EditText Nome;
        private String sobrenome;
        private String curso;
        private String telefone;

        public Pessoa(EditText Nome, String sobrenome, String curso, String telefone) {
            this.Nome = Nome;
            this.sobrenome = sobrenome;
            this.curso = curso;
            this.telefone = telefone;
        }

        public EditText getNome() {
            return Nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public String getCurso() {
            return curso;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setNome(EditText nome) {
            Nome = nome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return "listaCurso{" +
                    "Nome='" + Nome + '\'' +
                    ", sobrenome='" + sobrenome + '\'' +
                    ", curso='" + curso + '\'' +
                    ", telefone='" + telefone + '\'' +
                    '}';
        }
    }

