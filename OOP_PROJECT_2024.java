package com.mycompany.oop_project_2024;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class OOP_PROJECT_2024 extends JFrame implements ActionListener{
JPanel panel1,panel2,panel3,panel4,panel5;
JLabel label1,label2,label3,label4,label5;
JTextField text1,text2,text3;
JButton button1,button2,button3;
JTable tabel1;
ImageIcon img;
DefaultTableModel model=new DefaultTableModel(new Object [][] {},new String []{"Name","Email","Phone"});
JScrollPane scroll1;
Font f1=new Font("Arial",1,30);
Font f2=new Font("Arial",1,40);
Font f3=new Font("Times new Roman",3,25);
Font f4=new Font("Arial",1,15);
    public OOP_PROJECT_2024()
    {
        this.setTitle("project GUI");
        this.setSize(800, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        panel1=new JPanel(new BorderLayout(10, 10));
        panel2=new JPanel(new GridLayout(2, 1));
        panel3=new JPanel(new GridLayout(2, 3));
        panel4=new JPanel(new GridLayout(3, 1));
        panel5=new JPanel();
        label1=new JLabel("My contact");
        label2=new JLabel("Name");
        label3=new JLabel("Email");
        label4=new JLabel("Phone");
        label2.setFont(f1);
        label3.setFont(f1);
        label4.setFont(f1);
        label1.setFont(f2);
        text1=new JTextField(10);
        text2=new JTextField(10);
        text3=new JTextField(10);
        text1.setFont(f4);
        text2.setFont(f4);
        text3.setFont(f4);
        button1=new JButton("Add");
        button2=new JButton("Clear");
        button3=new JButton("Delete");
        button1.setFont(f3);
        button2.setFont(f3);
        button3.setFont(f3);
        tabel1=new JTable();
        tabel1.setModel(model);
        scroll1=new JScrollPane();
        scroll1.setViewportView(tabel1);
        img =new ImageIcon("amr.jpg");
        label5=new JLabel(img);
        tabel1.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(0).setResizable(false);
        tabel1.getColumnModel().getColumn(1).setResizable(false);
        tabel1.getColumnModel().getColumn(2).setResizable(false);
        panel2.add(label5);
        panel2.add(label1);
        panel3.add(label2);
        panel3.add(label3);
        panel3.add(label4);
        panel3.add(text1);
        panel3.add(text2);
        panel3.add(text3);
        panel4.add(button1);
        panel4.add(button2);
        panel4.add(button3);
        panel1.add(panel2,BorderLayout.WEST);
        panel1.add(panel3,BorderLayout.CENTER);
        panel1.add(panel4,BorderLayout.EAST);
        panel5.add(scroll1);
         panel1.setBackground(Color.gray);
        panel2.setBackground(Color.gray);
        panel3.setBackground(Color.gray);
        panel4.setBackground(Color.gray);
        panel5.setBackground(Color.gray);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
          this.add(panel1);
          this.add(panel5);
       this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        OOP_PROJECT_2024 project=new OOP_PROJECT_2024();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
             try{
          if(text1.getText().length()>0 && text2.getText().length()>0  && text3.getText().length()>0 )
              {
                  String s1=text1.getText();
                  String s2=text2.getText();
                  String s3=text3.getText();
                  if(!(s2.contains("@")))
                      throw new Exception("invalid Email");
                  if(!(s3.startsWith("010")||s3.startsWith("011")||s3.startsWith("012")||s3.startsWith("015")))
                      throw new Exception("invalid phone number");
                  if(!(s3.length()==11))
                      throw new Exception("length of phone number is invalid");
          model.addRow(new Object[]{s1,s2,s3});
      text1.setText(null);
      text2.setText(null);
      text3.setText(null);
          }
          else
                throw new Exception("please enter data");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex.toString());
      }
        }
        if(e.getSource()==button2)
        {
             text1.setText(null);
             text2.setText(null);
             text3.setText(null);
        }
        if(e.getSource()==button3)
        {
           try{
      int rownumber=tabel1.getSelectedRow();
         model.removeRow(rownumber);
      }catch(Exception ex)
      {
           JOptionPane.showMessageDialog(null, "please select row ");
      }
        }
    }  
}
