package co.com.createSales.dto;

public class ProductSaleBySelleDTO {

	Long idProduct;
	
	Long documentIdPerson;
	
	String nameProduct;
	
	Double pricePerUnit;
	
	Double totalPrice;

	public ProductSaleBySelleDTO() {
		super();
	}

	public ProductSaleBySelleDTO(Long idProduct, Long documentIdPerson, String nameProduct, Double pricePerUnit,
			Double totalPrice) {
		super();
		this.idProduct = idProduct;
		this.documentIdPerson = documentIdPerson;
		this.nameProduct = nameProduct;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getDocumentIdPerson() {
		return documentIdPerson;
	}

	public void setDocumentIdPerson(Long documentIdPerson) {
		this.documentIdPerson = documentIdPerson;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ProductSaleBySelleDTO [idProduct=" + idProduct + ", documentIdPerson=" + documentIdPerson
				+ ", nameProduct=" + nameProduct + ", pricePerUnit=" + pricePerUnit + ", totalPrice=" + totalPrice
				+ "]";
	}
	
}
