package modelo.javabeans;

import java.sql.Date;


/**
 * Creo la clase Empleado que contiene todos los atributos que hacen referenciua al empleado de la base de datos
 * y 2 objetos de tipo privado que hacen referencia a las clases Perfil y departamento
 * 
 * @author Gerard_Perujo
 *
 */
public class Empleados {
	
	private int idEmpl;
	private String nombre;
	private String apellidos;
	private String genero;
	private String email;
	private String password;
	private double salario;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Perfil perfil;
	private Departamentos departamentos;
	
	
	public Empleados() {
		super();
	}


	
	/**
	 * Creo un costructor con todos los atributos de Empleados
	 * @param idEmpl: Hace referencia al id_ del Empleado
	 * @param nombre: Hace referencia al Nombre del Empleado
	 * @param apellidos: Hace referencia a los apellidos del Empleado
	 * @param email: Hace referencia al Email del Empleado
	 * @param password: Es la password que tiene el Empleado
	 * @param salario: El Salario bruto que tiene el Empleado
	 * @param fechaIngreso: La Fecha de contratacion del Empleado
	 * @param fechaNacimiento: La Fecha de nacimiento del Empleado
	 * @param perfil: Este atributo hace referencia a la Clase Perfil
	 * @param departamentos: Este atributo hace referencia a la Clase Departamentos
	 */

	public Empleados(int idEmpl, String nombre, String apellidos, String genero, String email, String password,
			double salario, Date fechaIngreso, Date fechaNacimiento, Perfil perfil, Departamentos departamentos) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.departamentos = departamentos;
	}

	/**
	 * Creamos todos los getters and setters de la Classe
	 */

	public int getIdEmpl() {
		return idEmpl;
	}


	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Perfil getPerfil(){
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Departamentos getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}


	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	/**
	 * Creamos el metodo toString con los 2 atributos que hacen referencia a las Clases Perfil y Departamentos
	 */
	
	
	@Override
	public String toString() {
		return "Empleados [idEmpl = " + idEmpl + "]" + " [nombre = " + nombre + "]" + " [apellidos = " + apellidos + "]" + " [genero = " + genero
				+ "]" + " [email = " + email + "]" + " [password = " + password + "]" + " [salari o= " + salario + "]" + " [fechaIngreso = "
				+ fechaIngreso + "]" + " [fechaNacimiento = " + fechaNacimiento + "]" + " [perfil = " + perfil + "]" + " [departamentos = "
				+ departamentos + "]";
	}


	
	/**
	 * Este metodo te calcula el SalarioBruto del Empleado
	 * 
	 * @return devuelve un double con el Salario Bruto
	 */
	public double salarioBruto() {
		return salario;
	}
	

	/**
	 * Te calcula el salario mensual del Empleado a partir de los meses introducidos
	 * 
	 * @param meses: Es un numero entero que hace referencia a los meses por los que
	 * hay que calcular el salario
	 * 
	 * @return despues de dividir el salario por los meses introducidos te devuelve un
	 * double
	 */
	public double salarioMensual(int meses) {
		return salario/meses;
	}
	
	
	/**
	 * Este metodo a partir de un caracter te dice si el Empleado es Hombre o Mujer
	 * 
	 * @return si el valor introducido es 'H', te devuelve eres un hombre
	 * 		   si el valor introducido es 'M', te devuelve eres una mujer
	 * 		   si el valor introducido no es ni 'M', ni 'H', te devuelve, caracter erroneo
	 */
	public String literalSexo() {
		String sexo = "";
			switch(sexo){
				case "H", "h":
					System.out.println("Eres un Hombre");;
				break;
				case "M", "m":
					System.out.println("Eres una Mujer"); ;
				break;
				default:
				System.out.println("Caracter introducido incorrecto");;
				
			}
			
			return sexo;
	}
	
	/**
	 * A partir de un nombre y un apellido te genera el email, cogiendo el primer
	 * caracter del nombre y el apellido
	 * 
	 * @return devuelve el primer caracter del nombre en mayuscuylas y los concatena con
	 * los apellidos poniendolos en minusculas
	 */
	public String obtenerEmail() {
		String minuscula = apellidos.toLowerCase();
		char letra = 'c';
		for(int i = nombre.length()-1; i > 0; i--) {
			letra = nombre.charAt(i);
			
			System.out.println("La direccion del email: " + letra + minuscula + "@edix.com");
		}
		return email;
	}
	
	/**
	 * Te saca el nombre completo del Empleado con su nombre y apellido
	 * 
	 * @return concatena el nombre con el apellido
	 */
	public String nombreCompleto() {
		return "Tu nombre completo es: " + nombre + " " + apellidos;
		
	}
	
	
	

}
