package PasDefaultPackage;
    
    
public class CSpéciale extends Carte {
    private TypeSpeciale typeSpeciale;
    
    
    
    public CSpéciale(int numID, String nomCarte,TypeSpeciale typeSpeciale) {
        super(numID, nomCarte);
        this.typeSpeciale = typeSpeciale;
        
    }

    
    
    
 
    
}
// Ne coute pas de PA ! + si on doit s'en débarasser on peut l'utiliser.
// helico x3 --  et sacs de sable x2 

/* Helico = Deplacez un pion ou un groupe de pion d'une tuile vers n'importe qu'elle autre
 ou fairee décoller l'équipe si tout le monde est sur l'héliport (même si il est innondé)

sac de sable = assècher n'importe qu'elle tuile de  l'île
*/