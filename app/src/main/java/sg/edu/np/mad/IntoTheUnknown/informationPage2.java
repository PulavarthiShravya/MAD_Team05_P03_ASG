package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class informationPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page2);


        //variables
        Button button = findViewById(R.id.button2);
        TextView weather = findViewById(R.id.textView14);
        TextView search = findViewById(R.id.textView18);

        //redirect user to first information page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage2.this, informationPage.class);
                //start activity
                startActivity(intent);
                finish();
            }
        });

        //redirect user to weather page
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage2.this, weatherPage.class);
                //start activity
                startActivity(intent);
                finish();
            }
        });

        //redirect user to search page
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating intent
                Intent intent = new Intent(informationPage2.this, searchPage.class);
                //start activity
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
