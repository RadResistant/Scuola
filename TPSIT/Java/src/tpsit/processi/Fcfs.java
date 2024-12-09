package tpsit.processi;
/**
 *This class sorts all the process gave in input 
 *by its execution time in ascending order
 * @return it returns all the 4 array (p[],ta[],te[],ts[]) 
 * sorted by time arrival in ascending order
 */
public class Fcfs extends Processi{
	public void sortFCFS(){
		int appoggioTe=0;
		String appoggioP;
		int appoggioTa=0;
		int appoggioTs=0;
		for(int c=0;c<arrivalTime.length;c++) {
			for(int i=0;i<arrivalTime.length;i++) {
				if(arrivalTime[i]>arrivalTime[i+1]) {
					appoggioP=processName[i];
					processName[i]=processName[i+1];
					processName[i+1]=appoggioP;
					appoggioTa=arrivalTime[i];
					arrivalTime[i]=arrivalTime[i+1];
					arrivalTime[i+1]=appoggioTa;
					appoggioTe=executionTime[i];
					executionTime[i]=executionTime[i+1];
					executionTime[i+1]=appoggioTe;
					appoggioTs=serviceTime[i];
					serviceTime[i]=serviceTime[i+1];
					serviceTime[i+1]=appoggioTs;
				}
			}
		}
	}	
}
