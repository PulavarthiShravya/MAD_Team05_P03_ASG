package sg.edu.np.mad.IntoTheUnknown;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParkNameAdapter extends RecyclerView.Adapter<ParkNameAdapter.ParkViewHolder> {
    private List<Park> mparksList;

    public static class ParkViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;

        public ParkViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.flower1);
            name = itemView.findViewById(R.id.parkName);

        }
    }

    public ParkNameAdapter(ArrayList<Park> parksList) {
        mparksList = parksList;
    }

    @Override
    public ParkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name_search_page,
                parent, false);
        ParkViewHolder pvh = new ParkViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ParkViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Park info = mparksList.get(position);
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
        return mparksList.size();
    }

    public void updateList(List<Park> newList){
        mparksList = new ArrayList<>();
        mparksList.addAll(newList);
        notifyDataSetChanged();
    }
}
