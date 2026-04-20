package co.com.createSales.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transferencia de datos (DTO) que representa el detalle
 * de las ventas realizadas por un vendedor.
 * 
 * Contiene información del producto y el vendedor
 * 
 * Se utiliza para mostrar o transportar información consolidada
 * de ventas.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class ProductSaleBySellerDTO {

    /** Identificador del producto */
    private String documentType;
    
    /** Número de documento del vendedor */
    private Long documentIdPerson;
    
    /** Lista de productos asociados a este vendedor */
    private List<ProductItemDTO> listProductItemDTO;
    
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
    public ProductSaleBySellerDTO(String documentType, Long documentIdPerson, Long idProduct, int salesQuantity) {
		super();
		this.documentType = documentType;
		this.documentIdPerson = documentIdPerson;
	}
    
    public static class ProductItemDTO {
    	
        /** Nombre del producto */
        private Long idProduct;
        
        /** Precio por unidad del producto */
        private int salesQuantity;
                        
        public ProductItemDTO() {
			super();
		}

		public ProductItemDTO(Long idProduct, int salesQuantity) {
        	this.idProduct = idProduct;
        	this.salesQuantity = salesQuantity;
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
         * Asigna el id del producto
         * 
         * @param idProduct id del producto
         */
    	public void setIdProduct(Long idProduct) {
    		this.idProduct = idProduct;
    	}

        /**
         * Obtiene la cantidad vendida
         * 
         * @return precio por unidad
         */
    	public int getSalesQuantity() {
    		return salesQuantity;
    	}

    	/**
         * Asigna ela cantidad de la venta
         * 
         * @param salesQuantity cantidad de venta
         */
    	public void setSalesQuantity(int salesQuantity) {
    		this.salesQuantity = salesQuantity;
    	}
    	
    	@Override
    	public String toString() {
    		return "ProductItemDTO [idProduct = " + idProduct + ", salesQuantity " + salesQuantity + "]";
    	}
    }

    /**
     * Obtiene el tipo de documento del vendedor.
     * 
     * @return tipo de documento
     */
	public String getDocumentType() {
		return documentType;
	}

	/**
     * Asigna el tipo de documento del vendedor.
     * 
     * @param documentType del vendedor
     */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
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
	
	public List<ProductItemDTO> getListProductItemDTO() {
        return listProductItemDTO;
    }

    public void setSalesItems(List<ProductItemDTO> listProductItemDTO) {
        this.listProductItemDTO = listProductItemDTO;
    }
    
    /**
     * Método utilitario para añadir un producto a la lista.
     */
    public void addSaleItem(Long idProduct, int quantity) {
    	if (this.listProductItemDTO == null) {
            this.listProductItemDTO = new ArrayList<>();
        }
    	
        this.listProductItemDTO.add(new ProductItemDTO(idProduct, quantity));
    }

    /**
     * Retorna una representación en texto del detalle de venta.
     * 
     * @return información de la venta
     */
	@Override
	public String toString() {
		return "ProductSaleBySellerDTO [documentType=" + documentType + ", documentIdPerson=" + documentIdPerson + " ]";
	}
}