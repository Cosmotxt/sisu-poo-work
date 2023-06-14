public class Casa extends Imovel{
    boolean temQuintal;


    @Override
    public float precoVenda(float precoCompra) {
        if (temQuintal || getQntQuartos() > 4) {
            return precoCompra + (precoCompra * 0.3f);
        }else {
            return precoCompra + (precoCompra * 0.15f);
        }
    }
}
