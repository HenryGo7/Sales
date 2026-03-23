package co.com.createSales.dto;

/**
 * Objeto de transferencia de datos (DTO) que representa un vendedor.
 * 
 * Contiene la información básica del vendedor como tipo de documento,
 * número de documento, nombre y apellido.
 * 
 * Se utiliza para transportar datos entre las diferentes capas del sistema.
 * 
 * @author Henry Gomez
 * @version 1.0
 */
public class SalesPersonDTO {
    
    /** Tipo de documento del vendedor */
    private String documentType;
    
    /** Número de documento del vendedor */
    private Long numberDocument;
    
    /** Nombre del vendedor */
    private String name;
    
    /** Apellido del vendedor */
    private String lastName;
    
    /**
     * Constructor vacío.
     */
    public SalesPersonDTO() {}

    /**
     * Constructor con parámetros.
     * 
     * @param documentType tipo de documento
     * @param numberDocument número de documento
     * @param name nombre del vendedor
     * @param lastName apellido del vendedor
     */
    public SalesPersonDTO(String documentType, Long numberDocument, String name, String lastName) {
        super();
        this.documentType = documentType;
        this.numberDocument = numberDocument;
        this.name = name;
        this.lastName = lastName;
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
     * Obtiene el nombre del vendedor.
     * 
     * @return nombre del vendedor
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna el nombre del vendedor.
     * 
     * @param name nombre del vendedor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido del vendedor.
     * 
     * @return apellido del vendedor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Asigna el apellido del vendedor.
     * 
     * @param lastName apellido del vendedor
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retorna una representación en texto del vendedor.
     * 
     * @return información del vendedor
     */
    @Override
    public String toString() {
        return "SalesPersonDTO [documentType=" + documentType + ", numberDocument=" + numberDocument + ", name=" + name
                + ", lastName=" + lastName + "]";
    }
}