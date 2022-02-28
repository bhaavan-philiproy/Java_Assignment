import javax.swing.*;  
import java.awt.event.*; 
import java.sql.*;


class gui implements ActionListener{  

    JTextField tf1,tf2,tf3,tf4;  
    JButton b1;  

    gui(){  
        JFrame f= new JFrame("STUDENT DETAILS"); 

        JLabel label0 = new JLabel("DETAILS");
        label0.setVerticalAlignment(JLabel.TOP);

        JLabel label1 = new JLabel("Enter Student Adm Number(eg:101) :");
        label1.setBounds(40,150,400,40);

        tf1=new JTextField();  
        tf1.setBounds(250,150,300,40); 
        
        b1=new JButton("SEARCH.");  
        b1.setBounds(570,160,100,25); 
        b1.addActionListener(this);

        tf2=new JTextField();  
        tf2.setBounds(250,300,300,40);  
        tf2.setEditable(false);   

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(50,300,400,40);

        tf3=new JTextField();  
        tf3.setBounds(250,400,300,40);  
        tf3.setEditable(false); 

        JLabel label3 = new JLabel("Age :");
        label3.setBounds(50,400,400,40);

        tf4=new JTextField();  
        tf4.setBounds(250,500,300,40);  
        tf4.setEditable(false); 

        JLabel label4 = new JLabel("Address :");
        label4.setBounds(50,500,400,40);

       

        f.add(label0);f.add(label1);f.add(tf1);f.add(label2);f.add(tf2);f.add(label3);f.add(tf3);f.add(label4);f.add(tf4);f.add(b1);

        f.setSize(800,800);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {

        String s1=tf1.getText();  
        int a=Integer.parseInt(s1); 
         
     
        if(e.getSource()==b1){  
            
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");

                PreparedStatement stmt=con.prepareStatement("select * from details where adm_no=?");

                stmt.setInt(1,a);
                ResultSet rs=stmt.executeQuery();
    
                while(rs.next()) {
    
                    String name = rs.getString(2);
                    int age = rs.getInt(3);
                    String address = rs.getString(4);
                    String ages=String.valueOf(age);  
                    tf2.setText(name); 
                    tf3.setText(ages);
                    tf4.setText(address);
                }
            con.close();
            }
            catch (Exception k){System.out.println(k);} 
        } 
         
    }  
}

class assignment_2 {
    public static void main(String[] args) { 
        new gui();  
    }
}
