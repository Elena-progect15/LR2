package Laba2;

public class MasGen {
	Rumber rum = new Rumber();//ѕолучаем доступ классу Rumber
	public static int x; // —оздаЄм статическую переменную
	public void arr () {
		int[] q=new int [8]; //ќбъ€вл€ю массив и выдел€ю пам€ть на 8 элементов
		for (int i=0; i<8; i++) { 
			q[i]=rum.number();
			x=q[i];

}
}}