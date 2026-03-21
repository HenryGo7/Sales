package co.com.createSales.service;

import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dao.CreatePersonDAO;
import co.com.createSales.dto.SalesPersonDTO;

public class SalesManFileService {

	private final CreatePersonDAO createPersonDAO;
	
	public List<SalesPersonDTO> listSalesPersons;
	
	public SalesManFileService(CreatePersonDAO createPersonDAO) {
		this.createPersonDAO = createPersonDAO;
	}
	
	/**
	 * Method for creating sellers
	 */
	public void createSalesManInfoFile(int salesmanCount) {		
		System.out.println("==============================================\n"
				+ "Iniciando la creación de vendedores......");
		
		if (salesmanCount <= 0) {
			System.out.println("La cantidad de vendedores a crear no "
					+ "puede ser igual o menor a 0");
			return;
		}		
		
		// Sellers are obtained from the DAO layer (simulates a data source)
		listSalesPersons =  new ArrayList<SalesPersonDTO>();
		
		int personNumber = 1;
		
		for (int i = 0; i < salesmanCount; i++) {
			
			SalesPersonDTO person = createPersonDAO.generateRandomSalesPerson();
			
			// The seller information is printed in a readable report-like format
			System.out.println("==============================================");
			System.out.println("Persona número: "+ personNumber + "\n" 
					+ "Nombre: " + person.getName() + "\n"
					+ "Apellido: " + person.getLastName() + "\n"
					+ "Tipo de documento: " + person.getDocumentType() + "\n"
					+ "Número de documento: " + person.getNumberDocument() + "\n");
			personNumber ++;
			
			listSalesPersons.add(person);
		}
				
		System.out.println("Creación de vendedores completada......\n" 
				+ "==============================================");		
	}

	public List<SalesPersonDTO> getListSalesPersons() {
		return listSalesPersons;
	}

	public void setListSalesPersons(List<SalesPersonDTO> listSalesPersons) {
		this.listSalesPersons = listSalesPersons;
	}
	
}
