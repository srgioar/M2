package main;

import clases.Empleado;
import clases.EmpleadoBase;
import clases.Jefe;
import clases.Junior;
import clases.Manager;
import clases.Mid;
import clases.Senior;
import clases.Voluntario;

public class TrabajosApp {
	
	public static void main(String[] args) {
		
		// Creamos un empleado de cada tipo y le damos nombre y sueldo:
		EmpleadoBase empleadoBase = new EmpleadoBase("Sergio", 1040);
		Senior seniorTest = new Senior("Roger", 1410);
		Mid midTest = new Mid("Adrián", 1190);
		Junior juniorTest = new Junior("Carlos", 920);
		Manager managerTest = new Manager("Javi", 1577);
		Jefe jefeTest = new Jefe("Aitana", 2060);
		
		// creamos dos voluntarios de prueba, uno con ayuda y otro sin
		Voluntario voluntarioTest = new Voluntario("Dolors", false);
		Voluntario voluntarioTest2 = new Voluntario("Xavi", true);
		
		empleadoBase.mostrar();
		seniorTest.mostrar();
		midTest.mostrar();
		juniorTest.mostrar();
		managerTest.mostrar();
		jefeTest.mostrar();
		voluntarioTest.mostrar();
		voluntarioTest2.mostrar();
		
		// Empaquetar todos los empleados en un array para aplicar a toda la plantilla el bonus:
		Empleado[] arrayEmpleados = new Empleado[8];
		arrayEmpleados[0] = empleadoBase;
		arrayEmpleados[1] = seniorTest;
		arrayEmpleados[2] = midTest;
		arrayEmpleados[3] = juniorTest;
		arrayEmpleados[4] = managerTest;
		arrayEmpleados[5] = jefeTest;
		arrayEmpleados[6] = voluntarioTest;
		arrayEmpleados[7] = voluntarioTest2;
		
		System.out.println("VALORES DESPUÉS DE RECIBIR UN BONUS DEL 10%: ");
		System.out.println();
		
		for (int i = 0; i < arrayEmpleados.length; i++) {
			arrayEmpleados[i].aplicarBonus();
			arrayEmpleados[i].mostrar();
		}
		
		
	}

}
