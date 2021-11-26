package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class guiArray extends JFrame implements ActionListener{
    ArrayList list1=new ArrayList();
    ArrayList list2=new ArrayList();
    
    JLabel linsert, l5;
    JTextField t1;
    JButton binsert1, binsert2, bdisplay;
    JComboBox c1;
    
    guiArray()
    {
        setVisible(true);
        setSize(1000, 500);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        
        linsert = new JLabel("Enter Data");
        l5 = new JLabel("");
        t1 = new JTextField(15);
        binsert1 = new JButton("Insert in List1");
        binsert2 = new JButton("Insert in List2");
        bdisplay=new JButton("Display");
        
        add(linsert); add(t1); add(binsert1);add(binsert2);
        add(bdisplay); add (l5);
        
        binsert1.addActionListener(this);
        binsert2.addActionListener(this);
        bdisplay.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== binsert1)
        {
            list1.add(t1.getText());
            l5.setText("inserted");
        }
        else if (e.getSource()== binsert1)
        {
            list2.add(t1.getText());
            l5.setText("inserted");
        }
        else if (e.getSource()==bdisplay)
        {
            c1.addItem(list1);
            
        }
    }
    
}
