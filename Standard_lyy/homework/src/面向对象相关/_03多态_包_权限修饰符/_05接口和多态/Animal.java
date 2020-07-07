package 面向对象相关._03多态_包_权限修饰符._05接口和多态;

public abstract class Animal {
    private String name;
    private String weight;
    public Animal(){}

    public Animal(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public  abstract void eat();
}
