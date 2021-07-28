package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import org.w3c.dom.Text;


public class searchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);


        getSupportActionBar().hide();
        //variables
        TextView textView = findViewById(R.id.infoTagName);
        TextView textView1 = findViewById(R.id.weatherTagName);
        ImageView searchButton = findViewById(R.id.searchPark);
        TextView searchName = findViewById(R.id.searchParkName);
        Button north = findViewById(R.id.northButton);
        Button west = findViewById(R.id.westButton);
        Button south = findViewById(R.id.southButton);
        Button east = findViewById(R.id.eastButton);

        //when user clicks on North
        north.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, NorthParkListActivity.class);
                startActivity(intent);
            }
        });

        //when user clicks on West
        west.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, WestParkListActivity.class);
                startActivity(intent);
            }
        });

        //when user clicks on South
        south.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, SouthParkListActivity.class);
                startActivity(intent);
            }
        });

        //when user clicks on East
        east.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, EastParkListActivity.class);
                startActivity(intent);
            }
        });



        //when user clicks on informationTagName
        searchButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, ParkListActivity.class);
                startActivity(intent);
            }
        });

        //when user clicks on informationTagName
        textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, informationPage.class);
                startActivity(intent);
            }
        });

        //when user clicks on weatherTagName
        textView1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, weatherPage.class);
                startActivity(intent);
            }
        });
    }

}
