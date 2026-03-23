package co.com.createSales.dto;

/**
 * Objeto de transferencia de datos (DTO) que representa el detalle
 * de una venta realizada por un vendedor.
 * 
 * Contiene información del producto, el vendedor y los valores
 * asociados a la venta como precio unitario y precio total.
 * 
 * Se utiliza para mostrar o transportar información consolidada
 * de ventas.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ProductSaleBySellerDTO {

    /** Identificador del producto */
    private Long idProduct;
    
    /** Número de documento del vendedor */
    private Long documentIdPerson;
    
    /** Nombre del producto */
    private String nameProduct;
    
    /** Precio por unidad del producto */
    private Double pricePerUnit;
    
    /** Precio total de la venta */
    private Double totalPrice;

    /**
     * Constructor vacío.
     */
    public ProductSaleBySellerDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     * 
     * @param idProduct id del producto
     * @param documentIdPerson documento del vendedor
     * @param nameProduct nombre del producto
     * @param pricePerUnit precio por unidad
     * @param totalPrice precio total de la venta
     */
    public ProductSaleBySellerDTO(Long idProduct, Long documentIdPerson, String nameProduct, Double pricePerUnit,
            Double totalPrice) {
        super();
        this.idProduct = idProduct;
        this.documentIdPerson = documentIdPerson;
        this.nameProduct = nameProduct;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
    }

    /**
     * Obtiene el id del producto.
     * 
     * @return id del producto
     */
    public Long getIdProduct() {
        return idProduct;
    }

    /**
     * Asigna el id del producto.
     * 
     * @param idProduct id del producto
     */
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Obtiene el documento del vendedor.
     * 
     * @return documento del vendedor
     */
    public Long getDocumentIdPerson() {
        return documentIdPerson;
    }

    /**
     * Asigna el documento del vendedor.
     * 
     * @param documentIdPerson documento del vendedor
     */
    public void setDocumentIdPerson(Long documentIdPerson) {
        this.documentIdPerson = documentIdPerson;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return nombre del producto
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * Asigna el nombre del producto.
     * 
     * @param nameProduct nombre del producto
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * Obtiene el precio por unidad.
     * 
     * @return precio por unidad
     */
    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    /**
     * Asigna el precio por unidad.
     * 
     * @param pricePerUnit precio por unidad
     */
    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * Obtiene el precio total de la venta.
     * 
     * @return precio total
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Asigna el precio total de la venta.
     * 
     * @param totalPrice precio total
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Retorna una representación en texto del detalle de venta.
     * 
     * @return información de la venta
     */
    @Override
    public String toString() {
        return "ProductSaleBySelleDTO [idProduct=" + idProduct + ", documentIdPerson=" + documentIdPerson
                + ", nameProduct=" + nameProduct + ", pricePerUnit=" + pricePerUnit + ", totalPrice=" + totalPrice
                + "]";
    }
}