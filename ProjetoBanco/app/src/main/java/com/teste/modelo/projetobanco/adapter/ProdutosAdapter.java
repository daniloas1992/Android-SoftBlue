package com.teste.modelo.projetobanco.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teste.modelo.projetobanco.R;
import com.teste.modelo.projetobanco.data.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by: Danilo A. Santos on 02/20/18.
 */
public class ProdutosAdapter extends BaseAdapter {

    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

    private Context context;
    private List<Produto> produtos = new ArrayList<>();

    public ProdutosAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_list_produtos, parent, false);
            holder = new ViewHolder();

            holder.tvNome = (TextView) view.findViewById(R.id.tv_nome);
            holder.tvValor = (TextView) view.findViewById(R.id.tv_valor);

            view.setTag(holder);

        } else{
            holder = (ViewHolder) view.getTag();
        }

        Produto produto = produtos.get(position);

        holder.tvNome.setText(produto.getNome());;
        holder.tvValor.setText(nf.format(produto.getValor()));

        return view;
    }

    public void setItems(List<Produto> produtos){
        this.produtos = produtos;
        notifyDataSetChanged();
    }

    private static class ViewHolder{

        public TextView tvNome;
        public TextView tvValor;

    }

}
