package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class ParkListActivity extends AppCompatActivity {

    static List<Park> parksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);

        String url = "https://tih-api.stb.gov.sg/national-park/v1/name/ ?apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
        RequestQueue requestQueue = Volley.newRequestQueue(ParkListActivity.this);

        //making JSON object request
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



                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ParkListActivity.this, "Please enter a park name", Toast.LENGTH_SHORT).show();
                }
        });

        requestQueue.add(jsonObjectRequest);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ParkAdapter adapter = new ParkAdapter(parksList);
        LinearLayoutManager mLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
