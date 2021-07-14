package sg.edu.np.mad.IntoTheUnknown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ParkListActivity extends AppCompatActivity {

    static List<Park> parksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);

        //recycler view, list of everything
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ParkAdapter adapter = new ParkAdapter(parksList);
        LinearLayoutManager layoutManager =  new LinearLayoutManager(this);

        //DB
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.addItemDecoration(divider);
    }
}
