package PasDefaultPackage;

public class CInnondation extends Carte {

    private Tuile tuile;
    private String nomCarte;

    public CInnondation(int numID, String nomCarte, Tuile t) {
        super(numID, TypeCarte.innondation);
        this.nomCarte = nomCarte;
        this.tuile = t;
    }

}
