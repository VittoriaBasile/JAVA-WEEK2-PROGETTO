package progetto.catalogo;

import java.util.UUID;

public abstract class Catalogo {
	private UUID codiceISBN = UUID.randomUUID();
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;

	public UUID getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(UUID codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public Catalogo(String titolo, int annoPubblicazione2, int numeroPagine) {
		setCodiceISBN(codiceISBN);
		setTitolo(titolo);
		setAnnoPubblicazione(annoPubblicazione2);
		setNumeroPagine(numeroPagine);

	}

	@Override
	public abstract String toString();
}
