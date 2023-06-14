import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Paulino Souza");
        funcionario1.setCpf("00000000001");
        funcionario1.setSalario(1503.98f);

        Presidente presidente = new Presidente();
        presidente.setNome("Jacob Ferreira");
        presidente.setCpf("00000011100");
        presidente.setSalario(6789.81f);

        System.out.format("Bonus do %s: R$%.2f\n", funcionario1.getNome(), funcionario1.bonus());
        System.out.format("Bonus do %s: R$%.2f\n", presidente.getNome(), presidente.bonus());
    }
}
