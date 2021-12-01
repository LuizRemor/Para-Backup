package application;

import java.util.Scanner;

import entities.Viga;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Qual a largura da viga?");
		Double h = sc.nextDouble();
		System.out.println("Qual a altura da viga?");
		Double bw = sc.nextDouble();
		System.out.println("Qual comprimento (m) total da viga?");
		Double comprimento = sc.nextDouble();
		System.out.println("Qual o maior momento fletor positivo da viga?");
		Double mPos = sc.nextDouble();
		System.out.println("Qual o maior momento fletor negativo da viga?");
		Double mNeg = sc.nextDouble();
		System.out.println("Qual o maior esforço cortante da viga?");
		Double esfCor = sc.nextDouble();
		
		Viga viga1 = new Viga(h, bw, comprimento, mPos, mNeg, esfCor, 0);
		
		System.out.println(viga1);
		
		/*Armadura armadura = new Armadura();
		
		System.out.println("%.2f" + armadura.D());*/
		
		sc.close();
		
	}

}