package schach.model;

public class Laufer extends Figuren{
	
	public Laufer(){
		super();
	}
	
	public Laufer(boolean b){
		super(b);
	}
	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/laufer_weiss";
		else
			return "/schach/gui/figures/laufer_sw";
	}

	@Override
	protected boolean calcmove(int xstart, int ystart, int xend, int yend,
			Figuren[][] field) {
		if(xstart == xend && ystart == yend)
			return false;
		if(Math.abs(xstart-xend)==Math.abs(ystart-yend)){
			for(int i = 1; i <= Math.abs(xstart-xend);i++){
				if((xstart-xend)>0){
					if((ystart-yend)>0){
						if(field[xstart-i][ystart-i]!=null){
							if((xstart-i)== xend)
								if(field[xstart-i][ystart-i].isWeiss() != field[xstart][ystart].isWeiss())
									return true;
							return false;
						}
					}else{
						if(field[xstart-i][ystart+i]!=null){
							if((xstart-i)== xend)
								if(field[xstart-i][ystart+i].isWeiss() != field[xstart][ystart].isWeiss())
									return true;
							return false;
						}
					}
				}else{
					if((ystart-yend)>0){
						if(field[xstart+i][ystart-i]!=null){
							if((xstart+i)== xend)
								if(field[xstart+i][ystart-i].isWeiss() != field[xstart][ystart].isWeiss())
									return true;
							return false;
						}
					}else{
						if(field[xstart+i][ystart+i]!=null){
							if((xstart+i)== xend)
								if(field[xstart+i][ystart+i].isWeiss() != field[xstart][ystart].isWeiss())
									return true;
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Laeufer";
	}
}
