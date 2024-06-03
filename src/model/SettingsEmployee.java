package model;

public interface SettingsEmployee {
	public final String mainPath="src/Documentos";
	public final String information="Empleados.txt";
	public final String inventario="Inventario.txt";
	public final String cliente="Clientes.txt";
	public final String provider="Provider.txt";


	//ER para clientes
	public static String ERNamesCLient = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s){3}[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	//public static String EREmailClient = "^[\\w._%+-]+@(gmail|hotmail|outlook|est|ups)\\.(com|ec|ups\\.edu\\.ups|ec)$";
	public static String ERAddress = "^[A-Z][a-z0-9\\s,\\-\\.#]+$";
	
	//ER para Proveedor
	public static String ERNamesProvider = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s)[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	public static String EREmailProvider = "^[\\w._%+-]+@(gmail|hotmail|outlook|est|ups)\\.(com|ec|ups\\.edu\\.ups|ec)$";
	public static String ERRuc = "^(\\d{10})(001)$";
	public static String ERPhone = "^([\\(]?0[2-7][\\)]?[\\s-]?\\d{4}[\\s-]?\\d{3})$";
}
