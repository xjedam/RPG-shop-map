package models;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Map extends Model {

    @Required
    private String name;

    private Blob backgroundImage;

    @ManyToMany
    private List<Shop> shops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public Blob getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Blob backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String toString() {
        return name;
    }
}
