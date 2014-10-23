package homefinder;

public class Home {
	
	int cordX;
	int cordY;
	int nbpieces; 
	int valeurbien;
	
	public Home(int cordX, int cordY, int nbpièces, int valeurbien) {
		super();
		this.cordX = cordX;
		this.cordY = cordY;
		this.nbpieces = nbpièces;
		this.valeurbien = valeurbien;
	}
	
	public int getCordX() {
		return cordX;
	}
	public void setCordX(int cordX) {
		this.cordX = cordX;
	}
	public int getCordY() {
		return cordY;
	}
	public void setCordY(int cordY) {
		this.cordY = cordY;
	}
	public int getNbpieces() {
		return nbpieces;
	}
	public void setNbpieces(int nbpieces) {
		this.nbpieces = nbpieces;
	}
	public int getValeurbien() {
		return valeurbien;
	}
	public void setValeurbien(int valeurbien) {
		this.valeurbien = valeurbien;
	}
	
	
}
