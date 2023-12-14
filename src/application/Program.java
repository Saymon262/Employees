package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entitites.Employee;
import entitites.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<Employee>();
		
		//Employee employee = new Employee();
		
		System.out.println("How many employees?");
		int quantity = scan.nextInt();
		
		
		int i = 0;
		while (i < quantity) {
			
			System.out.println("Outsourced (y/n?)");
			char OS= scan.next().charAt(0);
			
			System.out.println("Name of the "+ (i+1) +"° employee" );
			String name= scan.next();
			
			System.out.println("Hours of work");
			int hours = scan.nextInt();
			
			System.out.println("Value per Hour" );
			Double valuePerHour= scan.nextDouble();
			
			if (OS == 'y') {
				System.out.println("Additional Charge: ");
				double additionalCharge = scan.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}else {
				list.add(new Employee(name, hours, valuePerHour));
			}
			i++;
		}
		System.out.println("Payments: ");
		
		for(Employee e : list) {
			System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
		}
		scan.close();
	}
}
