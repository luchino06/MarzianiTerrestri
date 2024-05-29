package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMarziVsTerr {
private JFrame f = new JFrame();
	
	private Container c = f.getContentPane();
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	
	private JButton b = new JButton("Attacca");
	
	private JLabel ter = new JLabel("Terrestre");
	private JLabel vit = new JLabel("Vita: ");
	private JLabel vel = new JLabel("Velocità: ");
	private JLabel arma = new JLabel("Armamento: ");
	private JLabel mar = new JLabel("Marziano");
	private JLabel auto = new JLabel("Autonomia: ");
	private JLabel ai = new JLabel("AI: ");
	private JLabel tec = new JLabel("Tecnologia: ");
	
	private JTextField nome = new JTextField(20);
	private JTextField vita = new JTextField("30");
	private JTextField velo = new JTextField("7");
	private JTextField armam = new JTextField("4");
	private JTextField mat = new JTextField(20);
	private JTextField aut = new JTextField("50");
	private JTextField intell = new JTextField("2");
	private JTextField tecno = new JTextField("4");
	private JTextField attacco = new JTextField(12);
	
	public MarzianiVsTerrestri(){
		
		attacco.setEditable(false);
		
		mat.setText("K-1292");
		
		p1.add(ter);
		p1.add(nome);
		
		p2.add(vit);
		p2.add(vita);
		p2.add(vel);
		p2.add(velo);
		p2.add(arma);
		p2.add(armam);
		
		p3.add(b);
		p3.add(attacco);
		
		p4.add(mar);
		p4.add(mat);
		
		p5.add(auto);
		p5.add(aut);
		p5.add(ai);
		p5.add(intell);
		p5.add(tec);
		p5.add(tecno);
		
		c.setLayout(new GridLayout(5,1));
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
				
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.pack();
		
		f.setVisible(true);
		f.setTitle("Terrestri_VS_Marziani");
		f.setLocation(400, 400);
		
		b.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		int vita1, autonomia, forzaTer, forzaAl, fortunaTer, fortunaAl;
		String nLetto1, nLetto2;
		
		Object oggetto = e.getSource();
		
		if(oggetto == b) {
			
			nome.setEditable(false);
			
			nLetto1 = armam.getText();
			nLetto2 = velo.getText();
			
			forzaTer = Integer.valueOf(nLetto1).intValue()*2 + Integer.valueOf(nLetto2).intValue();
			
			nLetto1 = tecno.getText();
			nLetto2 = intell.getText();
			
			forzaAl = Integer.valueOf(nLetto1).intValue()*2 + Integer.valueOf(nLetto2).intValue();
			
			fortunaTer = (int)(Math.random()*10+1);
			fortunaAl = (int)(Math.random()*10+1);
			
			if(fortunaTer > fortunaAl) {
				
				nLetto1 = aut.getText();
				
				autonomia = Integer.valueOf(nLetto1).intValue() - forzaTer;
				
				attacco.setText("Terrestre Attacca!");
				aut.setText("" +autonomia);
				
			}else {
				
				if(fortunaTer == fortunaAl) {
					
					attacco.setText("Pareggio!");
					
				}else {
					
					nLetto2 = vita.getText();
					
					vita1 = Integer.valueOf(nLetto2).intValue() - forzaAl;
					
					attacco.setText("Marziano Attacca!");
					vita.setText("" +vita1);
					
				}
				
			}
			
			if(Integer.valueOf(nLetto2).intValue() <= 0) {
				
				b.setText("Partita Terminata");
				attacco.setText("Terrestre sconfitto");
				b.setEnabled(false);
				
			}
			
			if(Integer.valueOf(nLetto1).intValue() <= 0) {
				
				b.setText("Partita Terminata");
				attacco.setText("Marziano sconfitto");
				b.setEnabled(false);
				
			}
			
		}
		
	}
	
}

