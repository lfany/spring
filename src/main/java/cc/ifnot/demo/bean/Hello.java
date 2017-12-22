package cc.ifnot.demo.bean;

public class Hello extends Base {

    private final long id;
    private final String hello;

    public Hello(long id, String hello) {
        this.id = id;
        this.hello = hello;
    }

    public long getId() {
        return id;
    }

    public String getHello() {
        return hello;
    }
}