package it.edu.iisgubbio.tpsit.processi;
/**
 *This class sorts all the process gave in input 
 *by its execution time in ascending order
 * @return it returns all the 4 array (p[],ta[],te[],ts[]) 
 * sorted by time arrival in ascending order
 */
public class Fcfs extends processi{
	public void sortFCFS(){
		int appoggioTe=0;
		String appoggioP;
		int appoggioTa=0;
		int appoggioTs=0;
		for(int c=0;c<ta.length;c++) {
			for(int i=0;i<ta.length;i++) {
				if(ta[i]>ta[i+1]) {
					appoggioP=p[i];
					p[i]=p[i+1];
					p[i+1]=appoggioP;
					appoggioTa=ta[i];
					ta[i]=ta[i+1];
					ta[i+1]=appoggioTa;
					appoggioTe=te[i];
					te[i]=te[i+1];
					te[i+1]=appoggioTe;
					appoggioTs=ts[i];
					ts[i]=ts[i+1];
					ts[i+1]=appoggioTs;
				}
			}
		}
	}	
}
