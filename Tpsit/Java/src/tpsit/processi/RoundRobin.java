package tpsit.processi;

public class RoundRobin extends Fcfs{
	int qT;
	public void setqT(int qT) {
		this.qT = qT;
	}
	public void sortRoundRobin() {
		for (int i=0;i<processName.length;i++) {
			executionTime[i]-=qT;
		} 
	}
}
