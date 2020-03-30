package com.desafio.carrinhodecompra.core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.desafio.carrinhodecompra.core.DriverFactory.getDriver;

public class BasePage {
    private static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public static void digitar(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public static void digitar(String id_campo, String texto){
        aguardarElementoFicarDisponivelParaClick(By.id(id_campo));
        digitar(By.id(id_campo), texto);
    }

    public static void aguardarElementoFicarDisponivelParaClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void aguardarElementoSerLocalizado(String elemento){
        aguardarElementoSerLocalizado(By.id(elemento));
    }

    public static void aguardarElementoSerLocalizado(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void aguardarSegundos(int segundos){
        getDriver().manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public static boolean verificarSeElementoEstaNaTela(String elemento){
        return getDriver().findElement(By.xpath(elemento)).isDisplayed();
    }

    public static void clicarNoElemento(String elemento){
        clicarNoElemento(By.xpath(elemento));
    }

    public static void clicarNoElemento(By by){
        getDriver().findElement(by).click();
    }

    public static String obterTextoDoElemento(String elemento){
        return getDriver().findElement(By.id(elemento)).getText();
    }
}
