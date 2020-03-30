package com.desafio.carrinhodecompra.pages;

import com.desafio.carrinhodecompra.core.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;

@Slf4j
public class CarrinhoPage extends BasePage {

    public static void validarSmartTVNoCarrinho(){
        log.info("***Validando se Smart TV esta no carrinho***");
        String elemento = "//p[contains(text(), 'Smart TV 4K LED 50” Samsung UN50RU7100 - Wi-Fi Bluetooth HDR 3 HDMI 2 USB')]";

        aguardarElementoSerLocalizado(By.xpath(elemento));
        Assert.assertTrue(verificarSeElementoEstaNaTela(elemento));
    }
}
