package aOften.fFileIO.aFileAndStream;

import java.io.File;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args){
listDirAllFiles(null);
    }

    /**
     * 遍历指定目录下的所有文件
     * @param pathStr
     */
    private static void listDirAllFiles(String pathStr){
        if(pathStr==null||pathStr.trim()==""){
            System.out.println("路径不能为空");
            return;
        }
        File file = new File(pathStr);
        if(file.exists()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isDirectory()){
                    listDirAllFiles(file1.getPath());
                }else {
                    System.out.println(file1.getPath());
                }
            }
        }else {
            System.out.println("不存在该路径");
        }
    }

    /**
     * 创建目录及文件的方法
     */
    private static void testCreateDirAndFile( ){
        File file = new File("D:/a/b/a.txt");
        String parent = file.getParent();
        File dirFile = new File(parent);
        if(!dirFile.exists()){
            //dirFile.mkdir();//创建一级目录
            dirFile.mkdirs(); //创建多级目录
        }
        //创建文件
        if(!file.exists()){
            try {
                boolean newFile = file.createNewFile();
                System.out.println(newFile ? "创建成功" : "创建失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
// 文件属性
        System.out.println("最后修改时间:"+new Date(file.lastModified()));
        System.out.println("文件路径:"+file.getAbsolutePath());
        System.out.println("文件名称:"+file.getName());
        System.out.println("文件的大小:"+file.length());
        System.out.println("是否可读:"+file.canRead());
        System.out.println("是否可写:"+file.canWrite());
        System.out.println("是否隐藏:"+file.isHidden());

        // 删除文件（文档才能直接删除，文件夹必须为空才能删除）
        file.delete();
    }
}
