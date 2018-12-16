package roguelike;



public class GenerUnivers {
	private int width;
	private int height;
	private int niveau;
	private ElementUnivers[][] elements;
	
	
	public GenerUnivers(int width, int height) {
		this.width = width;
		this.height = height;
		this.elements = new ElementUnivers[width][height];
		this.niveau=1;
	}
	
	/**
	 * @return une instance de l'Univers avec comme tableau, le tableau d'éléments généré
	 */
	
	public Univers generer() {
		return new Univers(randomizeElement());
	}
	
	
	/**
	 * Génère aléatoirements des éléments pour remplire elements
	 * @return elements
	 */
	public ElementUnivers[][] randomizeElement() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				elements[x][y] =  Objet.getRandomElement();
			}
		}
		return elements;
	}
	
	

}
