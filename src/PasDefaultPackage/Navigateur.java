package PasDefaultPackage;

public class Navigateur extends Aventurier {

    public Navigateur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t) {
        super(nomJoueur, typeRole, idaventurier, t);
    }

    /**
     * @return the nbmaxPa
     */
    @Override
    public int getNbmaxPa() {
        return 4;
    }
}
