package p;

public class colorClass {
	public int id;
	public int key;
	public int r;
	public int g;
	public int b;
	colorClass(){
		id = 0;
		key = 0;
	}
	colorClass(int id,int r,int g,int b){
		this.id = id;
		this.r = 255-r;
		this.g = 255-g;
		this.b = 255-b;
		RGB();
		//min = 0;
		//max = 0;
	}
	void RGB() {
		key = (r <<16) + (g<<8) + b;
	}

}
