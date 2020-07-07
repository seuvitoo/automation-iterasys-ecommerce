package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    List<WebElement> listaProdutos = new ArrayList();

    private By produtos = By.className("product-description");
    private By produtosNoCarrinho = By.className("cart-products-count");

    public HomePage(WebDriver driver){
        this.driver = driver;

    }

    public int contarProdutos() {
        carregarListaProdutos();
        return listaProdutos.size();
    }

    private void carregarListaProdutos(){
        listaProdutos = driver.findElements(produtos);

    }

    public int obterQtdadeProdCarrinho() {

        String quantidadeProdCarrinho =   driver.findElement(produtosNoCarrinho).getText();
        quantidadeProdCarrinho = quantidadeProdCarrinho.replace("(", "");
        quantidadeProdCarrinho = quantidadeProdCarrinho.replace(")", "");

        int qtdProdutosCarrinho = Integer.parseInt(quantidadeProdCarrinho);

      return qtdProdutosCarrinho;
    }
}
