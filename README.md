# Selenium Demo

Este es un proyecto de prueba que utiliza **Selenium WebDriver** con **Java** y **Maven** para automatizar pruebas en el navegador web DuckDuckGo.

---

## Contenido del proyecto

- `src/main/java` → código principal (vacío o ejemplo básico)
- `src/test/java` → pruebas automatizadas con Selenium y JUnit
  - `AppTest.java` → test de ejemplo simple que siempre pasa
  - `DuckDuckGoTest.java` → test que abre DuckDuckGo y realiza una búsqueda
- `pom.xml` → configuración de Maven con dependencias y plugins

---

## Tecnologías utilizadas

- **Java 17**
- **Maven 4.x**
- **Selenium WebDriver 4.25.0**
- **JUnit 5.11**
- **WebDriverManager 5.9.2**
- Navegador: Google Chrome (Chromedriver gestionado automáticamente)

---

## Instalación y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/TU-USUARIO/selenium-demo.git
cd selenium-demo

2. Asegúrate de tener instalados:

Java JDK 17

Maven

Google Chrome

Variables de entorno correctamente configuradas (PATH)

3. Ejecuta los tests con Maven:

mvn clean test
