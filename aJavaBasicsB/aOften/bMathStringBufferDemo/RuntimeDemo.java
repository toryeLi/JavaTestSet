package aOften.bMathStringBufferDemo;

public class RuntimeDemo {

    public static  void getFreeMemory(){
        long value=Runtime.getRuntime().freeMemory();//获取可用内存
        System.out.println("可用内存为：" + value / 1024 / 1024 + "mb");
        long totalMemory=Runtime.getRuntime().totalMemory();//获取jvm的总量，该值会不断的变化
        System.out.println("全部内存为：" + totalMemory / 1024 / 1024 + "mb");
        //获取jvm可以最大使用的内存数量，如果没有被限制 返回 Long.MAX_VALUE;
        long maxMemory=Runtime.getRuntime().maxMemory();
        System.out.println("可用最大内存为：" + maxMemory / 1024 / 1024 + "mb");
    }

    public static void main(String[] args) {
        Runtime run=Runtime.getRuntime();
//        Process proc=run.exec("mspaint")
        //获取内存信息
      getFreeMemory();
      //获取可用CPU核数
        System.out.println(run.availableProcessors());
    }

}
