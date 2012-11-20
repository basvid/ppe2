import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent; 
import java.text.NumberFormat; 
import java.text.ParsePosition; 
import javax.swing.JButton; 

public class calculbouton implements ActionListener 
{ 
  calculatrice parent; // appelle classe mere  Calculatrice
  char actionSélectionnée = ' ';  // +, -, /, effacer ou * pour faire les calculs
  double résultatCourant = 0;  //stock les valeurs renter
  // un objet capable de lire un nombre
  NumberFormat formatNombres = NumberFormat.getInstance();  
     
  // Le constructeur stocke la classe mere Calculatrice dans la variable parent
  calculbouton(calculatrice parent) 
  { 
    this.parent = parent; 
  } 
  
  public void actionPerformed(ActionEvent événement) 
  { 
    // Retrouve la source de l'action
    JButton boutonCliqué = (JButton) événement.getSource(); //evenement du bouton (si on a bien clique sur ce bouton et pas un autre)
    String texteChampAffichage = parent.champAffichage.getText(); 
    double valeurAffichée = 0; 
    // Retrouve le nombre dans le champ texte s'il n'est pas vide
    if (!"".equals(texteChampAffichage)) 
    { 
      valeurAffichée =  
        // analyse la chaîne de caractères
        formatNombres.parse(texteChampAffichage,  new ParsePosition(0)). 
          // puis donne sa valeur en tant que double
          doubleValue(); 
    } 
    
    Object sourceEvénement = événement.getSource(); 
    // Pour chaque bouton d'action, mémorise l'action 
    // sélectionnée, +, -, /, ou *, stocke la valeur courante 
    // dans la variable résultatCourant et vide le champ  
    // Affichage avant l'entrée du nombre suivant
    if (sourceEvénement == parent.boutonr) 
    { 
    	 parent.champAffichage.setText(""); //vide le jtextfield
    }   	
    
    else if (sourceEvénement == parent.boutonPlus) //si on clique sur le bouton plus
    { 
    	 actionSélectionnée = '+'; 
    	 résultatCourant = valeurAffichée; //stock valeur
    	 parent.champAffichage.setText(""); 
    }  
      else if (sourceEvénement == parent.boutonMoins) 
    	    { 
    	      actionSélectionnée = '-'; 
    	      résultatCourant = valeurAffichée; 
    	      parent.champAffichage.setText(""); 
    	    }  
    	    else if (sourceEvénement == parent.boutonDiviser) 
    	    { 
    	         actionSélectionnée = '/'; 
    	         résultatCourant = valeurAffichée;  
    	         parent.champAffichage.setText(""); 
    	    }  
    	          else if (sourceEvénement == parent.boutonMultiplier)
    	          { 
    	            actionSélectionnée = '*';  
    	            résultatCourant = valeurAffichée; 
    	            parent.champAffichage.setText(""); 
    	          }  
    	                else if (sourceEvénement == parent.boutonEgale)
    	                { 
    	                      // Effectue les calculs en fonction de actionSélectionnée
    	                     // Modifie la valeur de la variable résultatCourant 
    	                    // et affiche le résultat 
    	                    if (actionSélectionnée == '+') 
    	                     { 
    	                      résultatCourant += valeurAffichée; //fait le calcul + des 2 valeurs saisies
    	                      // Convertit le résultat en le transformant en String ou en double à l'aide de formatNombres 
    	                      parent.champAffichage.setText(formatNombres.format(résultatCourant)); 
    	                     }  
    	                    else if (actionSélectionnée == '-')
    	                        {  
    	                         résultatCourant -= valeurAffichée; //fait le calcul de - des 2 valeurs saisies
    	                         parent.champAffichage.setText(formatNombres.format(résultatCourant)); 
                             	 }  
    	                    else if (actionSélectionnée == '/')
    	                    { 
    	                         résultatCourant /= valeurAffichée;   //fait le calcul de / des 2 valeurs saisies
    	                         parent.champAffichage.setText(formatNombres.format(résultatCourant)); 
    	                   }  
    	                   else if (actionSélectionnée == '*') 
    	                   { 
    	                        résultatCourant *= valeurAffichée;   //fait le calcul de * des 2 valeurs saisies
    	                        parent.champAffichage.setText(formatNombres.format(résultatCourant)); 
    	                   } 
    	               }  
    
    	               else { 
    	                     // Pour tous les boutons numériques, affiche le libellé du bouton au champ texte 
    	            	    //click sur 2 boutons pour n'en former qu'un et l'afficher
    	                    String libelléBoutonCliqué = boutonCliqué.getText();// Retrouve le libellé du bouton 
                            parent.champAffichage.setText(texteChampAffichage + libelléBoutonCliqué); 
    	                    } 
   } 
}