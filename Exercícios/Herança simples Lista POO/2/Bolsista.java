public class Bolsista extends Estudante{
    private float valorBolsa;

    public float getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(float valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public float precoCopia(float qntPag) {
        return qntPag * 0.07f;
    }

    public float copiasComValorDaBolsa() {
        float qntCopias = valorBolsa/0.07f;
        return qntCopias;

    }
}
