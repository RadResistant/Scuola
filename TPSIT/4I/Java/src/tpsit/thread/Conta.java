package tpsit.thread;
/**
 * lanciare due thread uno che scrive i numeri da 1 a 10
 * e l'altro che scrive i numeri da 50 a 100
 * 
 * dato che abbiamo realizzato un unica classe che implementa 
 * il thread per distinguere i due thread occorre passre 
 * al costruttore una variabile di selezione
 * 
 * in questa versione non abbiamo implementato uno scheduler, 
 * i thread partono in ordine impartito dalla machine e 
 * stampano tutti i numeri prima di far passare al secondo thread
 */
public class Conta extends Thread{
	int typeThread;
	public static void main(String args[]) {
		Conta t1=new Conta(0);
		Conta t2=new Conta(1);
		t1.start();
		t2.start();
	}
	public Conta(int type) {
		typeThread=type;
	}
	public void run() {
		if(typeThread==0) {
			for(int i=1;i<=10;i++){
				System.out.println(i);
			}
		}
		else {
			for(int i=50;i<=100;i++) {
				System.out.println(i);
			}
		}
	}
}