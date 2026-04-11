package co.com.createSales.main;

import java.util.List;
import java.util.Random;

import co.com.createSales.dao.CreatePersonDAO;
import co.com.createSales.dao.CreateProductDAO;
import co.com.createSales.dto.SalesPersonDTO;
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
		
		int numberSellers = 8;
		
		List<SalesPersonDTO> listSalesPersons = salesPersonService.createSalesManInfoFile(numberSellers);
		
		int numberProducts = 10;
		
		productFileServices.createProductsInfoFile(numberProducts);
		
		for (SalesPersonDTO salesPersonData : listSalesPersons) {	
			
			Random random = new Random();
			int randomValue = random.nextInt(10) + 1;			
			
			salesMenFileServices.createSalesMenFile(
					randomValue,
					salesPersonData.getName() , 
					salesPersonData.getNumberDocument());
		}
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
