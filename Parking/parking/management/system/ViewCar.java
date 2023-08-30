package parking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewCar extends JFrame implements ActionListener {
    JTable table;
    Choice ccarId;
    JButton search, print,update,back;
    ViewCar(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchlbl=new JLabel("Search by Car Id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);

        ccarId=new Choice();
        ccarId.setBounds(170,20,150,27);
        add(ccarId);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from parking");

            while (rs.next()){
                ccarId.add(rs.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table =new JTable();

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from parking");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(700,500);
        setLocation(300,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){
            String query="select * from parking where empId='"+ccarId.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==print){
            try{
                table.print();

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCar(ccarId.getSelectedItem());


        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[]args){
        new ViewCar();

    }
}
