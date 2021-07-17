package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class searchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        getSupportActionBar().hide();
        //variables
        TextView textView = findViewById(R.id.infoTagName);
        TextView textView1 = findViewById(R.id.weatherTagName);

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

//Things to do in this class, user can search available parks using search bar (use API)
//when user click on any one of the regions to bring user to that particular search region