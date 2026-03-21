package co.com.createSales.main;


import java.util.Scanner;

import javax.swing.JOptionPane;

import co.com.createSales.dao.CreatePersonDAO;
import co.com.createSales.dao.CreateProductDAO;
import co.com.createSales.service.ProductFileServices;
import co.com.createSales.service.SalesManFileService;
import co.com.createSales.service.SalesMenFileServices;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		CreatePersonDAO createPersonDAO = new CreatePersonDAO();
		SalesManFileService salesPersonService = new SalesManFileService(createPersonDAO);
		
		CreateProductDAO createProductDAO = new CreateProductDAO();
		ProductFileServices productFileServices = new ProductFileServices(createProductDAO);
		
		SalesMenFileServices salesMenFileServices = new SalesMenFileServices(salesPersonService, productFileServices);
		
		String numberSellers = JOptionPane.showInputDialog("Ingrese la cantidad de vendedores");
		
		if (!isNumber(numberSellers)) {
			System.out.println("Debe ingresar un valor numerico");
			return;
		}
		
		salesPersonService.createSalesManInfoFile(Integer.parseInt(numberSellers));
		
		String numberProducts = JOptionPane.showInputDialog("Ingrese la cantidad de productos");
		
		if (!isNumber(numberProducts)) {
			System.out.println("Debe ingresar un valor numerico");
			return;
		}
		
		productFileServices.createProductsInfoFile(Integer.parseInt(numberProducts));
		
		String idProduct = JOptionPane.showInputDialog("Ingrese el id de producto");
		
		if (!isLong(idProduct)) {
			System.out.println("Debe ingresar un valor numerico");
			return;
		}
		
		String salesQuantity = JOptionPane.showInputDialog("Ingrese la cantidad de venta realizada");
		
		if (!isNumber(salesQuantity)) {
			System.out.println("Debe ingresar un valor numerico");
			return;
		}
						
		String sellerName = JOptionPane.showInputDialog("Ingrese el nombre del vendedor");
		
		salesMenFileServices.createSalesMenFile(
				Integer.parseInt(salesQuantity),
				sellerName , 
				Long.parseLong(idProduct));
	}
	
	public static boolean isNumber(String input) {
	    if (input == null || input.trim().isEmpty()) {
	        return false;
	    }

	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean isLong(String input) {
	    if (input == null || input.trim().isEmpty()) {
	        return false;
	    }

	    try {
	        Long.parseLong(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
}
