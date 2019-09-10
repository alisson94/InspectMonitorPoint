package disciplina;

import curso.Curso;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import professor.Professor;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToOne
    private Curso curso;
    @OneToOne
    private Professor professor;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    
}
