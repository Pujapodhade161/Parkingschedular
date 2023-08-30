package parking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;
import java.sql.*;


public class RemoveCar extends JFrame implements ActionListener {
    Choice cEmpId;
    JButton delete, back;

    RemoveCar() {
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JLabel labelempId = new JLabel("Car Id");
        labelempId.setBounds(50, 50, 50, 30);
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(133, 53, 150, 30);
        add(cEmpId);

        try {
            Conn c = new Conn();
            String query = "select * from parking";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 90, 50, 30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(140, 90, 100, 30);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 130, 50, 30);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(140, 130, 100, 30);
        add(lblphone);

        JLabel labelemail = new JLabel("Car Id");
        labelemail.setBounds(50, 170, 50, 30);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(140, 170, 100, 30);
        add(lblemail);

        try {
            Conn c = new Conn();
            String query = "select * from parking where empId ='" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try {
                    Conn c = new Conn();
                    String query = "select * from parking where empId ='" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));


                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

        });

        delete = new JButton("Delete");
        delete.setBounds(200, 260, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(380, 260, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/q.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 30, 200, 200);
        add(image);


        setSize(700, 400);
        setLocation(300, 120);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try{
                Conn c=new Conn();
                String query="delete from parking where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Car details deleted successfully");
                setVisible(false);
                new Home();


            }catch (Exception e ){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveCar();
    }
}
