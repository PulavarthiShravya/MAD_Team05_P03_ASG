package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class searchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        //variables

        Button direction = findViewById(R.id.directionButton);
        Button name = findViewById(R.id.nameButton);
        ImageView weather = findViewById(R.id.imageView12);
        ImageView info = findViewById(R.id.imageView13);

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
                Intent intent = new Intent(searchPage.this, informationPage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
