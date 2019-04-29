package com.shishike.myapplication.testsuite;

import com.shishike.myapplication.Beauty;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Created by tdd on 2019/1/3.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class TestRunCase {
    public static Test suite() {

        TestSuite suite = new TestSuite("TestRunCase");
        suite.addTestSuite(Beauty.class);
        return suite;
    }

}
