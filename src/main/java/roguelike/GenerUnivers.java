package roguelike;

import java.util.Stack;
// objectif

// 1 genere un perfect maze = aucune case n'est innacessible
//   1.1 backtracking version avec des trous (4/25 non_exploré)
//       theoriquement inaccessibles mais 
//       la generation de sale ignorera ce defaut
// 2 faire des salles numeroté( percage )
// 		une liste de sale (nouvelle class ?)
// 3 placer le joueur dans la sale 1 
// 4 placer l'escalier dans la derniere sale
// 5 placer des monstres dans les salles

public class GenerUnivers {
	private int width;// largeur
	private int height;// longeur
	private int niveau;
	private ElementUnivers[][] elements;
	public Stack<Integer> a_visiter_x;
	public Stack<Integer> a_visiter_y;
	
	public GenerUnivers(int width, int height) {
		this.width = width;
		this.height = height;
		this.elements = new ElementUnivers[width][height];
		this.niveau=1;
	}
	
	
	/*ENvoie du tableau généré dans le l'univers
	 * Cette fonction créé une instance de Univers et lui 
	 * envoie le tableau généré en paramettre
	 */
	public Univers generer() {
		//return new Univers(randomizeElement());
		return new Univers(walling());
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
	
	public ElementUnivers[][] walling() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				elements[x][y] =  Objet.MUR;
			}
		}
		return elements;
	}
	
	public ElementUnivers[][] mazing() {
			this.elements[1][1] =  Objet.SOL;
			this.a_visiter_x.push(1);
			this.a_visiter_y.push(1);
			
			int tmpx;
			int tmpy;
			
			while(!this.a_visiter_x.empty()) {// on s'arrete des que c'est vide
			tmpx=a_visiter_y.pop();
			}
			
		return elements;
	}
	
	
}
