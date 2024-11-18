import java.awt.*;
import java.awt.event.*;

public class l10q1 extends Frame {

    public l10q1() {
        // Set the title and size of the window
        setTitle("Window Event Demo");
        setSize(400, 400);

        // Add a window listener to handle window events
        addWindowListener(new WindowAdapter() {
            // Event when the window is opened
            public void windowOpened(WindowEvent we) {
                // Display message in the frame window
                Label openedLabel = new Label("Window opened.");
                add(openedLabel);
                setLayout(new FlowLayout());
                revalidate();
            }

            // Event when the window is closing
            public void windowClosing(WindowEvent we) {
                System.out.println("Window closing in terminal.");  // Print to terminal
                System.exit(0); // Close the application
            }

            // Event when the window is closed
            public void windowClosed(WindowEvent we) {
                System.out.println("Window closed.");
            }

            // Event when the window is minimized (iconified)
            public void windowIconified(WindowEvent we) {
                System.out.println("Window iconified.");
            }

            // Event when the window is restored from minimized state
            public void windowDeiconified(WindowEvent we) {
                System.out.println("Window deiconified.");
            }

            // Event when the window is activated
            public void windowActivated(WindowEvent we) {
                // Display message in the frame window
                Label activatedLabel = new Label("Window activated.");
                add(activatedLabel);
                setLayout(new FlowLayout());
                revalidate();
            }

            // Event when the window is deactivated
            public void windowDeactivated(WindowEvent we) {
                System.out.println("Window deactivated.");
            }
        });
    }

    public static void main(String[] args) {
        // Create the window
        l10q1 window = new l10q1();
        window.setVisible(true);  // Make the window visible
    }
}
