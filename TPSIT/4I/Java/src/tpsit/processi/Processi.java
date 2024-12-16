package tpsit.processi;
/**
 *This class sorts all the process gave in input 
 *by its execution time in ascending order
 */
public class Processi {
	String processName[];
	int arrivalTime[];
	int executionTime[];
	int serviceTime[];
	/**
	 * Takes the process and gives it a name
	 * @param 	processName Is the name of the process
	 * @return	returns an array with the complete name of the process
	 */
	public String[] setProcess() {
		for(int x=0;x<this.processName.length;x++) {
			processName[x]+=x;
		}
		return processName;
	}
	/**
	 *Takes the time of arrival to inserts it in an array
	 *@param arrivalTime is the time of arrival
	 *@return gives back an array full of arrival time 
	 */
	public int[] setTimeofArrival() {
		for(int x=0;x<arrivalTime.length;x++) {
			arrivalTime[x]=x;
		}
		return arrivalTime;
	}
	/**
	 * Takes the execution time to inserts it in an array
	 * @param te te is the Execution Time
	 * @return it doesn't return anything
	 */
	public int[] setExecutionTime(int[] te) {
		executionTime = te;
		return te;
	}
	/**
	 * Calculates the service time for all the processes
	 * @param serviceTime is the service time
	 * @return it returns an array full of services time
	 */ 
	public int[] setServiceTime() {
		int time[] = null;
		for (int x=0;x<serviceTime.length;x++) {
			serviceTime[x]=executionTime[x]+time[x-1];
		}
		return serviceTime;
	}
}
