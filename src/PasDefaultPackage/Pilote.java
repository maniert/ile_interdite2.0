package PasDefaultPackage;

public class Pilote extends Aventurier {

    private boolean helicoDispo;
    private boolean deplSpePilote;

    public Pilote(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t) {
        super(nomJoueur, typeRole, idaventurier, t);
        this.helicoDispo = true;
        this.deplSpePilote = true;
    }

    @Override
    public void setTuileAtteignable(Grille g) {
        int i = 0;
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        if (isHelicoDispo()) {
            while (i != 36) {       // tant que l'on a pas parcouru tout
                getTuileAtteignable().add(g.getTuiles().get(i)); // que l'on est pas à la tuile de l'aventurie
                i++;
            }                                                      // on ajout aux tuiles atteingables
        } else {
            casePossiblebasique(g, this.getTuileAtteignable()); //rentre les déplacements propre à tout les roles
        }
        filtrageDeplacementpossible(getTuileAtteignable(), g); //filtrage null+innondé+immergé+case du joueur
    }

    /**
     * @return the helicoDispo
     */
    @Override
    public boolean isHelicoDispo() {
        return helicoDispo;
    }

    /**
     * @param helicoDispo the helicoDispo to set
     */
    @Override
    public void setHelicoDispo(boolean helicoDispo) {
        this.helicoDispo = helicoDispo;
    }

    /**
     * @return the deplSpePilote
     */
    @Override
    public boolean isDeplSpePilote() {
        return deplSpePilote;
    }

    /**
     * @param deplSpePilote the deplSpePilote to set
     */
    @Override
    public void setDeplSpePilote(boolean deplSpePilote) {
        this.deplSpePilote = deplSpePilote;
    }

}
