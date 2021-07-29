package sg.edu.np.mad.IntoTheUnknown;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParkAdapter extends RecyclerView.Adapter<ParkViewHolder>{
    List<Park> parks;
    AlertDialog.Builder builder;
    public ParkAdapter(List<Park> parks){
        this.parks = parks;
    }
    //UserViewHolder Class
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.parkrecyclerview,parent, false);
        return new ParkViewHolder(item);
    }
    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Park info = parks.get(position);
        holder.name.setText(info.name);
        holder.image.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle(info.name)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, ViewPark.class);
                        intent.putExtra("id", position);
                        context.startActivity(intent);
                    }
                })

                .show());
    }
    @Override
    public int getItemCount() {
        return parks.size();
    }

    public void updateParksList(List<Park> updatedList){
        parks.clear();
        parks.addAll(updatedList);
        ParkAdapter.this.notifyDataSetChanged();
    }

}
