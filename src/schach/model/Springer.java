package schach.model;

public class Springer extends Figuren{

	public Springer(){
		super();
	}
	
	public Springer(boolean b){
		super(b);
	}
	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/spring_weiss";
		else
			return "/schach/gui/figures/spring_sw";
	}

	@Override
	protected boolean calcmove(int xstart, int ystart, int xend, int yend,
			Figuren[][] field) {
		if(((Math.abs(xstart-xend))<=2)&&((Math.abs(ystart-yend))<=2)&&(((Math.abs(xstart-xend))+(Math.abs(ystart-yend)))==3)){
			if((field[xend][yend]!= null)){
				if((field[xend][yend].isWeiss() != field[xstart][ystart].isWeiss()))
					return true;
				else
					return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Springer";
	}
}
