package org.arvios.jpaapps.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by artem-ostrovsky on 16.10.2016.
 */
@Entity
@Table(name="Dish")
public class Dish {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public Dish() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (!id.equals(dish.id)) return false;
        return name.equals(dish.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
