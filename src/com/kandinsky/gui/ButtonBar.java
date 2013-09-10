package com.kandinsky.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.kandinsky.objects.FunctionsHelper;
import com.kandinsky.objects.SideFunctionsHelper;

/**
 * PUNKT 3 - ButtonBar. Zeigt eine Liste mit Buttons. Hier ist zu ueberlegen, ob
 * die Buttons fuer beide Seiten angezeigt werden sollen, oder nur fuer eine
 * Seite.
 * 
 * @author Marc L., Mamoudou B.
 */

public class ButtonBar extends JPanel implements ActionListener {

	private static final long serialVersionUID = -7230543120102084314L;

	private static final String TODO = "Needs to be implemented";

	private static final Insets margins = new Insets(0, 0, 0, 0);
	
	private String actualPath;
	private static ArrayList<String> pathList; 
	private String nowTempPath;
	private int len = -1;
	
	
	private JToolBar buttonBar;
	private JButton neuesFenster;
	private JToggleButton zurueck;
	private JToggleButton weiter;
	private JButton hoch;
	private JButton home;
	private JButton aktualisieren;
	private JButton vertauschen;
	private JButton favoritenAnlegen;
	private JButton favoritenAnzeigen;
	private JButton benutzer;
	private JButton ftpVerwalten;
	private JButton ftpAnzeigen;
	private JButton shellOeffnen;
	private JButton hilfe;
	private JButton einstellungen;

	/**
	 * der Funktionshelfer, ueber den verschiedene Funktionen aufgerufen werden
	 * koennen
	 */
	private SideFunctionsHelper sideFunctionsHelper;
	// private FunctionsHelper functionsHelper; Das ding hat nur statische Funktionen!

	public ButtonBar(SideFunctionsHelper sideFunctionsHelper) {
		this.sideFunctionsHelper = sideFunctionsHelper;
		
		
		// buttonBar = new JToolBar("Button Bar",0);
		buttonBar = new JToolBar();
		this.add(buttonBar, BorderLayout.NORTH);
		// buttonBar.setPreferredSize(new Dimension(200,100));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		buttonBar.setBackground(Color.WHITE);
		buttonBar.setOrientation(SwingConstants.HORIZONTAL);
		buttonBar.setFloatable(true);
		buttonBar.setBorderPainted(false);
		buttonBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonBar.setBorderPainted(true);
		buttonBar.setRollover(true);
		// buttonBar.addSeparator(new Dimension(0,0));
		// buttonBar.setMargin(margins);
		// buttonBar.setAlignmentX(0);

		// Icon Quellen fuer die Buttons, am besten png

		Icon a = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/window-icon.png"));
		Icon b = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/zurueck-icon.png"));
		Icon c = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/weiter-icon.png"));
		Icon d = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/hoch-icon.png"));
		Icon e = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/home-6-icon.png"));
		Icon f = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/refresh-icon.png"));
		Icon g = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/shuffle-icon.png"));
		Icon h = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/favorite-anlegen-icon.png"));
		Icon i = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/favorite-icon.png"));
		Icon j = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/user-icon.png"));
		Icon k = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/network-icon.png"));
		Icon l = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/ftp-connection-icon.png"));
		Icon m = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/shell-icon.png"));
		Icon n = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/help-icon.png"));
		Icon o = new ImageIcon(getClass().getResource(
				"/com/kandinsky/resources/options-icon.png"));

		// Buttons erstellen mit Icons
		neuesFenster = new JButton(a);
		// neuesFenster.setHorizontalTextPosition(JButton.CENTER);
		// neuesFenster.setVerticalTextPosition(JButton.CENTER);
		zurueck = new JToggleButton(b);
		weiter = new JToggleButton(c);
		hoch = new JButton(d);
		home = new JButton(e);
		aktualisieren = new JButton(f);
		vertauschen = new JButton(g);
		favoritenAnlegen = new JButton(h);
		favoritenAnzeigen = new JButton(i);
		benutzer = new JButton(j);
		ftpVerwalten = new JButton(k);
		ftpAnzeigen = new JButton(l);
		shellOeffnen = new JButton(m);
		hilfe = new JButton(n);
		einstellungen = new JButton(o);

		// Groesse der Buttons anpassen
		neuesFenster.setMargin(margins);
		zurueck.setMargin(margins);
		weiter.setMargin(margins);
		hoch.setMargin(margins);
		home.setMargin(margins);
		aktualisieren.setMargin(margins);
		vertauschen.setMargin(margins);
		favoritenAnlegen.setMargin(margins);
		favoritenAnzeigen.setMargin(margins);
		benutzer.setMargin(margins);
		ftpVerwalten.setMargin(margins);
		ftpAnzeigen.setMargin(margins);
		shellOeffnen.setMargin(margins);
		hilfe.setMargin(margins);
		einstellungen.setMargin(margins);

		// ToolTips fuer die Buttons
		neuesFenster.setBackground(Color.WHITE);
		// neuesFenster.setFont(new Font("Arial", Font.PLAIN, 12));
		neuesFenster.setToolTipText("�ffnet eine neues Hauptfenster");
		zurueck.setBackground(Color.WHITE);
		zurueck.setToolTipText("Zum Ordner zur�ck navigieren");
		weiter.setBackground(Color.WHITE);
		weiter.setToolTipText("Zum Ordner vorw�rts navigieren");
		weiter.setEnabled(false);
		hoch.setBackground(Color.WHITE);
		hoch.setToolTipText("Zum �bergeordneten Ordner wechseln");

		home.setBackground(Color.WHITE);
		// home.setFont(new Font("Arial", Font.PLAIN, 12));
		home.setToolTipText("Zum Home Ordner wechseln");
		aktualisieren.setBackground(Color.WHITE);
		aktualisieren.setToolTipText("Fenster aktualisieren");
		vertauschen.setBackground(Color.WHITE);
		vertauschen.setToolTipText("Split-Fenster vertauschen");
		favoritenAnlegen.setBackground(Color.WHITE);
		favoritenAnlegen.setToolTipText("Neue Favoriten anlegen");
		favoritenAnzeigen.setBackground(Color.WHITE);
		favoritenAnzeigen.setToolTipText("Favoriten anzeigen");
		benutzer.setBackground(Color.WHITE);
		benutzer.setToolTipText("Benutzer");
		ftpVerwalten.setBackground(Color.WHITE);
		ftpVerwalten.setToolTipText("Neuen FTP Server anlegen");
		ftpAnzeigen.setBackground(Color.WHITE);
		ftpAnzeigen.setToolTipText("FTP Verbindungen anzeigen");
		shellOeffnen.setBackground(Color.WHITE);
		shellOeffnen.setToolTipText("Shell im aktuellen Ordner �ffnen");
		hilfe.setBackground(Color.WHITE);
		hilfe.setToolTipText("Hilfe und Infos");
		einstellungen.setBackground(Color.WHITE);
		einstellungen.setToolTipText("Einstellungen �ffnen");

		// Buttons der buttonBar Anlegen
		// buttonBar.add(neuesFenster);
		buttonBar.add(zurueck);
		buttonBar.add(weiter);
		buttonBar.add(hoch);
		// add(btnRename, "3, 6, fill, center");
		buttonBar.add(home);
		buttonBar.add(aktualisieren);
		buttonBar.add(vertauschen);
		buttonBar.add(favoritenAnlegen);
		buttonBar.add(favoritenAnzeigen);
		// buttonBar.add(benutzer);
		buttonBar.add(ftpVerwalten);
		// buttonBar.add(ftpAnzeigen);
		buttonBar.add(shellOeffnen);
		buttonBar.add(hilfe);
		buttonBar.add(einstellungen);

		// ActionListener fuer die einzelnen Buttons
		neuesFenster.addActionListener(getNeuesFenster());
		zurueck.addActionListener(this);
		weiter.addActionListener(this);		
		hoch.addActionListener(this);
		home.addActionListener(this);
		aktualisieren.addActionListener(this);
		vertauschen.addActionListener(this);
		favoritenAnlegen.addActionListener(this);
		favoritenAnzeigen.addActionListener(this);
		benutzer.addActionListener(this);
		ftpVerwalten.addActionListener(this);
		ftpAnzeigen.addActionListener(this);
		shellOeffnen.addActionListener(this);
		hilfe.addActionListener(this);
		einstellungen.addActionListener(this);
		
		
		
		
		//************************************************************************************************
		
		
		pathList = new ArrayList<String>();
		actualPath = sideFunctionsHelper.getFolder();
		addFolder(actualPath);
		
		
		
		

	}

	private ActionListener getNeuesFenster() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, TODO, "Neues Fenster",
						JOptionPane.OK_OPTION);

			}
		};
	}

	// public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {

		Object quelle = ae.getSource();

		if (quelle == neuesFenster) {
			buttonBar.add(new JButton("GEKLICKT!"));

		}

		/**
		 * if (quelle == neuesFenster) { }
		 */

		if (quelle == zurueck) {
			//folderList.setSelectedIndex(folderList.getSelectedIndex()-1);			
			nowTempPath = getPreviousListElement(getLastListElement(actualPath));
			sideFunctionsHelper.switchFolder(nowTempPath);		
			weiter.setEnabled(true);
			//sideFunctionsHelper.getFolder();				
		}

		if (quelle == weiter) {			
			sideFunctionsHelper.switchFolder(ButtonBar.getNextListElement(getActualElement(sideFunctionsHelper)));				
			String path = getActualElement(sideFunctionsHelper);			
			//String lastElement = pathList.get(pathList.size()-1);	
			
			for (String element : pathList) {				
				if (element != null) {
		            len = Math.max(len, element.length());
				}
		            if (path.length() == len){
		            	weiter.setEnabled(false);
		            }
		            	
		            else {
					weiter.setEnabled(true);
		            }			
			}
		}
		
		

		if (quelle == hoch) {
			String papapapaap = (String)sideFunctionsHelper.getFolder();
			System.out.println(papapapaap);
			for (String element : pathList)
				if (papapapaap.length() == element.length() ) {
					System.out.println(true);
				}
					else {
						System.out.println(false);					
					}
		}
				
		

		if (quelle == home) {
			sideFunctionsHelper.switchFolder(System.getProperty("user.home"));			
		}

		if (quelle == aktualisieren) {
			sideFunctionsHelper.refresh();
		}

		if (quelle == favoritenAnlegen) {
		}

		if (quelle == favoritenAnzeigen) {
		}

		if (quelle == benutzer) {
		}

		if (quelle == ftpVerwalten) {
			FunctionsHelper.showOptions(1);

		}

		if (quelle == ftpAnzeigen) {
		}

		if (quelle == shellOeffnen) {
		}

		if (quelle == hilfe) {
			FunctionsHelper.showAbout();
		}

		if (quelle == einstellungen) {
		}		
				
	}
	
	
	//*****************************************************************************************************************
			//Funktionen für die ButtonNavigation , erstmal noch nicht in eigener Klasse
	

	public static void addFolder(String folderName) {	
//		if (pathList.contains(folderName))
//		{			
//		}
//		else {
			pathList.add(folderName);
				for (String element : pathList) {
					System.out.println(element);
			}		
		}
//	}
	
	public static String getActualElement(SideFunctionsHelper sideFunctionsHelper) {
		
		String actualPath = sideFunctionsHelper.getFolder();
		if (pathList.indexOf(actualPath) == pathList.size() -1) {
			return null;
		}
		return actualPath;
	}
	
	public static String getPreviousListElement(String actualPath) {
		if (pathList.contains(actualPath)) {
			int index = pathList.indexOf(actualPath);
			String previousElement = pathList.get(index -1);
			//System.out.println(previousElement);			
			return previousElement;			
		}
		return null ;
	}
	
	public static String getLastListElement(String actualPath) {
		if (!pathList.isEmpty()) {
			  String lastElement = pathList.get(pathList.size()-1);				  
			  return lastElement;			 
			}
		return null;			
	}
	
	public static String getNextListElement(String actualPath) {
		if (pathList.contains(actualPath)) {
			int index = pathList.indexOf(actualPath);
			if (index == (pathList.size() -1)) {
				return null;
			}
			else {
				String nextElement = pathList.get(index +1);				
				return nextElement;		
			}
		}
		return null;				
	}

	

}

