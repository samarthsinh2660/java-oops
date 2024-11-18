import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {
    public static void main(String args[]){

        JFrame f = new JFrame();
        f.setSize(300,300);

        JPanel p = new JPanel();
        JTextField user = new JTextField(20);
        JPasswordField pass = new JPasswordField(10);
        JButton b = new JButton("Login");
        JLabel l = new JLabel();

        p.add(new JLabel("username"));
        p.add(user);
        p.add(new JLabel("password"));
        p.add(pass);
        p.add(b);
        p.add(l);

        b.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                String username = user.getText();
                String password = new String(pass.getPassword());

                if(username .equals("admin") && password.equals("admin")){
                    JOptionPane.showMessageDialog(f, "Login success");
                }
                else{
                    JOptionPane.showMessageDialog(f, "invalid");
                }

                l.setText(username + password);
 
            }
        });

        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        f.setVisible(true);              
    }
}
