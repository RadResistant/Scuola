package it.edu.issgubbio.sjf;

public class Sjf {
	String p[];
	int ta[];
	int te[];
	int ts[];
	public String Sjf(String x) {
		return x;
	}
	/**
	 * Takes the process and gives it a name
	 * @param 	p Is the name of the process
	 * @return	returns an array with the complete name of the process
	 */
	public void setP() {
		for(int x=0;x<this.p.length;x++) {
			this.p[x]+=x;
		}
	}
	/**
	 *Takes the tima of arrival to inserts it in an array
	 *@param ta ta is the time of arrival
	 *@return gives back an array full of arrival time 
	 */
	public int[] getTa() {
		for(int x=0;x<ta.length;x++) {
			ta[x]=x;
		}
		return ta;
	}
	/**
	 * Takes the execution time to insterts it in an array
	 * @param te te is the Execution Time
	 * @return gives back an array full of execution times
	 */
	public void setTe(int[] te) {
		this.te = te;
	}
	/**
	 * 
	 */ 
	public int[] getTs() {
		for (int x=0;x<ts.length;x++) {
			ts[x]=te[x]+ta[x-1];
		}
		return ts;
	}
//	Ordino i processi secondo il tetmpo di esecuzione
	public void ordine(){
		int appoggioTe=0;
		String appoggioP;
		int appoggioTa=0;
		int appoggioTs=0;
		for(int c=0;c<te.length;c++) {
			for(int i=0;i<te.length;i++) {
				if(te[i]>te[i+1]) {
					appoggioP=p[i];
					p[i]=p[i+1];
					p[i+1]=appoggioP;
					appoggioTe=te[i];
					te[i]=te[i+1];
					te[i+1]=appoggioTe;
					appoggioTa=ta[i];
					ta[i]=ta[i+1];
					ta[i+1]=appoggioTa;
					appoggioTs=ts[i];
					ts[i]=ts[i+1];
					ts[i+1]=appoggioTs;
				}
			}
		}	
	}
}
