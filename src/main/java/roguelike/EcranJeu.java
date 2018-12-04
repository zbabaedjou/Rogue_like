package roguelike;


import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class EcranJeu implements InterfaceAffichage {
	


	    public void displayOutput(AsciiPanel terminal) {
	        terminal.write("You are having fun.", 1, 1);
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
