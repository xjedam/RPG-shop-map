package controllers;

import models.Map;
import models.Shop;
import play.db.Model;
import play.db.jpa.JPA;
import play.exceptions.TemplateNotFoundException;

import javax.persistence.Query;
import java.lang.reflect.Constructor;
import java.util.List;

public class Maps extends CRUD {

    public static void show(String id) throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Map object = (Map)type.findById(id);
        notFoundIfNull(object);

        List<Shop> shops = object.getShops();
        System.out.println(shops.size());
        try {
            render(type, object);
        } catch (TemplateNotFoundException e) {
            render("Map/show.html", type, object);
        }
    }

    public static void blank() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        try {
            render(type, object);
        } catch (TemplateNotFoundException e) {
            render("Map/blank.html", type, object);
        }
    }

}
