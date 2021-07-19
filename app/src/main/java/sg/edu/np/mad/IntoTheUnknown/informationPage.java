package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class informationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        getSupportActionBar().hide();

        //variables
        Button button = findViewById(R.id.button);
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
    }
}
//To Do:
//need to add screenshot of how weather page looks like