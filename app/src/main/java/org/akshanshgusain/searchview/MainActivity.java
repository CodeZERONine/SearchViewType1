package org.akshanshgusain.searchview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static android.support.v4.view.MenuItemCompat.getActionProvider;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private ArrayList<Model> list;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MyrecycleViewAdapter adapter;
    private MyrecycleViewAdapter myrecycleViewAdapter;
    private RecyclerView.LayoutManager recylerviewLayoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerView);
        recylerviewLayoutmanager=new LinearLayoutManager(this);


        list=new ArrayList<>();
        list.add(new Model("India"));
        list.add(new Model("USA"));
        list.add(new Model("Canada"));
        list.add(new Model("Australia"));
        list.add(new Model("Germany"));
        list.add(new Model("Russia"));
        list.add(new Model("England"));
        list.add(new Model("Itly"));
        list.add(new Model("pakistan"));
        list.add(new Model("Afganistan"));


        recyclerView.setLayoutManager(recylerviewLayoutmanager);

        adapter=new MyrecycleViewAdapter(list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.actionSearch);
        SearchView searchView= (SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Model> newArrayList=new ArrayList<>();
        for(Model model:list){
            String name=model.getName().toLowerCase();
             if(name.contains(newText)){
                 newArrayList.add(model);
             }
        }
        adapter.setFilter(newArrayList);

        return false;
    }
}
