/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDB;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PatientDB extends JFrame implements ActionListener {  
    String firstN;
    String lastN;
    String Pcp;
    String HCpro;
    String patient_id;
    int count = 1;
    HashMap<Integer, String> patient = new HashMap<Integer, String>();
//Initializing Components  
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9,lb10, label1, label2, lab1, lab2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, text1, text2, txt1, txt2;
    JButton btn, btn2;
    JFrame newFrame;
    //Creating Constructor for initializing JFrame components  
    PatientDB() {  
        //Providing Title  
        super("Fetching Patient Information");  
        lb5 = new JLabel("First Name:");  
        lb6 = new JLabel("Last Name:");
        lb5.setBounds(20, 20, 100, 20);  
        lb6.setBounds(20,50,100,20);
        tf5 = new JTextField(20);  
        tf5.setBounds(130, 20, 200, 20); 
        tf6 = new JTextField(20);
        tf6.setBounds(130,50,200,20);
        btn = new JButton("Submit");  
        btn.setBounds(180, 90, 100, 20);  
        btn.addActionListener(this);
        btn2 = new JButton("Add Patient");
        btn2.setBounds(300, 90, 100, 20);
        btn2.addActionListener(this);
        lb = new JLabel("Fetching Patient Information From Database");  
        lb.setBounds(40, 120, 450, 30);  
        lb.setForeground(Color.red);  
        lb.setFont(new Font("Serif", Font.BOLD, 20));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(500, 500);  
        lb1 = new JLabel("First Name:");  
        lb1.setBounds(20, 160, 100, 20);  
        tf1 = new JTextField(50);  
        tf1.setBounds(130, 160, 200, 20);  
        lb2 = new JLabel("Last Name:");  
        lb2.setBounds(20, 190, 100, 20);  
        tf2 = new JTextField(100);  
        tf2.setBounds(130, 190, 200, 20);  
        lb3 = new JLabel("Medication:");  
        lb3.setBounds(20, 220, 100, 20);  
        tf3 = new JTextField(50);  
        tf3.setBounds(130, 220, 200, 20);  
        lb4 = new JLabel("Med Des:");  
        lb4.setBounds(20, 250, 100, 20);  
        tf4 = new JTextField(200);  
        tf4.setBounds(130, 250, 200, 20);  
        lb7 = new JLabel("Med Side E");  
        lb7.setBounds(20, 280, 100, 20);  
        tf7 = new JTextField(100);  
        tf7.setBounds(130, 280, 200, 20);  
        lb8 = new JLabel("PCP:");  
        lb8.setBounds(20, 300, 100, 20);  
        tf8 = new JTextField(100);  
        tf8.setBounds(130, 300, 200, 20);
        lb9 = new JLabel("PCP Location:");  
        lb9.setBounds(20, 320, 100, 20);  
        tf9 = new JTextField(100);  
        tf9.setBounds(130, 320, 200, 20); 
        lb10 = new JLabel("HC Provider:");  
        lb10.setBounds(20, 340, 100, 20);  
        tf10 = new JTextField(200);  
        tf10.setBounds(130, 340, 200, 20);  
        setLayout(null);  
        //Add components to the JFrame  
        add(lb5);  
        add(tf5);  
        add(lb6);
        add(tf6);
        add(btn);  
        add(btn2);
        add(lb);  
        add(lb1);  
        add(tf1);  
        add(lb2);  
        add(tf2);  
        add(lb3);  
        add(tf3);  
        add(lb4);  
        add(tf4);  
        add(lb7);
        add(tf7);
        add(lb8);
        add(tf8);
        add(lb9);
        add(tf9);
        add(lb10);
        add(tf10);
        //Set TextField Editable False  
        tf1.setEditable(false);  
        tf2.setEditable(false);  
        tf3.setEditable(false);  
        tf4.setEditable(false);  
        tf7.setEditable(false); 
        tf8.setEditable(false); 
        tf9.setEditable(false); 
        tf10.setEditable(false); 
        setLocationRelativeTo(null);
    }  
    @Override
    public void actionPerformed(ActionEvent e) {  
        //Create DataBase Coonection and Fetching Records  
        try {
            System.out.println(e.getActionCommand());
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/PatientDB?autoReconnect=true&useSSL=false";
            Connection con = (Connection) DriverManager.getConnection(URL, "TMB132", "4328325");
            switch (e.getActionCommand()) {
                case "Add Patient":
                    newFrame = new JFrame("Add Patient");
                    newFrame.setSize(400, 400);
                    label1 = new JLabel("First Name:");
                    label2 = new JLabel("Last Name:");
                    label1.setBounds(20, 20, 100, 20);
                    label2.setBounds(20,50,100,20);
                    text1 = new JTextField(20);
                    text1.setBounds(130, 20, 200, 20);
                    text2 = new JTextField(20);
                    text2.setBounds(130,50,200,20);
                    newFrame.setLayout(null);
                    newFrame.add(label1);
                    newFrame.add(label2);
                    newFrame.add(text1);
                    newFrame.add(text2);
                    newFrame.setLocationRelativeTo(null);
                    newFrame.setVisible(true);
                    JButton btn3 = new JButton("Add Name");
                    btn3.setBounds(180, 90, 100, 20);
                    newFrame.add(btn3);
                    btn3.addActionListener(this);
                    break;
                case "Submit":
                    String str = tf5.getText();
                    String str2 = tf6.getText();
                    PreparedStatement st = con.prepareStatement("select * from Patient where patient_first_name=? AND patient_last_name=?");
                    st.setString(1, str);
                    st.setString(2,str2);
                    //Excuting Query
                    ResultSet rs = st.executeQuery();
                    System.out.println("Connection to Database: Successful!");
                    if (rs.next()) {
                        patient_id = rs.getString("patient_id");
                        System.out.println(patient_id);
                        String firstName = rs.getString("patient_first_name");
                        String lastName = rs.getString("patient_last_name");
                        //String medicationID = rs.getString("medication_id");
                       // if(!patient.containsKey(patient_id)){
                        PreparedStatement st2 = con.prepareStatement("select medication_name\n" +
                        "from Patient p inner join patient_medication_junction pm\n" +
                        "on p.patient_id = pm.patient_id inner join Medication m \n" +
                        "where m.medication_name = 'Zoloft'");
                       // st2.setString(1, medicationID);
                        ResultSet rs2 = st2.executeQuery();
                        //}
                        String med = null;
                        String hc = null;
                        String pcp = null;
                        String PCPloc = null;
                        String medDes = null;
                        String medSide = null;
                        if(rs2.next()){
                            med = rs2.getString("medication_name");
                        }
                        
                        PreparedStatement st3 = con.prepareStatement("select provider_name from HealthcareProvider where provider_id =?");
                        st3.setString(1, patient_id);
                        ResultSet rs3 = st3.executeQuery();
                        if(rs3.next()){
                            hc = rs3.getString("provider_name");
                        }
                        PreparedStatement st4 = con.prepareStatement("select doctor_last_name from Patient_PCP where patient_id =?");
                        st4.setString(1, patient_id);
                        ResultSet rs4 = st4.executeQuery();
                        if(rs4.next()){
                            pcp = rs4.getString("doctor_last_name");
                        }
                        PreparedStatement st5 = con.prepareStatement("select office_name from Doctor_Office where office_id =?");
                        st5.setString(1, patient_id);
                        ResultSet rs5 = st5.executeQuery();
                        if(rs5.next()){
                            PCPloc = rs5.getString("office_name");
                        }
                        PreparedStatement st6 = con.prepareStatement("select medication_description from "
                                + "Medication m inner join patient_medication_junction mj where mj.patient_id = 1");
                        //st6.setString(1, patient_id);
                        ResultSet rs6 = st6.executeQuery();
                        if(rs6.next()){
                            medDes = rs6.getString("medication_description");
                        }
                        PreparedStatement st7 = con.prepareStatement("select medication_side_effects from Medication m "
                                + "inner join patient_medication_junction mj where mj.patient_id  = 1");
                        //st7.setString(1, patient_id);
                        ResultSet rs7 = st7.executeQuery();
                        if(rs7.next()){
                            medSide = rs7.getString("medication_side_effects");
                        }
                        //Sets Records in TextFields.
                        tf1.setText(firstName);
                        tf2.setText(lastName);
                        tf3.setText(med);
                        tf4.setText(medDes);
                        tf7.setText(medSide);
                        tf8.setText("Dr. " + pcp);
                        tf9.setText(PCPloc);
                        tf10.setText(hc);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Name not Found");
                    }
                    break;
                case "Add Name":
                    firstN = text1.getText();
                    lastN = text2.getText();
                    String sql = "insert into Patient(patient_id, patient_first_name, patient_last_name) values(null, ?, ?)";
                    patient.put(count++, lastN);
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, firstN);
                    ps.setString(2,lastN);
                    int row;
                    row = ps.executeUpdate();
                    newFrame.setVisible(false);
                    //JOptionPane.showMessageDialog(null, "Patient Added!");
                    ////////new stuff here
                    newFrame = new JFrame("Add Patient information");
                    newFrame.setSize(400, 400);
                    lab1 = new JLabel("HC Provider:");
                    lab2 = new JLabel("PCP:");
                    lab1.setBounds(20, 20, 100, 20);
                    lab2.setBounds(20,50,100,20);
                    txt1 = new JTextField(20);
                    txt1.setBounds(130, 20, 200, 20);
                    txt2 = new JTextField(20);
                    txt2.setBounds(130,50,200,20);
                    newFrame.setLayout(null);
                    newFrame.add(lab1);
                    newFrame.add(lab2);
                    newFrame.add(txt1);
                    newFrame.add(txt2);
                    newFrame.setLocationRelativeTo(null);
                    newFrame.setVisible(true);
                    JButton btn4 = new JButton("Add info");
                    btn4.setBounds(180, 90, 100, 20);
                    newFrame.add(btn4);
                    btn4.addActionListener(this);
                    break;
                case "Add info":
                    String sqql = "update Patient_PCP set patient_id =? where pcp_id =?";
                    PreparedStatement prs = con.prepareStatement(sqql);
                    prs.setString(1, patient_id);
                    prs.setString(2, patient_id);
                    int roww;
                    roww = prs.executeUpdate();
                    Pcp = txt2.getText();
                    HCpro = txt1.getText();
                    String provAdd = "2611 E Ohath St Pittsburgh PA 15224";
                    String sql2 = "insert into HealthcareProvider(provider_id, provider_name, provider_address) values(null, ?, ?)";
                    PreparedStatement preps = con.prepareStatement(sql2);
                    preps.setString(1, HCpro);
                    preps.setString(2,provAdd);
                    int row2;
                    row2 = preps.executeUpdate();
                    String firstn = "Jamal";
                    String sql3 = "insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name, healthcareProvider) values(null, ?, ?, ?)";
                    PreparedStatement preps2 = con.prepareStatement(sql3);
                    preps2.setString(1, firstn);
                    preps2.setString(2,Pcp);
                    preps2.setString(3, HCpro);
                    int row3;
                    row3 = preps2.executeUpdate();
                    newFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Patient Added!");
                default :
                    break;
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {  
            System.out.println(ex);  
        }  
    }  
    
    //Running Constructor  
    public static void main(String args[]) { 
        System.out.println("NAMES: Tristin Butz, Rachel Krupa, Garret Cherry");
        PatientDB swingSearchApp = new PatientDB();  
    }  
}  
