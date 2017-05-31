package PasDefaultPackage;

import static PasDefaultPackage.Etat.innondé;
import static PasDefaultPackage.Etat.immergé;
import static PasDefaultPackage.Etat.sec;
import java.util.ArrayList;


public class Plongeur extends Aventurier{

    public Plongeur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }

    
    public void setTuileAtteignable(Grille g) {
        ArrayList<Tuile> tuilessouslocean = null;
        getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
        deplacementPossiblebasique(g); //rentre les déplacements propre à tout les role
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i).getEtat() == innondé || this.getTuileAtteignable(g).get(i).getEtat() == immergé){
                 this.getTuileAtteignable(g).add(this.getTuileAtteignable(g).get(i));  
            } else{
            i++;
            }
        }
        rechercheEau(tuilessouslocean, g);
        
        
        
    
        filtrageDeplacementPlongeur(getTuileAtteignable(g),g); //filtrage null+innondé,immergé 
        }
 
  
  
  
 
    public void filtrageDeplacementPlongeur(ArrayList<Tuile> tuileAtteignable, Grille g){
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i) == null){
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i)); 
            } else{
                i++;
            }
        }
    }
    
    public void rechercheEau(ArrayList<Tuile> tuilessouslocean, Grille g){
        
    }
 }
    
