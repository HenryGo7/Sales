package co.com.createSales.service;

import java.io.BufferedReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.com.createSales.dto.ProductDTO;
import co.com.createSales.dto.ProductSaleBySellerDTO;
import co.com.createSales.dto.ReadFileProductDTO;
import co.com.createSales.dto.ReadFileProductSaleBySellerDTO;
import co.com.createSales.dto.ReadFileSalesPersonDTO;
import co.com.createSales.dto.SalesPersonDTO;
import co.com.createSales.dto.ProductSaleBySellerDTO.ProductItemDTO;

/**
 * Servicio encargado de leer y procesar archivos planos
 * relacionados con vendedores, productos y ventas.
 * 
 * <p>Este servicio accede a carpetas específicas del sistema,
 * valida los archivos por fecha y estructura, y transforma la
 * información en objetos DTO.</p>
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ReadFilesService {
	
    /**
     * Lee el archivo de vendedores desde la carpeta configurada.
     * 
     * <p>Valida que exista un único archivo, que sea del día actual
     * y transforma cada línea en un objeto {@link SalesPersonDTO}.</p>
     * 
     * @return objeto con el nombre del archivo y la lista de vendedores
     * @throws RuntimeException si no hay archivos, hay más de uno o ocurre un error
     */
	public ReadFileSalesPersonDTO readFilePerson() {		

		ReadFileSalesPersonDTO readFileDTO = new ReadFileSalesPersonDTO();
		List<SalesPersonDTO> listSalePerson = new ArrayList<SalesPersonDTO>();
		Path pathFile = Paths.get("files/input/salesPerson");
		
		System.out.println("==============================================");
		System.out.println("Se inicia la busqueda del archivo de vendedores");

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathFile)) {
			
			List<Path> files = new ArrayList<>();
								
			for (Path filePath : directoryStream) {
												
				// Validación para saber si es un archivo .txt
				if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".txt")) {
					
	            	boolean isToday = validateFileDate(filePath.getFileName().toString());
	            	
	            	if (!isToday) {
	            		System.out.println("El archivo " + filePath.getFileName() + ", no es el actual "
	            				+ "por lo cual no se procesara");
	            		continue;
	            	}

					System.out.println("Procesando archivo: " + filePath.getFileName());
					readFileDTO.setFileName(filePath.getFileName().toString());
										
					try (BufferedReader br = Files.newBufferedReader(filePath)) {
						
						String line;

	                    while ((line = br.readLine()) != null) {

	                        String[] data = line.split(";");

	                        SalesPersonDTO seller = new SalesPersonDTO();
	                        
	                        seller.setDocumentType(data[0]);
	                        seller.setNumberDocument(Long.parseLong(data[1]));
	                        seller.setName(data[2]);
	                        seller.setLastName(data[3]);
	                        
	                        listSalePerson.add(seller);                       
	                    }						
						
					} catch (Exception e) {
						throw new RuntimeException("Error procesando archivo: " + filePath.getFileName());
					}
					
					files.add(pathFile);
				}
				
			}
			
			if (files.isEmpty()) {
				throw new RuntimeException("No se encontró ningún archivo");
				
			} else if (files.size() > 1) {
				throw new RuntimeException("Solo debe existir un archivo en la carpeta");
			}
			
			System.out.println("Se encontraron un total de " + listSalePerson.size() + " vendedores en el sistema");
			readFileDTO.setListPerson(listSalePerson);
			
		} catch (Exception e) {
			throw new RuntimeException("Error accediendo a la carpeta: " + e.getMessage());
		}	
		
		System.out.println("Finaliza la busqueda del archivo de vendedores");
		System.out.println("==============================================");
		
		return readFileDTO;
	}
	
    /**
     * Lee el archivo de productos desde la carpeta configurada.
     * 
     * <p>Valida que exista un único archivo, que sea del día actual
     * y transforma cada línea en un objeto {@link ProductDTO}.</p>
     * 
     * @return objeto con el nombre del archivo y la lista de productos
     * @throws RuntimeException si no hay archivos, hay más de uno o ocurre un error
     */
	public ReadFileProductDTO readFileProduct() {
		
		ReadFileProductDTO readFileProductDTO = new ReadFileProductDTO();		
		List<ProductDTO> listProduct = new ArrayList<ProductDTO>();
		Path pathFile = Paths.get("files/input/product");
		
		System.out.println("==============================================");
		System.out.println("Se inicia la busqueda del archivo de productos");

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathFile)) {
			
			List<Path> files = new ArrayList<>();
								
			for (Path filePath : directoryStream) {
												
				// Validación para saber si es un archivo .txt
				if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".txt")) {
					
	            	boolean isToday = validateFileDate(filePath.getFileName().toString());
	            	
	            	if (!isToday) {
	            		System.out.println("El archivo " + filePath.getFileName() + ", no es el actual "
	            				+ "por lo cual no se procesara");
	            		continue;
	            	}

					System.out.println("Procesando archivo: " + filePath.getFileName());
					readFileProductDTO.setFileName(filePath.getFileName().toString());
										
					try (BufferedReader br = Files.newBufferedReader(filePath)) {
						
						String line;

	                    while ((line = br.readLine()) != null) {

	                        String[] data = line.split(";");

	                        ProductDTO product = new ProductDTO();
	                        
	                        product.setId(Long.parseLong(data[0]));
	                        product.setProductName(data[1]);
	                        product.setPrice(Double.parseDouble(data[2]));
	                        
	                        listProduct.add(product);                       
	                    }						
						
					} catch (Exception e) {
						throw new RuntimeException("Error procesando archivo: " + filePath.getFileName());
					}
					
					files.add(pathFile);
				}
				
			}
			
			if (files.isEmpty()) {
				throw new RuntimeException("No se encontró ningún archivo");
				
			} else if (files.size() > 1) {
				throw new RuntimeException("Solo debe existir un archivo en la carpeta");
			}
			
			System.out.println("Se encontraron un total de " + listProduct.size() + " productos en el sistema");
			readFileProductDTO.setListProduct(listProduct);
			
		} catch (Exception e) {
			throw new RuntimeException("Error accediendo a la carpeta: " + e.getMessage());
		}	
		
		System.out.println("Finaliza la busqueda del archivo de productos");
		System.out.println("==============================================");
		
		return readFileProductDTO;
	}
	
    /**
     * Lee múltiples archivos de ventas por vendedor desde una carpeta.
     * 
     * <p>Cada archivo contiene:
     * <ul>
     *   <li>Primera línea: información del vendedor</li>
     *   <li>Siguientes líneas: productos vendidos</li>
     * </ul>
     * </p>
     * 
     * <p>Solo se procesan archivos del día actual.</p>
     * 
     * @return lista de objetos con la información de ventas por archivo
     * @throws RuntimeException si ocurre un error al leer los archivos
     */
	public List<ReadFileProductSaleBySellerDTO> readFilesProductSaleBySeller(){
			
		 List<ReadFileProductSaleBySellerDTO> listProductSalesBySeller = new ArrayList<>();
		    Path pathFile = Paths.get("files/output/productoSalesBySaller");
		    
		    System.out.println("==============================================");
		    System.out.println("Se inicia la busqueda de los archivo de productos vendidos por vendedor");

		    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathFile)) {
		                                            
		        for (Path filePath : directoryStream) {
		                                                
		            if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".txt")) {
		            	
		            	boolean isToday = validateFileDate(filePath.getFileName().toString());
		            	
		            	if (!isToday) {
		            		System.out.println("El archivo " + filePath.getFileName() + ", no es el actual "
		            				+ "por lo cual no se procesara");
		            		continue;
		            	}

		                ReadFileProductSaleBySellerDTO readDTO = new ReadFileProductSaleBySellerDTO();
		                ProductSaleBySellerDTO productSale = new ProductSaleBySellerDTO();

		                System.out.println("Procesando archivo: " + filePath.getFileName());
		                readDTO.setFileName(filePath.getFileName().toString());

		                try (BufferedReader br = Files.newBufferedReader(filePath)) {
		                    
		                    String line;
		                    boolean isFirstLine = true;
		                    List<ProductItemDTO> listProduct = new ArrayList<>();

		                    while ((line = br.readLine()) != null) {

		                        if (line.trim().isEmpty()) continue;

		                        String[] data = line.split(";");

		                        if (isFirstLine) {

		                            if (data.length < 2) {
		                                throw new RuntimeException("Formato inválido en cabecera");
		                            }

		                            productSale.setDocumentType(data[0]);
		                            productSale.setDocumentIdPerson(Long.parseLong(data[1]));

		                            isFirstLine = false;

		                        } else {

		                            if (data.length < 2) {
		                                throw new RuntimeException("Formato inválido en producto");
		                            }

		                            ProductItemDTO product = new ProductItemDTO();

		                            product.setIdProduct(Long.parseLong(data[0]));
		                            product.setSalesQuantity(Integer.parseInt(data[1]));

		                            listProduct.add(product);
		                        }
		                    }

		                    productSale.setSalesItems(listProduct);
		                    readDTO.setProductSaleBySeller(productSale);
		                    listProductSalesBySeller.add(readDTO);

		                } catch (Exception e) {
		                    throw new RuntimeException("Error procesando archivo: " + filePath.getFileName(), e);
		                }
		            }
		        }

		        System.out.println("Se procesaron " + listProductSalesBySeller.size() + " archivos");

		    } catch (Exception e) {
		        throw new RuntimeException("Error accediendo a la carpeta: " + e.getMessage(), e);
		    }

		    System.out.println("Finaliza la busqueda de los archivos de productos vendidos por vendedor");
		    System.out.println("==============================================");

		    return listProductSalesBySeller;
	}
	
    /**
     * Valida si el archivo corresponde a la fecha actual.
     * 
     * <p>El nombre del archivo debe tener el formato:
     * <pre>nombreArchivo-yyyyMMdd_HHmm.txt</pre></p>
     * 
     * @param fileName nombre del archivo a validar
     * @return true si el archivo es del día actual, false en caso contrario
     */
	public boolean validateFileDate(String fileName) {
		
		boolean isToday = true;
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
				
		String[] parts = fileName.split("-");
		String datePart = parts[1];
		String fileDate = datePart.split("_")[0];
		
		if (!fileDate.equals(today)) {
			isToday = false;
		}
		
		return isToday;
	}
	
}
