package tpsit.holt;
public class holt{
	int dimensione;
	int [][] grafo;
	public holt() {
		grafo =  new int[dimensione][dimensione];
		for (int i = 0; i <dimensione; i++) {
			for (int j = 0; j <dimensione; j++) {
				 grafo[i][j]=0;
			}
		}
	}
	public boolean cColonna(int resources) {
		int somma = 0;
		for (int i = 0; i <dimensione; i++) {
			somma = somma+grafo[i][resources];
			}
		if (somma == 0) {
			return (true);
		}
		else {
			return(false);
		}
	}
	public void setRichiesta(int processi, int risorse) {
		if (grafo[processi][risorse]==0) {
			if (cColonna(risorse)){
				grafo[processi][risorse]=1;
			}
			else {
				grafo[processi][risorse]=2;
			}
		}
		else {
			System.out.print("Impossibile");
		}
	}
	 public  void stampaGrafo() {
        for (int i = 0; i <dimensione; i++) {
            for (int j = 0; j <dimensione; j++) {
                System.out.print(grafo[i][j] + " ");
            }
        System.out.print("\n");
        }
    }
}