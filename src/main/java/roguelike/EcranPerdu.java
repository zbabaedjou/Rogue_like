package roguelike;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;


public class EcranPerdu implements InterfaceAffichage {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public InterfaceAffichage respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EcranJeu() : this;
    }

}
