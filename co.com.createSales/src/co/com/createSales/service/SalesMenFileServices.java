package co.com.createSales.service;

import java.util.List;

import co.com.createSales.dto.ProductDTO;
import co.com.createSales.dto.ProductSaleBySellerDTO;
import co.com.createSales.dto.SalesPersonDTO;

/**
 * Servicio encargado de la gestión de ventas.
 * 
 * Permite validar vendedores y productos existentes,
 * y calcular el valor total de una venta.
 * 
 * Utiliza los servicios de vendedores y productos
 * para obtener la información necesaria.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class SalesMenFileServices {

    private final SalesManFileService salesManFileService;
    
    private final ProductFileService productFileServices;
        
    /**
     * Constructor del servicio de ventas.
     * 
     * @param salesManFileService servicio de vendedores
     * @param productFileServices servicio de productos
     */
    public SalesMenFileServices(SalesManFileService salesManFileService, ProductFileService productFileServices) {
        this.productFileServices = productFileServices;
        this.salesManFileService = salesManFileService;
    }
    
    /**
     * Realiza el cálculo de una venta.
     * 
     * Valida que el vendedor y el producto existan,
     * y calcula el valor total según la cantidad indicada.
     * 
     * Luego imprime el resultado en consola.
     * 
     * @param randomSalesCount cantidad de productos vendidos
     * @param name nombre del vendedor
     * @param idProduct id del producto
     */
    public void createSalesMenFile(int randomSalesCount, String name, long idProduct) {
        System.out.println("==============================================\n" 
                + "Iniciando calculo de venta ......");
        
        List<SalesPersonDTO> salesPerson = salesManFileService.getListSalesPersons();
        List<ProductDTO> products = productFileServices.getListSalesProduct();
        ProductSaleBySellerDTO productSaleBySelleDTO = new ProductSaleBySellerDTO();
        SalesPersonDTO salePerson = null;
        ProductDTO product = null;
        
        if (randomSalesCount <= 0) {
            System.out.println("El valor de ventas a crear no puede ser menor o igual a 0");
            return;
        }
        
        salePerson = validateListSeller(salesPerson, name);
        
        if (salePerson == null) {
            return;
        }
        
        product = validateListProduct(products, idProduct);
        
        if (product == null) {
            return;
        }

        productSaleBySelleDTO.setIdProduct(product.getId());
        productSaleBySelleDTO.setDocumentIdPerson(salePerson.getNumberDocument());
        productSaleBySelleDTO.setNameProduct(product.getProductName());
        productSaleBySelleDTO.setPricePerUnit(product.getPrice());
        productSaleBySelleDTO.setTotalPrice(product.getPrice() * randomSalesCount);
        
        // Imprime la información de la venta
        System.out.println("==============================================");
        System.out.println("Producto Id: " + productSaleBySelleDTO.getIdProduct() + "\n"
                + "Documento de vendedor: " + productSaleBySelleDTO.getDocumentIdPerson() + "\n"
                + "Nombre de producto: " + productSaleBySelleDTO.getNameProduct() + "\n"
                + "Valor unidad: " + productSaleBySelleDTO.getPricePerUnit() + "\n"
                + "Valor Total: " + productSaleBySelleDTO.getTotalPrice() + "\n");
        
        System.out.println("Finaliza el calculo de venta para el producto " + product.getProductName() + "\n"
                + "==============================================");
    }
    
    /**
     * Valida si el vendedor existe en la lista.
     * 
     * @param salesPersons lista de vendedores
     * @param name nombre del vendedor a buscar
     * @return vendedor encontrado o null si no existe
     */
    public SalesPersonDTO validateListSeller(List<SalesPersonDTO> salesPersons, String name) {    
        
        if (salesPersons == null || salesPersons.isEmpty()) {
            System.out.println("La lista de vendedores no puede esta vacia");
            return null;
        }
        
        if (name == null || name.trim().isEmpty()) {
            System.out.println("El nombre del vendedor no puede ser vacío");
            return null;
        }
        
        for (SalesPersonDTO s : salesPersons) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        
        System.out.println("El nombre ingresado para generar las ventas no existe en la lista");
        return null;
    }
    
    /**
     * Valida si el producto existe en la lista.
     * 
     * @param products lista de productos
     * @param idProduct id del producto a buscar
     * @return producto encontrado o null si no existe
     */
    public ProductDTO validateListProduct(List<ProductDTO> products, Long idProduct) {
        
        if (products == null || products.isEmpty()) {
            System.out.println("La lista de productos no puede estar vacia");
            return null;
        }
        
        if (idProduct == null) {
            System.out.println("El id de producto debe ser un valor valido");
            return null;
        }
        
        for (ProductDTO p : products) {
            if (p.getId().equals(idProduct)) {
                return p;
            }
        }
        
        System.out.println("El Id de producto ingresado para generar las ventas no existe en la lista");
        return null;
    }
}