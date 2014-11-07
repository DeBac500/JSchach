package schach.model;

public abstract class Figuren {
	private boolean weiss;
	
	private int xstart, ystart;
	public Figuren(){
		this(true);
	}
	public Figuren(boolean weiss){
		this.weiss = weiss;
	}
	
	public boolean isWeiss(){
		return weiss;
	}
	
	public abstract String getImagePath();
	
	public boolean move(int x , int y){
		xstart = x;
		ystart = y;
		return true;
	}
	
	protected abstract boolean calcmove(int xstart, int ystart, int xend, int yend, Figuren[][] field);
	
	public boolean move(int x, int y, Figuren[][] field){
		if(xstart == x && ystart ==y)
			return false;
		return calcmove(xstart, ystart,x, y, field);
	}
	public boolean move(int xstart, int ystart, int xend, int yend, Figuren[][] field){
		return calcmove(xstart, ystart,xend, yend, field);
	}
	
	public int getXStart(){
		return xstart;
	}
	
	public int getYStart(){
		return ystart;
	}
}
