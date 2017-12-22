package cc.ifnot.demo.bean;

import java.util.Date;

public class Demo extends Base {

    private int id;
    private String name;
    private Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
