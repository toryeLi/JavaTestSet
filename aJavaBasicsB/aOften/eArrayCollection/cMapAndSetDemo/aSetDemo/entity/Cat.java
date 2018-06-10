package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity;

public class Cat implements Comparable  {
    private Integer size;

    public Cat() {
    }
    public Cat(Integer size) {
        this.size = size;
    }

    public Integer getSize() {

        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Cat){
            Cat o1 = (Cat) o;
            return this.size-o1.size;
        }
        return 0;
    }
}
