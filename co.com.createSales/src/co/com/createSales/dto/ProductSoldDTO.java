package co.com.createSales.dto;

public class ProductSoldDTO {
	
	String documentType;
	
	Long numberDocument;
	
	Long productId;
	
	Integer productQuantity;

	public ProductSoldDTO() {
		super();
	}

	public ProductSoldDTO(String documentType, Long numberDocument, Long productId, Integer productQuantity) {
		super();
		this.documentType = documentType;
		this.numberDocument = numberDocument;
		this.productId = productId;
		this.productQuantity = productQuantity;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Long getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(Long numberDocument) {
		this.numberDocument = numberDocument;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "ProductSoldDTO [documentType=" + documentType + ", numberDocument=" + numberDocument + ", productId="
				+ productId + ", productQuantity=" + productQuantity + "]";
	}
	
}
