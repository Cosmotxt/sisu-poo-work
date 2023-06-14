public class Presidente extends Funcionario{
    private int qntAcoes;

    public int getQntAcoes() {
        return qntAcoes;
    }

    public void setQntAcoes(int qntAcoes) {
        this.qntAcoes = qntAcoes;
    }

    public float bonus() {
        return getSalario() * 0.10f;
    }
}
