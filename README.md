## Introducción  
**EducaITPro** es un proyecto Java que utiliza **Maven** como gestor de dependencias y **TestNG** como framework para pruebas.  

---

## Requisitos Previos  
Antes de comenzar, asegúrate de tener instalado:  
- **Java** (JDK 8 o superior)  
- **Maven** (3.6.x o superior)  

Para verificar:  
```bash
java -version
mvn -version
```

---

## Instalación  

1. Clona el repositorio:  
   ```bash
   git clone https://github.com/usuario/EducaITPro.git
   cd EducaITPro
   ```

2. Compila el proyecto:  
   ```bash
   mvn clean install
   ```

3. Importa el proyecto en tu IDE favorito como un proyecto Maven.

---

## Ejecución de Pruebas  

Ejecuta las pruebas con el siguiente comando:  
```bash
mvn test
```

Los reportes se generarán en: `target/surefire-reports`.

---

## Estructura del Proyecto  

```plaintext
EducaITPro/
├── src/
│   ├── main/java/          # Código fuente
│   ├── test/java/          # Pruebas TestNG
│
├── pom.xml                 # Configuración de Maven
└── README.md               # Documentación
```

---

## Dependencias Principales  

- **TestNG**: Framework de pruebas.  
Ejemplo en `pom.xml`:
```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.6.0</version>
    <scope>test</scope>
</dependency>
```

---

## Licencia  

Este proyecto está bajo la licencia MIT.
