public class Preguica extends Animal{
    private boolean escala;

    public boolean isEscala() {
        return escala;
    }

    public void setEscala(boolean escala) {
        this.escala = escala;
    }

    @Override
    public void som() {
        System.out.println("beee");
    }
}
