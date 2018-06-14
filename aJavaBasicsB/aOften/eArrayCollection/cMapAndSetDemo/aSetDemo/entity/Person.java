package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity;

public class Person implements Comparable {
    private int id;//学号是唯一的
    private String name;

    public Person() {
    }

    @Override
    public int hashCode() {
        //  System.out.println("1");
        //    return this.getId()+this.getName().hashCode();
        return (this.getId() + this.getName()).hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*
        @Override
        public boolean equals(Object obj) {

           // System.out.println("2");
            if (obj instanceof Person) {
                Person p = (Person) obj;
                //判断Id相同和name相同则是同一个人
                //流程是：先判断hashCode是否相同，如果hashCode相同，在判断equals方法是否相同
               return p.getId().equals(this.getId())&&p.getName().equals(this.getName());
             //   return true;
            }
            return  false;
        }
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person) obj;
        return this.getId()== p.getId()&&this.getName()==p.getName();
    }

    public Person(Integer id, String name) {

        this.id = id;
        this.name = name;
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

    @Override
    public int compareTo(Object o) {
        //比较的过程返回3个值 >1,=0,<0
        if (o instanceof Person) {
            Person o1 = (Person) o;
            //o1代表与this比较的元素
            //this 指即将添加到集合的元素
//            System.out.println(o1 + "----------" + this);
//            System.out.println(o1.getId() - this.getId());
            return o1.getId() - this.getId();
            //   return o1.getName().hashCode()-this.getName().hashCode()>0?1:(o1.getName().hashCode()-this.getName().hashCode()==0?0:-1);
        }
        return 0;
    }
}
