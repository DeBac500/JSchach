package schach.model;

import schach.Schach;

public class Koenig extends Figuren{
	private boolean moved = false;
	public Koenig(){
		super();
	}
	
	public Koenig(boolean b){
		super(b);
	}
	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/konig_weiss";
		else
			return "/schach/gui/figures/konig_sw";
	}

	@Override
	protected boolean calcmove(int xstart, int ystart, int xend, int yend,
			Figuren[][] field) {
		if(((Math.abs(xstart-xend)==1) && (Math.abs(ystart-yend)<=1)) || ((Math.abs(ystart-yend)==1) &&(Math.abs(xstart-xend)<=1))){
			if(field[xend][yend]!= null){
				if(field[xend][yend].isWeiss() != field[xstart][ystart].isWeiss()){
					moved = true;
					return true;
				}
				return false;
			}
			moved = true;
			return true;
		}
		// Rochade
		if(((xstart == 7) && (ystart == 4)) && ( ((xend==7) && (yend==2 || yend == 6)) ) ){
			if(Schach.isunderattack(xstart, ystart, isWeiss()))
				return false;
			if(Schach.isunderattack(xend, yend, isWeiss()))
				return false;
			if(Schach.isunderattack((xstart + xend)/2,(ystart + yend)/2, isWeiss()))
				return false;
			for(int i = 1; i <= ((ystart-yend)>0?3:2);i++){
				if((ystart-yend)<0){
					if(field[xstart][ystart+i] != null)
						return false;
				}else{
					if(field[xstart][ystart-i] != null)
						return false;
				}
			}
			if(moved)
				return false;
			if((ystart-yend)>0){
				if(((Turm)(field[7][0])).isMoved())
					return false;
				field[7][3] = field[7][0];
				field[7][0] = null;
				((Turm)(field[7][3])).moveed();
			}else{
				if(((Turm)(field[7][7])).isMoved())
					return false;
				field[7][5] = field[7][7];
				field[7][7] = null;
				((Turm)(field[7][5])).moveed();
			}
			this.moved = true;
			return true;
		}
		return false;
	}
}
