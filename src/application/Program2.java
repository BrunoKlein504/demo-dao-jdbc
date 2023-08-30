package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findAll ===");
		List<Department> depList = departmentDao.findAll();
		for (Department d : depList) {
			System.out.println(d);
		}
		System.out.println("\n=== Test 2: Department findById ===");
		Department dep = departmentDao.findById(4);
		System.out.println(dep);
		
		System.out.println("\n=== Test 3: Department deleteById ===");
		System.out.print("Enter the number which as you wish delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		System.out.println("\n=== Test 4: Department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Gadgets");
		departmentDao.update(dep);
		System.out.println("Update complete!");
		
		System.out.println("\n=== Test 5: Department insert ===");
		Department newDepartment = new Department(null, "Magazines");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted Department: " + newDepartment.getId());

		sc.close();
	}

}
