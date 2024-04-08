package tpsit.processi;
/**
 * It sorts every single process in ascending order by it's execution time
 * @return it returns all the 4 array (p[],ta[],te[],ts[])
 *  sorted by Execution time in ascending order
 */
public class Sjf extends Processi{
	public void sortSJF(){
		int appoggioTe=0;
		String appoggioP;
		int appoggioTa=0;
		int appoggioTs=0;
		for(int c=0;c<executionTime.length;c++) {
			for(int i=0;i<executionTime.length;i++) {
				if(executionTime[i]>executionTime[i+1]) {
					appoggioP=processName[i];
					processName[i]=processName[i+1];
					processName[i+1]=appoggioP;
					appoggioTe=executionTime[i];
					executionTime[i]=executionTime[i+1];
					executionTime[i+1]=appoggioTe;
					appoggioTa=arrivalTime[i];
					arrivalTime[i]=arrivalTime[i+1];
					arrivalTime[i+1]=appoggioTa;
					appoggioTs=serviceTime[i];
					serviceTime[i]=serviceTime[i+1];
					serviceTime[i+1]=appoggioTs;
				}
			}
		}	
	}
}
