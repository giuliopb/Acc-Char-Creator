package soup;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.Map;

public class Soup {

    public static void main(String[] args) throws IOException, InterruptedException{
        WebClient webClient = new WebClient();
        
        HtmlPage page = webClient.getPage("https://univali.br/");
        
        System.out.println(page.asText());
        
        
        
        /*
        Conta conta = new Conta();
        while(true){
            try {
                
                
                Nome nome = new Nome();
                String login = nome.gerar(14);
                String senha = nome.gerar(6);
                conta.criaConta(login, senha);
                
                //System.out.println(login);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        */
    }
}
