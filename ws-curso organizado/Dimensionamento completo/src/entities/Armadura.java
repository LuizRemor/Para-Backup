package entities;

public class Armadura {
	
	private Aco aco = new Aco();
	private ClasseDeProjeto classeDeProjeto = new ClasseDeProjeto();
	private Viga viga = new Viga();
	
	public Armadura() {
		
	}
	
	public Double M() {
		return (viga.getMomentoFletorNegativo()*1.4)*100.0;
	}
	
	public Double D() {
		return viga.getAltura() - classeDeProjeto.getC() - aco.getDiametro()/2;
	}
	
	public double bhaskarax1() {
		double a = 0.85 * classeDeProjeto.Fcd() * viga.getLargura() * 0.5;
		double b = 0.85 * classeDeProjeto.Fcd() * viga.getLargura() * D();
		double ccbhas = viga.getMomentoFletorNegativo() * 100;
		double delta = (b * b) - (4 * a * ccbhas);

		return (-b - Math.sqrt(delta)) / (2 * a) * (-1);
	}

	public Double bhaskarax2() {
		double a = 0.85 * classeDeProjeto.Fcd() * viga.getLargura() * 0.5;
		double b = 0.85 * classeDeProjeto.Fcd() * viga.getLargura() * D();
		double ccbhas = viga.getMomentoFletorNegativo() * 100;
		double delta = (b * b) - (4 * a * ccbhas);

		return (-b + Math.sqrt(delta)) / (2 * a) * (-1);
	}
	
	public Double Y() {
		if (bhaskarax1() < viga.getAltura()) {
			return bhaskarax1();
		} else
			return bhaskarax2();
	}
	
	public Double X() {
		return Y() / 0.8;
	}
	
	public Double espacamento() {
		if (aco.quantBarrasAco() > 4) {
		return viga.getLargura() - 4 * aco.getDiametro() - 2 * classeDeProjeto.getC();
		}
		else {
			return viga.getLargura() - aco.quantBarrasAco() * aco.getDiametro() - 2 * classeDeProjeto.getC();
		}
	}
	
	public Double espacamentoMin() {
		return 2.5;
	}
	
	public double decideEspacamento() {

			espacamento();
			espacamentoMin();

			System.out.println("Espaçamento calculado: " + espacamento());
			System.out.println("Espaçamento mínimo: " + espacamentoMin());
			
			if (espacamento() > espacamentoMin()) {
				return espacamento();
			} else
				return espacamentoMin();
	}
}