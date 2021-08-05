package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class ViewParkName extends AppCompatActivity {

    private Park park;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_park_name);

        this.name = findViewById(R.id.textView21);
        TextView back = findViewById(R.id.textView23);

        int id = getIntent().getIntExtra("id", 0);
        Park info = nameSearchPage.parksList.get(id);
        this.setPark(info);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewParkName.this, nameSearchPage.class);
                startActivity(intent);
            }
        });
    }

    private void setPark(Park park){
        this.park = park;
        this.name.setText(park.getName());
    }

    public void browser1 (View view){
        AlertDialogue("https://www.lta.gov.sg/content/ltagov/en/map/fare-calculator.html", "You will be redirected to the LTA Website", view.getContext());
    }

    public void browserNpark (View view){
        AlertDialogue("https://www.nparks.gov.sg/activities", "You will be redirected to the Npark Website", view.getContext());
    }

    public void AlertDialogue(String uri, String message, Context context){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Redirect");
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        AlertDialog toWebPage = builder.create();
        toWebPage.show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}