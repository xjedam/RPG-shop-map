package models;

import play.db.jpa.Model;

public abstract class JsonModel extends Model {
    public abstract String toJson();
}
