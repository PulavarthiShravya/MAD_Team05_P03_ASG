package sg.edu.np.mad.IntoTheUnknown;

import android.media.Image;

import java.util.UUID;

public class Park{

    public String id;
    public String name;
    public String description;

    public Park() {
    }

    public Park(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public String getId() {
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
