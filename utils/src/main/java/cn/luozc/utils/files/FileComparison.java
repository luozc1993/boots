package cn.luozc.utils.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileComparison {


    public static void main(String[] args) {
        //oa(3);
        baogao();
    }
    //源文件E:\工作\工作\version
    static String  pathOA1 = "D:\\office\\apache-tomcat-9.0.13\\webapps\\ERDS_JAVA";
    //目标文件
    static String pathOA2 = "E:"+File.separator+"工作"+File.separator+"工作"+File.separator+"version"+File.separator+"complete"+File.separator+"ce";

    static String pathversionOA = "E:"+File.separator+"工作"+File.separator+"工作"+File.separator+"version"+File.separator+"version";
    public static void oa(int i){
        System.err.println("程序开始执行");


        File fileversion = new File(pathversionOA);
        File[] files = fileversion.listFiles();
        List<String> list = new ArrayList<>();
        for (File file:files) {
            list.add(file.getName());
        }
        Collections.sort(list);
        String name = "";
        if(list.size()>0){
            name = list.get(list.size() - 1);

            String[] names = name.split("-");
            names[i] = String.valueOf(Integer.valueOf(names[i]) + 1);
            name = names[0]+"-"+names[1]+"-"+names[2]+"-"+names[3];
        }
        //差异文件
        String path3 = "E:"+File.separator+"工作"+File.separator+"工作"+File.separator+"version"+File.separator+"version"+File.separator+name+File.separator+"ce";

        File file1 = new File(pathOA1);
        File file2 = new File(pathOA2);
        File file3 = new File(path3);
        if(!file1.exists()){
            return;
        }
        boolean exists = file3.exists();
        if(exists){
            deleteFile(file3);
        }
        //获取源文件子文件
        comparisonOA(pathOA1, pathOA2, path3, file1);
        System.err.println("程序执行结束=====");
    }


    private static void comparisonOA(String path1, String path2, String path3, File file1) {
        File[] files1 = file1.listFiles();
        for (int i = 0; i < files1.length; i++) {
            File file = files1[i];
            if(file.getPath().equals(pathOA1+"\\rs\\Temp")||
                    file.getPath().equals(pathOA1+"\\rs\\XcxCode")||
                    file.getPath().equals(pathOA1+"\\WEB-INF\\classes\\custom")||
                    file.getPath().equals(pathOA1+"\\WEB-INF\\classes\\ioc")||
                    file.getPath().equals(pathOA1+"\\WEB-INF\\classes\\db\\version.txt")){
                continue;
            }
            //判断是否为文件夹
            boolean directory = file.isDirectory();
            if(directory){
                String dir = file.getPath();
                String dir2 = dir.replace(path1,path2);
                String dir3 = dir.replace(path1,path3);
                comparisonOA(dir,dir2,dir3,file);
            }else {

                String path = file.getPath();
                String replace = path.replace(path1, path2);
                File f = new File(replace);
                boolean exists = f.exists();
                if(exists){
                    long length = file.length();
                    long length1 = f.length();
                    if(length!=length1){
                        copy(path1, path3, file);
                        copy(path1, path2, file);
                    }
                }else{
                    copy(path1, path3, file);
                    copy(path1, path2, file);
                }
            }
        }
    }



    public static void baogao(){
        System.err.println("程序开始执行");
        //源文件
        String path1 = "E:"+File.separator+"nutz"+File.separator+"baogao-yubodatas"+File.separator+"baogao"+File.separator+"target"+File.separator+"baogao";
        //目标文件
        String path2 = "D:"+File.separator+"version"+File.separator+"baogao1";
        //差异文件
        String path3 = "D:"+File.separator+"version"+File.separator+"baogao";

        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);
        if(!file1.exists()){
            return;
        }
        boolean exists = file3.exists();
        if(exists){
            deleteFile(file3);
        }
        //获取源文件子文件
        comparison(path1, path2, path3, file1);
        System.err.println("程序执行结束=====");
    }

    /**
     * 先根遍历序递归删除文件夹
     *
     * @param dirFile 要被删除的文件或者目录
     * @return 删除成功返回true, 否则返回false
     */
    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {

            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }


    private static void comparison(String path1, String path2, String path3, File file1) {

        File[] files1 = file1.listFiles();
        for (int i = 0; i < files1.length; i++) {
            File file = files1[i];
            //判断是否为文件夹
            boolean directory = file.isDirectory();
            if(directory){
                String dir = file.getPath();
                String dir2 = dir.replace(path1,path2);
                String dir3 = dir.replace(path1,path3);
                comparison(dir,dir2,dir3,file);
            }else {

                String path = file.getPath();
                String replace = path.replace(path1, path2);
                File f = new File(replace);
                boolean exists = f.exists();
                if(exists){
                    long length = file.length();
                    long length1 = f.length();
                    if(length!=length1){
                        copy(path1, path3, file);
                        copy(path1, path2, file);
                    }
                }else{
                    copy(path1, path3, file);
                    copy(path1, path2, file);
                }
            }
        }
    }

    private static void copy(String path1, String path3, File file) {
        String parent = file.getParent();
        String replace1 = parent.replace(path1, path3);
        FileUtil.copy(file,new File(replace1));
    }





}
