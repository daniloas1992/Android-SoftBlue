package com.teste.modelo.planetas;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

//implementation 'androidx.appcompat:appcompat:1.0.2'
public class MainActivity extends Activity implements PlanetAdapter.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private Planet selectedPlanet;
    private ActionBarDrawerToggle a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        drawerList.setAdapter(new PlanetAdapter(this,this));

        selectItem(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_search){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "Planeta "+ selectedPlanet.getName());
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void selectItem(Planet planet){
        if(planet != null){
            this.selectedPlanet = planet;

            Fragment fragment = PlanetFragment.newInstance(planet);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();

            setTitle(planet.getName());
        }

        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void onClick(Planet planet) {
        selectItem(planet);
    }
}
