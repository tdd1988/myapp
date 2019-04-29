package testgson;

import java.io.File;
import java.io.IOException;

/**
 * Created by tdd on 2019/1/19.
 */

public class Sds {
    public static void main(String[] args) {
        Sds gh = new Sds();
        try {
            gh.skdf();
        } catch (IOException E) {
            System.out.println("chuangjian wenjian dsjd");

        }
    }

    public void skdf() throws IOException{
        File fir= new File("/Users/tdd/Desktop/tdd2/ys/yss");
        if(!fir.exists()){
            fir.mkdirs();
        }else{
            System.out.println("文件夹已存在！！！");
        }

        File firs=new File("/Users/tdd/Desktop/td/ys/yss"+"/.tdds.txt");
        if(!firs.exists()){
            firs.createNewFile();
        }else {
            System.out.println("文件已存在");
        }
    }
    }



