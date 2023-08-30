
package parking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{

    Splash(){

        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel heading = new JLabel("PARKING SCHEDULER");
        heading.setBounds(200,40,1000,50);
        heading.setFont(new Font("serif",Font.PLAIN,30));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/b.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(170,150,400,200);
        add(image);


        JButton clickhere=new JButton("Click Here");
        clickhere.setBounds(300,400,130,40);
        clickhere.setBackground(Color.white);
        clickhere.setForeground(Color.black);
        clickhere.addActionListener(this);
        add(clickhere);


        setSize(770,600);
        setLocation(300,50);
        setVisible(true);

        while (true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){

            }

        }

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }

    public static void main(String[]args){
        new Splash();

    }
}
