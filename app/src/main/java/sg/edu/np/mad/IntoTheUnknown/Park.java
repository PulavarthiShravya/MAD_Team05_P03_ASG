package sg.edu.np.mad.IntoTheUnknown;

import android.media.Image;

import java.util.UUID;

public class Park{
    public int id;
    public String name;
    public String description;
    public Park() {
    }
    public Park(int id, String name) {
        this.id = id;
        this.name = name;
        //this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
