package com.example.exercicio2serafim;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exercicio2serafim.adapter.ProductAdapter;
import com.example.exercicio2serafim.model.ProductListResponse;
import com.example.exercicio2serafim.services.ProductService;

public class ExcluirActivity extends AppCompatActivity {

    private ListView listaProdutos;
    private Retrofit retrofit;
    private ProductService pService;
    private ProductAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        listaProdutos = findViewById(R.id.lista_excluir_produtos);
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.IP))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pService = retrofit.create(ProductService.class);
        pService.listaTodosProdutos().enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if(response.isSuccessful()){
                    pAdapter = new ProductAdapter(ExcluirActivity.this, response.body().getProducts());
                    listaProdutos.setAdapter(pAdapter);
                    listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            pService.excluirProduto(response.body().getProducts().get(i).getId()).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Toast.makeText(ExcluirActivity.this,"Item excluído com sucesso",Toast.LENGTH_LONG).show();
                                    finish();
                                    startActivity(getIntent());
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    Toast.makeText(ExcluirActivity.this,"Verifique sua internet",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });
                }else{
                    Toast.makeText(ExcluirActivity.this,"Erro no cadastro de produto",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Toast.makeText(ExcluirActivity.this,"Verifique sua internet",Toast.LENGTH_LONG).show();
            }
        });
    }
}