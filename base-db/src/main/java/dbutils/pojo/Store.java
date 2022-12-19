package dbutils.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Store {

    public int id;
    public String name;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Timestamp data_updated_at;
    public Date day;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", data_updated_at=" + data_updated_at +
                ", day=" + day +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getData_updated_at() {
        return data_updated_at;
    }

    public void setData_updated_at(Timestamp data_updated_at) {
        this.data_updated_at = data_updated_at;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
