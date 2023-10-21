public class Endereco {
    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco(String logradouro, String string, String bairro, String cep, String cidade, String uf){
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero(){
        return numero;
    }

    public String getBairro(){
        return bairro;
    }

    public String getCep(){
        return cep;
    }

    public String getCidade(){
        return cidade;
    }

    public String getUf(){
        return uf;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}