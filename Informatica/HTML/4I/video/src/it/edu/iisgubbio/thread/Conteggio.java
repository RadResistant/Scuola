package it.edu.iisgubbio.thread;

public class Conteggio extends Thread {
	int n;
	String nome;
	public Conteggio(int numero,String nome) {
		this.n=numero;
		this.nome=nome;
	}
	@Override
	public void run() {
		System.out.println(nome);
		for(int j=0;j<n+10;j++) {
			System.out.println(j+1+" ");
		}
	}
}
