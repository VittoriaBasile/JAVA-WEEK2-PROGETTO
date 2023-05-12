package progetto.catalogo;

public class Libro extends Catalogo {

	private String genere;
	private String autore;

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Libro(String titolo, int annoPubblicazione, int numeroPagine, String genere, String autore) {
		super(titolo, annoPubblicazione, numeroPagine);
		setGenere(genere);
		setAutore(autore);

	}

	@Override
	public String toString() {
		return "codiceISBN : " + getCodiceISBN() + " , " + "titolo: " + getTitolo() + " , " + "anno di pubblicazione : "
				+ getAnnoPubblicazione() + " , " + "numero di pagine : " + getNumeroPagine() + " , " + "genere : "
				+ getGenere() + " , " + "autore : " + getAutore() + "\n";
	}
}
