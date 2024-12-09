package tpsit.thread;

public class HelloThreads extends Thread{
	/**
	 *un thread in java puo essere realizzato in vari modi:
	 *faccio una classe che estende la classe nativa di java Thread
	 *che ha due metodi principali:
	 *start(): fa partire il thread 
	 *run() contiene il codice che deve essere eseguito dal thread 
	 */
	public static void main(String args[]) {
		HelloThreads t1 =new HelloThreads();
		t1.start();
	}
	public void run() {
		System.out.println("Hello from a thread");
	}
}
