package co.com.createSales.dto;

public class ProductDTO {

	Long id;
	
	String productName;
	
	Double price;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String productName, Double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
	
}
