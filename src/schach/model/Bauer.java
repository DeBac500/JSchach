package schach.model;

public class Bauer extends Figuren{

	public Bauer(){
		super();
	}
	public Bauer(boolean weiss){
		super(weiss);
	}
	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/bauer_weiss";
		else
			return "/schach/gui/figures/bauer_sw";
	}
	@Override
	protected boolean calcmove(int xstart, int ystart, int xend, int yend,
			Figuren[][] field) {
		if((field[xend][yend] != null)&&((ystart==yend)))
			return false;
		if((xstart == xend+1) && (ystart == yend))
			return true;
		if(((xstart == xend+2) && (ystart == yend)) && (xstart == 6)){
			
			return true;	
		}
		if((xstart == xend+1)&&((ystart==yend+1)||(ystart == yend-1))&&(field[xend][yend]!= null)){
			if(field[xend][yend].isWeiss() != field[xstart][ystart].isWeiss()){
				return true;
			}
		}
		return false;
	}
	
	
	private Figuren[][] rotate(Figuren [][] field) {
		Figuren[][] result = new Figuren[field.length][field[0].length];
		
		for(int i =0; i< field.length; i++) {
			for(int j =0; j < field[i].length; j++) {
				result[j][i] = field[i][j];
			}
		}
		
		return result;
	}

}
