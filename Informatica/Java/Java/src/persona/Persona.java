package it.edu;

public class Persona {
	String nome;
	String cognome;
	int anno;
	
	public Persona (String x,String y,int a) {
		nome=x;
		cognome=y;
		anno=a;
		
	}
	 public String toString(){
		return nome+" "+  cognome +" Nato nell'anno "+ anno;
	}
	 public int eta(int i) {
		return i - anno;
		 
	 }
}
