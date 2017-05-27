package PasDefaultPackage;

public class Tuile {

        private int idTuile;
	private String nomTuile;
	private int x;
	private int y;

    public Tuile(int idTuile, String nomTuile, int x, int y) {
        this.idTuile = idTuile;
        this.nomTuile = nomTuile;
        this.x = x;
        this.y = y;
    }

    
        
        
	public void getEtat() {
		// TODO - implement Tuile.getEtat
		throw new UnsupportedOperationException();
	}

    /**
     * @return the nomTuile
     */
    public String getNomTuile() {
        return nomTuile;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
      public int getX(int idTuile) {
        return x;
    }

    
    public int getY() {
        return y;
    }
    
    /**
     * @param idTuile
     * @return the y
     */
    public int getY(int idTuile) {
        return y;
    }

    
    
    
        /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}