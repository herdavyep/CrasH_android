package com.example.heriberto.crash.vistas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.heriberto.crash.Adaptadores.AdapterVerAlmacenes;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;

import java.util.ArrayList;

public class verAlmacenes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_almacenes);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerAlmacenes);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ArrayList<Almacenes> myDataset = new ArrayList<>();
        myDataset.add(new Almacenes("ara","cra 7 # 13 - 111","3146487711","cartago",R.drawable.ara));
        myDataset.add(new Almacenes("D1","cra 10 # 13 - 111","3146487661","cartago",R.drawable.d1));
        myDataset.add(new Almacenes("Exito","cra 4 # 13 - 111","3146487711","cartago",R.drawable.exito));
        myDataset.add(new Almacenes("Super Inter","cra 11 # 13 - 111","3144487711","cartago",R.drawable.superinter));
        myDataset.add(new Almacenes("Olimpica","cra 9 # 13 - 111","3146487711","cartago",R.drawable.olimpica));
        myDataset.add(new Almacenes("Comfandi","cra 5 # 13 - 111","3146486611","cartago",R.drawable.comfandi));
        myDataset.add(new Almacenes("Colsubsidio","cra 1 # 13 - 111","3146007711","cartago",R.drawable.colsubsidio));
        myDataset.add(new Almacenes("Metro","cra 7 # 13 - 111","3146487121","cartago",R.drawable.metro));

        AdapterVerAlmacenes mAdapter = new AdapterVerAlmacenes(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

}
