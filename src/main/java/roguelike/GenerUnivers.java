package roguelike;

import java.util.*;
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
	public Stack<Integer> pere_x;
	public Stack<Integer> pere_y;
	
	public GenerUnivers(int width, int height) {
		this.width = width;
		this.height = height;
		this.elements = new ElementUnivers[width][height];
		this.a_visiter_x = new Stack<Integer>();
		this.a_visiter_y = new Stack<Integer>();
		this.pere_x = new Stack<Integer>();
		this.pere_y = new Stack<Integer>();
		this.niveau=1;
	}
	
	
	/*ENvoie du tableau généré dans le l'univers
	 * Cette fonction créé une instance de Univers et lui 
	 * envoie le tableau généré en paramettre
	 */
	public Univers generer() {
		//return new Univers(randomizeElement());
		//return new Univers(walling());
		return new Univers(mazing());
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
		this.walling();
		int i=1;
			//this.elements[1][1] =  Objet.MUR;
			this.a_visiter_x.push(i);
			this.a_visiter_y.push(i);
			this.pere_x.push(1);
			this.pere_y.push(1);
			
			int x_actuel;
			int y_actuel;
			int prevx;
			int prevy;
			
			int w=0;
			
			// problem de non random
		      List arrlist = new ArrayList();
		      String priorite="A";
		      // populate the list
		      arrlist.add("A");
		      arrlist.add("B");
		      arrlist.add("C"); 
		      arrlist.add("D"); 
		      
			while(!this.a_visiter_x.empty()) {// on s'arrete des que c'est vide
				Collections.shuffle(arrlist);
				System.out.println(" iteration n° "+w);
				w++;
			x_actuel=this.a_visiter_x.pop();
			y_actuel=this.a_visiter_y.pop();
			prevx=this.pere_x.pop();
			prevy=this.pere_y.pop();
			if(this.elements[x_actuel][y_actuel] ==  Objet.MUR) {
			this.elements[x_actuel][y_actuel] =  Objet.SOL;
			this.elements[(x_actuel+prevx)/2][(y_actuel+prevy)/2] =  Objet.SOL;
			
			

		    for(int r=0;r<4;r++) {
		    	
		    	priorite=(String)arrlist.get(r);
		    	System.out.println("after "+priorite);
		    
				if(x_actuel+2<this.width && priorite=="A") {// x+2 y+0
					this.a_visiter_x.push(x_actuel+2);
					this.a_visiter_y.push(y_actuel);
					this.pere_x.push(x_actuel);
					this.pere_y.push(y_actuel);
				}
				if(x_actuel-2>0  && priorite=="B") {// x-2 y+0
					this.a_visiter_x.push(x_actuel-2);
					this.a_visiter_y.push(y_actuel);
					this.pere_x.push(x_actuel);
					this.pere_y.push(y_actuel);
				}
				if(y_actuel+2<this.height  && priorite=="C") {// x+0 y+2
					this.a_visiter_x.push(x_actuel);
					this.a_visiter_y.push(y_actuel+2);
					this.pere_x.push(x_actuel);
					this.pere_y.push(y_actuel);
				}
				if(y_actuel-2>0  && priorite=="D") {// x+0 y-2
					this.a_visiter_x.push(x_actuel);
					this.a_visiter_y.push(y_actuel-2);
					this.pere_x.push(x_actuel);
					this.pere_y.push(y_actuel);
				}
		    }
			}
			}
			
		return elements;
	}
	
	//////////////     //////////
}
