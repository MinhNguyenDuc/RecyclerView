package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem{


    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ProductAdapter adapter = new ProductAdapter(this, listProduct,this);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
        listProduct.add(new Product("Test", "Test", "11231231", R.drawable.iron));
        listProduct.add(new Product("Test", "Test", "11231231", R.drawable.iron));
        listProduct.add(new Product("Test", "Test", "11231231", R.drawable.iron));
        listProduct.add(new Product("Test", "Test", "11231231", R.drawable.iron));
        listProduct.add(new Product("Test", "Test", "11231231", R.drawable.iron));

    }

    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this, product.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
