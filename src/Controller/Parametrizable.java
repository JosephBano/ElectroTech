package Controller;

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
	
	public default boolean validateFields(View.View_Clientes vc){
		if(vc.txt_Name.getText().matches(ERNamesCLient) && vc.txt_Address.getText().matches(ERAddress) && vc.txt_ContactDetails.getText().matches(EREmailClient)){
            return true;
        }
        return false;
	};
	
}
