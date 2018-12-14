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
		
	}
	
	
	/*ENvoie du tableau généré dans le l'univers
	 * Cette fonction créé une instance de Univers et lui 
	 * envoie le tableau généré en paramettre
	 */
	public Univers generer() {
		return new Univers(randomizeElement());
	}
	
	
	/*Fonction de generation alléatoire de l'espace 
	 * Cette fonction remplis aléatoirement les cases du tableau éléments	
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
