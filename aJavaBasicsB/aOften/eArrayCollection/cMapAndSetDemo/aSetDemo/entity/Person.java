package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity;

public class Person {
    private Integer id;//学号是唯一的
    private String name;

    public Person() {
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            //判断Id相同则是同一个人
            return p.getId().equals(this.getId());
        }
        return  false;
    }

    public Person(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
