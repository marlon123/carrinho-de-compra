package com.desafio.carrinhodecompra.pages;

import com.desafio.carrinhodecompra.core.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;

@Slf4j
public class ResultadoBuscaPage extends BasePage {

    public static void confirmarProdutoNaoEncontrado() {
        log.info("***Validando produto sem estoque***");
        String elemento = "//*[contains(text(), 'Não disponível')]";
        //aguardarElementoSerLocalizado(elemento);
        aguardarSegundos(3);
        Assert.assertTrue(verificarSeElementoEstaNaTela(elemento));
    }
}
