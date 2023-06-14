public class Imobiliaria extends Imovel{
    private Imovel[] conjuntoImoveis;

    public Imovel[] getConjuntoImoveis() {
        return conjuntoImoveis;
    }

    public void setConjuntoImoveis(Imovel[] conjuntoImoveis) {
        this.conjuntoImoveis = conjuntoImoveis;
    }


    @Override
    public float precoVenda(float precoCompra) {
        return 0;
    }
}
