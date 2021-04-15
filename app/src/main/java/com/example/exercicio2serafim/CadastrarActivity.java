package com.example.exercicio2serafim;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.exercicio2serafim.model.Product;
import com.example.exercicio2serafim.services.ProductService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class CadastrarActivity extends AppCompatActivity {

    private TextInputEditText tiName, tiDescricao, tiPreco, tiImageUrl, tiStockLevel;
    private Button btCadastrar;
    private Retrofit retrofit;
    private ProductService pService;


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
        product.setPrice((Number) Float.parseFloat(this.tiPreco.getText().toString()));
        product.setImageUrl(this.tiImageUrl.getText().toString());
        product.setStockLevel(Integer.parseInt(this.tiStockLevel.getText().toString()));
        product.setEnabled(true);
        product.setCreationTimestamp("");
        System.out.println(product);
        pService.cadastrarProduto(product).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Produto criado com sucesso", Toast.LENGTH_LONG);
                    toast.show();
                    clean();
                }else{
                    Toast.makeText(CadastrarActivity.this,"Erro no cadastro de produto",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

                Toast.makeText(CadastrarActivity.this,"Erro de Conexão",Toast.LENGTH_SHORT).show();
            }
        });
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
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.IP))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pService =retrofit.create(ProductService.class);
    }

}