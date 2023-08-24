package com.example.lunchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.lunchlist.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Restaurant> model = new ArrayList<>();
    /*arraylist initialization when we use <> it means we are using generics, the type could be anything we want
    in this case it is Restaurant
    * */

    /*
    an ArrayAdapter is used so we can visualize the items of the ArrayList the arraylist data is of type stream.

    * */
    ArrayAdapter<Restaurant> adapter = null;

    /* The onCreate method comes from the Activity base class (AppCompatActivity)
    This comes from the Android Activity Lifecycle (Diagram included under res > drawable
    What each of these methods do
    onCreate -> first called when the activity is created
    onStart -> when the activity gets populated onto the UI (this method gets called in the background
    you can't see it)

     */
 @Override
    protected void onCreate(Bundle savedInstanceState) {
     /* the Bundle class is used to pass information between activities (so that we can call other activities
     from within the current activity -> think of how we usually get a UI state from XML and display it to the user
     (all thanks to the Bundle class. It extends os.BaseBundle) meaning the contents of the XML files are parceable.
     * */
        super.onCreate(savedInstanceState);
        /*super keyword refers to the parent class (Object). It helps us implement the default behaviour
        this means the Object class must be created with our Bundle. to see Hierarchy Ctrl+H
        * */
        setContentView(R.layout.activity_main);
        //here we inflate the view with our XML.

        Button btnAdd = findViewById(R.id.add);
        //Button widget initialization, we have to locate the id in XML


     /* after locating our widget we then assign an onClickListener to check if the button is clicked.
     if it is clicked it must implement the logic
     * */
        btnAdd.setOnClickListener(view -> {
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


        });

       /* Toast.makeText(this,
                "Restaurant Added",Toast.LENGTH_LONG).show();*/

       /*
         here we "bind" the ArrayAdapter to our ListView. This way we can visualize the data
         of our ArrayList directly onto the ListView. (there are  a number of ways to do this,
         like RecyclerView, GridView etc.
       * */
        ListView lvRestaurants = findViewById(R.id.restaurants);
        adapter = new ArrayAdapter<Restaurant>(this,
                android.R.layout.simple_list_item_1,model);
        lvRestaurants.setAdapter(adapter);
    }
}