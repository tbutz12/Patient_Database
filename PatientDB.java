/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDB;

import java.util.UUID;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PatientDB extends JFrame implements ActionListener {

    String firstN;
    String lastN;
    String Pcp;
    String HCpro;
    String patient_id;
    String URL;
    String id1, id2, id3, id4;
    Connection con;
    boolean[] panelFlags = new boolean[5];
    ArrayList<String> names = new ArrayList<>();
    int count = -1;
//Initializing Components  
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb10, label1, label2, lab1, lab2, lab3, lab4;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf8, tf10, text1, text2, txt1, txt2, txt3, txt4;
    JTextArea tf7;
    JButton btn, btn2, btn3, btn4;
    JFrame newFrame, newFrame2, newFrame3;

    //Creating Constructor for initializing JFrame components  
    PatientDB() throws SQLException, ClassNotFoundException {

        //Providing Title  
        super("Fetching Patient Information");
        Class.forName("com.mysql.jdbc.Driver");
        URL = "jdbc:mysql://localhost:3306/PatientDB?autoReconnect=true&useSSL=false";
        con = (Connection) DriverManager.getConnection(URL, "TMB132", "4328325");
        PreparedStatement start = con.prepareStatement("select patient_id from Patient where patient_last_name = ?");
        start.setString(1, "butz");
        //Excuting Query
        ResultSet r = start.executeQuery();
        if (r.next()) {
            id1 = r.getString("patient_id");
        }
        PreparedStatement start2 = con.prepareStatement("select patient_id from Patient where patient_last_name = ?");
        start2.setString(1, "krupa");
        //Excuting Query
        ResultSet r2 = start2.executeQuery();
        if (r2.next()) {
            id2 = r2.getString("patient_id");
        }
        PreparedStatement start3 = con.prepareStatement("select patient_id from Patient where patient_last_name = ?");
        start3.setString(1, "cherry");
        //Excuting Query
        ResultSet r3 = start3.executeQuery();
        if (r3.next()) {
            id3 = r3.getString("patient_id");
        }
        PreparedStatement start4 = con.prepareStatement("select patient_id from Patient where patient_last_name = ?");
        start4.setString(1, "blake");
        //Excuting Query
        ResultSet r4 = start4.executeQuery();
        if (r4.next()) {
            id4 = r4.getString("patient_id");
        }
        lb5 = new JLabel("First Name:");
        lb6 = new JLabel("Last Name:");
        lb5.setBounds(20, 20, 100, 20);
        lb6.setBounds(20, 50, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 20);
        tf6 = new JTextField(20);
        tf6.setBounds(130, 50, 200, 20);
        btn = new JButton("Submit");
        btn.setBounds(180, 90, 100, 20);
        btn.addActionListener(this);
        btn2 = new JButton("Add Patient");
        btn2.setBounds(300, 90, 100, 20);
        btn2.addActionListener(this);
        btn3 = new JButton("View Visit Info");
        btn3.setBounds(450, 50, 100, 20);
        btn3.addActionListener(this);
        btn4 = new JButton("Add Meds");
        btn4.setBounds(400,90,100,20);
        btn4.addActionListener(this);
        lb = new JLabel("Fetching Patient Information From Database");
        lb.setBounds(40, 120, 450, 30);
        lb.setForeground(Color.red);
        lb.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
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
        lb4.setBounds(20, 310, 100, 20);
        tf4 = new JTextField(200);
        tf4.setBounds(130, 310, 200, 20);
        lb7 = new JLabel("Med Side Effects");
        lb7.setBounds(20, 340, 100, 20);
        tf7 = new JTextArea(5, 20);
        tf7.setBounds(130, 340, 340, 140);
        tf7.setVisible(true);
        tf7.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(tf7, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        lb8 = new JLabel("PCP:");
        lb8.setBounds(20, 250, 100, 20);
        tf8 = new JTextField(100);
        tf8.setBounds(130, 250, 200, 20);
        lb10 = new JLabel("Insurance Provider:");
        lb10.setBounds(20, 280, 100, 20);
        tf10 = new JTextField(200);
        tf10.setBounds(130, 280, 200, 20);
        setLayout(null);
        //Add components to the JFrame  
        add(lb5);
        add(tf5);
        add(lb6);
        add(tf6);
        add(btn);
        add(btn2);
        add(btn3);
        add(btn4);
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
        add(lb10);
        add(tf10);
        //Set TextField Editable False  
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf10.setEditable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Create DataBase Coonection and Fetching Records  
        try {
            switch (e.getActionCommand()) {
                case "Add Patient":
                    newFrame = new JFrame("Add Patient");
                    newFrame.setSize(400, 400);
                    label1 = new JLabel("First Name:");
                    label2 = new JLabel("Last Name:");
                    label1.setBounds(20, 20, 100, 20);
                    label2.setBounds(20, 50, 100, 20);
                    text1 = new JTextField(20);
                    text1.setBounds(130, 20, 200, 20);
                    text2 = new JTextField(20);
                    text2.setBounds(130, 50, 200, 20);
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
                    st.setString(2, str2);
                    //Excuting Query
                    ResultSet rs = st.executeQuery();
                    System.out.println("Connection to Database: Successful!");
                    if (rs.next()) {
                        patient_id = rs.getString("patient_id");
                        String firstName = rs.getString("patient_first_name");
                        String lastName = rs.getString("patient_last_name");
                        PreparedStatement st2 = con.prepareStatement("select medication_name\n"
                                + "from Patient p inner join Prescription pr\n"
                                + "on p.patient_id = pr.patient_id inner join Medication m \n"
                                + "on m.medication_id =  pr.medication_id where p.patient_id =?");
                        st2.setString(1, patient_id);
                        ResultSet rs2 = st2.executeQuery();
                        String med = null;
                        String hc = null;
                        String pcp = null;
                        String PCPloc = null;
                        String medDes = null;
                        String medSide = null;
                        if (rs2.next()) {
                            med = rs2.getString("medication_name");
                        }

                        PreparedStatement st3 = con.prepareStatement("select provider_name from InsuranceProvider where patient_id =?");
                        st3.setString(1, patient_id);
                        ResultSet rs3 = st3.executeQuery();
                        if (rs3.next()) {
                            hc = rs3.getString("provider_name");
                        }
                        PreparedStatement st4 = con.prepareStatement("select doctor_last_name from Patient_PCP where patient_id =?");
                        st4.setString(1, patient_id);
                        ResultSet rs4 = st4.executeQuery();
                        if (rs4.next()) {
                            pcp = rs4.getString("doctor_last_name");
                        }
                        PreparedStatement st6 = con.prepareStatement("select medication_description from "
                                + "Medication m inner join Prescription pr on m.medication_id = pr.medication_id where pr.patient_id = ?");
                        st6.setString(1, patient_id);
                        ResultSet rs6 = st6.executeQuery();
                        if (rs6.next()) {
                            medDes = rs6.getString("medication_description");
                        }
                        PreparedStatement st7 = con.prepareStatement("select medication_side_effects from Medication m "
                                + "inner join Prescription pr on m.medication_id = pr.medication_id where pr.patient_id  = ?");
                        st7.setString(1, patient_id);
                        ResultSet rs7 = st7.executeQuery();
                        if (rs7.next()) {
                            medSide = rs7.getString("medication_side_effects");
                        }
                        //Sets Records in TextFields.
                        tf1.setText(firstName);
                        tf2.setText(lastName);
                        tf3.setText(med);
                        tf4.setText(medDes);
                        tf7.setText(medSide);
                        tf8.setText("Dr. " + pcp);
                        tf10.setText(hc);
                    } else {
                        JOptionPane.showMessageDialog(null, "Name not Found");
                    }
                    break;
                case "Add Name":
                    firstN = text1.getText();
                    lastN = text2.getText();
                    String sql = "insert into Patient(patient_id, patient_first_name, patient_last_name) values(?, ?, ?)";
                    UUID uuid = UUID.randomUUID();
                    String random = uuid.toString();
                    names.add(random);
                    count++;
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, random);
                    ps.setString(2, firstN);
                    ps.setString(3, lastN);
                    int row;
                    row = ps.executeUpdate();
                    newFrame.setVisible(false);
                    newFrame = new JFrame("Add Patient information");
                    newFrame.setSize(400, 400);
                    lab1 = new JLabel("Ins. Provider:");
                    lab2 = new JLabel("PCP first name:");
                    lab3 = new JLabel("PCP last name");
                    lab4 = new JLabel("PCP address");
                    lab1.setBounds(20, 20, 100, 20);
                    lab2.setBounds(20, 50, 100, 20);
                    lab3.setBounds(20, 80, 100, 20);
                    lab4.setBounds(20, 110, 100, 20);
                    txt1 = new JTextField(20);
                    txt1.setBounds(130, 20, 200, 20);
                    txt2 = new JTextField(20);
                    txt2.setBounds(130, 50, 200, 20);
                    txt3 = new JTextField(20);
                    txt3.setBounds(130, 80, 200, 20);
                    txt4 = new JTextField(20);
                    txt4.setBounds(130, 110, 200, 20);
                    newFrame.setLayout(null);
                    newFrame.add(lab1);
                    newFrame.add(lab2);
                    newFrame.add(lab3);
                    newFrame.add(lab4);
                    newFrame.add(txt1);
                    newFrame.add(txt2);
                    newFrame.add(txt3);
                    newFrame.add(txt4);
                    newFrame.setLocationRelativeTo(null);
                    newFrame.setVisible(true);
                    JButton btn4 = new JButton("Add info");
                    btn4.setBounds(180, 140, 100, 20);
                    newFrame.add(btn4);
                    btn4.addActionListener(this);
                    break;
                case "Add info":
                    String pat = names.get(count);
                    HCpro = txt1.getText();
                    String provAdd = txt4.getText();
                    String sql2 = "insert into InsuranceProvider(provider_id, provider_name, provider_address) values(null, ?, ?)";
                    PreparedStatement preps = con.prepareStatement(sql2);
                    preps.setString(1, HCpro);
                    preps.setString(2, provAdd);
                    int row2;
                    row2 = preps.executeUpdate();
                    String sql3 = "insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name) values(null, ?, ?)";
                    PreparedStatement preps2 = con.prepareStatement(sql3);
                    preps2.setString(1, firstN);
                    preps2.setString(2, lastN);
                    int row3;
                    row3 = preps2.executeUpdate();
                    String sqql = "update Patient_PCP set patient_id =? where doctor_last_name =?";
                    PreparedStatement prs = con.prepareStatement(sqql);
                    prs.setString(1, pat);
                    prs.setString(2, lastN);
                    int roww;
                    roww = prs.executeUpdate();
                    String sqql2 = "update InsuranceProvider set patient_id =? where provider_address =?";
                    PreparedStatement prs2 = con.prepareStatement(sqql2);
                    prs2.setString(1, pat);
                    prs2.setString(2, provAdd);
                    int roww2;
                    roww2 = prs2.executeUpdate();
                    newFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Patient Added!");
                    break;
                case "View Visit Info":
                    newFrame2 = new JFrame("Visit Info");
                    newFrame2.setSize(400, 400);
                    newFrame2.setVisible(true);
                    newFrame2.setLayout(null);
                    newFrame2.setLocationRelativeTo(null);
                    JLabel visitLab1 = new JLabel("Time:");
                    JLabel visitLab2 = new JLabel("Doctor:");
                    visitLab1.setBounds(20, 20, 100, 20);
                    visitLab2.setBounds(20, 50, 100, 20);
                    JTextField visitTxt1 = new JTextField(20);
                    visitTxt1.setBounds(130, 20, 200, 20);
                    JTextField visitTxt2 = new JTextField(20);
                    visitTxt2.setBounds(130, 50, 200, 20);

                    PreparedStatement visitStatement = con.prepareStatement("select date, doctorName from Visit where patient_visit = ?");
                    visitStatement.setString(1, patient_id);
                    ResultSet visitResult = visitStatement.executeQuery();
                    String time,
                     dName;
                    if (visitResult.next()) {
                        time = visitResult.getString("date");
                        dName = visitResult.getString("doctorName");
                        visitTxt1.setText(time);
                        visitTxt2.setText(dName);
                    }
                    newFrame2.add(visitLab1);
                    newFrame2.add(visitLab2);
                    newFrame2.add(visitTxt1);
                    newFrame2.add(visitTxt2);
                    visitTxt1.setEditable(false);
                    visitTxt2.setEditable(false);
                    JButton det = new JButton("View More Details");
                    newFrame2.add(det);
                    det.setBounds(150, 90, 100, 20);
                    det.addActionListener(this);
                    break;

                case "View More Details":
                    newFrame2.setVisible(false);
                    newFrame3 = new JFrame("More Information");
                    newFrame3.setSize(400, 400);
                    JComboBox panels = new JComboBox(new String[]{"Dx", "Labs", "Procedures", "Pathology", "Imaging"});
                    newFrame3.setLayout(null);
                    newFrame3.setLocationRelativeTo(null);
                    newFrame3.setVisible(true);
                    JButton but = new JButton("Go");
                    JMenuBar menuBar = new JMenuBar();
                    menuBar.add(panels);
                    menuBar.setBounds(150, 40, 100, 20);
                    newFrame3.add(menuBar);
                    JButton _btn_1 = new JButton("Go");
                    _btn_1.setBounds(150, 90, 100, 20);
                    newFrame3.add(_btn_1);
                    _btn_1.addActionListener(this);
                    Arrays.fill(panelFlags, false);
                    ActionListener cbActionListener = (ActionEvent a) -> {
                        String s = (String) panels.getSelectedItem();
                        switch (s) {
                            case "Dx":
                                Arrays.fill(panelFlags, false);
                                panelFlags[0] = true;
                                break;
                            case "Labs":
                                Arrays.fill(panelFlags, false);
                                panelFlags[1] = true;
                                break;
                            case "Procedures":
                                Arrays.fill(panelFlags, false);
                                panelFlags[2] = true;
                                break;
                            case "Pathology":
                                Arrays.fill(panelFlags, false);
                                panelFlags[3] = true;
                                break;
                            case "Imaging":
                                Arrays.fill(panelFlags, false);
                                panelFlags[4] = true;
                                break;
                            default:
                                break;
                        }
                    };
                    panels.addActionListener(cbActionListener);
                case "Go":
                    int access = -1;
                    for (int x = 0; x < panelFlags.length; x++) {
                        if (panelFlags[x] == true) {
                            access = x;
                        }
                    }

                    switch (access) {
                        case 0:
                            JFrame newFrame4 = new JFrame("Dx");
                            newFrame4.setSize(400, 400);
                            newFrame4.setLayout(null);
                            newFrame4.setLocationRelativeTo(null);
                            newFrame4.setVisible(true);
                            JLabel desLab = new JLabel("Description");
                            desLab.setBounds(168, 20, 100, 20);
                            JTextArea desText = new JTextArea(5, 20);
                            desText.setBounds(50, 40, 300, 220);
                            desText.setVisible(true);
                            desText.setLineWrap(true);
                            desText.setEditable(false);
                            newFrame4.setLayout(null);
                            newFrame4.add(desLab);
                            newFrame4.add(desText);
                            String description;
                            PreparedStatement Dx = con.prepareStatement("select description from Dx where patient_dx =?");
                            Dx.setString(1, patient_id);
                            ResultSet DxRes = Dx.executeQuery();
                            if (DxRes.next()) {
                                description = DxRes.getString("description");
                                desText.setText(description);
                            }
                            break;
                        case 1:
                            JFrame newFrame5 = new JFrame("Labs");
                            newFrame5.setSize(400, 400);
                            newFrame5.setLayout(null);
                            newFrame5.setLocationRelativeTo(null);
                            newFrame5.setVisible(true);
                            JLabel bodyW = new JLabel("Bodyweight");
                            bodyW.setBounds(20, 20, 100, 20);
                            newFrame5.add(bodyW);
                            JLabel height = new JLabel("Height");
                            height.setBounds(20, 40, 100, 20);
                            newFrame5.add(height);
                            JLabel bloodP = new JLabel("Blood Pressure");
                            bloodP.setBounds(20, 60, 100, 20);
                            newFrame5.add(bloodP);
                            JLabel bloodType = new JLabel("Blood Type");
                            bloodType.setBounds(20, 80, 100, 20);
                            newFrame5.add(bloodType);
                            JLabel bodyTemp = new JLabel("Body Temp");
                            bodyTemp.setBounds(20, 100, 100, 20);
                            newFrame5.add(bodyTemp);
                            JTextField bodyWeight = new JTextField();
                            bodyWeight.setBounds(200, 20, 100, 20);
                            newFrame5.add(bodyWeight);
                            JTextField heightText = new JTextField();
                            heightText.setBounds(200, 40, 100, 20);
                            newFrame5.add(heightText);
                            JTextField bPressure = new JTextField();
                            bPressure.setBounds(200, 60, 100, 20);
                            newFrame5.add(bPressure);
                            JTextField bType = new JTextField();
                            bType.setBounds(200, 80, 100, 20);
                            newFrame5.add(bType);
                            JTextField bTemp = new JTextField();
                            bTemp.setBounds(200, 100, 100, 20);
                            newFrame5.add(bTemp);
                            bodyWeight.setEditable(false);
                            heightText.setEditable(false);
                            bPressure.setEditable(false);
                            bType.setEditable(false);
                            bTemp.setEditable(false);
                            double b,h,bp,bt;
                            String blt;
                            PreparedStatement Labs = con.prepareStatement("select bodyweight, height, bloodPressure, bloodType, bodyTemp from Labs where patient_lab =?");
                            Labs.setString(1, patient_id);
                            ResultSet LabRes = Labs.executeQuery();
                            if (LabRes.next()) {
                                b = LabRes.getDouble("bodyweight");
                                bodyWeight.setText(Double.toString(b));
                                h = LabRes.getDouble("height");
                                heightText.setText(Double.toString(h));
                                bp = LabRes.getDouble("bloodPressure");
                                bPressure.setText(Double.toString(bp));
                                blt = LabRes.getString("bloodType");
                                bType.setText(blt);
                                bt = LabRes.getDouble("bodyTemp");
                                bTemp.setText(Double.toString(bt));
                            }

                            break;
                        case 2:
                            JFrame newFrame6 = new JFrame("Procedures");
                            newFrame6.setSize(400, 400);
                            newFrame6.setLayout(null);
                            newFrame6.setLocationRelativeTo(null);
                            newFrame6.setVisible(true);
                            newFrame6.setLayout(null);
                            JLabel sHistory = new JLabel("Surgical History");
                            sHistory.setBounds(20, 20, 100, 20);
                            newFrame6.add(sHistory);
                            JTextArea surgicalH = new JTextArea(5, 20);
                            surgicalH.setBounds(50, 40, 300, 220);
                            surgicalH.setVisible(true);
                            surgicalH.setLineWrap(true);
                            surgicalH.setEditable(false);
                            newFrame6.add(surgicalH);
                            String procedures;
                            PreparedStatement proc = con.prepareStatement("select surgicalHistory from Procedures where patient_procedures =?");
                            proc.setString(1, patient_id);
                            ResultSet procRes = proc.executeQuery();
                            if (procRes.next()) {
                                procedures = procRes.getString("surgicalHistory");
                                surgicalH.setText(procedures);
                            }
                            break;
                        case 3:
                            JFrame newFrame7 = new JFrame("Pathology");
                            newFrame7.setSize(400, 400);
                            newFrame7.setLayout(null);
                            newFrame7.setLocationRelativeTo(null);
                            newFrame7.setVisible(true);
                            newFrame7.setLayout(null);
                            JLabel date = new JLabel("Time");
                            date.setBounds(20, 20, 100, 20);
                            newFrame7.add(date);
                            JLabel testName = new JLabel("Test Type");
                            testName.setBounds(20, 40, 100, 20);
                            newFrame7.add(testName);
                            JLabel testDescription = new JLabel("Test Desc.");
                            testDescription.setBounds(20, 62, 100, 20);
                            newFrame7.add(testDescription);
                            JLabel site = new JLabel("Site Collected");
                            site.setBounds(20, 100, 100, 20);
                            newFrame7.add(site);
                            JLabel res = new JLabel("Result");
                            res.setBounds(20, 120, 100, 20);
                            newFrame7.add(res);
                            JTextField dateTime = new JTextField();
                            JTextField tType = new JTextField();
                            JTextField sCollected = new JTextField();
                            JTextField result = new JTextField();
                            JTextArea testD = new JTextArea(5, 20);
                            testD.setVisible(true);
                            testD.setLineWrap(true);
                            testD.setEditable(false);
                            dateTime.setBounds(200, 20, 100, 20);
                            tType.setBounds(200, 40, 100, 20);
                            testD.setBounds(200, 64, 180, 30);
                            sCollected.setBounds(200, 100, 100, 20);
                            result.setBounds(200, 120, 100, 20);
                            newFrame7.add(dateTime);
                            newFrame7.add(tType);
                            newFrame7.add(sCollected);
                            newFrame7.add(result);
                            newFrame7.add(testD);
                            dateTime.setEditable(false);
                            tType.setEditable(false);
                            sCollected.setEditable(false);
                            result.setEditable(false);
                            testD.setEditable(false);
                            String dateT,
                             testT,
                             testDes,
                             siteC,
                             resultT;
                            PreparedStatement path = con.prepareStatement("select date, testName, testDescription, siteCollected, result from Pathology where patient_pathology =?");
                            path.setString(1, patient_id);
                            ResultSet pathRes = path.executeQuery();
                            if (pathRes.next()) {
                                dateT = pathRes.getString("date");
                                testT = pathRes.getString("testName");
                                testDes = pathRes.getString("testDescription");
                                siteC = pathRes.getString("siteCollected");
                                resultT = pathRes.getString("result");
                                dateTime.setText(dateT);
                                tType.setText(testT);
                                sCollected.setText(siteC);
                                result.setText(resultT);
                                testD.setText(testDes);
                            }
                            break;
                        case 4:
                            JFrame newFrame8 = new JFrame("Image");
                            newFrame8.setSize(400, 400);
                            newFrame8.setLayout(null);
                            newFrame8.setLocationRelativeTo(null);
                            newFrame8.setVisible(true);
                            newFrame8.setLayout(null);
                            File f1 = new File("/Users/tristinbutz/1.jpg");
                            File f2 = new File("/Users/tristinbutz/fracture.png");
                            File f3 = new File("/Users/tristinbutz/rootCanal.png");
                            File f4 = new File("/Users/tristinbutz/ivp.jpg");
                            System.out.println("Pat_id\n" + patient_id);
                            System.out.println("ID\n" + id2);
                            if (patient_id.equals(id1)) {
                                try {
                                        try (FileInputStream fin = new FileInputStream(f1)) {
                                            PreparedStatement pst_1 = con.prepareStatement("insert into Imaging(imaging_id, scan, image, patient_imaging) values(null, ?, ?, ?)");
                                            pst_1.setString(1, "X-Ray");
                                            pst_1.setBinaryStream(2, fin);
                                            pst_1.setString(3, patient_id);
                                            pst_1.executeUpdate();
                                            pst_1.close();
                                            PreparedStatement img = con.prepareStatement("select image from imaging where patient_imaging =?");
                                            img.setString(1, patient_id);
                                            img.executeQuery();
                                            ResultSet rset = img.executeQuery();
                                            if (rset.next()) {
                                                newFrame8.setContentPane(new JLabel(new ImageIcon(ImageIO.read(f1))));
                                                newFrame8.pack();
                                            }
                                        }
                                } catch (NullPointerException n) {
                                }
                            }
                            if (patient_id.equals(id2)) {
                                try {
                                        try (FileInputStream fin2 = new FileInputStream(f2)) {
                                            PreparedStatement pst_2 = con.prepareStatement("insert into Imaging(imaging_id, scan, image, patient_imaging) values(null, ?, ?, ?)");
                                            pst_2.setString(1, "X-Ray");
                                            pst_2.setBinaryStream(2, fin2);
                                            pst_2.setString(3, patient_id);
                                            pst_2.executeUpdate();
                                            pst_2.close();
                                            PreparedStatement img2 = con.prepareStatement("select image from imaging where patient_imaging =?");
                                            img2.setString(1, patient_id);
                                            img2.executeQuery();
                                            ResultSet rset2 = img2.executeQuery();
                                            if (rset2.next()) {
                                                newFrame8.setContentPane(new JLabel(new ImageIcon(ImageIO.read(f2))));
                                                newFrame8.pack();
                                            }
                                        }
                                } catch (NullPointerException n) {
                                }
                            }
                            if (patient_id.equals(id3)) {
                                try {
                                        try (FileInputStream fin3 = new FileInputStream(f3)) {
                                            PreparedStatement pst_3 = con.prepareStatement("insert into Imaging(imaging_id, scan, image, patient_imaging) values(null, ?, ?, ?)");
                                            pst_3.setString(1, "CT-Scan");
                                            pst_3.setBinaryStream(2, fin3);
                                            pst_3.setString(3, patient_id);
                                            pst_3.executeUpdate();
                                            pst_3.close();
                                            PreparedStatement img3 = con.prepareStatement("select image from imaging where patient_imaging =?");
                                            img3.setString(1, patient_id);
                                            img3.executeQuery();
                                            ResultSet rset3 = img3.executeQuery();
                                            if (rset3.next()) {
                                                newFrame8.setContentPane(new JLabel(new ImageIcon(ImageIO.read(f3))));
                                                newFrame8.pack();
                                            }
                                        }
                                    
                                } catch (NullPointerException n) {
                                }
                            }
                            if (patient_id.equals(id4)) {
                                try {
                                        try (FileInputStream fin4 = new FileInputStream(f4)) {
                                            PreparedStatement pst_4 = con.prepareStatement("insert into Imaging(imaging_id, scan, image, patient_imaging) values(null, ?, ?, ?)");
                                            pst_4.setString(1, "IVP");
                                            pst_4.setBinaryStream(2, fin4);
                                            pst_4.setString(3, patient_id);
                                            pst_4.executeUpdate();
                                            pst_4.close();
                                            PreparedStatement img4 = con.prepareStatement("select image from imaging where patient_imaging =?");
                                            img4.setString(1, patient_id);
                                            img4.executeQuery();
                                            ResultSet rset4 = img4.executeQuery();
                                            if (rset4.next()) {
                                                newFrame8.setContentPane(new JLabel(new ImageIcon(ImageIO.read(f4))));
                                                newFrame8.pack();
                                            }
                                        }
                                    
                                } catch (NullPointerException n) {
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "Add Meds":
                    JFrame medFrame = new JFrame("Prescription");
                    medFrame.setSize(400, 400);
                    medFrame.setLayout(null);
                    medFrame.setLocationRelativeTo(null);
                    medFrame.setVisible(true);
                    medFrame.setLayout(null);
                    String medQ = "insert into Prescription(patient_id, medication_id, prescription_start_date, prescription_daily_dosage)" +
                    "values(?, ?, '2016-09-23 10:10:10-08:20', '1 per day')";
                    PreparedStatement medPrep = con.prepareStatement(medQ);
                    medPrep.setString(1, names.get(count));
                    medPrep.setString(2, "@med_id_4");
                    int ex;
                    ex = medPrep.executeUpdate();
                default:
                    break;
            }
        } catch (SQLException | IOException ex1) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    //Running Constructor  
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        System.out.println("NAMES: Tristin Butz, Rachel Krupa, Garret Cherry");
        PatientDB swingSearchApp = new PatientDB();
    }
}
