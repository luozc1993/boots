package cn.luozc.utils.file;

import cn.luozc.utils.files.FileUtil;
import org.junit.Test;

import java.io.File;

public class FileUtilTest {


    @Test
    public void isExists(){
        boolean exists = FileUtil.isExists(FileUtil.getFile("D://out.log"));
        System.err.println(exists);
    }
    @Test
    public void rename(){

        System.out.println(FileUtil.isExists(FileUtil.getFile("D://out.log"))?"out.log文件存在":"out.log文件不存在");

        FileUtil.rename(FileUtil.getFile("D://out.log"),"out1.log");
        System.out.println(FileUtil.isExists(FileUtil.getFile("D://out.log"))?"out.log文件存在":"out.log文件不存在");

    }
    @Test
    public void copy(){
        for (int i = 0; i < 3; i++) {
            long time = System.currentTimeMillis();
            File file = FileUtil.getFile("d://D.zip");
            FileUtil.copy(file,FileUtil.getFile("D://test/"));
            long time2 = System.currentTimeMillis();
            System.out.println("1024=="+(time2-time));
        }


    }
}
