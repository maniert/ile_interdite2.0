package PasDefaultPackage;

public class EchelleMontéeDesEaux {

    private int niveauEau;
    
    public EchelleMontéeDesEaux(int i) {
	niveauEau = i;        
    }
    


	public void monterEchelle() {
	}

	public int getNiveauEchelle() {
            return niveauEau;
            
	}
        public int getnbCarteInnondation(){
            if (niveauEau <=2){
                return 2;
            } else if (niveauEau <= 5){
                return 3;                
            } else if (niveauEau <= 7){
                return 4;
            } else if (niveauEau <= 9) {
                return 5;
            } else {
                return 111;
            }
        }

}