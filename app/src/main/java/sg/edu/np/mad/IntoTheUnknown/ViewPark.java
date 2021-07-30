package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPark extends AppCompatActivity {

    private Park park;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_park);

        this.name = findViewById(R.id.textView21);
        TextView back = findViewById(R.id.textView23);

        int id = getIntent().getIntExtra("id", 0);
        Park info = ParkListActivity.parksList.get(id);
        this.setPark(info);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPark.this, ParkListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setPark(Park park){
        this.park = park;
        this.name.setText(park.getName());
    }

    public void browser1 (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lta.gov.sg/content/ltagov/en/map/fare-calculator.html"));
        startActivity(intent);
    }
}