package co.com.createSales.dto;

public class SalesPersonDTO {
	
	String documentType;
	
	Long numberDocument;
	
	String name;
	
	String lastName;
	
	public SalesPersonDTO() {}
	
	public SalesPersonDTO(String documentType, Long numberDocument, String name, String lastName) {
		super();
		this.documentType = documentType;
		this.numberDocument = numberDocument;
		this.name = name;
		this.lastName = lastName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "SalesMen [documentType=" + documentType + ", numberDocument=" + numberDocument + ", name=" + name
				+ ", lastName=" + lastName + "]";
	}
	
}
