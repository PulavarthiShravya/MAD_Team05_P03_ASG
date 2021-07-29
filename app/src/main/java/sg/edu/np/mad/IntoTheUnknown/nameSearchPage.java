package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
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
import java.util.List;

public class nameSearchPage extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private ArrayList<Park> mparksList;

    private ParkNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search_page);

        RequestQueue requestQueue = Volley.newRequestQueue(nameSearchPage.this);
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
                        mparksList.add(new Park(i, nameOfPark));
                    }
                    RecyclerView recyclerView = findViewById(R.id.recyclerView2);
                    ParkNameAdapter adapter = new ParkNameAdapter(mparksList);
                    LinearLayoutManager mLayoutManager =  new LinearLayoutManager(nameSearchPage.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);

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
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        List<Park> newList = new ArrayList<>();
        for (Park park : mparksList){
            if(park.getName().toLowerCase().contains(userInput)){
                newList.add(park);
            }
        }
        adapter.updateList(newList);
        return true;
    }
}