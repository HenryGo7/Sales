package co.com.createSales.dao;

import java.util.concurrent.ThreadLocalRandom;

import co.com.createSales.dto.ProductDTO;

public class CreateProductDAO {

	public ProductDTO generateRamdomProduct() {
				
        String[] namesProduct = {"Laptop", "Smartphone", "Tablet", "Headphones", "Keyboard", "Mouse", "Monitor",
                "Printer", "Webcam", "Microphone", "Smartwatch", "Speaker", "Charger"};
        
        String nameProduct = randomFrom(namesProduct);
        Long IdProduct = ThreadLocalRandom.current().nextLong(1001L, 2005L);
        Double price = ThreadLocalRandom.current().nextDouble(100, 999);
        price = Math.round(price * 100.0) / 100.0;

        return new ProductDTO(IdProduct, nameProduct, price);
	}
	
    private String randomFrom(String[] array) {
        return array[ThreadLocalRandom.current().nextInt(array.length)];
    }
}
