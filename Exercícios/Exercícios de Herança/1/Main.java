public class Main {
    public static void main(String[] args) {
        Cachorro cachorro1 = new Cachorro();
        cachorro1.setNome("Carlos");
        cachorro1.setPeso(16.8);
        cachorro1.setRaca("Husky");

        System.out.printf("Informações sobre o cachorro:\n" + cachorro1);

        Peixe peixe1 = new Peixe();
        peixe1.setNome("Pedro");
        peixe1.setPeso(2.3);
        peixe1.setTipoHabitat("Água doce");

        System.out.printf("\n\nInformações sobre o peixe:\n" + peixe1);

    }
}
