package schach.model;

public class Koenigin extends Figuren{
	
	public Koenigin(){
		super();
	}
	public Koenigin(boolean b){
		super(b);
	}
	@Override
	public String getImagePath() {
		if(this.isWeiss())
			return "/schach/gui/figures/konigin_weiss";
		else
			return "/schach/gui/figures/konigin_sw";
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
		if(xstart == xend){
			for(int i= 1; i <= Math.abs(ystart-yend);i++){
				if((ystart-yend)<0){
					if(field[xstart][ystart+i] != null){
						if((ystart+i)==yend)
							if(field[xstart][ystart+i].isWeiss()!=field[xstart][ystart].isWeiss())
								return true;
						return false;
					}
				}else{
					if(field[xstart][ystart-i] != null){
						if((ystart-i)==yend)
							if(field[xstart][ystart-i].isWeiss()!=field[xstart][ystart].isWeiss())
								return true;
						return false;
					}
				}
			}
			return true;
		}
		if(ystart == yend){
			for(int i= 1; i <= Math.abs(xstart-xend);i++){
				if((xstart-xend)<0){
					if(field[xstart+i][ystart] != null){
						if((xstart+i)==xend)
							if(field[xstart+i][ystart].isWeiss()!=field[xstart][ystart].isWeiss())
								return true;
						return false;
					}
				}else{
					if(field[xstart-i][ystart] != null){
						if((xstart-i)==xend)
							if(field[xstart-i][ystart].isWeiss()!=field[xstart][ystart].isWeiss())
								return true;
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Koenigin";
	}
}
