package co.com.createSales.service;

import java.util.List;

import co.com.createSales.dto.ProductDTO;
import co.com.createSales.dto.ProductSaleBySelleDTO;
import co.com.createSales.dto.SalesPersonDTO;

public class SalesMenFileServices {

	private final SalesManFileService salesManFileService;
	
	private final ProductFileServices productFileServices;
		
	public SalesMenFileServices(SalesManFileService salesManFileService, ProductFileServices productFileServices) {
		this.productFileServices = productFileServices;
		this.salesManFileService = salesManFileService;
	}
	
	/**
	 * Method for creating salesMen
	 */
	public void createSalesMenFile(int randomSalesCount, String name, long idProduct) {
		System.out.println("==============================================\n" 
				+ "Iniciando calculo de venta ......");
		
		List<SalesPersonDTO> salesPerson = salesManFileService.listSalesPersons;
		List<ProductDTO> products = productFileServices.listSalesProduct;
		ProductSaleBySelleDTO productSaleBySelleDTO = new ProductSaleBySelleDTO();
		SalesPersonDTO salePerson = null;
		ProductDTO product = null;
		
		if (randomSalesCount <= 0) {
			System.out.println("El valor de ventas a crear no puede ser menor o igual a 0");
			return;
		}
		
		salePerson = validateListSeller(salesPerson, name);
		
		if (salePerson == null) {
			return;
		}
		
		product = validateListProduct(products, idProduct);
		
		if (product == null) {
			return;
		}

		productSaleBySelleDTO.setIdProduct(product.getId());
		productSaleBySelleDTO.setDocumentIdPerson(salePerson.getNumberDocument());
		productSaleBySelleDTO.setNameProduct(product.getProductName());
		productSaleBySelleDTO.setPricePerUnit(product.getPrice());
		productSaleBySelleDTO.setTotalPrice(product.getPrice() * randomSalesCount);
		
		// The information for the sale calculation is printed
		System.out.println("==============================================");
		System.out.println("Producto Id: " + productSaleBySelleDTO.getIdProduct() + "\n"
				+ "Documento de vendedor: " + productSaleBySelleDTO.getDocumentIdPerson() + "\n"
				+ "Nombre de producto: " + productSaleBySelleDTO.getNameProduct() + "\n"
				+ "Valor unidad: " + productSaleBySelleDTO.getPricePerUnit() + "\n"
				+ "Valor Total: " + productSaleBySelleDTO.getTotalPrice() + "\n");
		
		System.out.println("Finaliza el calculo de venta para el producto " + product.getProductName() + "\n"
				+ "==============================================");
	}
	
	public SalesPersonDTO validateListSeller(List<SalesPersonDTO> salesPersons, String name) {	
		
		if (salesPersons == null || salesPersons.isEmpty() ) {
			System.out.println("La lista de vendedores no puede esta vacia");
			return null;
		}
		
	    if (name == null || name.trim().isEmpty()) {
	        System.out.println("El nombre del vendedor no puede ser vacío");
	        return null;
	    }
		
		for (SalesPersonDTO s : salesPersons) {
			if (s.getName().equalsIgnoreCase(name)) {
				return s;
			}
		}
		
		System.out.println("El nombre ingresado para generar las ventas no existe en la lista");
		return null;
	}
	
	public ProductDTO validateListProduct(List<ProductDTO> products, Long idProduct) {
		
		if (products == null || products.isEmpty()) {
			System.out.println("La lista de productos no puede estar vacia");
			return null;
		}
		
		if (idProduct == null) {
			System.out.println("El id de producto debe ser un valor valido");
		}
		
		for (ProductDTO p : products) {
			if (p.getId().equals(idProduct)) {
				return p;
			}
		}
		
		System.out.println("El Id de producto ingresado para generar las ventas no existe en la lista");
		return null;
	}
	
}
