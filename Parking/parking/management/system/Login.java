package parking.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;



public class Login extends JFrame implements ActionListener {

            JTextField tfusername,tfpassword;
            Login(){

                getContentPane().setBackground(Color.GRAY);
                setLayout(null);

                JLabel lblusername = new JLabel("Username");
                lblusername.setBounds(100,71,100,30);
                add(lblusername);

                tfusername = new JTextField();
                tfusername.setBounds(200,73,200,30);
                add(tfusername);

                JLabel lblpassword = new JLabel("Password");
                lblpassword.setBounds(100,173,200,30);
                add(lblpassword);

                tfpassword = new JTextField();
                tfpassword.setBounds(200,173,200,30);
                add(tfpassword);

                JButton login=new JButton("LOGIN");
                login.setBounds(230,275,130,30);
                login.setBackground(Color.white);
                login.setForeground(Color.black);
                login.addActionListener(this);
                add(login);

                ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/l.jpg"));
                Image i2=i1.getImage().getScaledInstance(180,150,Image.SCALE_DEFAULT);
                ImageIcon i3 =new ImageIcon(i2);
                JLabel image =new JLabel(i3);
                image.setBounds(470,40,200,200);
                add(image);


                setSize(700,500);
                setLocation(300,100);
                setVisible(true);
            }

            public void actionPerformed(ActionEvent ae){
                try{
                    String username= tfusername.getText();
                    String password=tfpassword.getText();


                   Conn c=new Conn();
                    String query="select * from login where username = '"+username+"'and password = '"+password+"'";
                    ResultSet rs =c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Home();
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                        setVisible(false);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }


    public static void main(String [] args){
    new Login();
    }
}
