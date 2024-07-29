package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.*;
import libreriaVersion3.*;

public interface Parametrizable {
	
	public final Conexion conn = new Conexion("ElectroTech");
	
	//DAOs 
	public final EmployeesDAO edao = new EmployeesDAO();
	public final ClientDAO cdao = new ClientDAO();
	public final ProductDAO pdao = new ProductDAO();
	public final SaleDAO sdao = new SaleDAO();
	public final ProviderDAO prdao = new ProviderDAO();
	
	//User of History Client View
	public final Client client_history = new Client();
	
	//Notificaciones Low Stock process
	public final List<Product> low_stock_products = new ArrayList<>();
	
	//ERs
	public static String ERNames4 = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s){3}[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	public static String ERNames2 = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s)[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	public static String ERAddress = "^[a-zA-Z0-9\\s,.-/#]+$";
	public static String ERDNI = "^(0[1-9]|1[0-9]|2[0-4])[0-5][0-9]{7}$";
	public static String EREmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	public static String ERRuc = "^(0[1-9]|1[0-9]|2[0-4])[0-5][0-9]{7}001$";
	public static String ERPhone = "^([\\(]?0[2-7][\\)]?[\\s-]?\\d{4}[\\s-]?\\d{3})$";
	public static String ERPhonenumber = "^[09][0-9]{8}$";
	public static String ERPassword = "^[^\\s]{4,}$";
	public static String ERCode = "^[a-zA-Z0-9]{1,10}$";
	public static String ERSocialReason = "^[\\p{L}\\p{M}\\p{N}\\p{P}\\p{S}\\s]+$";
	
	//Metodo validar String
	public static boolean validarRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
	
	public final List<String> userRoll = Arrays.asList(
            "Encargado Inventario",
            "Encargado Clientes",
            "Encargado Proveedores",
            "Encargado Ventas"
        );
	
	public final List<String> contCmb = Arrays.asList(
			"Año",
			"Mes",
			"Día"
		);
	
	public default String getDateFormatted() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }
	
}
