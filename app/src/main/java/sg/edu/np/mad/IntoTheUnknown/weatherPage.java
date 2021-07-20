package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class weatherPage extends AppCompatActivity {
    //declare universal variable
    TextView currentTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_page);

        getSupportActionBar().hide();
        //variables (nav bar)
        TextView information = findViewById(R.id.textView28);
        TextView search = findViewById(R.id.textView29);

        //redirect to information page
        information.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weatherPage.this, informationPage.class);
                startActivity(intent);
            }
        });

        //redirect to search page
        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weatherPage.this, searchPage.class);
                startActivity(intent);
            }
        });

        //variables for displaying temperature
        currentTemperature = findViewById(R.id.currentTemperature);

        //method to find the weather and display current temperature
        find_weather();
    }

    public void find_weather(){
        //api url + api key as well
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=1.3521&lon=103.8198&appid=2208cad7b3134f7a764a2d2acde4b635&units=metric";

        //Passing JSONObject
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //the "part" which we need take the temperature from
                    JSONObject main_object = response.getJSONObject("main");

                    JSONArray array = response.getJSONArray("weather");
                    //getting the first index
                    JSONObject object = array.getJSONObject(0);
                    //getting the value of current Temperature
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    //setting the current temp value inside XML
                    currentTemperature.setText(temp);
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}

//To-do:
//weather API, display them as needed