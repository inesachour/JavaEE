import java.util.List;

public class TestCatalogue {
	public static void main(String[] args) {
		CatalogueImpl metier = new CatalogueImpl();
		List<Produit> prods = metier.getProduitsParMotCle("ps");
		for (Produit p : prods)
			System.out.println(p.getNomProduit());
	}
}