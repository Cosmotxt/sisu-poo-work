public class Email implements Seguranca{
    private String name;
    private String email;
    private String senhaEmail;

    public Email(String name, String email, String senhaEmail) {
        this.name = name;
        this.email = email;
        this.senhaEmail = senhaEmail;
    }


    @Override
    public boolean verificarSenha(String senha) {
        if(senha.equals(this.senhaEmail)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String mensagemSucesso() {
        return "Acesso concedido. Senha correta.\n";
    }

    @Override
    public String mensagemFracasso() {
        return "\nAcesso negado. Senha incorreta. Tente novamente.";
    }
}
