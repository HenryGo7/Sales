# 🧾 Generación y Clasificación de Datos

## 📌 Descripción

Este proyecto en Java permite procesar archivos planos de vendedores, productos y ventas, con el objetivo de generar reportes organizados en formato CSV.

El sistema lee múltiples archivos de ventas por vendedor, calcula el total vendido por cada uno y genera estadísticas de productos vendidos.

Este desarrollo cumple con los requisitos del módulo de programación del Politécnico Grancolombiano.

---

## 🎯 Objetivo del proyecto

Diseñar e implementar un programa en Java que:

* Lea archivos de entrada (vendedores, productos y ventas)
* Procese la información
* Genere reportes ordenados
* Aplique buenas prácticas de programación y documentación

---

## ⚙️ Tecnologías utilizadas

* Java 8
* Eclipse IDE
* java.nio.file (manejo de archivos)
* Programación Orientada a Objetos (POO)

---

## 📂 Estructura del proyecto

```
src/
 ├── co.com.createSales.dao
 ├── co.com.createSales.dto
 ├── co.com.createSales.main
 └── co.com.createSales.service

files/
 ├── input/
 │   ├── product/
 │   └── salesPerson/
 │
 ├── output/
 │   └── productoSalesBySaller/
 │
 └── reports/
     ├── productsByQuantitySold/
     └── sellerSale/
```

---

## ▶️ Ejecución del programa

El proyecto contiene dos clases principales:

### 1️⃣ GenerateInfoFiles

* Genera archivos de prueba pseudoaleatorios
* Se usa para pruebas del sistema

### 2️⃣ Main

* Lee los archivos de entrada
* Procesa la información
* Genera los reportes finales

⚠️ El programa NO solicita datos al usuario.

---

## 📄 Formato de archivos

### 👤 Archivo de vendedores

```
CC;123456;Juan;Perez
CC;789012;Maria;Gomez
```

---

### 🛒 Archivo de productos

```
1001;Laptop;1500.0
1002;Mouse;50.0
```

---

### 📊 Archivo de ventas por vendedor

```
CC;123456
1001;2
1002;5
```

Cada archivo corresponde a un vendedor diferente.

---

## 📈 Reportes generados

### 🧑‍💼 Ventas por vendedor

* Ordenado de mayor a menor
* Formato CSV:

```
123456;Juan Perez;5000.0
789012;Maria Gomez;3200.0
```

---

### 📦 Productos más vendidos

* Ordenado por cantidad vendida (descendente)
* Formato CSV:

```
1001;Laptop;20;1500.0
1002;Mouse;15;50.0
```

---

## ⚠️ Reglas del sistema

* Se pueden procesar múltiples archivos de ventas
* Los archivos deben ubicarse en las rutas definidas
* No se solicita entrada al usuario
* Se generan reportes automáticamente
* Los datos deben tener formato válido

---

## 🚀 Funcionalidades principales

✔ Lectura de archivos planos
✔ Procesamiento de múltiples vendedores
✔ Cálculo de ventas totales
✔ Generación de reportes CSV
✔ Ordenamiento de datos

---

## 🧪 Generación de datos (Testing)

El sistema incluye métodos para generar datos de prueba:

* createSalesMenFile(int randomSalesCount, String name, long id)
* createProductsFile(int productsCount)
* createSalesManInfoFile(int salesmanCount)

Estos métodos generan archivos pseudoaleatorios para pruebas del sistema.

---

## 📌 Consideraciones importantes

* El proyecto está diseñado para ejecutarse en Eclipse
* Se recomienda mantener la estructura de carpetas
* Los archivos deben existir antes de ejecutar el procesamiento
* Se manejan excepciones para errores de lectura/escritura

---

## 👨‍💻 Autor

Henry Gomez

---

## 📚 Conclusión

Este proyecto permite aplicar conceptos fundamentales de programación como:

* Manejo de archivos
* Estructuras de datos
* Programación orientada a objetos
* Buenas prácticas de desarrollo

Además, simula un escenario real de procesamiento de información empresarial, donde se analizan datos y se generan reportes útiles para la toma de decisiones.

---
