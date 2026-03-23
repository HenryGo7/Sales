package co.com.createSales.service;

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
    public void createSalesManInfoFile(int salesmanCount) {        
        System.out.println("==============================================\n"
                + "Iniciando la creación de vendedores......");
        
        if (salesmanCount <= 0) {
            System.out.println("La cantidad de vendedores a crear no "
                    + "puede ser igual o menor a 0");
            return;
        }        
        
        // Inicializa la lista de vendedores
        listSalesPersons = new ArrayList<>();
        
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
                
        System.out.println("Creación de vendedores completada......\n" 
                + "==============================================");        
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
}