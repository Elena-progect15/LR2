package Laba2;

import java.util.Random;

public class Rumber {
int a=1, b=700;

public int number() {
	Random rand = new Random();
	return rand.nextInt(a + (int) (Math.random() * b));
}


}