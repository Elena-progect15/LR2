package Laba3;

import static org.junit.Assert.assertTrue;
import Laba2.Rumber;
import org.junit.Test;

public class RumberTest{


	@Test
	public void test() {
	    int high = 700, low = 1, c;
		Rumber chislo = new Rumber ();
		c = chislo.number();
		assertTrue(high >= c);
		assertTrue(low  <= c);
		System.out.println(c);
	}
	
	}	
