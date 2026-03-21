package co.com.createSales.service;

import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dao.CreateProductDAO;
import co.com.createSales.dto.ProductDTO;

public class ProductFileServices {
	
	private final CreateProductDAO createProductDAO;
	
	public List<ProductDTO> listSalesProduct;
	
	public ProductFileServices(CreateProductDAO createProductDAO) {
		this.createProductDAO = createProductDAO;
	}
	
	/**
	 * Method for creating product
	 */
	public void createProductsInfoFile(int productsCount) {		
		System.out.println("==============================================\n" 
				+ "Iniciando la creación de productos......");
		
		if (productsCount <= 0) {
			System.out.println("El valor de productos a crear no puede ser "
					+ "igual o menor a 0");
			return;
		}		
		
		// Products are obtained from the DAO layer (simulates a data source)
		listSalesProduct =  new ArrayList<ProductDTO>();
				
		for (int i = 0; i < productsCount; i++) {
			
			ProductDTO product = createProductDAO.generateRamdomProduct();
			
			// The product information is printed in a readable report-like format
			System.out.println("==============================================");
			System.out.println("Producto Id: " + product.getId() + "\n"
					+ "Nombre: " + product.getProductName() + "\n"
					+ "Precio: " + product.getPrice() + "\n");
			
			listSalesProduct.add(product);
		}
				
		System.out.println("Creación de productos finalizada......\n" 
				+ "==============================================");		
	}
	
}
