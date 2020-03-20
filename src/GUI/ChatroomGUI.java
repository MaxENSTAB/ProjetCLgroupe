package GUI;

//## class MontantBanqueGUI 
import javax.swing.JFrame;


//## class MontantBanqueGUI 
import java.util.Observer;
//## operation update(Observable,Object) 
import java.util.Observable;
//## link testField 
import javax.swing.JTextField;



//import sun.awt.geom.AreaOp.AddOp;


//## class MontantBanqueGUI 
public class ChatroomGUI extends JFrame implements Observer {
    
    private JTextField testField;		//## link testField 
    
    
    public  ChatroomGUI() {
        super();
        
        this.setTitle("CHATROOM");
        testField = new javax.swing.JTextField();
        this.add(testField);  

        
        
        
        testField.setBackground(new java.awt.Color(255,128,0));
        testField.setPreferredSize(new java.awt.Dimension(250, 108));
        testField.setFont(new java.awt.Font("Antique Olive",1,28));

        
        testField.setText( "Message des users" );
        
        
        this.pack();
        this.setVisible(true);
        testField.setEditable(false);
        getContentPane().setBackground(new java.awt.Color(255,128,64));
        getContentPane().setForeground(new java.awt.Color(255,128,0));
        
        //#]
    }
    public void setTestField(String s) { 
        testField.setFont(new java.awt.Font("Antique Olive",1,20));
    	testField.setText(s);
    }
    

    
    
}

