package com.example.exercicio2serafim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exercicio2serafim.R;
import com.example.exercicio2serafim.model.Product;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context mContext;
    private List<Product> listaProdutos = new ArrayList<>();

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list){
        super(context,0, list);
        this.mContext = context;
        this.listaProdutos = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.product_list_view, parent, false);
        }

        Product product = listaProdutos.get(position);
        TextView name = listItem.findViewById(R.id.tv_name);
        TextView descricao = listItem.findViewById(R.id.tv_descricao);
        name.setText(product.getName());
        descricao.setText(product.getDescription());
        return  listItem;
    }
}
