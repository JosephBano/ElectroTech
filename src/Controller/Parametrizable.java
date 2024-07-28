package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	//ER para clientes
	public static String ERNamesCLient = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s){3}[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	public static String EREmailClient = "^[\\w._%+-]+@(gmail|hotmail|outlook|est|ups)\\.(com|ec|ups\\.edu\\.ups|ec)$";
	public static String ERAddress = "^[A-Z]{1}[A-Za-z0-9\\s,\\-\\.#]+$";
	
	//ER para Proveedor
	public static String ERNamesProvider = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s)[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";
	public static String EREmailProvider = "^[\\w._%+-]+@(gmail|hotmail|outlook|est|ups)\\.(com|ec|ups\\.edu\\.ups|ec)$";
	public static String ERRuc = "^(\\d{10})(001)$";
	public static String ERPhone = "^([\\(]?0[2-7][\\)]?[\\s-]?\\d{4}[\\s-]?\\d{3})$";
	public static String ERPhonenumber = "^[09][0-9]{8}$";
	
	public final List<String> userRoll = Arrays.asList(
            "Encargado Inventario",
            "Encargado Clientes",
            "Encargado Proveedores",
            "Encargado Ventas"
        );
	
	public default String getDateFormatted() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }
	
}
