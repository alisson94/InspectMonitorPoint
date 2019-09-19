package aluno;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private int id;
    private String matricula;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    
    @Column
    @Lob
    private byte[] fotoAluno;

    public int getId() {
        return id;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public byte[] getFotoAluno() {
        return fotoAluno;
    }

    public void setFotoAluno(byte[] fotoAluno) {
        this.fotoAluno = fotoAluno;
    }
    
    
}
