package PasDefaultPackage;

public class CFigurine extends Carte {

    private TypeFigurine typeFigurine;

    public CFigurine(int numID, String nomCarte, TypeFigurine typeFigurine) {
        super(numID, nomCarte);
        this.typeFigurine = typeFigurine;

        /* Objectif en cummuler 4 pour pourvoir obtenir un tresor
        Se donner que sur certaine case et coute un PA
        On peut gagner un trésor une case innondé
        5carte de chaque*/
    }
}
