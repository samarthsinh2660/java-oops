import java.awt.*;
import java.awt.event.*;

public class l10q2 extends Frame implements MouseListener, MouseMotionListener {

    // Constructor to set up the frame
    public l10q2() {
        setTitle("Mouse Event Demo");
        setSize(400, 400);
        
        // Add mouse listeners to the frame
        addMouseListener(this);
        addMouseMotionListener(this);

        // Set the layout and make the window visible
        setLayout(null);
        setVisible(true);
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered the frame.");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited the frame.");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at: (" + e.getX() + ", " + e.getY() + ")");
    }

    // MouseMotionListener methods
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseMoved(MouseEvent e) {
        // This event is triggered when the mouse is moved without clicking
        // We can print the mouse position if needed
    }

    public static void main(String[] args) {
        // Create the frame to show mouse events
        new l10q2();
    }
}
