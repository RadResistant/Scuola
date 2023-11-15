package it.edu.iisgubbio.tpsit.fcfs;
public class Fcfs {
	String p[];
	int ta[];
	int te[];
	int ts[];
	public String Fcfs(String x) {
		return x;
	}
//	Do il nome ai processi	
	public void setP() {
		for(int x=0;x<this.p.length;x++) {
			this.p[x]+=x;
		}
	}
	//	Predno il tempo di arrivo
	public int[] getTa() {
		for(int x=0;x<ta.length;x++) {
			ta[x]=x;
		}
		return ta;
	}
//	Prendo il tempo che ci mette per essere eseguito
	public void setTe(int[] te) {
		this.te = te;
	}
//	Calcolo il tempo che ci metto per servire il processo 
	public int[] getTs() {
		for (int x=0;x<ts.length;x++) {
			ts[x]=te[x]+ta[x-1];
		}
		return ts;
	}
}