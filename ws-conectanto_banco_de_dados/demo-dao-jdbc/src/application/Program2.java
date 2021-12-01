package application;

import java.text.ParseException;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		
		DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();
		
		/*System.out.println("Teste de INSERT: \n");
		Department newDepartment = new Department(7, "inovação");
		DepartmentDao.insert(newDepartment);
		System.out.println("Inserted! New Department = " + newDepartment.getName());*/
		
		/*System.out.println("Teste de UPDATE: \n");
		Department newDepartment = new Department(7, "Inovação e Novos Negócios");
		DepartmentDao.update(newDepartment);
		System.out.println("UPDATED! New Department = " + newDepartment.getName());*/
		
		System.out.println("\n=== TEST 6: Seller Delete ====");
		int id = 5;
		DepartmentDao.deleteById(id);
		System.out.println("Delete completed!!");

	}

}
