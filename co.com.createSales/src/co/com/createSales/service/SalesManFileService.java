package co.com.createSales.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dao.CreatePersonDAO;
import co.com.createSales.dto.SalesPersonDTO;

/**
 * Servicio encargado de la gestión de vendedores.
 * 
 * Permite crear una lista de vendedores con datos simulados
 * y almacenarlos en memoria para su posterior uso.
 * 
 * Utiliza la capa DAO para obtener la información de los vendedores.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class SalesManFileService {

    private final CreatePersonDAO createPersonDAO;
    
    /** Lista de vendedores generados */
    private List<SalesPersonDTO> listSalesPersons;
    
    /**
     * Constructor del servicio.
     * 
     * @param createPersonDAO objeto DAO para generar vendedores
     */
    public SalesManFileService(CreatePersonDAO createPersonDAO) {
        this.createPersonDAO = createPersonDAO;
    }
    
    /**
     * Crea una lista de vendedores según la cantidad indicada.
     * 
     * Valida que la cantidad sea mayor a cero, genera vendedores
     * de forma aleatoria usando el DAO y los almacena en memoria.
     * 
     * Además, imprime la información de cada vendedor en consola
     * en formato de reporte.
     * 
     * @param salesmanCount cantidad de vendedores a crear
     */
    public List<SalesPersonDTO> createSalesManInfoFile(int salesmanCount) {        
        System.out.println("==============================================\n"
                + "Iniciando la consulta de vendedores......");
        
        // Inicializa la lista de vendedores
        listSalesPersons = new ArrayList<>();
        
        if (salesmanCount <= 0) {
            System.out.println("La cantidad de vendedores a crear no "
                    + "puede ser igual o menor a 0");
            return listSalesPersons;
        }        
                
        int personNumber = 1;
        
        for (int i = 0; i < salesmanCount; i++) {
            
            SalesPersonDTO person = createPersonDAO.generateRandomSalesPerson();
            
            // Imprime la información del vendedor
            System.out.println("==============================================");
            System.out.println("Persona número: " + personNumber + "\n" 
                    + "Nombre: " + person.getName() + "\n"
                    + "Apellido: " + person.getLastName() + "\n"
                    + "Tipo de documento: " + person.getDocumentType() + "\n"
                    + "Número de documento: " + person.getNumberDocument() + "\n");
            personNumber++;
            
            listSalesPersons.add(person);
        }
                
        System.out.println("Consulta de vendedores completada......\n" 
                + "=============================================="); 
        
        generateFile(listSalesPersons);

        
        return listSalesPersons;
    }

    /**
     * Obtiene la lista de vendedores generados.
     * 
     * @return lista de vendedores
     */
    public List<SalesPersonDTO> getListSalesPersons() {
        return listSalesPersons;
    }

    /**
     * Asigna la lista de vendedores.
     * 
     * @param listSalesPersons lista de vendedores
     */
    public void setListSalesPersons(List<SalesPersonDTO> listSalesPersons) {
        this.listSalesPersons = listSalesPersons;
    }
    
    /**
     * Creación de un archivo de texto con datos de los vendedores.
     * 
     * @param listSalesPersons lista de vendedores
     */
    public void generateFile(List<SalesPersonDTO> salesPerson) {
    	
    	System.out.println("==============================================");
    	System.out.println("Iniciando generación de archivo de vendedores");
    	
    	// Creación de valor fecha y hora para nombre de archivo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
    	String dateAndTime = LocalDateTime.now().format(formatter);
    	    	
    	// Se define la estructura para el nombre del archivo
    	String fileName = "salesPerson-" + dateAndTime + ".txt";
    	Path rute = Paths.get("files/input/salesPerson");
    	Path ruteFile = rute.resolve(fileName);
    	
    	try {
    		
    		List<String> lines = new ArrayList<>();
    		
    		for (SalesPersonDTO person : salesPerson) {
    			
    		String data = person.getDocumentType()
    				+ ";" + person.getNumberDocument()
    				+ ";" + person.getName()
    				+ ";" + person.getLastName();
    			
    			lines.add(data);
    		}    		

    		// Generación del archivo
    		
    		Files.createDirectories(rute);
    		Files.write(ruteFile, lines);
    		
    		System.out.println("Archivo " + fileName + " generado correctamente");
    		System.out.println("==============================================");
			
		} catch (Exception e) {
			System.err.println("Error creando el archivo salesPerson : " + e.getMessage());
		}    	
    }
}