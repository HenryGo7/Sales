package co.com.createSales.dao;

import java.util.concurrent.ThreadLocalRandom;

import co.com.createSales.dto.ProductDTO;

/**
 * Clase DAO encargada de generar datos simulados de productos.
 * 
 * Permite crear instancias de {@link ProductDTO} con información
 * aleatoria como nombre, identificador y precio.
 * 
 * Se utiliza principalmente para pruebas o generación de datos iniciales.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class CreateProductDAO {
	
	private static final long MIN_ID = 1001L;
	
	private static final long MAX_ID = 2005L;
	
	private static final double MIN_PRICE = 100;
	
	private static final double MAX_PRICE = 999;

    /**
     * Genera un producto con datos aleatorios.
     * 
     * Los datos generados incluyen:
     * - Nombre del producto
     * - Identificador
     * - Precio
     * 
     * @return objeto ProductDTO con información aleatoria
     */
    public ProductDTO generateRamdomProduct() {
                
        String[] namesProduct = {"Laptop", "Smartphone", "Tablet", "Headphones", "Keyboard", "Mouse", "Monitor",
                "Printer", "Webcam", "Microphone", "Smartwatch", "Speaker", "Charger"};
        
        String nameProduct = randomFrom(namesProduct);
        Long IdProduct = ThreadLocalRandom.current().nextLong(MIN_ID, MAX_ID);
        Double price = ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);
        price = Math.round(price * 100.0) / 100.0;

        return new ProductDTO(IdProduct, nameProduct, price);
    }
    
    /**
     * Obtiene un valor aleatorio de un arreglo de Strings.
     * 
     * @param array arreglo de opciones
     * @return elemento aleatorio del arreglo
     */
    private String randomFrom(String[] array) {
    	return array[ThreadLocalRandom.current().nextInt(array.length)];
    }
}