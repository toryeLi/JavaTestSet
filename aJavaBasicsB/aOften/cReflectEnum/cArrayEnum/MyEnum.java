package aOften.cReflectEnum.cArrayEnum;

import java.util.Arrays;

/**
 * 枚举是值类型，它里面的元素都是常量
 * 特点：
 * 1 私有构造函数，避免被继承和扩展
 * 2 定义方法的参数时，必须用枚举常量类型。如上面的Constant,这样就转变成了强类型，不会出现弱类型引用的问题。
 * 3 常量值地址唯一，可以用==直接对比，性能会有提高
 * 4 编译时，没有把常量值编译到代码里，即使常量的值发生变化，也不会影响引用常量的类。
 */
public class MyEnum {
   public static void main(String[] args){
       //声明枚举对象
       Direction direction = Direction.DOWN;
       //获取枚举元素中的值
       System.out.println(direction.ordinal());
       System.out.println(direction);
       //获取枚举的所有值
       Direction[] values = Direction.values();
       System.out.println(Arrays.toString(values));
       //获取枚举元素对应的值
       System.out.println(Direction.valueOf("LEFT"));
       //定义一个枚举对象
       ResultCode code = ResultCode.ERROR_CODE;
       System.out.println(ResultCode.getCodeName(1000011));
       //定义一个带抽象方法的枚举
       AbstractMark abstractMark = AbstractMark.HTML;
       System.out.println(abstractMark);
       System.out.println(abstractMark.getInfo());
   }
}
enum Direction{
    UP,
    DOWN,
    LEFT,
    RIGHT,
    NONE
}
enum ResultCode{
    ERROR_CODE(20001,"支付失败"),
    INFO_CODE(300031,"订单取消"),
    STATUS_CODE(1000011,"支付正常"),
    FAIL_CODE;
    private  int code;
    private String codeName;
    private ResultCode(){

    }
    private ResultCode(int code,String codeName){
        this.code=code;
        this.codeName=codeName;
    }

    /**
     * 通过编码获取到对象的信息
     * @param code
     * @return
     */
    public static String getCodeName(int code){
    for (ResultCode resultCode : ResultCode.values()) {
        if (resultCode.code==code) {
            return resultCode.codeName;
        }
    }
     return null;
}
}
enum AbstractMark{
    CSS{
        @Override
        public String getInfo() {
            return "层叠样式表";
        }
    },
    HTML{
        @Override
        public String getInfo() {
            return "超文本标记语言";
        }
    },
    JAVA{
        @Override
        public String getInfo() {
            return "面向对象编程";
        }
    },
    SQLSERVER{
        @Override
        public String getInfo() {
            return "SQLSERVER数据库";
        }
    };
public abstract String getInfo();
}
