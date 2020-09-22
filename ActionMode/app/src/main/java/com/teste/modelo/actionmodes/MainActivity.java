package com.teste.modelo.actionmodes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private TextView _tvNumber;
    private int count = 0;
    private boolean isActionModeActived = false;
    private Button _btnAbrirTelaDois;
    private ImageButton _imgPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _tvNumber = (TextView) findViewById(R.id.tvNumber);
        _tvNumber.setText(String.valueOf(count));
        _tvNumber.setOnLongClickListener(this);

        _btnAbrirTelaDois = (Button) findViewById(R.id.btnAbrirTelaDois);
        _btnAbrirTelaDois.setOnClickListener(this);

        _imgPopUp = (ImageButton) findViewById(R.id.imgPopUp);
        _imgPopUp.setOnClickListener(this);

    }

    @Override
    public boolean onLongClick(View v) {

        if(!isActionModeActived){
            startActionMode(this);
            isActionModeActived = true;
        }
        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_actions:{
                count++;
                _tvNumber.setText(String.valueOf(count));
                mode.finish();
                return true;
            }
            default: return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        isActionModeActived = false;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAbrirTelaDois:{
                Intent i = new Intent(this,TelaDois.class);
                startActivity(i);
                break;
            }
            
            case R.id.imgPopUp:{
                abrirPopUpMenu(v);
            }
        }
    }

    private void abrirPopUpMenu(View view) {

        PopupMenu popup = new PopupMenu(this, view);

        popup.inflate(R.menu.popup_menu);
        popup.setOnMenuItemClickListener(this);
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){

            case R.id.action_next:{
                Toast.makeText(this, R.string.proximo, Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_previous:{
                Toast.makeText(this, R.string.anterior, Toast.LENGTH_SHORT).show();
                return true;
            }
            default: return false;
        }
    }
}
