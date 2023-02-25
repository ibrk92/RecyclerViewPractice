package com.ibrahimkiceci.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.ibrahimkiceci.recyclerviewpractice.adapters.TuneAdapter;
import com.ibrahimkiceci.recyclerviewpractice.adapters.TuneAdapter2;
import com.ibrahimkiceci.recyclerviewpractice.model.Tune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //I am going to create List for tune names and tune pics,
    //Note:asList() ---> is used to return a fixed-size list backed by the specified array
    List<String> TuneNames = new ArrayList<>(Arrays.asList("Beauty and the Beast", "Lion King", "Mary Poppins", "Game of Thrones", "Ozark"));
    List<Integer> TunePics = new ArrayList<>(Arrays.asList(R.drawable.beauty, R.drawable.lionking, R.drawable.marypoppins, R.drawable.gameofthrones, R.drawable.ozark));
   // by default list is null not empty
   // empty list needed to add elements to the list - else null pointer exception
    List<Tune> AllTunes = new ArrayList<>();
    List<Tune> MovieTunes = new ArrayList<>();
    List<Tune> TvTunes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadModelData();
        TabLayout tabLayoutTunes = findViewById(R.id.tabLayoutTunes);
        RecyclerView recyclerViewTunes = findViewById(R.id.recyclerViewTunes);

        //create adapter object
        //TuneAdapter tuneAdapter = new TuneAdapter(AllTunes);
        TuneAdapter2 tuneAdapter =new TuneAdapter2(AllTunes);

        //create layout manager
        //GridLayoutManager rlm = new GridLayoutManager(this, 2);
        LinearLayoutManager rlm = new LinearLayoutManager(this);

        //set adapter
        recyclerViewTunes.setAdapter(tuneAdapter);
        //set layoutmanager

        recyclerViewTunes.setLayoutManager(rlm);

        tabLayoutTunes.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0:
                        tuneAdapter.setTuneList(AllTunes);
                        //tuneAdapter.notifyDataSetChanged(); bunlari her case de yazabilirsin ancak bunu her defasinda yazmak yerine adapterin icerisinde, setTuneList icerisinde yazabilirsin cunku orasi calisiyor!!
                        Toast.makeText(MainActivity.this, AllTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        tuneAdapter.setTuneList(MovieTunes);
                        Toast.makeText(MainActivity.this, MovieTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        tuneAdapter.setTuneList(TvTunes);
                        Toast.makeText(MainActivity.this, TvTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch(tab.getPosition()){
                    case 0:
                        Toast.makeText(MainActivity.this, AllTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(MainActivity.this, MovieTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, TvTunes.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });


    }


    private void LoadModelData(){

        for(int i = 0; i < TuneNames.size(); i++){

            Tune eachTune = new Tune(TuneNames.get(i), TunePics.get(i));
            AllTunes.add(eachTune); // add required empty list not null list
        }

        MovieTunes = AllTunes.subList(0,3); //lower bound is inclusive, upper bound is exclusive index
                                             // so it means that 0,1 and 2.
        TvTunes = AllTunes.subList(3,5); // so it gets 3 and 4.



    }



}