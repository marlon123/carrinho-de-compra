package com.desafio.carrinhodecompra.pages;

import com.desafio.carrinhodecompra.core.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class GarantiaEstendidaPage extends BasePage {

    public static void continuarSemGarantiaEstendida(){
        log.info("***Continuar sem garantia estendida***");
        String elemento = "//a[@class='price-warranty__btn--continue btn-buy-warranty']";
        aguardarElementoSerLocalizado(By.xpath(elemento));
        clicarNoElemento(elemento);
    }
}
