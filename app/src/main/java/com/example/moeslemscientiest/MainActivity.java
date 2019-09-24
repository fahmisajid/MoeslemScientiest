package com.example.moeslemscientiest;

import android.content.Intent;
import android.icu.util.Measure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvScientist;
    private ArrayList<Scientist> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvScientist = findViewById(R.id.rv_scientist);
        rvScientist.setHasFixedSize(true);

        list.addAll(ScientistData.getListData());

        showRecyclerList();

    }

    private void showRecyclerList(){
        rvScientist.setLayoutManager(new LinearLayoutManager(this));
        ListScientistAdapter listScientistAdapter = new ListScientistAdapter(list);
        rvScientist.setAdapter(listScientistAdapter);

        listScientistAdapter.setOnItemClickCallback(new ListScientistAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Scientist data) {
                showSelectedScientist(data);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                Intent moveIntent = new Intent(MainActivity.this, About_Activity.class);
                startActivity(moveIntent);
                break;

        }
    }
    private void showSelectedScientist(Scientist scientist) {
        Toast.makeText(this, "Kamu memilih " + scientist.getName(), Toast.LENGTH_SHORT).show();
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.EXTRA_NAME, scientist.getName());
        detailIntent.putExtra(DetailActivity.EXTRA_DESC, scientist.getDesc());
        detailIntent.putExtra(DetailActivity.EXTRA_PHOTO, scientist.getPhoto());
        detailIntent.putExtra(DetailActivity.EXTRA_TTL, scientist.getTTL());
        detailIntent.putExtra(DetailActivity.EXTRA_DIED, scientist.getDied());
        detailIntent.putExtra(DetailActivity.EXTRA_EXPERT, scientist.getExpert());
        detailIntent.putExtra(DetailActivity.EXTRA_KARYA, scientist.getKarya());


        startActivity(detailIntent);

    }
}
