package co.com.createSales.dto;

import java.util.List;

/**
 * Objeto de transferencia de datos (DTO) que representa un archivo
 * recuperado de vendedores.
 * 
 * Contiene el nombre del archivo
 * Contiene un lista con la información básica del vendedor 
 * como tipo de documento, número de documento, nombre y apellido.
 * 
 * Se utiliza para transportar datos entre las diferentes capas del sistema.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ReadFileSalesPersonDTO {

	 /** nombre del archivo recuperado */
	String fileName;
	
	 /** Lista de vendedores */
	List<SalesPersonDTO> listPerson;

    /**
     * Constructor vacío.
     */
	 public ReadFileSalesPersonDTO() {
		super();
	 }

	    /**
	     * Constructor con parámetros.
	     * 
	     * @param fileName nombre de archivo
	     * @param listPerson lista de vendedores
	     *
	     */
	 public ReadFileSalesPersonDTO(String fileName, List<SalesPersonDTO> listPerson) {
		super();
		this.fileName = fileName;
		this.listPerson = listPerson;
	 }

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public List<SalesPersonDTO> getListPerson() {
			return listPerson;
		}

		public void setListPerson(List<SalesPersonDTO> listPerson) {
			this.listPerson = listPerson;
		}

		@Override
		public String toString() {
			return "ReadFileSalesPersonDTO [nameFile=" + fileName + ", listPerson=" + listPerson + "]";
		}
		
}
