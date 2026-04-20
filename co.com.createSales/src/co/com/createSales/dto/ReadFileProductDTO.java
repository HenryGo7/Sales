package co.com.createSales.dto;

import java.util.List;

/**
 * DTO que representa la información leída desde un archivo de productos.
 * 
 * Contiene el nombre del archivo procesado y la lista de productos obtenidos.
 */
public class ReadFileProductDTO {

    /** Nombre del archivo procesado */
    String fileName;

    /** Lista de productos leídos desde el archivo */
    List<ProductDTO> listProduct;

    /**
     * Constructor vacío.
     */
    public ReadFileProductDTO() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param fileName nombre del archivo
     * @param listProduct lista de productos leídos
     */
    public ReadFileProductDTO(String fileName, List<ProductDTO> listProduct) {
        super();
        this.fileName = fileName;
        this.listProduct = listProduct;
    }

    /**
     * Obtiene el nombre del archivo.
     *
     * @return fileName nombre del archivo
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Asigna el nombre del archivo.
     *
     * @param fileName nombre del archivo
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Obtiene la lista de productos.
     *
     * @return listProduct lista de productos
     */
    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    /**
     * Asigna la lista de productos.
     *
     * @param listProduct lista de productos
     */
    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    /**
     * Representación en texto del objeto.
     *
     * @return cadena con la información del archivo y los productos
     */
    @Override
    public String toString() {
        return "ReadFileProductDTO [fileName=" + fileName + ", listProduct=" + listProduct + "]";
    }
}
