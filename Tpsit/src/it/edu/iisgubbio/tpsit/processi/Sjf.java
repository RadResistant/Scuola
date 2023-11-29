package it.edu.iisgubbio.tpsit.processi;
/**
 * It sorts every single process in ascending order by it's execution time
 * @return it returns all the 4 array (p[],ta[],te[],ts[])
 *  sorted by Execution time in ascending order
 */
public class Sjf extends processi{
	public void sortSJF(){
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
