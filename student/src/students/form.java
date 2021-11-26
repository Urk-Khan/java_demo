package students;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import students.DAOstudent;

public class form extends JFrame implements ActionListener {

    JLabel lstf;
    JButton bstf, bftf, bstaf;
    JComboBox cb1;
    
    form()
    {
        setVisible(true);
        setSize(1000, 500);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        bstf = new JButton("Student");
        bftf = new JButton("Faculity");
        bstaf = new JButton("Staff");
        cb1 = new JComboBox();
        add(bstf); add(bftf); add (bstaf);
        
        bstf.addActionListener(this);
        bftf.addActionListener(this);
        bstaf.addActionListener(this);
    }
                
    public void actionPerformed(ActionEvent ae) {
        try
        {
            if (ae.getSource() == bstf){
                GuiStudent sobj = new GuiStudent();
            }
            else if (ae.getSource() == bftf)
            {
                GuiFaculty fobj = new GuiFaculty();
            }
            else if (ae.getSource() == bstaf)
            {
                GuiStaff stf_obj = new GuiStaff();
            }
        }
        catch(Exception ex){
            System.out.println("Error In Form");
            System.out.println(ex);
        }
    }
    
            
}
