package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cadastro;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Cadastro> list = new ArrayList<>();
		
		System.out.println("Quantos alunos irão alugar? ");
		int n = 3;
		
		for(int i=1 ; i<=n; i++) {
			System.out.println("Quarto: ");
			String nome = "Marco";
			String email = "marco@gmail";
			Integer quarto = sc.nextInt();
			
			list.add(new Cadastro(nome, email, quarto));
		}
		
		for(Cadastro quartos : list) {
			System.out.println(quartos);
		}
		
		sc.close();
	}

}
