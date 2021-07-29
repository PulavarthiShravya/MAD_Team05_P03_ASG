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

        //variables

        Button direction = findViewById(R.id.directionButton);
        Button name = findViewById(R.id.nameButton);
        ImageView weather = findViewById(R.id.weatherTag);
        ImageView info = findViewById(R.id.infoTab);

        //when user clicks on direction
        direction.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, directionSearchPage.class);
                startActivity(intent);
            }
        });

        //when user clicks on name
        name.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, nameSearchPage.class);
                startActivity(intent);
            }
        });

        //when user clicks on weather
        weather.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, weatherPage.class);
                startActivity(intent);
            }
        });

        //when user clicks on info
        info.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPage.this, weatherPage.class);
                startActivity(intent);
            }
        });

    }

}
