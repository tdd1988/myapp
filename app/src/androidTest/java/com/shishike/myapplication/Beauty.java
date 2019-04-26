package com.shishike.myapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;


/**
 * Created by tdd on 2018/12/28.
 */

public class Beauty extends ActivityInstrumentationTestCase2 {
    protected static Class<?> launchActivityClass;
    protected Solo solo;
    protected String caseClassName;
    protected String casePackage;


    static{
        try{
            launchActivityClass = Class.forName("com.shishike.calm.splash.KouBeiLogoAcitivty_");
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Beauty() throws ClassNotFoundException {
        super(launchActivityClass);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), launchActivityClass);
        //getActivity();
        caseClassName = getClass().getSimpleName()+"#"+getName();
        casePackage = getClass().getPackage().getName().replace("com.shishike.calm.testcases.", "")+".";
        Log.v("getClass.getSimpleName",getClass().getSimpleName());
        Log.v("getName",getName());
        Log.v("getPackage",getClass().getPackage().getName());

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void test_setMess(){
        Log.v("tiandongdong","哈哈哈哈");
        solo.sleep(3000);
    }

    public void test_setMess2(){
        Log.v("tiandongdong","哈哈哈哈");
        solo.sleep(3000);
    }


}
