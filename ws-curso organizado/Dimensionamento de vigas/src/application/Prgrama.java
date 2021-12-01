package application;

import java.util.Scanner;

import entities.Calculos;

public class Prgrama {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Calculos calc = new Calculos();

		System.out.println("Qual o maior momento positivo da viga?");

		calc.momentoP = sc.nextDouble();

		System.out.printf("Momento de projeto: %.4f%n", calc.mFletorPos());
		
		System.out.println();
		
		System.out.printf("fcd = %.4f kN/cm²%n", calc.classeDeProjeto());
		
		System.out.println();
		
		//System.out.println("Vamos utilizar cobrimento = 3cm");
		
		//System.out.println();
		
		System.out.printf("d = %.2fcm%n", calc.d());
		
		System.out.println();
		
		calc.bhaskarax1();
		
		calc.bhaskarax2();
		
		System.out.printf("Bhaskara = -%.2fx² + %.2fx - %.2f%n", calc.a, calc.b, calc.ccbhas);
		
		System.out.println();
		
		//System.out.printf("X1 = %.2f%n", calc.bhaskarax1());
		
		//System.out.println();
		
		//System.out.printf("X2 = %.2f%n", calc.bhaskarax2());
		
		//System.out.println();
		
		System.out.printf("Y = %.2f%n", calc.Y());
		
		System.out.println();
		
		System.out.printf("X = %.2f%n", calc.X());
		
		System.out.println();
		
		System.out.println(calc.dominio());
		
		System.out.println();
		
		calc.armadura();
		
		System.out.println();
		
		System.out.printf("fyd = %.2f MPa%n", calc.fyd);
		
		System.out.println();
		
		System.out.printf("As calculado = %.2fcm²%n", calc.areaDeAcoCalc());
		
		System.out.println();
		
		System.out.printf("As mínimo = %.2fcm²%n", calc.areaMinDeAco());
		
		System.out.println();
		
		System.out.printf("As final = %.2fcm²%n", calc.areaDeAco());
		
		System.out.println();
				
		System.out.printf("Usaremos %.2f barras%n", calc.quantBarrasAco());
		
		System.out.println();
		
		System.out.printf("Espaçamento = %.2fcm", calc.espacamento());
		
		sc.close();
	}

}