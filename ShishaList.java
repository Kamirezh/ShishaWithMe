package com.kamisolutions.shishawithme;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.kamisolutions.shishawithme.ui.Shisha1;

public class ShishaList extends AppCompatActivity {

    ListView shishaListView;
    String[] items;
    String[] description;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Resources res = getResources();
        shishaListView = findViewById(R.id.shishaListView);
        items = res.getStringArray(R.array.Product);
        description = res.getStringArray(R.array.Beschreibung);

        itemadapter itemadapter = new itemadapter(this, items, description);

        shishaListView.setAdapter(itemadapter);

        shishaListView.setClickable(true);
        shishaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object o = shishaListView.getItemAtPosition(position);




                switch(position) {


                    case 0: Intent shisha0 = new Intent(getApplicationContext(), Shisha1.class);
                            shisha0.putExtra("Gewählt: ", position);
                            startActivity(shisha0);
                        break;
                    case 1: Intent shisha1 = new Intent(getApplicationContext(), Shisha1.class);
                        shisha1.putExtra("Gewählt: ", position);
                        startActivity(shisha1);
                        break;
                    case 2: Intent shisha2 = new Intent(getApplicationContext(), Shisha1.class);
                        shisha2.putExtra("Gewählt: ", position);
                        startActivity(shisha2);
                        break;
                    case 3: Intent shisha3 = new Intent(getApplicationContext(), Shisha1.class);
                        shisha3.putExtra("Gewählt: ", position);
                        startActivity(shisha3);
                        break;
                    default:
                         Intent shisha4 = new Intent(getApplicationContext(), Shisha1.class);
                        shisha4.putExtra("Gewählt: ", position);
                        startActivity(shisha4);
                        break;




                }

            }
        });

    }
}
