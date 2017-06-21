package PasDefaultPackage;

public class Carte {

    private int numID;
    private TypeCarte typeCarte;

    public Carte(int numID, TypeCarte typeCarte) {
        this.numID = numID;
        this.typeCarte = typeCarte;
    }

    /**
     * @return the typeCarte
     */
    public TypeCarte getTypeCarte() {
        return typeCarte;
    }

    /**
     *
     * @param t cartesTresorEnJeu.remove(0);//TODO ihm
     */
}
