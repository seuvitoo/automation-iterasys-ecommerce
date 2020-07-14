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
    private By nomeDoProdutos = By.cssSelector(".product-description a");
    private By precoDosProdutos = By.className("price");
    private By botaoSignin = By.cssSelector("#_desktop_user_info span.hidden-sm-down");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public int contarProdutos() {
        carregarListaProdutos();
        return listaProdutos.size();
    }

    private void carregarListaProdutos() {
        listaProdutos = driver.findElements(produtos);

    }

    public int obterQtdadeProdCarrinho() {

        String quantidadeProdCarrinho = driver.findElement(produtosNoCarrinho).getText();
        quantidadeProdCarrinho = quantidadeProdCarrinho.replace("(", "");
        quantidadeProdCarrinho = quantidadeProdCarrinho.replace(")", "");

        int qtdProdutosCarrinho = Integer.parseInt(quantidadeProdCarrinho);

        return qtdProdutosCarrinho;
    }

    public String obterNomeProduto(int indice) {

        return driver.findElements(nomeDoProdutos).get(indice).getText();

    }

    public String obterPrecoProduto(int indice) {

        return driver.findElements(precoDosProdutos).get(indice).getText();
    }

    public ProdutoPage clicarProduto(int indice) {

        driver.findElements(nomeDoProdutos).get(indice).click();

        return new ProdutoPage(driver);
    }

    public LoginPage clicarBotaoSignIn(){
        driver.findElement(botaoSignin).click();
        return new LoginPage(driver);
    }
}
