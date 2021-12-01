package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class guiArray extends JFrame implements ActionListener{
    ArrayList<Integer> list1=new ArrayList<Integer>();
    ArrayList list2=new ArrayList();
    ArrayList list3=new ArrayList();
    
    JLabel linsert, l5;
    JTextField t1;
    JButton binsert1, binsert2, bdisplay, bshf , bfrq, bfil, bmax, bmin, bdl;
    JButton bdisplay1, bcpy1_2, bcpy2_1, bdisjoint;
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
        binsert1 = new JButton("Insert in RollNo");
        binsert2 = new JButton("Insert in Degree");
        bshf = new JButton("Shuffle");
        bfil =new JButton("Fill BSCS");
        bfrq = new JButton("Frequency");
        bmax = new JButton("Maximum Number");
        bmin = new JButton("Minimum");
        bcpy1_2 = new JButton("Move List1 to list2"); 
        bcpy2_1 = new JButton("Move List2 to List1");
        bdisjoint  = new JButton("disjoint");
        bdisplay=new JButton("Display List1");
        bdisplay1=new JButton("Display List2");
        bdl = new JButton("delete all ");
        c1 =new JComboBox();
        
        add(linsert); add(t1); add(binsert1);add(binsert2);
        add(bshf);add(bfrq);add(bfil);add(bmax);add(bmin);add(bcpy1_2);add(bdisjoint);
        add(bdisplay); add(bdisplay1); add (l5); add(c1); add(bdl);
        
        binsert1.addActionListener(this);
        binsert2.addActionListener(this);
        bdisplay.addActionListener(this);
        bdisplay1.addActionListener(this);
        bshf.addActionListener(this);
        bfrq.addActionListener(this);
        bmax.addActionListener(this);
        bmin.addActionListener(this);
        bcpy1_2.addActionListener(this);
        bcpy2_1.addActionListener(this);
        bdisjoint.addActionListener(this);
        bfil.addActionListener(this);
        bdl.addActionListener(this);
    }
    void display_list1()
    {
        c1.removeAllItems();
        Iterator itr = list1.iterator();
        while(itr.hasNext()){
            c1.addItem(itr.next());
        }
    }
    void display_list2()
    {
        c1.removeAllItems();
        Iterator itr = list2.iterator();
        while(itr.hasNext()){
            c1.addItem(itr.next());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== binsert1)
        {
            list1.add(Integer.parseInt(t1.getText()));
            l5.setText("inserted");
            t1.setText("");
        }
        else if (e.getSource()== binsert2)
        {
            list2.add(t1.getText());
            l5.setText("inserted");
            t1.setText("");
        }
        else if (e.getSource()==bshf)
        {
            Collections.shuffle(list1);
            display_list1();           
            l5.setText("Shuffled");
        }
        else if (e.getSource()==bfrq)
        {
            int  count = 0;
            count = Collections.frequency(list1, t1.getText());
            c1.addItem(count);
//            l5.setText(""+count);
        }
        else if (e.getSource()==bfil)
        {
            Collections.fill(list2, "BSCS");
            display_list2();
        }
        else if (e.getSource()==bmax)
        {
          c1.removeAllItems();
          c1.addItem( Collections.max(list1));
//            l5.setText(""+ Collections.max(list1));
        }
        else if (e.getSource()==bmin)
        {
          c1.removeAllItems();
            c1.addItem( Collections.min(list1));
        }
        else if (e.getSource()==bcpy1_2)
        {
            Collections.copy(list1, list2);
        }
        else if (e.getSource()==bdisjoint)
        {
            c1.removeAllItems();
            Boolean  ret=null;
            ret = Collections.disjoint(list1, list2);
//            l5.setText(""+ret);
            c1.addItem(ret);
        }
        else if (e.getSource()==bdisplay)
        {
            display_list1();
        }
        else if (e.getSource()==bdisplay1)
        {
            display_list2();
        }
        else if (e.getSource()==bdl);
        {
//            list1.clear();
        }
    }
}
