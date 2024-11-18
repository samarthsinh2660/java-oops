import java.awt.*;
import java.awt.event.*;

public class l10q3 extends Frame implements KeyListener {

    // Label to display key events
    Label keyLabel;

    // Constructor to set up the frame
    public l10q3() {
        setTitle("Keyboard Event Demo");
        setSize(400, 400);
        
        // Set layout to null for absolute positioning
        setLayout(null);

        // Create and add a label to display key events
        keyLabel = new Label("Press any key...");
        keyLabel.setBounds(100, 150, 200, 30);
        add(keyLabel);

        // Add key listener to the frame
        addKeyListener(this);

        // Set the frame visible
        setVisible(true);
    }

    // KeyListener methods
    public void keyPressed(KeyEvent e) {
        keyLabel.setText("Key pressed: " + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
        keyLabel.setText("Key released: " + e.getKeyChar());
    }

    public void keyTyped(KeyEvent e) {
        keyLabel.setText("Key typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        // Create the frame to show keyboard events
        new l10q3();
    }
}
