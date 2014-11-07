package schach.model;

public class Turm extends Figuren{
	private boolean moved = false;
	public Turm() {
		super();
	}
	
	public Turm(boolean b) {
		super(b);
	}

	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/turm_weiss";
		else
			return "/schach/gui/figures/turm_sw";
	}

	@Override
	protected boolean calcmove(int xstart, int ystart, int xend, int yend,
			Figuren[][] field) {
		if(xstart == xend && ystart == yend)
			return false;
		if(xstart == xend){
			for(int i= 1; i <= Math.abs(ystart-yend);i++){
				if((ystart-yend)<0){
					if(field[xstart][ystart+i] != null){
						if((ystart+i)==yend)
							if(field[xstart][ystart+i].isWeiss()!=field[xstart][ystart].isWeiss()){
								moved = true;
								return true;
							}
						return false;
					}
				}else{
					if(field[xstart][ystart-i] != null){
						if((ystart-i)==yend)
							if(field[xstart][ystart-i].isWeiss()!=field[xstart][ystart].isWeiss()){
								moved = true;
								return true;
							}
						return false;
					}
				}
			}
			moved = true;
			return true;
		}
		if(ystart == yend){
			for(int i= 1; i <= Math.abs(xstart-xend);i++){
				if((xstart-xend)<0){
					if(field[xstart+i][ystart] != null){
						if((xstart+i)==xend)
							if(field[xstart+i][ystart].isWeiss()!=field[xstart][ystart].isWeiss()){
								moved = true;
								return true;
							}
						return false;
					}
				}else{
					if(field[xstart-i][ystart] != null){
						if((xstart-i)==xend)
							if(field[xstart-i][ystart].isWeiss()!=field[xstart][ystart].isWeiss()){
								moved = true;
								return true;
							}
						return false;
					}
				}
			}
			moved = true;
			return true;
		}
		return false;
	}
	public boolean isMoved(){
		return moved;
	}
	public void moveed(){
		moved= true;
	}
	
	@Override
	public String toString(){
		return "Turm";
	}
}
