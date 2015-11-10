package models;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Entity
public class Shop extends JsonModel {

    @Required
    private String name;

    @Column(columnDefinition = "TEXT")
    @MaxSize(1000)
    private String description;

    private int xCoordinate;

    private int yCoordinate;

    private Blob image;

    @OneToMany
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String toString() {
        return name;
    }

    public String getBase64Image() {
        if (!getImage().exists()) {
            return null;
        }

        try {
            return Base64.encodeBase64String(IOUtils.toByteArray(getImage().get()));
        } catch(IOException e) {
            System.out.println("ERROR: cannot read shop image file");
            return null;
        }
    }

    public String toJson() {
        return String.format("{\"name\": \"%s\"" +
                ", \"description\": \"%s\"" +
                ", \"xCoordinate\": %d" +
                ", \"yCoordinate\": %d" +
                ", \"image\": \"%s\"}",
                getName(), getDescription(), getxCoordinate(), getyCoordinate(),
                getBase64Image());
    }
}
