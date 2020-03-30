package com.desafio.carrinhodecompra.pages;

import com.desafio.carrinhodecompra.core.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class ProdutoSelecionadoPage extends BasePage {

    public static void adicionarProdutoNoCarrinho(){
        log.info("***Adicionando produto a sacola***");
        String elemento = "//div[@class='wrapper-product__informations js-block-product']//*[contains(text(), 'Adicionar à sacola')]";
        aguardarElementoSerLocalizado(By.xpath(elemento));
        clicarNoElemento(elemento);
    }
}
