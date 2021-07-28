package sg.edu.np.mad.IntoTheUnknown;

import android.app.AlertDialog;
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
        Park info = parks.get(position);
        holder.name.setText(info.name);
    }
    @Override
    public int getItemCount() {
        return parks.size();
    }
}
