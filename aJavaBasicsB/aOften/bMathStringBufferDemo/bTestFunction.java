package aOften.bMathStringBufferDemo;

/**
 * 测试String,StringBuffer效率
 * StringBuffer和StringBuilder区别：
 * StringBuffer是线程安全的，StringBuilder是非线程安全的
 */
public class bTestFunction {

    public static void main(String[] args) {

    }

    //
    private static void testStringBuffer() {
        StringBuffer sb = new StringBuffer("AAA");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= 50000; i++) {
            sb.append("BBB");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuffer用时" + (endTime - startTime));
    }

    private static void testString() {
        String str = "AAA";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= 50000; i++) {
            str += "BBB";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String用时:" + (endTime - startTime));

    }
}














