package com.example.usandorecicleviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder>{

    private List<Item> items = new ArrayList<>();
    private Context context;

    public ItemAdapter(Context context){

        this.context = context;

        for (int i = 0; i < 100; i++){
            Item item = new Item(i+1,"Item "+(i+1));
            items.add(item);
        }
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, viewGroup, false);

        ItemHolder holder = new ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        Item item = items.get(position);
        itemHolder.txtId.setText(String.valueOf(item.getId()));
        itemHolder.txtNome.setText(item.getNome());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtId;
        public TextView txtNome;

        public ItemHolder(View view){
            super(view);
            txtId = view.findViewById(android.R.id.text1);
            txtNome = view.findViewById(android.R.id.text2);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            items.remove(pos);

            Toast.makeText(context, "Item removido: "+ pos, Toast.LENGTH_SHORT).show();

            notifyItemRemoved(pos);
        }
    }

}
