package students;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import students.DAOstudent;

public class GuiStudent extends JFrame implements ActionListener {

    JLabel lno, lname, lroll, ldegree, l5;
    JRadioButton r1, r2;
    JTextField tno, tname, troll, tdegree;
    JButton binsert, bupdate, bdelete, bselect, bselectAll;
    JComboBox cb1;

    GuiStudent() {
        setVisible(true);
        setSize(1000, 500);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        lno = new JLabel("SNo");
        lname = new JLabel("Name");
        lroll = new JLabel("Roll No");
        ldegree = new JLabel("Degree");
        l5 = new JLabel("");
        
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        cb1 = new JComboBox();

        tno = new JTextField(15);
        tname = new JTextField(15);
        troll = new JTextField(15);
        tdegree = new JTextField(15);

        binsert = new JButton("Insert");
        bupdate = new JButton("Update");
        bdelete = new JButton("Delet");
        bselect = new JButton("Display");
        bselectAll = new JButton("Display_All");

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        add(lno);       add(tno);
        add(lname);     add(tname);
        add(lroll);     add(troll);
        add(ldegree);   add(tdegree);
        
        add(r1); add(r2);
        add(binsert);
        add(bupdate);
        add(bdelete);
        add(bselect);
        add(bselectAll);

        add(l5);
        add(cb1);

        binsert.addActionListener(this);
        bupdate.addActionListener(this);
        bdelete.addActionListener(this);
        bselect.addActionListener(this);
        bselectAll.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            student s = new student();
            DAOstudent dao = new DAOstudent();
           
            if (ae.getSource() == binsert) {
                 if (tno.getText() != null) {
                s.no = Integer.parseInt(tno.getText());
            } else {
                s.no = 0;
            }
                s.name = tname.getText();
                s.rollNo = Integer.parseInt(troll.getText());
                s.degree = tdegree.getText();
                dao.insert(s);
                l5.setText("inseted");
            } 
            else if (ae.getSource() == bupdate) {
                 if (tno.getText() != null) {
                s.no = Integer.parseInt(tno.getText());
                } else {
                     s.no = 0;
                }
                s.name = tname.getText();
                s.rollNo = Integer.parseInt(troll.getText());
                s.degree = tdegree.getText();
                dao.update(s);
                l5.setText("Updeted");
            } 
            else if (ae.getSource() == bdelete) {
                dao.delete(s);
                l5.setText("Deleted");
            } 
            else if (ae.getSource() == bselect) {
                 if (tno.getText() != null) {
                     s.no = Integer.parseInt(tno.getText());
                 } else {
                     s.no = 0;  
                 }
                 cb1.removeAllItems();
                ResultSet ret = dao.SelectById(s);
                while (ret.next()) {
                   cb1.addItem("id: " + ret.getString(1) );
                   cb1.addItem("Name: " + ret.getString(2));
                   cb1.addItem("Roll No: " +  ret.getString(3));
                   cb1.addItem("Degree: " +  ret.getString(4));
                }
            }
            else if (ae.getSource() == bselectAll)
            {
                    cb1.removeAllItems();
                ResultSet ret = dao.SelectAll(s);
                while (ret.next()) {
                    cb1.addItem("id: " + ret.getString(1) );
                    cb1.addItem("Name: " + ret.getString(2));
                    cb1.addItem("Roll No: " +  ret.getString(3));
                    cb1.addItem("Degree: " +  ret.getString(4));
                }
            }
            
        } 
        catch (Exception ex) {
            System.out.println("error, Try again");
            System.out.println(ex);
        }
    }
}
