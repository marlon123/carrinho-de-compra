package com.desafio.carrinhodecompra.core;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Slf4j
public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver(String navegador, String sistema_operacional){
        if(driver == null) {
            if(sistema_operacional.equalsIgnoreCase("mac")){
                log.info("Configurando driver mac");
                if (navegador.equalsIgnoreCase("firefox")){
                    System.setProperty("webdriver.gecko.driver", "drivers/mac/geckodriver");
                    driver = new FirefoxDriver();
                }else if(navegador.equalsIgnoreCase("chrome")){
                    System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
                    driver = new ChromeDriver();
                }
            }
            if(sistema_operacional.equalsIgnoreCase("linux")){
                log.info("Configurando driver linux");
                if (navegador.equalsIgnoreCase("firefox")){
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                    driver = new FirefoxDriver();
                }else if(navegador.equalsIgnoreCase("chrome")){
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                    driver = new ChromeDriver();
                }
            }
            if(sistema_operacional.equalsIgnoreCase("windows")){
                log.info("Configurando driver windows");
                if (navegador.equalsIgnoreCase("firefox")){
                    System.setProperty("webdriver.gecko.driver", "drivers/windows/geckodriver.exe");
                    driver = new FirefoxDriver();
                }else if(navegador.equalsIgnoreCase("chrome")){
                    System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
