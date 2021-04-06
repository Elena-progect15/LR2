package Laba2NRR;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Laba2.Rumber;

public class MasGenTest {
	private static int z;
	@BeforeClass
	public static void RumberTest() {
		Rumber rum =new Rumber ();
		z=(rum.number());
	}

	@Test
	public void test() {
		int[] q=new int [8]; 
		for (int i=0; i<8; i++) {
			RumberTest();
			q[i]=z;
			System.out.println(z);
		}
		assertTrue(q.length==8);
		assertFalse(q==null);
	}

}
