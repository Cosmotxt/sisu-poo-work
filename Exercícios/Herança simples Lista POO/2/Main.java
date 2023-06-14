public class Main {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        estudante.setMatricula("2217300");
        estudante.setCurso("Engenharia da computação");
        estudante.setAnoIngresso(2022);

        Bolsista bolsista = new Bolsista();
        bolsista.setValorBolsa(920.35f);

        System.out.printf("Valor para um estudante fazer 10 cópias: " + estudante.precoCopia(10));
        System.out.printf("\nValor para um bolsista fazer 10 cópias: " + bolsista.precoCopia(10));
        System.out.printf("\nQuantidade de cópias que um bolsista consegue fazer com sua bolsa: " + bolsista.copiasComValorDaBolsa());
    }
}
