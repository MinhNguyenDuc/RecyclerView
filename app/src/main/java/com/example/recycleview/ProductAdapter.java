package com.example.recycleview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Product> listProduct;
    private IOnClickItem iOnClickItemListener;

    public ProductAdapter(Activity activity, List<Product> listProduct, IOnClickItem iOnClickItemListener) {
        this.activity = activity;
        this.listProduct = listProduct;
        this.iOnClickItemListener = iOnClickItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_product, parent, false);
        ProductHolder holder = new ProductHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ProductHolder vh = (ProductHolder) holder;
        Product product = listProduct.get(position);
        vh.tvTitle.setText(product.getTitle());
        vh.tvDes.setText(product.getDes());
        vh.tvPrice.setText(product.getPrice());
        vh.ivCover.setImageResource(product.getImg());

        vh.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                iOnClickItemListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public interface IOnClickItem {
        void onClickItem(int position);
    }

    private static class ProductHolder extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvDes;
        private TextView tvPrice;

        public ProductHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }
}
