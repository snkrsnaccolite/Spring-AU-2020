package one.traction.models;

public class Employee {
    private Integer id;
    private String name;

    public Employee(String name) {
        Integer min = 1111;
        Integer max = 9999;

        this.id = (int)(Math.random() * ((max - min) + 1)) + min;
        this.name = name;
    }

    public Integer getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean setName(String name) {
        if (name.length() != 0) {
            this.name = name;
            return true;
        }
        return false;
    }
}
