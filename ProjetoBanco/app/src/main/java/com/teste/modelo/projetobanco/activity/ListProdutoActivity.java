package com.teste.modelo.projetobanco.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.teste.modelo.projetobanco.R;
import com.teste.modelo.projetobanco.adapter.ProdutosAdapter;
import com.teste.modelo.projetobanco.data.Produto;
import com.teste.modelo.projetobanco.data.ProdutoDAO;
import com.teste.modelo.projetobanco.dialog.DeleteDialog;

import java.util.List;

/**
 * Created by: Danilo A. Santos on 02/20/18.
 */
public class ListProdutoActivity  extends ListActivity implements AdapterView.OnItemLongClickListener, DeleteDialog.OnDeleteListener {

    private static final int REQ_EDIT = 100;
    private ProdutoDAO produtoDAO;
    private ProdutosAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_produtos);

        adapter = new ProdutosAdapter(this);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(this);

        produtoDAO = ProdutoDAO.getInstace(this);

        updateList();
    }

    private void updateList() {
        List<Produto> produtos = produtoDAO.list();
        adapter.setItems(produtos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_list_produtos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_add){
            Intent intent = new Intent(getApplicationContext(), EditProdutoActivity.class);
            startActivityForResult(intent, REQ_EDIT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_EDIT && resultCode == RESULT_OK){
            updateList();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), EditProdutoActivity.class);
        intent.putExtra("PRODUTO", adapter.getItem(position));
        startActivityForResult(intent, REQ_EDIT);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Produto produto = adapter.getItem(position);

        DeleteDialog dialog = new DeleteDialog();
        dialog.setProduto(produto);
        dialog.show(getFragmentManager(), "deleteDialog");
        return true;
    }

    @Override
    public void onDelete(Produto produto) {
        produtoDAO.delete(produto);
        updateList();
    }

}
