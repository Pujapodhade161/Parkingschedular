package parking.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;




    public class UpdateCar extends JFrame implements ActionListener {


        JTextField  tfname,tffname, tfsalary,tfemail, tfaddress,tfphone,tfaadhar,tftime;

        JButton add,back;
        JLabel lblempId;
        JDateChooser dcdob;
        String empId;
        UpdateCar(String empId){
            this.empId = empId;

            getContentPane().setBackground(Color.lightGray);
            setLayout(null);

            JLabel heading =new JLabel("Update Car Details");
            heading.setBounds(250,30,400,40);
            heading.setFont(new Font("SAN_SERIF",Font.BOLD,27));
            add(heading);

            JLabel labelname=new JLabel("Full Name");
            labelname.setBounds(40,100,150,30);
            labelname.setFont(new Font("serif",Font.PLAIN,20));
            add(labelname);

            JLabel lblname=new JLabel();
            lblname.setBounds(140,103,203,30);
            add(lblname);

            JLabel labelfname=new JLabel("Car Name");
            labelfname.setBounds(400,100,150,30);
            labelfname.setFont(new Font("serif",Font.PLAIN,20));
            add(labelfname);

            tffname=new JTextField();
            tffname.setBounds(490,103,203,30);
            add(tffname);

            JLabel labeldob=new JLabel("Park Date");
            labeldob.setBounds(40,153,150,30);
            labeldob.setFont(new Font("serif",Font.PLAIN,20));
            add(labeldob);

            JLabel lbldob=new JLabel();
            lbldob.setBounds(140,153,200,30);
            add(lbldob);

            JLabel labelsalary=new JLabel("Payment");
            labelsalary.setBounds(400,156,150,30);
            labelsalary.setFont(new Font("serif",Font.PLAIN,20));
            add(labelsalary);

            tfsalary=new JTextField();
            tfsalary.setBounds(490,156,203,30);
            add(tfsalary);

            JLabel labeladdress=new JLabel("Address");
            labeladdress.setBounds(40,200,150,30);
            labeladdress.setFont(new Font("serif",Font.PLAIN,20));
            add(labeladdress);

            tfaddress=new JTextField();
            tfaddress.setBounds(140,203,203,30);
            add(tfaddress);

            JLabel labelphone=new JLabel("Phone");
            labelphone.setBounds(400,206,150,30);
            labelphone.setFont(new Font("serif",Font.PLAIN,20));
            add(labelphone);

            tfphone=new JTextField();
            tfphone.setBounds(490,206,203,30);
            add(tfphone);

            JLabel labelemail=new JLabel("Car_No");
            labelemail.setBounds(40,250,150,30);
            labelemail.setFont(new Font("serif",Font.PLAIN,20));
            add(labelemail);

            tfemail=new JTextField();
            tfemail.setBounds(140,253,203,30);
            add(tfemail);

            JLabel labelaadhar=new JLabel("AadharNo");
            labelaadhar.setBounds(400,256,150,30);
            labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
            add(labelaadhar);

            JLabel lblaadhar=new JLabel();
            lblaadhar.setBounds(490,256,203,30);
            add(lblaadhar);

            JLabel labeltimee=new JLabel("Time");
            labeltimee.setBounds(40,299,150,30);
            labeltimee.setFont(new Font("serif",Font.PLAIN,20));
            add(labeltimee);

            tftime=new JTextField();
            tftime.setBounds(140,299,203,30);
            add(tftime);

            JLabel labelempId=new JLabel("Parking Id");
            labelempId.setBounds(400,303,150,30);
            labelempId.setFont(new Font("serif",Font.PLAIN,20));
            add(labelempId);

            lblempId=new JLabel();
            lblempId.setBounds(510,303,150,30);
            lblempId.setFont(new Font("serif",Font.PLAIN,20));
            add(lblempId);

            try{
                Conn c =new Conn();
                String query="select * from parking where empId ='"+empId+"'";
                ResultSet rs=c.s.executeQuery(query);
                while (rs.next()){
                    lblname.setText(rs.getString("name"));
                    tffname.setText(rs.getString("fname"));
                    tfsalary.setText(rs.getString("salary"));
                    tfaddress.setText(rs.getString("address"));
                    lbldob.setText(rs.getString("dob"));
                    tfphone.setText(rs.getString("phone"));
                    tfemail.setText(rs.getString("email"));
                    lblaadhar.setText(rs.getString("aadhar"));
                    tftime.setText(rs.getString("timee"));
                    lblempId.setText(rs.getString("empId"));

                }

            }catch(Exception e){
                e.printStackTrace();
            }

            add=new JButton("Update Details");
            add.setBounds(170,400,130,38);
            add.addActionListener(this);
            add.setBackground(Color.black);
            add.setForeground(Color.white);
            add(add);

            back=new JButton("Back");
            back.setBounds(390,400,130,38);
            back.addActionListener(this);
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            add(back);


            setSize(720,550);
            setLocation(250,80);
            setVisible(true);

        }
        public void actionPerformed(ActionEvent ae){

            if(ae.getSource()==add){

                String fname=tffname.getText();
                String salary=tfsalary.getText();
                String address=tfaddress.getText();
                String phone=tfphone.getText();
                String email=tfemail.getText();
                String timee=tftime.getText();

                try{
                    Conn conn=new Conn();
                    String query="update parking set fname= '"+fname+"',salary='"+salary+"', address='"+address+"', phone='"+phone+"', email='"+email+"',timee='"+timee+"' where empId='"+empId+"'";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Details Updated successfully");
                    setVisible(false);
                    new Home();

                }catch (Exception e){
                    e.printStackTrace();
                }


            }else{
                setVisible(false);
                new Home();
            }

        }

        public static void main(String[]args){
            new UpdateCar("");

        }
    }


