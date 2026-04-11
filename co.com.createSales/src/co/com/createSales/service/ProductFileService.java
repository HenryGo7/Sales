package co.com.createSales.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dao.CreateProductDAO;
import co.com.createSales.dto.ProductDTO;

/**
 * Servicio encargado de la gestión de productos.
 * 
 * Permite crear una lista de productos con datos simulados
 * y almacenarlos en memoria para su posterior uso.
 * 
 * Utiliza la capa DAO para obtener la información de los productos.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ProductFileService {
    
    private final CreateProductDAO createProductDAO;
    
    /** Lista de productos generados */
    private List<ProductDTO> listSalesProduct;
    
    /**
     * Constructor del servicio.
     * 
     * @param createProductDAO objeto DAO para generar productos
     */
    public ProductFileService(CreateProductDAO createProductDAO) {
        this.createProductDAO = createProductDAO;
    }
    
    /**
     * Crea una lista de productos según la cantidad indicada.
     * 
     * Valida que la cantidad sea mayor a cero, genera productos
     * de forma aleatoria usando el DAO y los almacena en memoria.
     * 
     * Además, imprime la información de cada producto en consola
     * en formato de reporte.
     * 
     * @param productsCount cantidad de productos a crear
     */
    public void createProductsInfoFile(int productsCount) {        
        System.out.println("==============================================\n" 
                + "Iniciando la consulta de productos......");
        
        if (productsCount <= 0) {
            System.out.println("El valor de productos a crear no puede ser "
                    + "igual o menor a 0");
            return;
        }        
        
        // Inicializa la lista de productos
        listSalesProduct = new ArrayList<>();
                
        for (int i = 0; i < productsCount; i++) {
            
            ProductDTO product = createProductDAO.generateRamdomProduct();
            
            // Imprime la información del producto
            System.out.println("==============================================");
            System.out.println("Producto Id: " + product.getId() + "\n"
                    + "Nombre: " + product.getProductName() + "\n"
                    + "Precio: " + product.getPrice() + "\n");
            
            listSalesProduct.add(product);
        }
                
        System.out.println("Consulta de productos finalizada......\n" 
                + "==============================================");     
        
        generateFile(listSalesProduct);
    }

    /**
     * Obtiene la lista de productos vendidos.
     * 
     * @return lista de productos
     */
	public List<ProductDTO> getListSalesProduct() {
		return listSalesProduct;
	}

	   /**
     * Asigna la lista de productos vendidos.
     * 
     * @param listSalesProduct lista de productos
     */
	public void setListSalesProduct(List<ProductDTO> listSalesProduct) {
		this.listSalesProduct = listSalesProduct;
	}
    
    /**
     * Creación de un archivo de texto con datos de los vendedores.
     * 
     * @param listSalesPersons lista de vendedores
     */
    public void generateFile(List<ProductDTO> listProduct) {
    	
    	System.out.println("==============================================");
    	System.out.println("Iniciando generación de archivo de productos ");
    	
    	// Creación de valor fecha y hora para nombre de archivo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
    	String dateAndTime = LocalDateTime.now().format(formatter);
    	    	
    	// Se define la estructura para el nombre del archivo
    	String fileName = "product-" + dateAndTime + ".txt";
    	Path rute = Paths.get("files/input/product");
    	Path ruteFile = rute.resolve(fileName);
    	
    	try {
    		
    		List<String> lines = new ArrayList<>();
    		
    		for (ProductDTO product : listProduct) {
    			
    		String data = product.getId()
    				+ ";" + product.getProductName()
    				+ ";" + product.getPrice();
    			
    			lines.add(data);
    		}    		

    		// Generación del archivo
    		
    		Files.createDirectories(rute);
    		Files.write(ruteFile, lines);
    		
    		System.out.println("Archivo " + fileName + " generado correctamente");
    		System.out.println("==============================================");
			
		} catch (Exception e) {
			System.err.println("Error creando el archivo product : " + e.getMessage());
		}    	
    }
}