package co.com.createSales.dto;

/**
 * DTO que representa la información leída desde un archivo
 * de ventas de productos por vendedor.
 * 
 * Contiene el nombre del archivo procesado y el objeto con los datos de ventas.
 */
public class ReadFileProductSaleBySellerDTO {

    /** Nombre del archivo procesado */
    String fileName;

    /** Información de ventas por vendedor contenida en el archivo */
    ProductSaleBySellerDTO productSaleBySeller;

    /**
     * Constructor vacío.
     */
    public ReadFileProductSaleBySellerDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param fileName nombre del archivo
     * @param productSaleBySeller información de ventas por vendedor
     */
    public ReadFileProductSaleBySellerDTO(String fileName, ProductSaleBySellerDTO productSaleBySeller) {
        super();
        this.fileName = fileName;
        this.productSaleBySeller = productSaleBySeller;
    }

    /**
     * Obtiene el nombre del archivo.
     *
     * @return fileName nombre del archivo
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Asigna el nombre del archivo.
     *
     * @param fileName nombre del archivo
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Obtiene la información de ventas por vendedor.
     *
     * @return productSaleBySeller datos de ventas
     */
    public ProductSaleBySellerDTO getProductSaleBySeller() {
        return productSaleBySeller;
    }

    /**
     * Asigna la información de ventas por vendedor.
     *
     * @param productSaleBySeller datos de ventas
     */
    public void setProductSaleBySeller(ProductSaleBySellerDTO productSaleBySeller) {
        this.productSaleBySeller = productSaleBySeller;
    }

    /**
     * Representación en texto del objeto.
     *
     * @return cadena con la información del archivo y sus datos
     */
    @Override
    public String toString() {
        return "ReadFileProductSaleBySellerDTO [fileName=" + fileName 
                + ", productSaleBySeller=" + productSaleBySeller + "]";
    }
}
