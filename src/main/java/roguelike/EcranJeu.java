package roguelike;


import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class EcranJeu implements InterfaceAffichage {
	
		private int screenWidth;
		private int screenHeight;
		private Univers univers;
		private PJ PJ;
		
		public EcranJeu(){
			screenWidth = 80;
			screenHeight = 21;
			createUnivers();
			
		}
		
		
		/*Création de l'univers
		 * Instantiation de l'univers en faisant usage de la fonction 
		 * generer de GenerUniver
		 */		
		public void createUnivers(){
			univers = new GenerUnivers(90, 32)
						.generer();
			//univers.addPj();
			//univers.ajouterMonstre();
			//univers.addPnj();
		}
		
		//public int getScrollX() { return Math.max(0, Math.min(univers.pj.getX() - screenWidth / 2, univers.width() - screenWidth)); }
		
		//public int getScrollY() { return Math.max(0, Math.min(univers.pj.getY() - screenHeight / 2, univers.height() - screenHeight)); }
		
		
		private void afficherElements(AsciiPanel terminal,int left, int top) {
			int wy;
			int wx; 
			for (int x = 0; x < screenWidth; x++){
				for (int y = 0; y < screenHeight; y++){
					wx = x + left;
					wy = y + top;
					terminal.write(univers.symbole(wx, wy), x, y, univers.color(wx, wy));
				}
			}
		}

		
		
		public void displayOutput(AsciiPanel terminal) {
	    	int left = 5;
			int top = 4; 
			
					
	        terminal.write("You are having fun.", 1, 1);
	        afficherElements(terminal, top, left);
	        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);
	    }

	    public InterfaceAffichage respondToUserInput(KeyEvent key) {
	        switch (key.getKeyCode()){
	        case KeyEvent.VK_ESCAPE: return new EcranPerdu();
	        case KeyEvent.VK_ENTER: return new EcranGagnee();
	        }
	    
	        return this;
	    }
	


}
