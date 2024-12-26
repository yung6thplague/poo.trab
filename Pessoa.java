import java.io.Serializable;

public class Pessoa implements Serializable {

    private String nome;
    private int nif;
    private String email;
    private int idade;


    public Pessoa(String nome, int nif, String email, int idade){
        this.nome = nome;
        this.nif = nif;
        this.email = email;
        this.idade = idade;
    }

    public Pessoa(){
        nome="";
        nif=0;
        idade=0;
        email="";
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getNif() {
        return nif;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", nif=" + nif +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
