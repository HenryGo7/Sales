package co.com.createSales.dto;

/**
 * Objeto de transferencia de datos (DTO) que representa un producto vendido.
 * 
 * Contiene la información relacionada con la venta de un producto,
 * incluyendo el tipo y número de documento del vendedor,
 * el id del producto y la cantidad vendida.
 * 
 * Se utiliza para transportar datos entre las capas de la aplicación.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ProductSoldDTO {
    
    /** Tipo de documento del vendedor */
    private String documentType;
    
    /** Número de documento del vendedor */
    private Long numberDocument;
    
    /** Identificador del producto */
    private Long productId;
    
    /** Cantidad de producto vendida */
    private Integer productQuantity;

    /**
     * Constructor vacío.
     */
    public ProductSoldDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     * 
     * @param documentType tipo de documento del vendedor
     * @param numberDocument número de documento del vendedor
     * @param productId id del producto vendido
     * @param productQuantity cantidad vendida
     */
    public ProductSoldDTO(String documentType, Long numberDocument, Long productId, Integer productQuantity) {
        super();
        this.documentType = documentType;
        this.numberDocument = numberDocument;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    /**
     * Obtiene el tipo de documento.
     * 
     * @return tipo de documento
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Asigna el tipo de documento.
     * 
     * @param documentType tipo de documento
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Obtiene el número de documento.
     * 
     * @return número de documento
     */
    public Long getNumberDocument() {
        return numberDocument;
    }

    /**
     * Asigna el número de documento.
     * 
     * @param numberDocument número de documento
     */
    public void setNumberDocument(Long numberDocument) {
        this.numberDocument = numberDocument;
    }

    /**
     * Obtiene el id del producto.
     * 
     * @return id del producto
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Asigna el id del producto.
     * 
     * @param productId id del producto
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Obtiene la cantidad vendida del producto.
     * 
     * @return cantidad vendida
     */
    public Integer getProductQuantity() {
        return productQuantity;
    }

    /**
     * Asigna la cantidad vendida del producto.
     * 
     * @param productQuantity cantidad vendida
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * Retorna una representación en texto del objeto.
     * 
     * @return información del producto vendido
     */
    @Override
    public String toString() {
        return "ProductSoldDTO [documentType=" + documentType + ", numberDocument=" + numberDocument + ", productId="
                + productId + ", productQuantity=" + productQuantity + "]";
    }
}