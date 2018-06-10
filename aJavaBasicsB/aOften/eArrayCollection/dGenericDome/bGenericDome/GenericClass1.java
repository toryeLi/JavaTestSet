package aOften.eArrayCollection.dGenericDome.bGenericDome;

public class GenericClass1 {
    public static void main(String[] args){
        BaseDao<String> stringBaseDao = new BaseDao<>();
        stringBaseDao.get(11F, "AAA")
    }
}
class BaseDao<T>{
    public <E,X,K> X get(E e,X x){
        System.out.println(e + "----" + x);
        return x;
    }
}