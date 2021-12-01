package entities;

public class Viga {

	private Armadura armadura = new Armadura();
	
	private Double largura;
	private Double altura;
	private Double comprimento;
	private Double momentoFletorPositivo;
	private Double momentoFletorNegativo;
	private Double esforçoCortante;
	private Integer dominio;
	
	public Viga() {
		
	}
	
	
	
	public Viga(Double largura, Double altura, Double comprimento, Double momentoFletorPositivo, Double momentoFletorNegativo, Double esforçoCortante, Integer dominio) {
		this.largura = largura;
		this.altura = altura;
		this.comprimento = comprimento;
		this.momentoFletorPositivo = momentoFletorPositivo;
		this.momentoFletorNegativo = momentoFletorNegativo;
		this.esforçoCortante = esforçoCortante;
		this.dominio = dominio;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getMomentoFletorPositivo() {
		return momentoFletorPositivo;
	}

	public void setMomentoFletorPositivo(Double momentoFletorPositivo) {
		this.momentoFletorPositivo = momentoFletorPositivo;
	}

	public Double getMomentoFletorNegativo() {
		return momentoFletorNegativo;
	}

	public void setMomentoFletorNegativo(Double momentoFletorNegativo) {
		this.momentoFletorNegativo = momentoFletorNegativo;
	}

	public Double getEsforçoCortante() {
		return esforçoCortante;
	}

	public void setEsforçoCortante(Double esforçoCortante) {
		this.esforçoCortante = esforçoCortante;
	}
	
	public Integer getDominio() {
		return dominio;
	}

	public void setDominio(Integer dominio) {
		this.dominio = dominio;
	}

	public String dominio() {

		double x23, x34;

		x23 = 0.259 * armadura.D();
		x34 = 0.628 * armadura.D();

		if (armadura.X()> 0 && armadura.X() <= 1 ) {
			dominio = 1;
			return "A viga está no Domínio I";
		} 
		else if (armadura.X() > 1 && armadura.X() < x23) {
			dominio = 2;
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga está no Domínio II";
		} 
		else if (armadura.X() > x23 && armadura.X() < x34) {
			dominio = 3;
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga está no Domínio III";
		} 
		else if(armadura.X() > x34 &&  armadura.X() < (armadura.D()-armadura.D()*0.05)) {
			dominio = 4;
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga está no Domínio IV";
		}
		else {
			dominio = 5;
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga está no Domínio V";
		}
	}
	
	
}
