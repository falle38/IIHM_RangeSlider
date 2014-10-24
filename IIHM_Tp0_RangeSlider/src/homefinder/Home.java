package homefinder;

public class Home {
	
	int cordX;
	int cordY;
	int nbpieces; 
	int valeurbien;
	
	public Home(int cordX, int cordY, int nbpieces, int valeurbien) {
		super();
		this.cordX = cordX;
		this.cordY = cordY;
		this.nbpieces = nbpieces;
		this.valeurbien = valeurbien;
	}
	
	public int getCordX() {
		return cordX;
	}
	
	public int getCordY() {
		return cordY;
	}
	
	public int getNbpieces() {
		return nbpieces;
	}
	
	public int getValeurbien() {
		return valeurbien;
	}
	
	
}
