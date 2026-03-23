package co.com.createSales.dto;

/**
 * Objeto de transferencia de datos (DTO) que representa un producto.
 * Contiene la información básica como id, nombre y precio.
 * 
 * Se utiliza para transportar datos entre las diferentes capas
 * de la aplicación.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ProductDTO {

    /** Identificador único del producto */
	private Long id;
    
    /** Nombre del producto */
	private String productName;
    
    /** Precio del producto */
	private Double price;

    /**
     * Constructor vacío.
     */
    public ProductDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     * 
     * @param id identificador del producto
     * @param productName nombre del producto
     * @param price precio del producto
     */
    public ProductDTO(Long id, String productName, Double price) {
        super();
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    /**
     * Obtiene el id del producto.
     * 
     * @return id del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el id del producto.
     * 
     * @param id nuevo id del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return nombre del producto
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Asigna el nombre del producto.
     * 
     * @param productName nuevo nombre del producto
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return precio del producto
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Asigna el precio del producto.
     * 
     * @param price nuevo precio del producto
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retorna una representación en texto del objeto.
     * 
     * @return cadena con la información del producto
     */
    @Override
    public String toString() {
        return "ProductDTO [id=" + id + ", productName=" + productName + ", price=" + price + "]";
    }
}