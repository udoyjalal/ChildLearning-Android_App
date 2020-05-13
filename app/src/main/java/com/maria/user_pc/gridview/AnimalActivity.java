package com.maria.user_pc.gridview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class AnimalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        GridView gridview = (GridView) findViewById(R.id.gridviewAnimal);
        gridview.setAdapter(new ImageAdapterAnimal(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AnimalSingleViewActivity.class);
                // Pass image index
                intent.putExtra("animalid", position);
                startActivity(intent);
                finish();
            }
        });
    }
}
