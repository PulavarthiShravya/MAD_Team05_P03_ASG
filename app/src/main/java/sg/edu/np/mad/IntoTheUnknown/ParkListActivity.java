package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import java.util.List;

public class ParkListActivity extends AppCompatActivity {

    static List<Park> parksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);
        TextView back = findViewById(R.id.textView24);

        RequestQueue requestQueue = Volley.newRequestQueue(ParkListActivity.this);

        //making JSON object request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, setUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    //go to the data jsonObject
                    JSONArray dataArray = response.getJSONArray("data");

                    parksList.clear();

                    //for loop
                    for (int i = 0; i<dataArray.length(); i++){
                            //getting data from the dataArray
                            JSONObject nameObject = dataArray.getJSONObject(i);
                            //extracting variables
                        String nameOfPark = nameObject.getString("name");
                        parksList.add(new Park(i, nameOfPark));
                    }

                    RecyclerView recyclerView = findViewById(R.id.recyclerview);
                    ParkAdapter adapter = new ParkAdapter(parksList);
                    LinearLayoutManager mLayoutManager =  new LinearLayoutManager(ParkListActivity.this);
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
                    Toast.makeText(ParkListActivity.this, "Please enter a park name", Toast.LENGTH_SHORT).show();
                }
        });

        requestQueue.add(jsonObjectRequest);

        //when user clicks on BacK (<)
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParkListActivity.this, searchPage.class);
                startActivity(intent);
            }
        });
    }

    private String setUrl() {
        Intent intent = getIntent();
        int value = intent.getIntExtra("value", 0);
        String url = "";

        if (value == 1) {
            url = "https://tih-api.stb.gov.sg/national-park/v1?location=1.461502967101%2C%20103.836845425704&radius=7000&apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
            return url;
        }
        else if (value == 2) {
            url = "https://tih-api.stb.gov.sg/national-park/v1?location=1.27884536282398%2C103.8105450682&radius=7000&apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
            return url;
        }
        else if (value == 3) {
            url = "https://tih-api.stb.gov.sg/national-park/v1?location=1.38972941806779%2C103.997184718828&radius=7000&apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
            return url;
        }
        else if (value == 4) {
            url = "https://tih-api.stb.gov.sg/national-park/v1?location=1.33801744333653%2C103.707875524434&radius=7000&apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
            return url;
        }

        /*else if (value == 5)
        {
            url = "https://tih-api.stb.gov.sg/national-park/v1/name/ ?apikey=AuCxF2XWFwNxlSdoWjOYHE71fJqRgi0j";
        }*/

        return url;

    }

}
