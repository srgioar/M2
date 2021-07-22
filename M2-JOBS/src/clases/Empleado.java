package clases;

public class Empleado {
	
	/* Mi gran duda sobre esta práctica siempre ha sido si derivar ciertas funciones a herencia de métodos o usar los constructores adecuados */
	
	String nombre;
	
	// Salario que se modifica según tipo de empleado
	int salarioBase;
	
	int salarioBrutoMensual;
	int salarioBrutoAnual;
	
	int salarioNetoMensual;
	int salarioNetoAnual;
	
	// IRPF es un double porque así multiplico para calcular % y evito conversiones
	double IRPF;
	
	public Empleado(String nombre, int salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		// Establece el salario bruto según salario base y su rol
		// también establece el IRPF según posición
		modificarSueldo(this);
		// Calcula impuestos según el salario bruto mensual
		// calcula también los anuales multiplicando por la cifra necesaria (12-14)
		calcularImpuestos();
		
	}
	
	// Me pide este constructor para poder usar un constructor sin salario para Voluntario
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.salarioBrutoMensual = 0;
	}
	
	// parecida a modificarSueldo pero esta función lo que hace es chequear si los valores son correctos
	public void chequearValoresSueldo(Empleado a) {
		
		if (a instanceof Junior) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.15));
		}
		
		// Salario 10% menor
		if (a instanceof Mid) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.10));
		}
		
		// Salario 5% menor
		if (a instanceof Senior) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.05));
		}
		
		// Cobran un 10% más de salario mensual
		if (a instanceof Manager) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase + (salarioBase * 0.10));
		}
		
		// Cobran un 50% más de su salario mensual
		if (a instanceof Jefe) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase + (salarioBase * 0.50));
		}
		
		// Cobran un 15% menos
		if (a instanceof EmpleadoBase) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.15));
		}
		
	}
	
	// Equipara el salario bruto anual al salario bruto mensual * 14
	// equipara el salario neto anual al salario
	public void calcularImpuestos() {
		
		// el salario bruto anual es el mensual x 14 (12+2 pagas)
		
		this.salarioBrutoAnual = salarioBrutoMensual * 14;
		
		this.salarioNetoMensual = (int) ((this.salarioBrutoMensual) - (this.salarioBrutoMensual * (this.IRPF)));

		this.salarioNetoAnual = this.salarioNetoMensual * 14;
		
	}
	
	public void aplicarBonus() {
		if (!this.getClass().getName().equals("Voluntario")){
			this.salarioBrutoMensual = (int) (this.salarioBrutoMensual + (this.salarioBrutoMensual * 0.10));
			calcularImpuestos();
		}
	}
	
	public void mostrar() {
		System.out.println(this.nombre);
		System.out.println("Tipo empleado: " + this.getClass().getName());
		System.out.println("impuestos: " + (int)(this.IRPF * 100));
		System.out.println("BRUTO MENSUAL: " + this.salarioBrutoMensual);
		System.out.println("NETO MENSUAL: " + this.salarioNetoMensual);
		System.out.println("BRUTO ANUAL: " + this.salarioBrutoAnual);
		System.out.println("NETO ANUAL: " + this.salarioNetoAnual);
		System.out.println();
	}
	
	@Override
	public String toString() {
		
		String empleadoString = "";
		
		empleadoString += this.nombre + "\n";
		empleadoString += "Tipo empleado: " + this.getClass().getName() + "\n";
		empleadoString += "impuestos: " + (int)(this.IRPF * 100) + "\n";
		empleadoString += ("BRUTO MENSUAL: " + this.salarioBrutoMensual + "\n");
		empleadoString += ("NETO MENSUAL: " + this.salarioNetoMensual + "\n");
		empleadoString += ("BRUTO ANUAL: " + this.salarioBrutoAnual + "\n");
		empleadoString += ("NETO ANUAL: " + this.salarioNetoAnual + "\n");
		
		return empleadoString;
	}
	
	// Función para modificar el sueldo según el sueldo base y el tipo de objeto de herencia:
	// Modifica el salarioBruto en base al salario base.
	// Es decir, como se ve en el orden del constructor, calcula complementos al salario base y tras eso, impuestos.
	
	void modificarSueldo(Object a){
		
		// Salario 15% menor
		if (a instanceof Junior) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.15));
		}
		
		// Salario 10% menor
		if (a instanceof Mid) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.10));
		}
		
		// Salario 5% menor
		if (a instanceof Senior) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.05));
		}
		
		// Cobran un 10% más de salario mensual
		if (a instanceof Manager) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase + (salarioBase * 0.10));
		}
		
		// Cobran un 50% más de su salario mensual
		if (a instanceof Jefe) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase + (salarioBase * 0.50));
		}
		
		// Cobran un 15% menos
		if (a instanceof EmpleadoBase) {
			this.IRPF = 0.20;
			this.salarioBrutoMensual = (int) (this.salarioBase - (salarioBase * 0.15));
		}
	}
	

	public int getSalarioBrutoMensual() {
		return salarioBrutoMensual;
	}

	public int getSalarioBrutoAnual() {
		return salarioBrutoAnual;
	}

	public int getSalarioNetoMensual() {
		return salarioNetoMensual;
	}

	public int getSalarioNetoAnual() {
		return salarioNetoAnual;
	}
	

}
