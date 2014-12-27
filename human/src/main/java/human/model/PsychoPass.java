package human.model;


public class PsychoPass {
	private int crimeCoefficient;
	private String color;
	
	public int getCrimeCoefficient() {
		return crimeCoefficient;
	}
	public void setCrimeCoefficient(int crimeCoefficient) {
		if(crimeCoefficient > 255 * 3){
			crimeCoefficient = 255 * 3;
		}
		this.crimeCoefficient = crimeCoefficient;
	}
	public String getColor() {
		int red = 255;
		int green  = 255;
		int blue = 255;
		if(crimeCoefficient < 255 + 1){
			blue = blue - crimeCoefficient;
		}else if(crimeCoefficient < 255 * 2 + 1){
			blue = 0;
			green = green - (crimeCoefficient - 255);
		}else{
			blue = 0;
			green = 0;
			red = red - (crimeCoefficient - 255 * 2);
		}
		
		return String.format("#$02d$02d$02d",Integer.toHexString(red),Integer.toHexString(green),Integer.toHexString(blue));
	}
}
