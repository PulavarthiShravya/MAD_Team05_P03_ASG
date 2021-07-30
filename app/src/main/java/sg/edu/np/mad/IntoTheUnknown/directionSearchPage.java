package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class directionSearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_search_page);

        //variables
        Button north = findViewById(R.id.northButton);
        Button west = findViewById(R.id.westButton);
        Button south = findViewById(R.id.southButton);
        Button east = findViewById(R.id.eastButton);
        TextView back = findViewById(R.id.textView20);

        //when user clicks on North
        north.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(directionSearchPage.this, ParkListActivity.class);
                intent.putExtra("value", 1);
                startActivity(intent);
            }
        });

        //when user clicks on South
        south.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(directionSearchPage.this, ParkListActivity.class);
                intent.putExtra("value",2);
                startActivity(intent);
            }
        });

        //when user clicks on East
        east.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(directionSearchPage.this, ParkListActivity.class);
                intent.putExtra("value",3);
                startActivity(intent);
            }
        });

        //when user clicks on West
        west.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(directionSearchPage.this, ParkListActivity.class);
                intent.putExtra("value",4);
                startActivity(intent);
            }
        });

        //when user clicks on BacK (<)
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(directionSearchPage.this, searchPage.class);
                startActivity(intent);
            }
        });

    }

}