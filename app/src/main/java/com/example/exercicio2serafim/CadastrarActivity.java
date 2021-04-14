package com.example.exercicio2serafim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.exercicio2serafim.model.Product;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class CadastrarActivity extends AppCompatActivity {

    private TextInputEditText tiName, tiDescricao, tiPreco, tiImageUrl, tiStockLevel;
    private Button btCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        inicializarComponentes();
        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
    }

    private void cadastrar() {
        Product product = new Product();
        product.setName(this.tiName.getText().toString());
        product.setDescription(this.tiDescricao.getText().toString());
        product.setPrice((Number) this.tiPreco.getText());
        product.setImageUrl(this.tiImageUrl.getText().toString());
        product.setStockLevel(Integer.parseInt(this.tiStockLevel.getText().toString()));
        product.setEnabled(true);
        product.setCreationTimestamp(new Date().toString());
        Toast toast = Toast.makeText(getApplicationContext(), "Usuario criado com sucesso", Toast.LENGTH_LONG);
        toast.show();
        clean();
    }

    private void clean() {
        this.tiName.getText().clear();
        this.tiDescricao.getText().clear();
        this.tiImageUrl.getText().clear();
        this.tiPreco.getText().clear();
        this.tiStockLevel.getText().clear();
    }

    private void inicializarComponentes() {
        tiName = (TextInputEditText) this.findViewById(R.id.ti_name);
        tiDescricao = (TextInputEditText) this.findViewById(R.id.ti_descricao);
        tiImageUrl = (TextInputEditText) this.findViewById(R.id.ti_imageUrl);
        tiPreco = (TextInputEditText) this.findViewById(R.id.ti_preco);
        tiStockLevel = (TextInputEditText) this.findViewById(R.id.ti_stockLevel);
        btCadastrar = (Button) this.findViewById(R.id.bt_cadastrar);
    }

}