package co.com.createSales.dto;

/**
 * DTO que representa el reporte de ventas por producto.
 * Contiene la información del producto, cantidad vendida y su precio.
 */
public class ProductReportDTO {

    /** Identificador del producto */
    Long productId;

    /** Nombre del producto */
    String productName;

    /** Cantidad total vendida del producto */
    int totalProductSold;

    /** Precio del producto */
    Double productPrice;

    /**
     * Constructor vacío.
     */
    public ProductReportDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param productId identificador del producto
     * @param productName nombre del producto
     * @param totalProductSold cantidad total vendida
     * @param productPrice precio del producto
     */
    public ProductReportDTO(Long productId, String productName, int totalProductSold, Double productPrice) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.totalProductSold = totalProductSold;
        this.productPrice = productPrice;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return productId identificador del producto
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Asigna el identificador del producto.
     *
     * @param productId identificador del producto
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return productName nombre del producto
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Asigna el nombre del producto.
     *
     * @param productName nombre del producto
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Obtiene la cantidad total vendida.
     *
     * @return totalProductSold cantidad vendida
     */
    public int getTotalProductSold() {
        return totalProductSold;
    }

    /**
     * Asigna la cantidad total vendida.
     *
     * @param totalProductSold cantidad vendida
     */
    public void setTotalProductSold(int totalProductSold) {
        this.totalProductSold = totalProductSold;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return productPrice precio del producto
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * Asigna el precio del producto.
     *
     * @param productPrice precio del producto
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Representación en texto del objeto.
     *
     * @return cadena con la información del producto
     */
    @Override
    public String toString() {
        return "ProductReportDTO [productId=" + productId + ", productName=" + productName
                + ", totalProductSold=" + totalProductSold + ", productPrice=" + productPrice + "]";
    }
}
