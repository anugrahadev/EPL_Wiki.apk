package com.aeorsh.dicoding.mysubmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aeorsh.dicoding.mysubmission.adapter.ListTeamAdapter;
import com.aeorsh.dicoding.mysubmission.model.Team;
import com.aeorsh.dicoding.mysubmission.model.TeamData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvteam;
    private ArrayList<Team> list = new ArrayList<>();
    private String title = "Premier League Wiki";
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);
        rvteam = findViewById(R.id.rv_team);
        rvteam.setHasFixedSize(true);

        list.addAll(TeamData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvteam.setLayoutManager(new LinearLayoutManager(this));
        ListTeamAdapter listHeroAdapter = new ListTeamAdapter(list);
        rvteam.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListTeamAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Team data) {
                showSelectedProv(data);
            }
        });
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
    private void showSelectedProv(Team prov) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        Bundle b = new Bundle();

        b.putString("nama",prov.getName());
        b.putString("konten",prov.getKonten());
        b.putString("pic",prov.getPic());

        intent.putExtras(b);
        startActivity(intent);

        Toast.makeText(this, "Kamu memilih " + prov.getName(), Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.profile){
            startActivity(new Intent(this, ProfileActivity.class));
        }
        return true;
    }


}
