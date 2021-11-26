package students;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import students.DAOstudent;

public class GuiFaculty extends JFrame implements ActionListener{
    
    JLabel lno, lname, ldep, lpost, lstatus, l5;
    JTextField tno, tname, tdep, tpost, tstatus;
    JButton binsert, bupdate, bdelete, bselect, bselectAll;
    JComboBox cb1;
    
    GuiFaculty()
    {
        setVisible(true);
        setSize(1000, 500);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        
        lno = new JLabel("SNo");
        lname = new JLabel("Name");
        ldep = new JLabel("Department");
        lpost = new JLabel("Post");
        lstatus = new JLabel("Status");
        l5 = new JLabel("");
        
        cb1 = new JComboBox();

        tno = new JTextField(15);
        tname = new JTextField(15);
        tdep = new JTextField(15);
        tpost = new JTextField(15);
        tstatus = new JTextField(15);

        binsert = new JButton("Insert");
        bupdate = new JButton("Update");
        bdelete = new JButton("Delet");
        bselect = new JButton("Display");
        bselectAll = new JButton("Display_All");

        add(lno);       add(tno);
        add(lname);     add(tname);
        add(ldep);     add(tdep);
        add(lpost);   add(tpost);
        add(lstatus);   add(tstatus);

        add(binsert);
        add(bupdate);
        add(bdelete);

        add(l5);
        //add(cb1);

        binsert.addActionListener(this);
        bupdate.addActionListener(this);
        bdelete.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            DAOFaculty dao = new DAOFaculty();
            student s = new student();
            if (tno.getText() != null) {
                s.no = Integer.parseInt(tno.getText());
            } else {
                s.no = 0;
            }
            if (tno.getText() != null) {
                s.no = Integer.parseInt(tno.getText());
            } else {
                s.no = 0;
            }
            if (ae.getSource() == binsert) {
                s.name = tname.getText();
                s.dept = tdep.getText();
                s.posts = tpost.getText();
                s.statuss = tstatus.getText();
                dao.insert(s);
                l5.setText("inseted");
            }
            else if (ae.getSource() == bupdate) {
                s.name = tname.getText();
                s.dept = tdep.getText();
                s.posts = tpost.getText();
                s.statuss = tstatus.getText();
                dao.update(s);
                l5.setText("updated");
            }
            else if (ae.getSource() == bdelete) {
                dao.delete(s);
                l5.setText("Deleted");
            }
        } 
        catch (Exception ex) {
            System.out.println("error, Try again");
            System.out.println(ex);
        }
    }
    
}
