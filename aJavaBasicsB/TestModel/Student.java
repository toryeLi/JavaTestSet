package TestModel;

import java.util.Date;

public class Student {
    static {
        System.out.println("执行了Student类中 static的方法");
    }
    public Integer id;
    String Name;
    protected String set;
    private Integer age;
    public Date birth;

    public Student() {
        System.out.println("Student 无参构造函数=================");
    }

    public Student(Integer id, String name) {
        System.out.println("Student 两个参数构造函数=================");
        this.id = id;
        Name = name;
    }

    public Student(Integer id) {
        System.out.println("Student  一个参数构造函数=================");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
