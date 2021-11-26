package students;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import students.DAOstudent;

public class check_form extends JFrame implements ActionListener{
    JButton bdata, brecord;
    
    check_form()
    {
        setVisible(true);
        setSize(1000, 500);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        bdata =new JButton("Data Entry");
        brecord = new JButton ("Check_records");
        
        add(bdata); add(brecord);
        
        
        bdata.addActionListener(this);
        brecord.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == bdata) {
            form f =new form();
        }
    }
}
