package co.com.createSales.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import co.com.createSales.dto.ProductDTO;
import co.com.createSales.dto.ProductSaleBySellerDTO;
import co.com.createSales.dto.SalesPersonDTO;

/**
 * Servicio encargado de la gestión de ventas.
 * 
 * Permite validar vendedores y productos existentes,
 * y calcular el valor total de una venta.
 * 
 * Utiliza los servicios de vendedores y productos
 * para obtener la información necesaria.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class SalesMenFileServices {
    
    private final ProductFileService productFileServices;
    
    private final SalesManFileService salesManFileService;
        
    /**
     * Constructor del servicio de ventas.
     * 
     * @param salesManFileService servicio de vendedores
     * @param productFileServices servicio de productos
     */
    public SalesMenFileServices(SalesManFileService salesManFileService, ProductFileService productFileServices) {
        this.productFileServices = productFileServices;
        this.salesManFileService = salesManFileService;
    }
    
    /**
     * Realiza el cálculo de una venta.
     * 
     * Valida que el vendedor y el producto existan,
     * y calcula el valor total según la cantidad indicada.
     * 
     * Luego imprime el resultado en consola.
     * 
     * @param randomSalesCount cantidad de productos vendidos
     * @param name nombre del vendedor
     * @param documentId documento de identidad del vendedor
     */
    public void createSalesMenFile(int randomSalesCount, String name, long documentId) {
        System.out.println("==============================================\n" 
                + "Iniciando calculo de venta ......");
        System.out.println("Documento del vendedor: " + documentId);
        System.out.println("Cantidad de tipo de productos: " + randomSalesCount);
        
        List<ProductDTO> products = new ArrayList<ProductDTO>(productFileServices.getListSalesProduct());
        List<SalesPersonDTO> salesPersons = salesManFileService.getListSalesPersons();
        ProductSaleBySellerDTO productSaleBySelleDTO = new ProductSaleBySellerDTO();
                       
        if (randomSalesCount <= 0) {
            System.err.println("El valor de ventas a crear no puede ser menor o igual a 0");
            return;
        }
        
        SalesPersonDTO dataPerson = salesPersons.stream()
        		.filter( person -> person.getNumberDocument().equals(documentId))
        		.findFirst()
        		.orElse(null);
        
        if (dataPerson == null) {
            System.err.println("Error: No se encontró el vendedor con documento: " + documentId);
            return;
        }
        
    	productSaleBySelleDTO.setDocumentType(dataPerson.getDocumentType());
    	productSaleBySelleDTO.setDocumentIdPerson(dataPerson.getNumberDocument());
    	
    	int itemsToSell = Math.min(randomSalesCount, products.size());
    	Random random = new Random();
    	Collections.shuffle(products);    
                
        for (int i = 0; i < itemsToSell; i++) {
        	// Obtenemos el producto de la lista barajada
            ProductDTO currentProduct = products.get(0);        	
			
			int randomValue = random.nextInt(20) + 1;	

			productSaleBySelleDTO.addSaleItem(currentProduct.getId(), randomValue);
        	
			// Removemos para no repetir el producto en el mismo reporte
        	products.remove(0);
        }

        
        // Imprime la información de la venta
        System.out.println("==============================================");
        System.out.println("Tipo documento: " + productSaleBySelleDTO.getDocumentType() + "\n"
                + "Documento de vendedor: " + productSaleBySelleDTO.getDocumentIdPerson());
        System.out.println("Id Producto -- Cantidad vendido");
        
        productSaleBySelleDTO.getListProductItemDTO().forEach(data -> {
        	System.out.println("   " + data.getIdProduct() + "             " + data.getSalesQuantity());
        });
        
        System.out.println("Finaliza el calculo de venta para el vendedor " + productSaleBySelleDTO.getDocumentIdPerson() + "\n"
                + "==============================================");
        System.out.println("Enviando datos para generación de archivo plano");
        
        generateSalesFile(productSaleBySelleDTO);
    }
    
    /**
     * Generación de archivo ventas por vendedor
     * 
     * @param saleProduct objeto producto vendido por vendedor
     */
    public void generateSalesFile(ProductSaleBySellerDTO productSale) {
    	
    	System.out.println("==============================================");
    	System.out.println("Iniciando generación de archivo de venta");
    	System.out.println(".........");
    	System.out.println("Identificación de vendedor: " + productSale.getDocumentIdPerson());
    	System.out.println(".........");
    	
    	// Creación de valor fecha y hora para nombre de archivo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
    	String dateAndTime = LocalDateTime.now().format(formatter);
    	
    	// Se define la estructura para el nombre del archivo
    	String fileName = productSale.getDocumentIdPerson() + "-" + dateAndTime + ".txt";
    	Path rute = Paths.get("files/output/productoSalesBySaller");
    	Path ruteFile = rute.resolve(fileName);
    	
    	try {
    		// Se realiza la conversión del objeto a una trama del tipo string
    		String data = productSale.getDocumentType() 
    				+ ";" + productSale.getDocumentIdPerson();
    		
    		StringBuilder dataBuilder = new StringBuilder();
    		
    		productSale.getListProductItemDTO().forEach(p -> {
    			dataBuilder.append(p.getIdProduct())
                .append(";")
                .append(p.getSalesQuantity())
                .append("\n");
    		});
    		
    		data = data + dataBuilder;
    				
    		List<String> lines = Collections.singletonList(data);
    		
			// Generación del archivo
    		
    		Files.createDirectories(rute);
    		Files.write(ruteFile, lines);
    		
    		System.out.println("Archivo " + fileName + " generado correctamente");
    		System.out.println("==============================================");
    		
		} catch (Exception e) {
			System.err.println("Error creando el archivo: " + e.getMessage());
		}
    }
}