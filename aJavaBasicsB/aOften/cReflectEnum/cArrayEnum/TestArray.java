package aOften.cReflectEnum.cArrayEnum;

/**
 * 成员变量：定义在类的里面，方法的外面
 * 特点：当前类初始化的时候会自动初始化缺省值（默认值）
 * 局部变量：定义在方法里面
 * 特点：使用前必须初始化
 *
 */
public class TestArray {
    private static float age;
    private static Object obj;
    public static void main(String[] args){
        // 1个班级有40名同学的时候，想存储这些同学姓名的话，需要定义40个变量来存储学生的名称
        // 40名学生定义40个变量，如果是1000人呢，那么是不是要定义1000个变量来存储，不现实。
        // 数组： 用于存储同一个类型的元素[基本数据类型，引用数据类型]的集合。
        // 数组定义语法: 数据类型[] 数组名称 = 初始化数组
        // 注意： 数组的定义必须要指定长度。

        ////////////////// 数组的方式 /////////////////////
        String[] names1 = new String[1000];
        // 数组句柄
        // 局部变量： 使用前必须初始化
        String[] names2 = null;
        names2 = new String[100];

        int[] ages1 = {}; // ages！=null 但是length为0的
        int[] ages2 = new int[]{};
        System.out.println("数组长度为:"+ages2.length);

        ///////////////////// 数组的初始化 //////////////////
        float[] prices = {1.1F,3.2F,4.5F,6.7F};
        int[] numbers1 = new int[] {1,4,5,6,3,6,2};
        int[] numbers2 = new int[5];
        // 通过数组对应元素下标(从0开始的)来赋值
        numbers2[0] = 100;
        numbers2[1] = 110;
        numbers2[2] = 120;
        numbers2[3] = 130;
        numbers2[4] = 140;
        // numbers2[5] = 200; // java.lang.ArrayIndexOutOfBoundsException(数组下标越界)

        //////////////// 数组的读取 ////////////////////
        // 通过指定下标获取
        // 语法： 数组对象变量[索引]
        System.out.println("numbers[3] = " + numbers2[3]);
        System.out.println("------------------------------------");
        // 遍历数组中的每一个元素
        // 只要你在java中操作的对象存在容量，那么必须判断这个对象是否为null&& 判断容量是否>0
        if (numbers2 != null && numbers2.length > 0) {
            // 普通遍历集合元素
            for (int i = 0; i < numbers2.length; i++) {
                System.out.println("numbers2["+i+"]="+numbers2[i]);
            }
            System.out.println("----------------------------");
            // 增强for循环
            for (int element : numbers2) {
                System.out.println(element);
            }
        }
    }
}
