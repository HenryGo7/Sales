package co.com.createSales.dto;

/**
 * DTO que representa el reporte de ventas por vendedor.
 * Contiene la información básica del vendedor y el total vendido.
 */
public class SellerReportDTO {

    /** Identificación del vendedor */
    Long documentId;

    /** Nombre del vendedor */
    String nameSeller;

    /** Monto total de ventas realizadas */
    Double totalAmount;

    /**
     * Constructor vacío.
     */
    public SellerReportDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param documentId identificador del vendedor
     * @param nameSeller nombre del vendedor
     * @param totalAmount monto total de ventas
     */
    public SellerReportDTO(Long documentId, String nameSeller, Double totalAmount) {
        super();
        this.documentId = documentId;
        this.nameSeller = nameSeller;
        this.totalAmount = totalAmount;
    }

    /**
     * Obtiene el identificador del vendedor.
     *
     * @return documentId identificador del vendedor
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * Asigna el identificador del vendedor.
     *
     * @param documentId identificador del vendedor
     */
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    /**
     * Obtiene el nombre del vendedor.
     *
     * @return nameSeller nombre del vendedor
     */
    public String getNameSeller() {
        return nameSeller;
    }

    /**
     * Asigna el nombre del vendedor.
     *
     * @param nameSeller nombre del vendedor
     */
    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    /**
     * Obtiene el monto total de ventas.
     *
     * @return totalAmount monto total vendido
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Asigna el monto total de ventas.
     *
     * @param totalAmount monto total vendido
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Representación en texto del objeto.
     *
     * @return cadena con la información del vendedor
     */
    @Override
    public String toString() {
        return "SellerReportDTO [documentId=" + documentId + ", nameSeller=" + nameSeller + ", totalAmount="
                + totalAmount + "]";
    }
}
