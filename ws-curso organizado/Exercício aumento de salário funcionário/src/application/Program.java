package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		Integer n = 3;
		
		System.out.printf("Cadastraremos %d funcionários", n);
		System.out.println();
		System.out.println();
		
		for(int i=1; i<=n; i++) {
			Integer id = i;
			String nome = "Maria";
			Double salario = 4000.0;
			
			list.add(new Funcionario(id, nome, salario));
		}
		
		for(Funcionario funcs : list) {
			System.out.println(funcs);
		}
		
		System.out.println();
		System.out.println("Id do funcionário que iremos aumentar o salário: ");
		Integer id = sc.nextInt();
		
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (func != null) {
			Double percentual = 10.0;
			func.AumentaSalario(percentual);
		}
			else {
				System.out.println("Esta matrícula não existe!!");
				System.out.println();
		}
		
		System.out.println(list);
		
		sc.close();

	}

}
