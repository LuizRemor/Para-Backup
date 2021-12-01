//PROBLEMAS:

package entities;

import java.util.Scanner;

public class Calculos {

	Scanner sc = new Scanner(System.in);

	public double momentoP, momentoN;

	public double mFletorPos() {
		return momentoP * 1.4;
	}

	public double fcd, fck, yc;

// CALCULO DA RESIST�NCIA DE PROJETO
	public double classeDeProjeto() {

		int opcao;

		System.out.println("A classe de projeto � a de Porto Alegre? (1-Sim 2-N�o)");
		opcao = sc.nextInt();

		if (opcao == 1) {
			fck = 25;
			yc = 1.4;
			return fcd = (fck / yc) / 10;
		} else {
			System.out.println("Qual o valor do fck da classe?");
			fck = sc.nextDouble();

			System.out.println("Qual o valor do yc da classe?");
			yc = sc.nextDouble();

			return fcd = (fck / yc) / 10;
		}
	}

// DIAMETRO E VIGA EST�O COMO CONSTANTES NOS PAR�METROS PADR�O DE PORTO ALEGRE
	public double diametro = 1;
	public double c = 3;

	public double h, bw, d;

//C�LCULO DA DIST�NCIA DO TOPO DA VIGA AT� O CENTRO GEOM�TRICO DA ARMADURA
	public double d() {

		System.out.println("Qual a altura da viga?");
		h = sc.nextDouble();

		System.out.println("Qual a largura da viga?");
		bw = sc.nextDouble();

		return d = h - c - (diametro / 2);
	}

	public double a, b, ccbhas;
	
// C�LCULO DA BHASKARA
	public double bhaskarax1() {
		a = 0.85 * fcd * bw * 0.5;
		b = 0.85 * fcd * bw * d;
		ccbhas = mFletorPos() * 100;
		double delta = (b * b) - (4 * a * ccbhas);

		return (-b - Math.sqrt(delta)) / (2 * a) * (-1);
	}
	
	public double bhaskarax2() {
		a = 0.85 * fcd * bw * 0.5;
		b = 0.85 * fcd * bw * d;
		ccbhas = mFletorPos() * 100;
		double delta = (b * b) - (4 * a * ccbhas);

		return (-b + Math.sqrt(delta)) / (2 * a) * (-1);
	}

//DECISAO DE QUAL VALOR DE X LINHA UTILIZAR
	public double Y() {
		if (bhaskarax1() < h) {
			return bhaskarax1();
		} else
			return bhaskarax2();
	}

//APLICA��O DO X NA PSEUDO LINHA NEUTRA
	public double X() {
		return Y() / 0.8;
	}

//INICIAR O C�LCULO DO DOM�NIO 4
//DECIS�O DO DOM�NIO
	
	int dominio;
	
	public String dominio() {
		double x23, x34;

		x23 = 0.259 * d;
		x34 = 0.628 * d;
		dominio = 1;

		if (X()> 0 && X() <= 1 ) {
			return "A viga est� no Dom�nio I";
		} else if (X() > 1 && X() < x23) {
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga est� no Dom�nio II";
		} else if (X() > x23 && X() < x34) {
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga est� no Dom�nio III";
		} else if(X() > x34 &&  X() < (d-d*0.05)) {
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga est� no Dom�nio IV";
		}
		else {
			dominio = 5;
			System.out.println("x23 = " + x23);
			System.out.println("x34 = " + x34);
			return "A viga est� no Dom�nio V";
		}
	}

//ESCOLHA DAS ARMADURAS
	public double fyd;

	public double armadura() {

		int opcao;

		System.out.println("Utilizaremos o a�o padr�o CA-50? (1-Sim 2-N�o)");
		opcao = sc.nextInt();

		if (opcao == 1) {
			fck = 500;
			yc = 1.15;
			return fyd = (fck / yc) / 10;
		} else {
			System.out.println("Qual o valor do fyk do a�o? (MPa)");
			fck = sc.nextDouble();

			System.out.println("Qual o valor do yc do a�o?");
			yc = sc.nextDouble();

			return fyd = (fck / yc) / 10;
		}
	}

//�REA DE A�O CALCULADO
	public double areaDeAcoCalc() {
		return (0.85 * 0.8 * fcd * bw * X()) / fyd;
	}

//�REA M�NIMA DE A�O
	public double areaMinDeAco() {
		return (0.150 / 100) * bw * h;
	}

//DECIS�O DA MAIOR �REA DE A�O
	public double areaDeAco() {
		if (areaMinDeAco() > areaDeAcoCalc()) {
			return areaMinDeAco();
		} else
			return areaDeAcoCalc();
	}

//QUANTIDADE DE BARRAS DE A�O M�XIMO
	
	Double qtdBarras = 0.0;
	
	public double quantBarrasAco() {

		double diametro;
		
		System.out.printf("Quantidade de barras usando o As = %.2f", areaDeAcoCalc());
		System.out.println();
		System.out.printf("%.0f barras de 8mm%n", (Math.ceil(areaDeAco() / 0.5)));
		System.out.printf("%.0f barras de 10mm%n", (Math.ceil(areaDeAco() / 0.78)));
		System.out.printf("%.0f barras de 12,5mm%n", (Math.ceil(areaDeAco() / 1.23)));
		System.out.printf("%.0f barras de 16mm%n", (Math.ceil(areaDeAco() / 2)));
		
		/*System.out.println("___________________________________________________________");
		
		System.out.printf("Quantidade de barras usando o Asm�n = %.2f", areaMinDeAco());
		System.out.println();
		System.out.printf("%.0f barras de 8mm%n", (Math.ceil(areaMinDeAco() / 0.5)));
		System.out.printf("%.0f barras de 10mm%n", (Math.ceil(areaMinDeAco() / 0.78)));
		System.out.printf("%.0f barras de 12,5mm%n", (Math.ceil(areaMinDeAco() / 1.23)));
		System.out.printf("%.0f barras de 16mm%n", (Math.ceil(areaMinDeAco() / 2)));*/
		
		System.out.println("Qual � de barra usaremos? (1)8mm  (2)10mm  (3)12,5mm  (4)16mm");
		diametro = sc.nextDouble();

		if (diametro == 1) {
			return qtdBarras =  Math.ceil(areaDeAco() / 0.5);
		} else if (diametro == 2) {
			return qtdBarras = Math.ceil(areaDeAco() / 0.78);
		} else if (diametro == 3) {
			return qtdBarras = Math.ceil(areaDeAco() / 1.23);
		}
		else {
			return qtdBarras = Math.ceil(areaDeAco() / 2);
		}
	}

	public double espacamentoMin;

//ESPA�AMENTO M�NIMO

	
	public double espacamentoMin() {
		
		System.out.println("Ter� brita maior que a brita 1? (1-Sim 2-N�o)");
		int op = sc.nextInt();

		if (op == 2) {
			return espacamentoMin = 2.5;

		} else {

			double brita;

			System.out.println("Qual o maior di�metro da brita? (cm)");
			brita = sc.nextDouble();

			return espacamentoMin = brita * 1.2;
		}
	}

	public double espacamentoCalc;
	
//ESPA�AMENTO CALCULADO
	public double espacamentoCalc() {
		return espacamentoCalc = (bw - (qtdBarras * diametro) - (2 * c))/(qtdBarras-1);
	}

//DECIS�O DE ESPA�AMENTO
	public double espacamento() {
		espacamentoCalc();
		espacamentoMin();
		
		System.out.println("Espa�amento calculado: " + espacamentoCalc);
		System.out.println("Espa�amento m�nimo: " + espacamentoMin);
		
		if (espacamentoCalc > espacamentoMin) {
			return espacamentoCalc;
		} else
			return espacamentoMin;
	}

}