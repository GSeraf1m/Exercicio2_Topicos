package com.example.exercicio2serafim;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exercicio2serafim.adapter.ProductAdapter;
import com.example.exercicio2serafim.model.Product;
import com.example.exercicio2serafim.model.ProductListResponse;
import com.example.exercicio2serafim.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends AppCompatActivity {

    private ListView listaProdutos;
    private Retrofit retrofit;
    private ProductService pService;
    private ProductAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        listaProdutos = findViewById(R.id.lista_produtos);
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.IP))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pService = retrofit.create(ProductService.class);
        pService.listaTodosProdutos().enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if(response.isSuccessful()){
                    pAdapter = new ProductAdapter(BuscarActivity.this, response.body().getProducts());
                    listaProdutos.setAdapter(pAdapter);
                }else{
                    Toast.makeText(BuscarActivity.this,"Erro no cadastro de produto",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Toast.makeText(BuscarActivity.this,"Verifique sua internet",Toast.LENGTH_LONG).show();
            }
        });
    }
}