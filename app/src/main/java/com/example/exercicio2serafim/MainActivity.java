package com.example.exercicio2serafim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btCadastro, btBusca, btEdicao, btExclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("users", users);
//                intent.putExtra("bundle", args);
                startActivity(intent);
            }
        });
        btBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuscarActivity.class);
                startActivity(intent);
            }
        });
        btEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditarActivity.class);
                startActivity(intent);
            }
        });
        btExclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExcluirActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inicializarComponentes() {
        btCadastro = this.findViewById(R.id.bt_cadastro);
        btBusca = this.findViewById(R.id.bt_busca);
        btEdicao = this.findViewById(R.id.bt_edicao);
        btExclusao = this.findViewById(R.id.bt_exclusao);
    }
}