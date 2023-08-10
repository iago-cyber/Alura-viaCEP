public class Endereco {
    private int cep;
    private String logadouro;
    private String bairro;
    private String localidade;
    private String uf;
    private int ibge;
    private int ddd;

    public Endereco(EnderecoViaCEP enderecoViaCEP) {
        this.cep = Integer.valueOf(enderecoViaCEP.cep());
        this.logadouro = enderecoViaCEP.logadouro();
        this.bairro = enderecoViaCEP.bairro();
        this.localidade = enderecoViaCEP.localidade();
        this.uf = enderecoViaCEP.uf();
        this.ibge = Integer.valueOf(enderecoViaCEP.ibge());
        this.ddd = Integer.valueOf(enderecoViaCEP.ddd());
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep= " + cep +
                ", logadouro= " + logadouro +
                ", bairro= " + bairro +
                ", localidade= " + localidade +
                ", uf= " + uf +
                ", ibge= " + ibge +
                ", ddd= " + ddd +
                '}';
    }
}
