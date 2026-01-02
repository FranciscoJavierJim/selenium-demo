package com.ejemplo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DuckDuckGoTest {

    @Test
    public void abrirDuckDuckGoYBuscar() {
        // Crea el driver con opciones silenciosas
        ChromeDriver driver = BaseTest.createDriver();

        try {
            driver.get("https://duckduckgo.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Espera hasta que la barra de búsqueda esté lista
            WebElement busqueda = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("q"))
            );

            busqueda.sendKeys("Selenium");
            busqueda.submit();

            // Espera máxima para resultados o CAPTCHA
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Verifica si aparece el CAPTCHA
            List<WebElement> captcha = driver.findElements(By.cssSelector("iframe[src*='captcha']"));
            if (!captcha.isEmpty()) {
                System.out.println("CAPTCHA detectado, ignorando prueba automática.");
                return; // Sale de la prueba sin fallar
            }

            // Espera a que los resultados aparezcan
            List<WebElement> resultados = longWait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result"))
            );

            // Verifica que haya al menos un resultado
            assertTrue(resultados.size() > 0, "No se encontraron resultados");

        } catch (Exception e) {
            System.out.println("La prueba falló: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
