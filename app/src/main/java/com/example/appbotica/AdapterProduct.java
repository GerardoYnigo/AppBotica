package com.example.appbotica;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.viewholderproduct> {
    private final RecyclerViewProduct recyclerViewProduct;

    List<Products> productsList;

    public AdapterProduct(List<Products> productsList, RecyclerViewProduct recyclerViewProduct)
    {
        this.productsList = productsList;
        this.recyclerViewProduct = recyclerViewProduct;
    }

    @NonNull
    @Override
    public viewholderproduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product,parent,false);
        viewholderproduct holder = new viewholderproduct(v, recyclerViewProduct);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderproduct holder, int position) {
        Products ps = productsList.get(position);
        holder.tv_nameproduct.setText(ps.getNameproduct());
        holder.tv_price.setText(ps.getPrice()+"");
        holder.tv_dateexpiration.setText(ps.getDateexpiration());
        holder.tv_namebotica.setText(ps.getNamebotica());
        holder.tv_directionbotica.setText(ps.getDirectionbotica());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static class viewholderproduct extends RecyclerView.ViewHolder {
        TextView tv_nameproduct,tv_price,tv_dateexpiration,tv_namebotica,tv_directionbotica;


        public viewholderproduct(@NonNull View itemView, RecyclerViewProduct recyclerViewProduct) {
            super(itemView);

            tv_nameproduct = itemView.findViewById(R.id.tv_nameproduct);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_dateexpiration = itemView.findViewById(R.id.tv_dateexpiration);
            tv_namebotica = itemView.findViewById(R.id.tv_namebotica);
            tv_directionbotica = itemView.findViewById(R.id.tv_directionbotica);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewProduct != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewProduct.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
