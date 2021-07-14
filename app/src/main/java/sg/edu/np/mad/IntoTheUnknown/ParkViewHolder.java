package sg.edu.np.mad.IntoTheUnknown;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ParkViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name;

    public ParkViewHolder(View itemView){
        super(itemView);

        image = itemView.findViewById(R.id.imageView15);
        name = itemView.findViewById(R.id.parkName);

    }
}
