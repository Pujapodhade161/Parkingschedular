package parking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    JButton add,view,remove,update;
    Home(){

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/g.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,700,500);
        add(image);

        JLabel heading =new JLabel("Parking Management System");
        heading.setBounds(170,30,400,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.white);
        image.add(heading);

        add=new JButton("Add Vehicle");
        add.setBounds(100,150,150,40);
        add.addActionListener(this);
        image.add(add);

         view=new JButton("View Vehicles");
        view.setBounds(400,150,150,40);
        view.addActionListener(this);
        image.add(view);

         update=new JButton("Update Vehicle");
        update.setBounds(100,250,150,40);
        update.addActionListener(this);
        image.add(update);

         remove=new JButton("Remove Vehicle");
        remove.setBounds(400,250,150,40);
        remove.addActionListener(this);
        image.add(remove);



        setSize(700,500);
        setLocation(240,100);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddCar();

        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewCar();

        } else if (ae.getSource()==update) {
            setVisible(false);
            new ViewCar();

        }else {
            setVisible(false);
            new RemoveCar();

        }

    }

    public static void main(String []args){

        new Home();

    }
}
