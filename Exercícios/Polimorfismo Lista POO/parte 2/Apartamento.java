public class Apartamento extends Imovel{
    boolean temPiscina;

    @Override
    public float precoVenda(float precoCompra) {
        if(temPiscina && getArea() > 300) {
            return precoCompra + (precoCompra * 0.5f);
        }else {
            return precoCompra + (precoCompra * 0.10f);
        }
    }
}
