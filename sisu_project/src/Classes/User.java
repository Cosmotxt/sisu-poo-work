package Classes;

import Exceptions.AutenticationException;

public class User implements Interfaces.Autentication {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;
    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean autenticarLogin(String email, String senha) throws AutenticationException {
        if(!email.endsWith("@gov.com")){
            throw new AutenticationException("Seu e-mail precisa ser @gov.com.\n");
        }
        if(!senha.matches(".*[A-Z].*") || !senha.matches(".*\\d.*")) {
            throw new AutenticationException("Senha inválida. A senha deve possuir pelo menos uma letra maiúscula e um número.\n");
        }
        else {
            return true;
        }
    }


}
