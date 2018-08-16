package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cleal\\Desktop\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //navegando para a página
        navegador.get("http://www.automationpractice.com");

        //Clicar no produto
        navegador.findElement(By.linkText("Blouse")).click();

        //Clicar no botão para adicionar ao carrinho
        navegador.findElement(By.id("add_to_cart")).click();

        //Clicar em prosseguir
        navegador.findElement(By.linkText("Proceed to checkout")).click();

        //Validar se o produto foi corretamente adicionado ao carrinho
        WebElement shopping_cart = navegador.findElement(By.className("shopping_cart"));
        String textoDentroDoCarrinho = shopping_cart.getText();
        Assert.assertEquals("Cart 1 Product", textoDentroDoCarrinho);

        //Clicar em prosseguir
        navegador.findElement(By.linkText("Proceed to checkout")).click();

        //Identificar o campo de e-mail para cadastro
        WebElement formularioCreateAccount = navegador.findElement(By.id("email_create"));

        //Preencher campo e-mail
        formularioCreateAccount.findElement(By.id("email_create")).sendKeys("jucalima@mailinator.com");

        //Clicar no botão Create an Account
        navegador.findElement(By.id("SubmitCreate")).click();

        //Realizar o cadastro de cliente preenchendo todos os campos obrigatórios
        WebElement account_creation_form = navegador.findElement(By.id("account-creation_form"));

        //Preencher campo customer_firstname
        account_creation_form.findElement(By.id("customer_firstname")).sendKeys("Juca");

        //Preencher campo customer_lastname
        account_creation_form.findElement(By.id("customer_lastname")).sendKeys("Lima");

        //Preencher campo passwd
        account_creation_form.findElement(By.id("passwd")).sendKeys("123leal");

        //Preencher campo address1
        account_creation_form.findElement(By.id("address1")).sendKeys("6602 N Federal Hwy");

        //Preencher campo city
        account_creation_form.findElement(By.id("city")).sendKeys("Pompano Beach");

        //Preencher campo id_state
        account_creation_form.findElement(By.id("id_state")).sendKeys("Florida");

        //Preencher campo postcode
        account_creation_form.findElement(By.id("postcode")).sendKeys("33308");

        //Preencher campo phone_mobile
        account_creation_form.findElement(By.id("phone_mobile")).sendKeys("+1 954-351-9103");

        //Preencher campo alias
        account_creation_form.findElement(By.id("alias")).sendKeys("2002 E Sample Rd");

        //Registrar cadastro
        account_creation_form.findElement(By.id("submitAccount")).click();

        //Prosseguir
        navegador.findElement(By.name("processAddress")).click();

        //Concordar
        navegador.findElement(By.id("cgv")).click();

        //Prosseguir
        navegador.findElement(By.name("processCarrier")).click();

        //Escolher forma de pagamento
        navegador.findElement(By.className("bankwire")).click();

        //Confirmar pagamento
        navegador.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).click();

        //Fechar navegador
        navegador.quit();
    }
}
