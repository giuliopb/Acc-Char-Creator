/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soup;

import java.io.IOException;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author giulio
 */
public class Conta {
    
    public void criaConta(String login, String senha) throws IOException{
        Connection.Response con = (Connection.Response) Jsoup.connect("http://nightmareots.com/register.php")
                .execute();
        String token = con.body().substring(17783, 17823);  //conecta na pagina de registro, pega o token e joga na variavel.
        
        Connection.Response formCreate = (Connection.Response) Jsoup.connect("http://nightmareots.com/register.php")
                .method(Connection.Method.POST)
                .data("username", login)
                .data("password", senha)
                .data("password_again", senha)
                .data("email", login+"@gmail.com")
                .data("flag", "br")
                .data("selected", "1")
                .data("token", token)   // usa o token ali de cima pra validar o login KKKKKKKK
                .execute();
        System.out.println("login: "+login +" e senha: "+senha);
        
            
        
            
    }
    
    public Map<String, String> conecta(String login, String senha) throws IOException{
        Connection.Response loginForm = (Connection.Response) Jsoup.connect("http://nightmareots.com/login.php")
            .method(Connection.Method.POST)
            .data("username", login)
            .data("password", senha)
            .execute();
            if(loginForm.body().contains("Failed to authorize your account")){
                return null;
            }
            Map<String, String> cookies = loginForm.cookies();
            
        return cookies;
    }
    public void criaChar(Map<String, String> cookies, String nome) throws IOException{
        Connection.Response form = (Connection.Response) Jsoup.connect("http://nightmareots.com/createcharacter.php")
                .method(Connection.Method.POST)
                .cookies(cookies)
                .data("name", nome)
                .data("selected_gender", "1")
                .data("selected_vocation", "1")
                .data("selected_town", "1")
                .execute();
    }
}
