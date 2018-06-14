package aOften.eArrayCollection.dGenericDome.aListDemo.entity;

/**
 * Comparable 此接口强行对实现它的每个类的对象进行整体排序。
 * 这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
 */
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
