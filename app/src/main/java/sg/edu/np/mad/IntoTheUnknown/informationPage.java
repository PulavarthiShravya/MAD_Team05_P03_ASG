package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class informationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);


        //variables
        Button button = findViewById(R.id.button);
        TextView weather = findViewById(R.id.textView14);
        TextView search = findViewById(R.id.textView18);

        //creating on click action to redirect user to next page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage.this, informationPage2.class);
                //start activity
                startActivity(intent);
            }
        });

        //redirecting user to weather page
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage.this, weatherPage.class);
                //start activity
                startActivity(intent);
            }
        });

        //redirecting user to search page
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage.this, searchPage.class);
                //start activity
                startActivity(intent);
            }
        });
    }
}
