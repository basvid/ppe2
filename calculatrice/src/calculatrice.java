import javax.swing.*; 
import java.awt.GridLayout; //grile du panneau
import java.awt.BorderLayout; //bordure de la fenetre

public class calculatrice { 
  // D�clare et instancie les composants de la fen�tre 
  JButton bouton0 = new JButton("0"); 
  JButton bouton1 = new JButton("1"); 
  //JButton bouton2 = new JButton("2"); 
  JButton bouton3 = new JButton("3"); 
  JButton bouton4 = new JButton("4"); 
  JButton bouton5 = new JButton("5"); 
  JButton bouton6 = new JButton("6"); 
  JButton bouton7 = new JButton("7"); 
  JButton bouton8 = new JButton("8"); 
  JButton bouton9 = new JButton("9"); 
  JButton boutona = new JButton(""); //bouton qui ne sert pas (decoration)
  JButton boutonr = new JButton("effacer"); 
  JButton boutonVirgule = new JButton(","); 
  JButton boutonEgale = new JButton("="); 
  JButton boutonPlus = new JButton("+"); 
  JButton boutonMoins = new JButton("-");
  JButton boutonDiviser = new JButton("/"); 
  JButton boutonMultiplier = new JButton("*"); 
  JPanel contenuFen�tre = new JPanel(); 
  JTextField champAffichage = new JTextField(30); //text
   
    // Constructeur 
  calculatrice() { 
    // Affecte le gestionnaire de disposition pour ce panneau
	  BorderLayout disposition = new BorderLayout();  
	  contenuFen�tre.setLayout(disposition); 
     
    // Ajoute le champ d'affichage en haut de la fen�tre
    contenuFen�tre.add("North", champAffichage); 
                     
    // Cr�e le panneau avec le quadrillage qui contient
    // 13 boutons (les 10 boutons num�riques, la virgule, le signe �gale)

    JPanel panneauChiffres = new JPanel(); 
    GridLayout dispositionChiffres = new GridLayout(4, 4); //colonne et ligne
    panneauChiffres.setLayout(dispositionChiffres); 
     
    panneauChiffres.add(bouton1); //ajoute le bouton au panneau
    panneauChiffres.add(bouton2); 
    panneauChiffres.add(bouton3); 
    panneauChiffres.add(bouton4); 
    panneauChiffres.add(bouton5); 
    panneauChiffres.add(bouton6); 
    panneauChiffres.add(bouton7); 
    panneauChiffres.add(bouton8); 
    panneauChiffres.add(bouton9); 
    panneauChiffres.add(bouton0); 
    panneauChiffres.add(boutonVirgule); 
    panneauChiffres.add(boutonEgale); 
    
    // Ajoute le panneau des chiffres � la zone centrale de la fen�tre 
    contenuFen�tre.add("Center", panneauChiffres); 
     
    // Cr�e le panneau avec le quadrillage 
    // boutons d'op�ration (Plus, Moins, Diviser, Multiplier et effacer)
    JPanel panneauOp�rations = new JPanel(); 
    GridLayout dispositionOp�rations = new GridLayout(3, 2);  
    panneauOp�rations.setLayout(dispositionOp�rations);  
    panneauOp�rations.add(boutonPlus); 
    panneauOp�rations.add(boutonMoins); 
    panneauOp�rations.add(boutonMultiplier); 
    panneauOp�rations.add(boutonDiviser);
    panneauOp�rations.add(boutonr); 
    panneauOp�rations.add(boutona); //bouton qui ne sert pas
    // Ajoute le panneau des op�rations � la zone est  
    // de la fen�tre
    contenuFen�tre.add("East", panneauOp�rations); 
     
    // Cr�e le cadre et lui affecte son contenu 
    JFrame frame = new JFrame("ma premiere Calculatrice"); 
    frame.setContentPane(contenuFen�tre); 
   
    // Affecte � la fen�tre des dimensions suffisantes pour prendre en compte tous les contr�les 
    frame.pack();  
      
    // Affiche la fen�tre
    frame.setVisible(true); 
     
    // Instancie le r�cepteur d'�v�nements et l'enregistre aupr�s de chaque bouton 
    
   calculbouton calculbouton = new calculbouton (this); 
     
    bouton0.addActionListener(calculbouton); 
    bouton1.addActionListener(calculbouton); 
    bouton2.addActionListener(calculbouton); 
    bouton3.addActionListener(calculbouton); 
    bouton4.addActionListener(calculbouton); 
    bouton5.addActionListener(calculbouton); 
    bouton6.addActionListener(calculbouton); 
    bouton7.addActionListener(calculbouton); 
    bouton8.addActionListener(calculbouton); 
    bouton9.addActionListener(calculbouton); 
    boutonr.addActionListener(calculbouton); 
    boutonVirgule.addActionListener(calculbouton);  
    boutonPlus.addActionListener(calculbouton); 
    boutonMoins.addActionListener(calculbouton); 
    boutonDiviser.addActionListener(calculbouton); 
    boutonMultiplier.addActionListener(calculbouton); 
    boutonEgale.addActionListener(calculbouton); 
  } 
}
