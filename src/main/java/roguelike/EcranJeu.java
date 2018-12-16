package roguelike;


import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class EcranJeu implements InterfaceAffichage {
	
		private int screenWidth;
		private int screenHeight;
		private Univers univers;
		private PJ pj;
		//créer tableau monstres
		public EcranJeu(){
			screenWidth = 80;
			screenHeight = 30;
			createUnivers();
			
		}
		
		
		/**Création de l'univers
		 * Instantiation de l'univers en faisant usage de la fonction 
		 * generer de GenerUniver
		 * @return void
		 */		
		public void createUnivers(){
			univers = new GenerUnivers(screenWidth, screenHeight)
						.generer();
			pj=univers.addPj();
			univers.addMonstre();
			univers.addPnj();
		}
		
		
		
		/**
		 * Achiche les elements de l'univer dans le terminal
		 * @param terminal 
		 * @param left marge du haut avec afichage de l'univers
		 * @param top marge de gauche avec afichage de l'univers
		 */
		private void afficherElements(AsciiPanel terminal,int left, int top) {
			int wy;
			int wx; 
			for (int x = 0; x < screenWidth; x++){
				for (int y = 0; y < screenHeight; y++){
					wx = x + left;
					wy = y + top;
					terminal.write(univers.symbole(x, y),wx, wy, univers.color(x, y));
				}
			}
		}

		
		/**
		 * Afichage du terminal
		 */
		public void displayOutput(AsciiPanel terminal) {
	    	int left = 10;
			int top = 5; 
			
					
			terminal.writeCenter("RogueLike Game " ,1,AsciiPanel.red);
	        afficherElements(terminal,left, top);
	        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 45);
	    }

		
		/**
		 * Gerer les interactions entre le joueur et le programme
		 */
	    public InterfaceAffichage respondToUserInput(KeyEvent key) {
	        switch (key.getKeyCode()){
	        
	        case KeyEvent.VK_ESCAPE: return new EcranPerdu();
	        case KeyEvent.VK_ENTER: return new EcranGagnee();
	        }
	    
	        return this;
	    }
	


}
