package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreríaVersion2.FIles;

public class ProductDAO implements SettingsEmployee{

private FIles file;
	
	public ProductDAO() {
		super();
		this.file = new FIles(mainPath+inventario);
		file.create(1);
	}
	
	public boolean writeProduct(Product p) throws IOException {
		file.setFile(new File(mainPath,inventario));
		return file.writerFile(p.infoProduct()+"\n", false);
	}
	
	public boolean replaceProduct(Product new_p, String infoProd) throws IOException {
		String [] products = file.readerFile().split("\n");
		boolean flag = false;
		
		for(String product: products) {
			if(product.equals(infoProd)) {
				product = new_p.infoProduct();
				flag = true;
			}
		}
		
		if(flag == false) return false;
		
		file.writerFile("", true);
		
		for(String product: products) {
			file.writerFile(product, false);
		}
		return true;
	}
	
	public List<Product> readProducts() throws IOException{
		List<Product> products = new ArrayList<>();
		file.setFile(new File(mainPath, inventario));
		
		String [] data = file.readerFile().split("\n"); 
		for(String d:data) {
			String [] info = d.split(";");
			Product p = new Product(info[0],//nombre
									info[1],//descripcion
									Double.parseDouble(info[2]),//precio
									Integer.parseInt(info[3]),//stock
									Long.parseLong(info[4]));//dni proveedor
			products.add(p);
		}
		return products;
	}
}
