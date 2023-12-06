package it.edu.iisgubbio.tpsit.holt;
public class holt{
	int dimension;
	int [][] grafo;
	public holt(int dimension) {
		this.grafo =  new int[dimension][dimension];
		this.dimension=dimension;
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				 this.grafo[i][j]=0;
			}
		}
	}
	public boolean checkcolum(int resources) {
		int somma = 0;
		for (int i = 0; i < this.dimension; i++) {
			somma = somma  + this.grafo[i][resources];
			}
		if (somma == 0) {
			return (true);
		}
		else {
			return(false);
		}
	}
	public void setRequest(int process, int resources) {
		if (this.grafo[process][resources]==0) {
			if (this.checkcolum(resources)){
				this.grafo[process][resources]=1;
			}
			else {
				this.grafo[process][resources]=2;
			}
		}
		else {
			System.out.print("Assegnamento non possibile");
		}
	}
	 public  void print2D() {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                System.out.print(this.grafo[i][j] + " ");
            }
        System.out.print("\n");
        }
    }
}