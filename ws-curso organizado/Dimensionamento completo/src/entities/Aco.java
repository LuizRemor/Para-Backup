package entities;

public class Aco {

	private Armadura armadura = new Armadura();
	private ClasseDeProjeto classeDeProjeto = new ClasseDeProjeto();
	private Viga viga = new Viga();

	private Double diametro;
	private Double tipoBarra;
	private Double tipoEstribo;
	private Double bitolaBarra;
	private Double bitolaEstribo;
	private Double fyk;
	private Double yd;

	public Aco() {

	}

	public Aco(Double diametro, Double tipoBarra, Double tipoEstribo, Double bitolaBarra, Double bitolaEstribo,	Double fyk, Double yd) {
		this.diametro = diametro;
		this.tipoBarra = tipoBarra;
		this.tipoEstribo = tipoEstribo;
		this.bitolaBarra = bitolaBarra;
		this.bitolaEstribo = bitolaEstribo;
		this.fyk = fyk;
		this.yd = yd;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	public Double getTipoBarra() {
		return tipoBarra;
	}

	public void setTipoBarra(Double tipoBarra) {
		this.tipoBarra = tipoBarra;
	}

	public Double getTipoEstribo() {
		return tipoEstribo;
	}

	public void setTipoEstribo(Double tipoEstribo) {
		this.tipoEstribo = tipoEstribo;
	}

	public Double getBitolaBarra() {
		return bitolaBarra;
	}

	public void setBitolaBarra(Double bitolaBarra) {
		this.bitolaBarra = bitolaBarra;
	}

	public Double getBitolaEstribo() {
		return bitolaEstribo;
	}

	public void setBitolaEstribo(Double bitolaEstribo) {
		this.bitolaEstribo = bitolaEstribo;
	}

	public Double getFyk() {
		return fyk;
	}

	public void setFyk(Double fyk) {
		this.fyk = fyk;
	}

	public Double getYd() {
		return yd;
	}

	public void setYd(Double yd) {
		this.yd = yd;
	}

	public Double Fyd() {
		return (fyk / yd) / 10;
	}

	// ÁREA DE AÇO CALCULADA
	public Double As() {
		return (0.85 * 0.8 * classeDeProjeto.Fcd() * viga.getLargura() * armadura.X()) / Fyd();
	}

	// ÁREA MÍNIMA DE AÇO
	public Double AsMin() {
		return 0.0015 * viga.getLargura() * viga.getAltura();
	}

	// DECISÃO DE QUAL AREA DE ACO USAR
	public double areaDeAco() {
		if (AsMin() > As()) {
			return AsMin();
		} else
			return As();
	}

	// QUANTIDADE DE BARRAS DE AÇO
	public double quantBarrasAco() {

		if (diametro == 1) {
			return Math.ceil(areaDeAco() / 0.5);
		} else if (diametro == 2) {
			return Math.ceil(areaDeAco() / 0.78);
		} else if (diametro == 3) {
			return Math.ceil(areaDeAco() / 1.23);
		} else {
			return Math.ceil(areaDeAco() / 2);
		}
	}

}