package co.com.createSales.main;


import java.util.Scanner;

import javax.swing.JOptionPane;

import co.com.createSales.dao.CreatePersonDAO;
import co.com.createSales.dao.CreateProductDAO;
import co.com.createSales.service.ProductFileService;
import co.com.createSales.service.SalesManFileService;
import co.com.createSales.service.SalesMenFileServices;

/**
 * Clase principal del programa.
 * Se encarga de solicitar datos al usuario y generar archivos
 * de vendedores, productos y ventas.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class GenerateInfoFiles {

    /**
     * Método principal que ejecuta el flujo del programa.
     * 
     * Solicita al usuario:
     * - Cantidad de vendedores
     * - Cantidad de productos
     * - ID del producto
     * - Cantidad vendida
     * - Nombre del vendedor
     * 
     * Luego genera los archivos correspondientes.
     * 
     * @param args argumentos de entrada (no usados)
     */
	public static void main(String[] args) {
				
		CreatePersonDAO createPersonDAO = new CreatePersonDAO();
		SalesManFileService salesPersonService = new SalesManFileService(createPersonDAO);
		
		CreateProductDAO createProductDAO = new CreateProductDAO();
		ProductFileService productFileServices = new ProductFileService(createProductDAO);
		
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
	
    /**
     * Valida si el valor ingresado es un número entero.
     * 
     * @param input valor a validar
     * @return true si es número válido, false si no
     */
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
	
    /**
     * Valida si el valor ingresado es un número tipo Long.
     * 
     * @param input valor a validar
     * @return true si es número válido, false si no
     */
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
