package it.edu.iisgubbio.tpsit.processi;
/**
 *This class sorts all the process gave in input 
 *by its execution time in ascending order
 */
public class processi {
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
	public String[] getProcess() {
		for(int x=0;x<this.p.length;x++) {
			this.p[x]+=x;
		}
		return p;
	}
	/**
	 *Takes the time of arrival to inserts it in an array
	 *@param ta is the time of arrival
	 *@return gives back an array full of arrival time 
	 */
	public int[] setTimeofArrival() {
		for(int x=0;x<ta.length;x++) {
			ta[x]=x;
		}
		return ta;
	}
	/**
	 * Takes the execution time to inserts it in an array
	 * @param te te is the Execution Time
	 * @return it doesn't return anything
	 */
	public int[] setExecutionTime(int[] te) {
		this.te = te;
		return te;
	}
	/**
	 * Calculates the service time for all the processes
	 * @param ts is the service time
	 * @return it returns an array full of services time
	 */ 
	public int[] setServiceTime() {
		for (int x=0;x<ts.length;x++) {
			ts[x]=te[x]+ta[x-1];
		}
		return ts;
	}
}
