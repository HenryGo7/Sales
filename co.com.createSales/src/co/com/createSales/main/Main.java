package co.com.createSales.main;


import java.util.List;

import co.com.createSales.dto.ReadFileProductDTO;
import co.com.createSales.dto.ReadFileProductSaleBySellerDTO;
import co.com.createSales.dto.ReadFileSalesPersonDTO;
import co.com.createSales.service.ReadFilesService;
import co.com.createSales.service.ReportsService;

/**
 * Clase secundaria del programa.
 * 
 * <p>Se encarga de ejecutar el flujo completo del sistema:
 * lectura de archivos, procesamiento de información
 * y generación de reportes.</p>
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * <p>Realiza las siguientes acciones:
     * <ul>
     *   <li>Lee archivos de vendedores</li>
     *   <li>Lee archivos de productos</li>
     *   <li>Lee archivos de ventas por vendedor</li>
     *   <li>Genera reportes en formato CSV</li>
     * </ul>
     * </p>
     *
     * @param args argumentos de entrada (no utilizados)
     */
	public static void main(String[] args) {
		
		ReadFilesService readFilesServices = new ReadFilesService();
		ReportsService reportsService = new ReportsService();
		
		ReadFileSalesPersonDTO salesPerson = readFilesServices.readFilePerson();
		ReadFileProductDTO product = readFilesServices.readFileProduct();
		List<ReadFileProductSaleBySellerDTO> listProductSaleBySeller = readFilesServices.readFilesProductSaleBySeller();
		
		reportsService.createReports(salesPerson, product, listProductSaleBySeller);
		
	}

}
