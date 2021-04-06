package Laba2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class Bubletest {
	static ArrayBubble array;
	
    @BeforeClass
    public static void setUp() throws Exception {
        array = new ArrayBubble(5);
        array.into(1);//заполняем массив
        array.into(5);
        array.into(3);
        array.into(4);
        array.into(2);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        array = null;
        
    }

    @Test
    public void bubbleSorter() {
        array.bubbleSorter();
        assertArrayEquals(new long[]{1,2,3,4,5},array.Test());
    }
}

