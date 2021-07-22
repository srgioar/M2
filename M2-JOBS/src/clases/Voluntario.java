package clases;

public class Voluntario extends Empleado {
	
	// Determina si cobra o no ayuda
	boolean cobraAyuda = false;

	public Voluntario(String nombre, boolean cobraAyuda) {
		super(nombre);
		this.cobraAyuda = cobraAyuda;
		cobrarAyuda();
		// es una ayuda, no tiene pagas extra:
		this.salarioBrutoAnual = salarioBrutoMensual * 12;
		// es una ayuda, no tiene retenciones:
		this.salarioNetoMensual = salarioBrutoMensual;
		this.salarioNetoAnual = salarioNetoMensual * 12;
	}
	
	public void cobrarAyuda() {
		if (this.cobraAyuda) {
			this.salarioBrutoMensual = 300;
		}
	}

	public boolean cobraAyuda() {
		return cobraAyuda;
	}

}
