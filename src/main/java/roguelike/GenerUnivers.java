package roguelike;

import java.util.Random;


public class GenerUnivers {
	int width;
	int height;
	private ElementUnivers[][] elements;
	
	
	public GenerUnivers(){
		Random rand = new Random();

		int n = rand.nextInt(50) + 1;
	}
	public Univers build() {
		return new Univers(elements);
	}

	private GenerUnivers randomizeTiles() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				elements[x][y] =  Objet.getRandomElement();
			}
		}
		return this;
	}
	

}
