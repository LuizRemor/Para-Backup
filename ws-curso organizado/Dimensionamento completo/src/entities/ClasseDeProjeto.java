package entities;

public class ClasseDeProjeto {
	
	private Double fck;
	private Double yc;
	private Double ys;
	private Double c;
	
	public ClasseDeProjeto() {
		
	}

	public ClasseDeProjeto(Double fck, Double yc, Double ys, Double c) {
		this.fck = fck;
		this.yc = yc;
		this.ys = ys;
		this.c = c;
	}

	public Double getFck() {
		return fck;
	}

	public void setFck(Double fck) {
		this.fck = fck;
	}

	public Double getYc() {
		return yc;
	}

	public void setYc(Double yc) {
		this.yc = yc;
	}

	public Double getYs() {
		return ys;
	}

	public void setYs(Double ys) {
		this.ys = ys;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}
	
	public Double Fcd() {
		return (fck / yc) / 10.0;
	}
	
}