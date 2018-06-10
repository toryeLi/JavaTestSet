package aOften.eArrayCollection.dGenericDome.aListDemo.entity;

public class Student implements Comparable<Student> {
 private Integer id;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    public Student() {
    }

    public Student(Integer id) {

        this.id = id;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {
        System.out.println((this.getId() - o.getId()));
        return this.getId()-o.getId();
     //   return o.getId()-this.getId();
    }
}
