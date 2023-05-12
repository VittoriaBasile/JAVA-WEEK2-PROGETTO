package progetto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import progetto.catalogo.Catalogo;
import progetto.catalogo.Libro;
import progetto.catalogo.Periodicità;
import progetto.catalogo.Rivista;

public class Application {

	public static void main(String[] args) {
		List<Catalogo> listaCatalogo = new ArrayList<>();
		Catalogo libro1 = new Libro("HarryPotter", 2001, 400, "Fantasy", "J.K.Rowling");
		Catalogo libro2 = new Libro("HarryPotter2", 2002, 400, "Fantasy", "J.K.Rowling");

		Catalogo rivista1 = new Rivista("Vogue", 2022, 50, Periodicità.MENSILE);
		Catalogo rivista2 = new Rivista("Vogue", 2022, 50, Periodicità.MENSILE);

		System.out.println(libro1.toString());
		System.out.println(rivista1.toString());

		System.out.println("METODO AGGIUNGI A CATALOGO");
		aggiungiACatalogo(listaCatalogo, libro1);
		aggiungiACatalogo(listaCatalogo, rivista1);
		aggiungiACatalogo(listaCatalogo, rivista2);
		aggiungiACatalogo(listaCatalogo, libro2);

		System.out.println(listaCatalogo);
		System.out.println("METODO RIMUOVI DAL CATALOGO");

		rimuoviDalCatalogo(listaCatalogo, libro1.getCodiceISBN());
		System.out.println(listaCatalogo);
		System.out.println("METODO CERCA CATALOGO PER ISBN");

		Catalogo catalogoCercato = cercaCatalogo(listaCatalogo, rivista1.getCodiceISBN());
		if (catalogoCercato != null) {
			System.out.println(catalogoCercato);
		} else {
			System.out.println("NESSUN CATALOGO TROVATO");
		}
		System.out.println("METODO CERCA CATALOGO PER ANNO");

		List<Catalogo> catalogoCercatoPerAnno = cercaCatalogoPerAnno(listaCatalogo, 2022);
		if (catalogoCercatoPerAnno.size() > 0) {
			System.out.println(catalogoCercatoPerAnno);
		} else {
			System.out.println("NESSUN CATALOGO TROVATO");
		}
		System.out.println("METODO CERCA CATALOGO PER AUTORE");
		List<Libro> catalogoCercatoPerAutore = cercaLibroPerAutore(listaCatalogo, "J.K.Rowling");

		if (catalogoCercatoPerAutore.size() > 0) {
			System.out.println(catalogoCercatoPerAutore);

		} else {
			System.out.println("NESSUN LIBRO TROVATO");
		}

	}

	public static void aggiungiACatalogo(List<Catalogo> lista, Catalogo c) {

		lista.add(c);
	}

	public static void rimuoviDalCatalogo(List<Catalogo> lista, UUID ISBN) {
		Iterator<Catalogo> i = lista.iterator();
		while (i.hasNext()) {
			Catalogo current = i.next();
			if (current.getCodiceISBN().equals(ISBN)) {
				i.remove();

			}
		}

	}

	public static Catalogo cercaCatalogo(List<Catalogo> lista, UUID ISBN) {
		Catalogo catalogoCercato = lista.stream().filter(catalogo -> catalogo.getCodiceISBN().equals(ISBN)

		).findAny().orElse(null);
		return catalogoCercato;

	}

	public static List<Catalogo> cercaCatalogoPerAnno(List<Catalogo> lista, int anno) {
		List<Catalogo> cataloghiCercatiPerAnno = lista.stream()
				.filter(catalogo -> catalogo.getAnnoPubblicazione() == anno

				).toList();
		return cataloghiCercatiPerAnno;

	}

	public static List<Libro> cercaLibroPerAutore(List<Catalogo> lista, String autore) {

		List<Libro> cataloghiCercatiPerAutore = lista.stream()
				.filter(catalogo -> catalogo instanceof Libro && ((Libro) catalogo).getAutore().equals(autore))
				.map(catalogo -> (Libro) catalogo)

				.toList();
		return cataloghiCercatiPerAutore;

	}

}
