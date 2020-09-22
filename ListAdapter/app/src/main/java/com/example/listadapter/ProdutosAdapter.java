package com.example.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProdutosAdapter extends BaseAdapter {

    private List<Produto> produtos;
    private LayoutInflater inflater;
    private static final NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

    public ProdutosAdapter(Context context, List<Produto> produtos){
        this.produtos = produtos;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;

        if(view == null){ // A view não é reciclada, precisa ser criada

            view = inflater.inflate(R.layout.adapter_produtos, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.tvNome = (TextView) view.findViewById(R.id.tvNome);
            viewHolder.tvPreco = (TextView) view.findViewById(R.id.tvPreco);
            view.setTag(viewHolder);

        } else { // Vai recciclar uma view que já possui tvNome e tvPreco

            viewHolder = (ViewHolder) view.getTag();

        }

        Produto produto = produtos.get(position);

        viewHolder.tvNome.setText(produto.getNome());
        viewHolder.tvPreco.setText(formatoMoeda.format(produto.getPreco()));




        return view;
    }

    private static class ViewHolder {
        public TextView tvNome;
        public TextView tvPreco;

    }

}
