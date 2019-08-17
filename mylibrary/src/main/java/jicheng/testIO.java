package jicheng;

import android.app.Instrumentation;
import android.test.ActivityTestCase;
import android.test.InstrumentationTestCase;
import android.app.Activity;

import com.robotium.solo.Solo;
import com.shishike.mylibrary.TestIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by tdd on 2019/3/19.
 */

public class testIO extends Solo {
    public testIO(Instrumentation instrumentation) {
        super(instrumentation);
    }

    public void test(){

    }


    public static void writeNameToText(String filePath, String filename) {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
            out.write(filename + "\r");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        writeNameToText("/Users/tdd/Desktop/chenhan.txt","tddys");

    }
}
