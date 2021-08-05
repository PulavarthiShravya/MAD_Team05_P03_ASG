package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class nameSearchPage extends AppCompatActivity {

    static ArrayList<Park> parksList;
    private RecyclerView parkNameRV;
    private ParkNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search_page);

        // initializing our variables.
        parkNameRV = findViewById(R.id.recyclerView2);
        TextView back = findViewById(R.id.textView25);

        // calling method to
        // build recycler view.
        buildRecyclerView();

        //when user clicks on BacK (<)
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nameSearchPage.this, searchPage.class);
                startActivity(intent);
            }
        });

    }

    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<Park> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (Park item : parksList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {

        // below line we are creating a new array list
        parksList = new ArrayList<>();

        // below line is to add data to our array list.
        String url = "https://tih-api.stb.gov.sg/national-park/v1/name/ ?apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    //go to the data jsonObject
                    JSONArray dataArray = response.getJSONArray("data");


                    //for loop
                    for (int i = 0; i<dataArray.length(); i++){
                        //getting data from the dataArray
                        JSONObject nameObject = dataArray.getJSONObject(i);
                        //extracting variables
                        String nameOfPark = nameObject.getString("name");
                        parksList.add(new Park(i, nameOfPark));
                    }


                    // initializing our adapter class.
                    adapter = new ParkNameAdapter(parksList, nameSearchPage.this);

                    // adding layout manager to our recycler view.
                    LinearLayoutManager manager = new LinearLayoutManager(nameSearchPage.this);
                    parkNameRV.setHasFixedSize(true);

                    // setting layout manager
                    // to our recycler view.
                    parkNameRV.setLayoutManager(manager);

                    // setting adapter to
                    // our recycler view.
                    parkNameRV.setAdapter(adapter);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(nameSearchPage.this, "No Parks to Display", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(nameSearchPage.this);
        requestQueue.add(jsonObjectRequest);

    }
}