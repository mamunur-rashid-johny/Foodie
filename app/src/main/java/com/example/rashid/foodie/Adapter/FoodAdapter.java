package com.example.rashid.foodie.Adapter;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rashid.foodie.Model.Listitem;
import com.example.rashid.foodie.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by rashid on 3/31/17.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.Myholder> {

    private LayoutInflater inflater;
    private List<Listitem> listitems;

    public FoodAdapter(List<Listitem> listitems, Context context)
    {
        this.inflater=LayoutInflater.from(context);
        this.listitems = listitems;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myholder(inflater.inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {

        Listitem listitem=listitems.get(position);
        holder.imageView.setImageResource(listitem.getImageid());
        holder.name.setText(listitem.getName());
        holder.price.setText(listitem.getPrice()+" tk");

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Myholder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView name,price;
        private View container;
        public Myholder(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.food_img);
            name=(TextView)itemView.findViewById(R.id.name_tv);
            price=(TextView)itemView.findViewById(R.id.price_tv);
            container=itemView.findViewById(R.id.cv_root);

        }
    }
}
