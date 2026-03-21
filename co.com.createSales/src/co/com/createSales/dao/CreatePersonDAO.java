package co.com.createSales.dao;

import java.util.concurrent.ThreadLocalRandom;

import co.com.createSales.dto.SalesPersonDTO;

public class CreatePersonDAO {
	
	public SalesPersonDTO generateRandomSalesPerson() {
		
		String[] documentTypes = {"CC", "CE"};
		
        String[] names = {"Juan", "Carlos", "Luis", "Andres", "Pedro", "Mauricio", "Mateo",
                "Maria", "Ana", "Luisa", "Sofia", "Valentina", "Julina", "Camila"};
        
        String[] lastNames = {"Gomez", "Rodriguez", "Perez", "Lopez", "Valencia", "Sanchez",
                "Martinez", "Garcia", "Hernandez"};
        
        String documentType = randomFrom(documentTypes);
        Long documentNumber = ThreadLocalRandom.current().nextLong(100100L, 2005988L);
        String name = randomFrom(names);
        String lastName = randomFrom(lastNames);
				
		return new SalesPersonDTO(documentType, documentNumber, name, lastName);
	}
	
    private String randomFrom(String[] array) {
        return array[ThreadLocalRandom.current().nextInt(array.length)];
    }

}
