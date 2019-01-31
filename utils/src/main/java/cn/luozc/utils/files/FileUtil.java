package cn.luozc.utils.files;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * 文件工具类
 */
public class FileUtil {


    /**
     *
     * @param filePath 文件路径
     * @return File
     */
    public static File getFile(String filePath){
        return new File(filePath);
    }

    /**
     * 判断文件是否存在
     * @param file //需要判断的文件
     * @return 返回boolean值
     */
    public static boolean isExists(File file){
        return file.exists();
    }

    /**
     * 重命名
     * @param file  需要改名的文件
     * @param newFileName   //新文件名
     * @return true and false
     */
    public static boolean rename(File file,String newFileName){
        if(file.exists()){
            //file.getParent()获取父目录路径   File.separator为分割符
            File newFile = new File(file.getParent() + File.separator + newFileName);
            return file.renameTo(newFile);
        }
        return false;
    }


    public static boolean copy(File file,File newFile){
        if(!file.exists()){                      //判断文件是否存在
            System.out.println("文件不存在");
            return false;
        }
        if(!newFile.exists()){                  //判断目标文件夹是否存在不存在则创建
            if(newFile.mkdirs()){
                System.out.println("目标文件夹不存在，文件夹创建成功");
            }else{
                System.out.println("目标文件夹不存在，文件夹创建失败");
                return false;
            }

        }
        if(file.isDirectory()){             //判断是否为文件夹
            copyDir(file,newFile);
        }else{
            copyFile(file,getFile(newFile+File.separator+file.getName()));
        }
        return true;
    }

    /**
     * 文件夹复制
     * @param dir 源文件夹路径
     * @param file  //目标目标文件夹路径
     * @return  //true and false
     */
    public static boolean copyDir(File dir,File file){
        if(!dir.isDirectory()){
            System.err.println("需要复制的不是文件夹");
            return false;
        }
        File[] files = dir.listFiles();                 //获取子文件
        if(!file.exists()){
            file.mkdir();
        }
        for (int i = 0; i < files.length; i++) {    //遍历源文件夹

            if(files[i].isFile()){                  //若为文件

                copyFile(files[i], new File(file.getPath() + File.separator + files[i].getName()));
            }
            if(files[i].isDirectory()){             //若为文件夹
                File newFile = new File(file.getPath() + File.separator + files[i].getName());//创建目标文件对象
                newFile.mkdir();                    //创建文件夹
                copyDir(files[i],newFile);//复制文件夹
            }

        }
        return true;
    }

    public static void copyFile(File file, File newFile) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);    //根据文件名创建文件输入流
            outputStream = new FileOutputStream(newFile);//根据目标文件路径创建输出流
            byte[] buf = new byte[1024*4];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf,0,buf.length)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
