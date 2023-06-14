public class Conta implements Seguranca {
    private String cpf;
    private String senha;
    private double saldo;

    public Conta(String cpf, String senha, double saldo) {
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    String saca(double valor, String senha) {
        if (verificarSenha(senha)) {
            return mensagemSucesso();
        }else {
            return mensagemFracasso();
        }
    }

    String deposita(double valor, String senha) {
        if (verificarSenha(senha)) {
            return mensagemSucesso();
        }else {
            return mensagemFracasso();
        }
    }
    @Override
    public boolean verificarSenha(String senha) {
        if(senha.equals(this.senha)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String mensagemSucesso() {
        return "Sucesso. Senha correta.\n";
    }

    @Override
    public String mensagemFracasso() {
        return "\nFalha. Senha incorreta. Tente novamente.";
    }
}
