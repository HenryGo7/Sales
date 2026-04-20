package co.com.createSales.service;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dto.ProductDTO;
import co.com.createSales.dto.ProductReportDTO;
import co.com.createSales.dto.ReadFileProductDTO;
import co.com.createSales.dto.ReadFileProductSaleBySellerDTO;
import co.com.createSales.dto.ReadFileSalesPersonDTO;
import co.com.createSales.dto.SalesPersonDTO;
import co.com.createSales.dto.SellerReportDTO;

/**
 * Servicio encargado de generar reportes a partir de la información
 * de vendedores, productos y ventas.
 * 
 * <p>Este servicio procesa los datos y genera reportes en formato CSV
 * tanto por vendedor como por producto.</p>
 */
public class ReportsService {

    /**
     * Orquesta la creación de todos los reportes del sistema.
     *
     * @param salesPerson información de vendedores
     * @param product información de productos
     * @param listProductSaleBySeller lista de ventas por vendedor
     */
	public void createReports(ReadFileSalesPersonDTO salesPerson , ReadFileProductDTO product, 
			List<ReadFileProductSaleBySellerDTO> listProductSaleBySeller) {
		
	    System.out.println("==============================================");
	    System.out.println("Iniciando la creación de reportes");
	    System.out.println("==============================================");
	    
	    List<SellerReportDTO> listSellerReport = reportSeller(salesPerson.getListPerson(),
	    		product.getListProduct(), listProductSaleBySeller);
	    
	    List<ProductReportDTO> listProductReport = reportProduct(product.getListProduct(), listProductSaleBySeller);
	    
	    createReportSeller(listSellerReport);
	    createReportProduct(listProductReport);
	    
	    System.out.println("==============================================");
	    System.out.println("Finaliza la creación de reportes");
	    System.out.println("==============================================");
	}
	
    /**
     * Genera el reporte de ventas totales por vendedor.
     *
     * <p>Calcula el total de dinero vendido por cada vendedor
     * sumando el valor de los productos vendidos.</p>
     *
     * @param listPerson lista de vendedores
     * @param listProduct lista de productos
     * @param listProductSaleBySeller lista de ventas por vendedor
     * @return lista de reportes por vendedor
     */
	public List<SellerReportDTO> reportSeller(List<SalesPersonDTO> listPerson, List<ProductDTO> listProduct, 
			List<ReadFileProductSaleBySellerDTO> listProductSaleBySeller) {
		
	    System.out.println("==============================================");
	    System.out.println("Consultando datos para el reporte dinero total de ventas por vendedor");
	    System.out.println("\n");
	    
	    List<SellerReportDTO> listSellerReport = new ArrayList<>();
	    
	    for (SalesPersonDTO seller : listPerson) {
	    	SellerReportDTO sellerReport = new SellerReportDTO();
	    		    	
	    	Double total = 0.0;
	    	Long documentId = seller.getNumberDocument();
	    	String nameSeller = seller.getName() + " " + seller.getLastName();
	    	
	    	System.out.println("Documento de vendedor: " + documentId);

	        total = listProductSaleBySeller.stream()
	                .filter(p -> p.getProductSaleBySeller().getDocumentIdPerson().equals(documentId))
	                .flatMap(i -> i.getProductSaleBySeller().getListProductItemDTO().stream())
	                .map(x -> {
	                    ProductDTO product = listProduct.stream()
	                        .filter(y -> x.getIdProduct().equals(y.getId()))
	                        .findFirst()
	                        .orElse(null);

	                    if (product == null) return 0.0;

	                    return product.getPrice() * x.getSalesQuantity();
	                })
	                .reduce(0.0, Double::sum);

	        Double roundedTotal = Math.round(total * 100.0) / 100.0;
	        
	        System.out.println("Vendedor: " + nameSeller);
	        System.out.println("Total ventas: " + roundedTotal);
	        System.out.println("\n");
	            
	        sellerReport.setDocumentId(documentId);
	        sellerReport.setNameSeller(nameSeller);
	        sellerReport.setTotalAmount(roundedTotal);
	        
	        listSellerReport.add(sellerReport);
	    }
	    
	    listSellerReport.sort((a, b) -> Double.compare(a.getTotalAmount(), b.getTotalAmount()));
	    
	    System.out.println("Finaliza el proceso para generar los datos del reporte");
	    System.out.println("==============================================");

	    return listSellerReport;
	}
	
    /**
     * Genera el reporte de cantidad de productos vendidos.
     *
     * <p>Calcula cuántas unidades se han vendido por cada producto
     * en todos los vendedores.</p>
     *
     * @param listProduct lista de productos
     * @param listProductSaleBySeller lista de ventas por vendedor
     * @return lista de reportes por producto
     */
	public List<ProductReportDTO> reportProduct(List<ProductDTO> listProduct, 
			List<ReadFileProductSaleBySellerDTO> listProductSaleBySeller) {
		
	    System.out.println("==============================================");
	    System.out.println("Consultando datos para el reporte de cantidad de ventas por producto");
	    System.out.println("\n");
	    
	    List<ProductReportDTO> listProductReport = new ArrayList<>();
	    
	    for (ProductDTO product : listProduct) {
	    	ProductReportDTO productReport = new ProductReportDTO();
	    	
	    	Long productoId = product.getId();
	    	String productName = product.getProductName();
	    	Double priceProduct = product.getPrice();
	    	
	    	System.out.println("Id de Producto: " + productoId);
	    	
	        int totalProduct = listProductSaleBySeller.stream()
	                .flatMap(p -> p.getProductSaleBySeller()
	                    .getListProductItemDTO().stream())
	                .filter(x -> x.getIdProduct().equals(productoId))
	                .mapToInt(x -> x.getSalesQuantity())
	                .sum();
	        
	        System.out.println("Cantidad total de producto vendido:" + totalProduct);
	        System.out.println("\n");
	        
	        productReport.setProductId(productoId);
	        productReport.setProductName(productName);
	        productReport.setProductPrice(priceProduct);
	        productReport.setTotalProductSold(totalProduct);
	        
	        listProductReport.add(productReport);
	    }
	    
	    listProductReport.sort((a, b) -> Integer.compare(b.getTotalProductSold(), a.getTotalProductSold()));
	    
	    System.out.println("Finaliza el proceso para generar los datos del reporte");
	    System.out.println("==============================================");
	    
	    return listProductReport;
	}
	
    /**
     * Genera un archivo CSV con el reporte de ventas por vendedor.
     *
     * <p>El archivo se guarda en la ruta:
     * <pre>files/reports/sellerSale/</pre></p>
     *
     * @param listReportSeller lista de reportes por vendedor
     * @throws RuntimeException si ocurre un error al escribir el archivo
     */
	public void createReportSeller(List<SellerReportDTO> listReportSeller) {
				
    	// Creación de valor fecha y hora para nombre de archivo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
    	String dateAndTime = LocalDateTime.now().format(formatter);
    	
    	// Se define la estructura para el nombre del archivo
    	String fileName = "sellerReport-" + dateAndTime + ".csv";
    	String filePath = "files/reports/sellerSale/" + fileName;
		
		try (BufferedWriter write = Files.newBufferedWriter(Paths.get(filePath))) {
			
			// Cabecera
			write.write("Numero_Documento;Nombre_Vendedor;Total_Venta");
			write.newLine();
			
			for (SellerReportDTO report : listReportSeller) {
				String line = report.getDocumentId().toString() + ";" +
						report.getNameSeller() + ";" + report.getTotalAmount().toString();
				
				write.write(line);
				write.newLine();
			}
			
			System.out.println("Archivo Ventas Por Vendedor CSV generado correctamente");
			
		} catch (Exception e) {
			throw new RuntimeException("Error escribiendo CSV", e);
		}
	}
	
    /**
     * Genera un archivo CSV con el reporte de productos vendidos.
     *
     * <p>El archivo se guarda en la ruta:
     * <pre>files/reports/productsByQuantitySold/</pre></p>
     *
     * @param listProductReport lista de reportes por producto
     * @throws RuntimeException si ocurre un error al escribir el archivo
     */
	public void createReportProduct(List<ProductReportDTO> listProductReport) {
		
    	// Creación de valor fecha y hora para nombre de archivo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
    	String dateAndTime = LocalDateTime.now().format(formatter);
    	
    	// Se define la estructura para el nombre del archivo
    	String fileName = "productReport-" + dateAndTime + ".csv";
    	String filePath = "files/reports/productsByQuantitySold/" + fileName;
		
		try (BufferedWriter write = Files.newBufferedWriter(Paths.get(filePath))) {
			
			// Cabecera
			
			write.write("Id_Producto;Nombre;Cantidad;Precio_Unidad");
			write.newLine();
			
			for (ProductReportDTO report : listProductReport) {
				String line = report.getProductId().toString() + ";" +
						report.getProductName() + ";" + 
						report.getTotalProductSold() + ";" + 
						report.getProductPrice();
				
				write.write(line);
				write.newLine();
			}
			
			System.out.println("Archivo Cantidad de Productos Vendidos CSV generado correctamente");
			
		} catch (Exception e) {
			throw new RuntimeException("Error escribiendo CSV", e);
		}
	}
}
