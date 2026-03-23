package co.com.createSales.dao;

import java.util.concurrent.ThreadLocalRandom;

import co.com.createSales.dto.SalesPersonDTO;

/**
 * Clase DAO encargada de generar datos simulados de vendedores.
 * 
 * Permite crear instancias de {@link SalesPersonDTO} con información
 * aleatoria para pruebas o carga inicial de datos.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class CreatePersonDAO {
	
	private static final long MIN_DOCUMENT = 100100L;
	
	private static final long MAX_DOCUMENT = 2005988L;
    
    /**
     * Genera un vendedor con datos aleatorios.
     * 
     * Los datos generados incluyen:
     * - Tipo de documento
     * - Número de documento
     * - Nombre
     * - Apellido
     * 
     * @return objeto SalesPersonDTO con información aleatoria
     */
    public SalesPersonDTO generateRandomSalesPerson() {
        
        String[] documentTypes = {"CC", "CE"};
        
        String[] names = {"Juan", "Carlos", "Luis", "Andres", "Pedro", "Mauricio", "Mateo",
                "Maria", "Ana", "Luisa", "Sofia", "Valentina", "Julina", "Camila"};
        
        String[] lastNames = {"Gomez", "Rodriguez", "Perez", "Lopez", "Valencia", "Sanchez",
                "Martinez", "Garcia", "Hernandez"};
        
        String documentType = randomFrom(documentTypes);
        Long documentNumber = ThreadLocalRandom.current().nextLong(MIN_DOCUMENT, MAX_DOCUMENT);
        String name = randomFrom(names);
        String lastName = randomFrom(lastNames);
                
        return new SalesPersonDTO(documentType, documentNumber, name, lastName);
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