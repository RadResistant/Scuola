package it.edu.iisgubbio.diversiThread;
public class DiversiThread extends Thread {
	int n;
	int[] vettore=new int[1000];
	public int[] Randomizza() {
		for(int i=0;i<vettore.length-1;i++) {
			vettore[i]=(int)(Math.random()*1000)+1;
		}
		return vettore;
	}
	@Override
	public void run() {
		
	}
	public static void main(String args[]) {
		DiversiThread t1=new DiversiThread();
		t1.Randomizza();
		t1.start();
	}
}