import java.applet.*;  
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.Graphics;
import java.awt.Color;

public class Name extends JApplet implements ActionListener{  
	private JButton b;  
	private JTextField tf;  

	public void init(){  
  
		tf=new JTextField();  
		tf.setBounds(30,40,150,20);  
  
		b=new JButton("Click");  
		b.setBounds(80,150,70,40);  
  
		add(b);
		add(tf);
                paint(this.getGraphics());
		b.addActionListener(this);  
  
		setLayout(null);  
	}  
  
	public void actionPerformed(ActionEvent e){  
		tf.setText("Welcome, you did it!");  
	}
  
	public void paint ( Graphics gr )  {
		int radius = 25;
		gr.setColor( Color.white );
		gr.fillRect( 0, 0, 150, 150 );
		gr.setColor( Color.black );
		gr.drawOval( (150/2 - radius), (150/2 - radius), radius*2, radius*2 );
   	}
}  