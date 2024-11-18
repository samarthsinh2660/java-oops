import java.awt.*;
import java.awt.event.*;

public class l10q4 extends Frame {

    
    Label label;
    Button button;

    // Constructor to set up the frame and components
    public l10q4() {
        // Set the title of the window
        setTitle("Simple GUI Example");
        
        // Set the layout manager
        setLayout(new FlowLayout());

        // Create a label and set initial text
        label = new Label("Click the button to change text");
        add(label);

        // Create a button
        button = new Button("Click Me");
        add(button);

        // Add a button click event listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Text changed after button click!");
            }
        });

     
        setSize(300, 150);
        
 
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new l10q4();
    }
}
