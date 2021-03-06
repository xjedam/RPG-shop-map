package models;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Item extends Model {

    @Required
    private String name;

    @Column(columnDefinition = "TEXT")
    @MaxSize(1000)
    private String description;

    private Long price;

    private Blob image;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String toString() {
        return name;
    }
}
