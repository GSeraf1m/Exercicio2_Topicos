package com.example.exercicio2serafim.services;

import com.example.exercicio2serafim.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductService {

    @POST("product/")
    Call<Product> cadastrarProduto(@Body Product product);

    @GET("product/")
    Call<List<Product>> listaTodosProdutos();

    @PUT("product/{id}")
    Call<Product> editarProduto(@Path("id") long id, @Body Product product);

    @DELETE("product/{id}")
    Call<Void> excluirProduto(@Path("id") long id);
}
