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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParkNameAdapter extends RecyclerView.Adapter<ParkNameAdapter.ParkViewHolder> {

    private ArrayList<Park> parksList = new ArrayList<>();
    private Context context;

    public ParkNameAdapter(ArrayList<Park> parksList, Context context) {

        this.parksList = parksList;
        this.context = context;
    }

    public void filterList(ArrayList<Park> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        parksList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ParkNameAdapter.ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parkrecyclerview,
                parent, false);
        return new ParkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkNameAdapter.ParkViewHolder holder, int position) {

        try{
            holder.name.setText(parksList.get(position).getName().substring(0,2));
            holder.image.setOnClickListener(v -> new AlertDialog.Builder(context)
                    .setTitle(parksList.getName())
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("View", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(context, ViewParkName.class);
                            intent.putExtra("id", position);
                            context.startActivity(intent);
                        }
                    })

                    .show());
        }
    }

    @Override
    public int getItemCount() {
        return parksList.size();
    }


    public static class ParkViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;

        public ParkViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.flower1);
            name = itemView.findViewById(R.id.parkName);

        }

        public interface OnNoteListener(
                void onNoteClicker(int position);
        )
    }

}
