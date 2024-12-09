package mobilita.mobilita;

public class AMuscoli extends MezzoDiTrasporto{
	private String muscoliCoinvolti;
	public AMuscoli() {}
	public AMuscoli(String nome, double costo,String muscoliCoinvolti) {
		super(nome,costo);
		this.muscoliCoinvolti=muscoliCoinvolti;
	}
	public boolean parteAlta() {
//		if(muscoliCoinvolti.equals("Quadricipiti")||muscoliCoinvolti.equals("Glutei")||muscoliCoinvolti.equals("gastrocnemio")) {
//			return false;
//		}
//		else {
//			return true;
//		}
		return muscoliCoinvolti.equals("Quadricipiti")||muscoliCoinvolti.equals("Glutei")||muscoliCoinvolti.equals("gastrocnemio");
	}
	@Override
	public String toString() {
		return "Veicolo a muscoli: "+ nome +", "+ costo +"(usa "+ muscoliCoinvolti+")";
	}
	public String getMuscoliCoinvolti() {
		return muscoliCoinvolti;
	}
	public void setMuscoliCoinvolti(String muscoliCoinvolti) {
		this.muscoliCoinvolti = muscoliCoinvolti;
	}
}