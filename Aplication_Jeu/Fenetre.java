package com.Aplication_Jeu;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class Fenetre {
	public int i=0;
	private String hostname ="";
	private JPanel panTab = new JPanel();
	private JPanel haut =new JPanel();
	private JPanel bas = new JPanel();
	private JPanel hautWest =new JPanel();
	private JTextField tempo = new JTextField();
	private JLabel tempolabel = new JLabel("Tempo : ");
	private JTextField host = new JTextField();
	private JLabel hostlabel = new JLabel("hostname : ");
	private JTextField artiste = new JTextField();
	private JLabel artisteLabel = new JLabel("Artiste : ");
	private JTextField createur = new JTextField();
	private JLabel createurLabel = new JLabel("Createur : ");
	private JTextField Nom = new JTextField();
	private JLabel nomLabel = new JLabel("Nom : ");
	private JButton boutonRight= new JButton();
	private JButton boutonLeft= new JButton();
	private JButton boutonValider= new JButton("valider");
	private ColorTableModel model = new ColorTableModel(0);
    private JTable table = new JTable(model);
    private JFrame frame ;
    private JScrollPane scrollPane;
	
	public Fenetre(){
		frame = new JFrame("Editable Color Table");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new GridLayout(2,1));
	    frame.setSize(600,250);
	    frame.setMinimumSize(new Dimension(600,300));
	    bas.setLayout(new BorderLayout());
	    
	    // TableColumn column = table.getColumnModel().getColumn(3);
	    // column.setCellRenderer(renderer);
	    // column.setCellEditor(editor);
	    
	    haut.setLayout(new BorderLayout());
	    haut.add(hautWest, BorderLayout.WEST);
	    hautWest.setLayout(new GridLayout(5,2));

	    scrollPane = new JScrollPane(table);
	    panTab.add(scrollPane, BorderLayout.CENTER);
	    frame.add(haut);
	    frame.add(bas);
	    hautWest.add(nomLabel);
	    hautWest.add(Nom);
	    hautWest.add(tempolabel);
	    hautWest.add(tempo);
	    hautWest.add(artisteLabel);
	    hautWest.add(artiste);
	    hautWest.add(createurLabel);
	    hautWest.add(createur);
	    hautWest.add(hostlabel);
	    hautWest.add(host);
	    bas.add(boutonLeft, BorderLayout.WEST);
	    bas.add(boutonRight, BorderLayout.EAST);
	    bas.add(panTab, BorderLayout.CENTER);
	    bas.add(boutonValider, BorderLayout.SOUTH);
	    tempo.addFocusListener(new FocusAdapter() {
	        public void focusLost(FocusEvent e) {
	        	String tempoS=tempo.getText();
	        	try{
	        		if(tempoS.compareTo("")==0){
	        		
	        		}
	        		else{
	        			int tempoI=Integer.parseInt(tempoS);
	        		}
	        	}
	        	catch(NumberFormatException ne){
	        		JOptionPane.showMessageDialog(null, "Vous n'avez pas rentré un nombre dans le champ du tempo", "Probleme", JOptionPane.ERROR_MESSAGE);
		        	tempo.requestFocusInWindow();
	        	}
	        }
	    });
	    boutonRight.addActionListener(new BoutonRightListener());
	    boutonLeft.addActionListener(new BoutonLeftListener());
	    boutonValider.addActionListener(new BoutonValiderListener());
	    frame.setSize(400, 150);
	    frame.setVisible(true);
	 }

	private class BoutonRightListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	    	i++;
			System.out.println(i);
			model.nextPage();
	    }
	   
	  }
	private class BoutonLeftListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	    	i--;
	    	if(i<1)
	    		i=1;
			model.previousPage();
			//System.out.println(i);
			
	    	
			
	    }
	  }
	private class BoutonValiderListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			hostname=host.getText();
			String texte =Nom.getText()+"\r\n"+tempo.getText()+"\r\n"+artiste.getText()+"\r\n"+createur.getText()+"\r\n\r\n\r\n"+model.noteCellWriting();
			JFrame parentFrame = new JFrame();
			File fileToSave = new File("");
			 
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Specify a file to save");   
			 
			int userSelection = chooser.showSaveDialog(parentFrame);
			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				fileToSave= chooser.getSelectedFile();
			    FileWriter fw;
		        try {
		            fw = new FileWriter(fileToSave);
		            fw.write(texte);
		            fw.flush();
		            fw.close();
		        } catch (Exception e3) {
		            e3.printStackTrace();
		        }

			    
			}
			Thread thread = new Thread();
	        try {
	        	String test="cmd /c start cmd.exe";
	            Runtime.getRuntime().exec(test);
	            String command = "pscp -r -p "+fileToSave+" pi@"+hostname+":/var/www/html/osuStyle";
	            System.out.println(command);
	            Keyboard keyboard;
				try {
					//Fenetremdp fenmdp=new Fenetremdp();
					keyboard = new Keyboard();
					thread.sleep(1000);
		            keyboard.type(command);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	            
	            
	        } catch (IOException ex) {
	            Logger.getLogger(Keyboard.class.getName()).log(Level.SEVERE, null, ex);
	        }

		}
		
	}

}
