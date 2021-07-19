package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class weatherPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_page);

        getSupportActionBar().hide();
        //variables
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
    }
}

//To-do:
//weather API, display them as needed