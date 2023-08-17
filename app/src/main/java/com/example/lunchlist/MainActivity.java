package com.example.lunchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Restaurant> model = new ArrayList<>();
    ArrayAdapter<Restaurant> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurant res = new Restaurant();
                EditText txtName= findViewById(R.id.name);
                EditText txtAddress = findViewById(R.id.address);

                res.setName(txtName.getText().toString());
                res.setAddress(txtAddress.getText().toString());

                RadioGroup rdType = findViewById(R.id.types);

                int checkedRdBtn = rdType.getCheckedRadioButtonId();
                if(checkedRdBtn == R.id.take_away){
                    res.setType(getString(R.string.take_away));
                } else if (checkedRdBtn == R.id.sit_down){
                    res.setType(getString(R.string.sit_down));
                } else if (checkedRdBtn == R.id.delivery){
                    res.setType(getString(R.string.delivery));
                }
                adapter.add(res);


            }
        });

       /* Toast.makeText(this,
                "Restaurant Added",Toast.LENGTH_LONG).show();*/

        ListView lvRestaurants = findViewById(R.id.restaurants);
        adapter = new ArrayAdapter<Restaurant>(this,
                android.R.layout.simple_list_item_1,model);
        lvRestaurants.setAdapter(adapter);
    }
}