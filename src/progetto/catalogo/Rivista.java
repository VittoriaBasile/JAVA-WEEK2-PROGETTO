package progetto.catalogo;

public class Rivista extends Catalogo {
	private Periodicità periodicità;

	public Periodicità getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}

	public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
		super(titolo, annoPubblicazione, numeroPagine);
		setPeriodicità(periodicità);

	}

	@Override
	public String toString() {
		return "codiceISBN : " + getCodiceISBN() + " , " + "titolo: " + getTitolo() + " , " + "anno di pubblicazione : "
				+ getAnnoPubblicazione() + " , " + "numero di pagine : " + getNumeroPagine() + " , " + "genere : "
				+ "periodicità : " + getPeriodicità() + "\n";
	}

}
