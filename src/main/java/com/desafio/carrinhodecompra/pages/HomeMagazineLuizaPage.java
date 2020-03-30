package com.desafio.carrinhodecompra.pages;

import com.desafio.carrinhodecompra.core.BasePage;
import com.desafio.carrinhodecompra.core.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;

@Slf4j
public class HomeMagazineLuizaPage extends BasePage {

    public static void acessarHomeMagazineLuiza(){
        log.info("***Acessando tela inicial Magazine Luiza***");
        DriverFactory.getDriver().get("https://www.magazineluiza.com.br/");
    }

    public static void pesquisarSmartTVDisponivel(){
        log.info("***Pesquisando Smart TV disponivel***");
        pesquisarProduto("Smart TV 4K LED 50” Samsung UN50RU7100 - Wi-Fi Bluetooth HDR 3 HDMI 2 USB");
    }

    public static void pesquisarSmartTVSemEstoque(){
        log.info("***Pesquisando Smart TV sem estoque***");
        pesquisarProduto("Smart TV 4K LED 50” Samsung NU7400 Wi-Fi - HDR 3 HDMI 2 USB");
    }

    public static void pesquisarProduto(String nomeProduto){
        aguardarElementoSerLocalizado(By.id("btnHeaderSearch"));
        digitar("inpHeaderSearch", nomeProduto);
    }

    public static void confirmarProdutosEncontrados(){
        String elemento = "//li[@data-productid='193425500']";
        aguardarElementoSerLocalizado(By.xpath(elemento));
        Assert.assertTrue(verificarSeElementoEstaNaTela(elemento));
    }

    public static void selecionarSmartTVDisponivel(){
        log.info("***Selecionando Smart TV Disponivel***");
        String elemento = "//li[@data-productid='193425500']";
        aguardarElementoSerLocalizado(By.xpath(elemento));
        clicarNoElemento(elemento);
    }

    public static void selecionarSmartTVSemEstoque(){
        log.info("***Selecionando Smart TV Sem Estoque***");
        String elemento = "//li[@data-productid='193421000']";
        aguardarElementoSerLocalizado(By.xpath(elemento));
        clicarNoElemento(elemento);
    }
}
