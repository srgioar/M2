package main;

import javax.swing.JOptionPane;

import clases.Empleado;
import clases.EmpleadoBase;
import clases.Jefe;
import clases.Junior;
import clases.Manager;
import clases.Mid;
import clases.Senior;
import clases.Voluntario;

public class TrabajosApp {
	
	public static void main(String[] args) throws Exception {
		
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
		
		crearEmpleado();

	}
	
	// Invoca excepciones con un throw para utilizar un if y comprobar que el rango de sueldo sea correcto
	public static void crearEmpleado() throws Exception {
		
		String nombreEmpleado = JOptionPane.showInputDialog("NOMBRE EMPLEADO: ");
		String rangoEmpleado = JOptionPane.showInputDialog("RANGO EMPLEADO: \n Para empleado raso introduce 'base'");
		int salarioEmpleado = 0;
		
		// Si no es voluntario, pedimos también salario
		
		if (!rangoEmpleado.toLowerCase().equals("voluntario")) {
			salarioEmpleado = Integer.parseInt(JOptionPane.showInputDialog("SALARIO BASE: "));
		}
		
		if (rangoEmpleado.toLowerCase().equals("junior")) {
			
			if (salarioEmpleado > 900 && salarioEmpleado < 1600) {
				Junior newJunior = new Junior(nombreEmpleado, salarioEmpleado);
				JOptionPane.showMessageDialog(null, newJunior.toString());
				JOptionPane.showMessageDialog(null, newJunior.toString());
			}
			
			else {
				throw new Exception("VALORES INCORRECTOS");
			}

		}
		
		if (rangoEmpleado.toLowerCase().equals("mid")) {
			
			if (salarioEmpleado > 1800 && salarioEmpleado < 2500) {
				Mid newMid = new Mid(nombreEmpleado, salarioEmpleado);
				JOptionPane.showMessageDialog(null, newMid.toString());
			}
			
			else {
				throw new Exception("VALORES INCORRECTOS");
			}
			
		}
		
		if (rangoEmpleado.toLowerCase().equals("senior")) {
			
			if (salarioEmpleado > 2700 && salarioEmpleado < 4000) {
				Senior newSenior = new Senior(nombreEmpleado, salarioEmpleado);
				JOptionPane.showMessageDialog(null, newSenior.toString());
			}
			
			else {
				throw new Exception("VALORES INCORRECTOS");
			}

		}
		
		if (rangoEmpleado.toLowerCase().equals("base")) {
			
			// El empleado base no tiene restricción de rango de salario
			EmpleadoBase newEmpleadoBase = new EmpleadoBase(nombreEmpleado, salarioEmpleado);
			JOptionPane.showMessageDialog(null, newEmpleadoBase.toString());
			JOptionPane.showMessageDialog(null, newEmpleadoBase.toString());
		}
		
		if (rangoEmpleado.toLowerCase().equals("manager")) {
			
			if (salarioEmpleado > 3000 && salarioEmpleado < 5000) {
				
				Manager newManager = new Manager(nombreEmpleado, salarioEmpleado);
				JOptionPane.showMessageDialog(null, newManager.toString());
				
			}
			
			else {
				throw new Exception("VALORES INCORRECTOS");
			}

		}
		
		if (rangoEmpleado.toLowerCase().equals("jefe")) {
			
			if (salarioEmpleado > 8000) {
				Jefe newJefe = new Jefe(nombreEmpleado, salarioEmpleado);
				JOptionPane.showMessageDialog(null, newJefe.toString());
			}
			
			else {
				throw new Exception("VALORES INCORRECTOS");
			}

		}

	}

}
