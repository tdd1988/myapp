package com.shishike.mylibrary;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    TreeSet a=null;

    @Before
    public void testTreeSetTest(){
        a=new TreeSet();
        a.add(0);
    }


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(0, a.first());
    }
}