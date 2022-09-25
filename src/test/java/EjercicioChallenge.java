import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EjercicioChallenge {

    @Test
    public void primerTest(){

        //INICIAR PROPERTIES
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //INICIAR GOOGLE CHROME (driver)
        WebDriver driver = new ChromeDriver();

        //NAVEGAR A www.netflix.com
        driver.get("https://www.netflix.com");

        //MAXIMIZAR PANTALLA
        driver.manage().window().maximize();
        //IMPRIMIR TITULO
        System.out.println(driver.getTitle());
        //IMPRIMIR URL
        System.out.println(driver.getCurrentUrl());
    }


    @Test
    public void titulosTest(){

        //INICIAR PROPERTIES
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //INICIAR GOOGLE CHROME (driver)
        WebDriver driver = new ChromeDriver();

        //NAVEGAR A www.netflix.com
        driver.get("https://www.netflix.com");

        //OBTENER ELEMENTOS h1
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));

        //MOSTRAR TODOS LOS h1
        System.out.println("Lista de H1: ");
        for (WebElement h1 : listaH1s) {
            System.out.println(h1.getText());
        }
        //OBTENER ELEMENTOS h2
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));

        //MOSTRAR TODOS LOS h2
        System.out.println("Lista de H2: ");
        for (WebElement h2 : listaH2s) {
            System.out.println(h2.getText());
        }
    }

    @Test
    public void docuSignTest() throws InterruptedException {
        //INICIAR PROPERTIES
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //INICIAR GOOGLE CHROME (driver)
        WebDriver driver = new ChromeDriver();

        //NAVEGAR A www.docusign.com
        driver.get("https://www.docusign.com");

        Thread.sleep(3000); // se usa esto para permitir que la pagina cargue
        //CLICK EN “Aceptar Cookies”
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //CLICK EN “Free Trial”
        driver.findElement(By.xpath("//*[@class='css-x91yru e9sefc00']")).click();

        //IMPRIMIR TITULO
        System.out.println(driver.getTitle());

        //IMPRIMIR LA URL
        System.out.println(driver.getCurrentUrl());

        //COMPLETAR CAMPO “Correo Electronico” con “test@test.com”
        driver.findElement(By.name("workEmail")).sendKeys("testing@test.com");

        //VALIDAR TITULO (Validar signfica para ver si el titulo que me esta mostrando es el mismo que estoy esperando)
        Assert.assertEquals(driver.getTitle(), "Empiece su prueba");

    }
}
