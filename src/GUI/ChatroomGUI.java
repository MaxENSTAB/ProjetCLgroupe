package GUI;

import javax.swing.JButton;
//## class MontantBanqueGUI 
import javax.swing.JFrame;
import javax.swing.JTextArea;

//## class MontantBanqueGUI 
import java.util.Observer;
import java.awt.Color;
//## operation update(Observable,Object) 
import java.util.Observable;
//## link testField 
import javax.swing.JTextField;



//import sun.awt.geom.AreaOp.AddOp;


//## class MontantBanqueGUI 
public class ChatroomGUI extends JFrame implements Observer {
    
    private JTextArea txtOutput;
    private JButton btnSend;
    
    public  ChatroomGUI() {
        super();            //Utilise le constructeur de la classe mère
        
        this.setTitle("CHATROOM");
        txtOutput = new JTextArea();
        
        this.add(txtOutput);  
        this.txtOutput.setBackground(new Color(220,220,220));
        this.txtOutput.setEditable(false);
        this.setSize(1000,400);
        this.setVisible(true);
        
  
        
        this.txtOutput.setText( "Bienvenue sur le chat \n" );
        
        this.setAlwaysOnTop(true);

        this.setVisible(true);
        txtOutput.setEditable(false);
        getContentPane().setBackground(new java.awt.Color(255,128,64));
        getContentPane().setForeground(new java.awt.Color(255,128,0));
        
   
    }

    public void ajouterMessage(String text){ //correspond à 'update' du pattern Observable/Observer

        this.txtOutput.append(text+"\n");

    }
	public void update(Observable obs, Object o) {
		// Auto-generated method stub
	}
    

    
    
}

