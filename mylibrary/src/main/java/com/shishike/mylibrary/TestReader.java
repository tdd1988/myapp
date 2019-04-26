package com.shishike.mylibrary;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.robotium.solo.By;
import com.robotium.solo.Solo;


/**
 * Created by tdd on 2019/1/3.
 */

public class TestReader extends ActivityInstrumentationTestCase2 {
    protected static Class<?> launchActivityClass;
    protected Solo solo;
    protected String caseClassName;
    protected String casePackage;
    //protected Solo by;


    static{
        try{
            launchActivityClass = Class.forName("com.shishike.calm.splash.KouBeiLogoAcitivty_");
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public TestReader() throws ClassNotFoundException {
        super(launchActivityClass);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), launchActivityClass);
        //getActivity();
        caseClassName = getClass().getSimpleName()+"#"+getName();
        casePackage = getClass().getPackage().getName().replace("com.shishike.calm.testcases.", "")+".";
        //Log.v("getClass.getSimpleName",getClass().getSimpleName());
        //Log.v("getName",getName());
        //Log.v("getPackage",getClass().getPackage().getName());

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testview(){
        Activity act=solo.getCurrentActivity();
        int id=act.getResources().getIdentifier("id名称","id", act.getPackageName());
        solo.assertMemoryNotLow();
        getInstrumentation().getTargetContext().getApplicationContext();
        solo.clearTextInWebElement(By.className("jdj"));
        RelativeLayout parernt=(RelativeLayout)solo.getText("").getParent();
        ListView search=(ListView)parernt.findViewById(id);
        solo.getView("id");
        solo.takeScreenshot();
    }
}
