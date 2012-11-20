import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent; 
import java.text.NumberFormat; 
import java.text.ParsePosition; 
import javax.swing.JButton; 

public class calculbouton implements ActionListener 
{ 
  calculatrice parent; // appelle classe mere  Calculatrice
  char actionS�lectionn�e = ' ';  // +, -, /, effacer ou * pour faire les calculs
  double r�sultatCourant = 0;  //stock les valeurs renter
  // un objet capable de lire un nombre
  NumberFormat formatNombres = NumberFormat.getInstance();  
     
  // Le constructeur stocke la classe mere Calculatrice dans la variable parent
  calculbouton(calculatrice parent) 
  { 
    this.parent = parent; 
  } 
  
  public void actionPerformed(ActionEvent �v�nement) 
  { 
    // Retrouve la source de l'action
    JButton boutonCliqu� = (JButton) �v�nement.getSource(); //evenement du bouton (si on a bien clique sur ce bouton et pas un autre)
    String texteChampAffichage = parent.champAffichage.getText(); 
    double valeurAffich�e = 0; 
    // Retrouve le nombre dans le champ texte s'il n'est pas vide
    if (!"".equals(texteChampAffichage)) 
    { 
      valeurAffich�e =  
        // analyse la cha�ne de caract�res
        formatNombres.parse(texteChampAffichage,  new ParsePosition(0)). 
          // puis donne sa valeur en tant que double
          doubleValue(); 
    } 
    
    Object sourceEv�nement = �v�nement.getSource(); 
    // Pour chaque bouton d'action, m�morise l'action 
    // s�lectionn�e, +, -, /, ou *, stocke la valeur courante 
    // dans la variable r�sultatCourant et vide le champ  
    // Affichage avant l'entr�e du nombre suivant
    if (sourceEv�nement == parent.boutonr) 
    { 
    	 parent.champAffichage.setText(""); //vide le jtextfield
    }   	
    
    else if (sourceEv�nement == parent.boutonPlus) //si on clique sur le bouton plus
    { 
    	 actionS�lectionn�e = '+'; 
    	 r�sultatCourant = valeurAffich�e; //stock valeur
    	 parent.champAffichage.setText(""); 
    }  
      else if (sourceEv�nement == parent.boutonMoins) 
    	    { 
    	      actionS�lectionn�e = '-'; 
    	      r�sultatCourant = valeurAffich�e; 
    	      parent.champAffichage.setText(""); 
    	    }  
    	    else if (sourceEv�nement == parent.boutonDiviser) 
    	    { 
    	         actionS�lectionn�e = '/'; 
    	         r�sultatCourant = valeurAffich�e;  
    	         parent.champAffichage.setText(""); 
    	    }  
    	          else if (sourceEv�nement == parent.boutonMultiplier)
    	          { 
    	            actionS�lectionn�e = '*';  
    	            r�sultatCourant = valeurAffich�e; 
    	            parent.champAffichage.setText(""); 
    	          }  
    	                else if (sourceEv�nement == parent.boutonEgale)
    	                { 
    	                      // Effectue les calculs en fonction de actionS�lectionn�e
    	                     // Modifie la valeur de la variable r�sultatCourant 
    	                    // et affiche le r�sultat 
    	                    if (actionS�lectionn�e == '+') 
    	                     { 
    	                      r�sultatCourant += valeurAffich�e; //fait le calcul + des 2 valeurs saisies
    	                      // Convertit le r�sultat en le transformant en String ou en double � l'aide de formatNombres 
    	                      parent.champAffichage.setText(formatNombres.format(r�sultatCourant)); 
    	                     }  
    	                    else if (actionS�lectionn�e == '-')
    	                        {  
    	                         r�sultatCourant -= valeurAffich�e; //fait le calcul de - des 2 valeurs saisies
    	                         parent.champAffichage.setText(formatNombres.format(r�sultatCourant)); 
                             	 }  
    	                    else if (actionS�lectionn�e == '/')
    	                    { 
    	                         r�sultatCourant /= valeurAffich�e;   //fait le calcul de / des 2 valeurs saisies
    	                         parent.champAffichage.setText(formatNombres.format(r�sultatCourant)); 
    	                   }  
    	                   else if (actionS�lectionn�e == '*') 
    	                   { 
    	                        r�sultatCourant *= valeurAffich�e;   //fait le calcul de * des 2 valeurs saisies
    	                        parent.champAffichage.setText(formatNombres.format(r�sultatCourant)); 
    	                   } 
    	               }  
    
    	               else { 
    	                     // Pour tous les boutons num�riques, affiche le libell� du bouton au champ texte 
    	            	    //click sur 2 boutons pour n'en former qu'un et l'afficher
    	                    String libell�BoutonCliqu� = boutonCliqu�.getText();// Retrouve le libell� du bouton 
                            parent.champAffichage.setText(texteChampAffichage + libell�BoutonCliqu�); 
    	                    } 
   } 
}