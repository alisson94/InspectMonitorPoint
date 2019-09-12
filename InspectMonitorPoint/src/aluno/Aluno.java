package aluno;

import curso.Curso;
import disciplina.Disciplina;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import professor.Professor;

@Entity
public class Aluno {
    @Id
    private String matricula;
    private String nome;
    private String email;
    private int semestre;
    private String cpf;
    
    @OneToOne
    private Curso curso;
    @OneToOne
    private Disciplina disciplina;
    @OneToOne
    private Professor professor;
    
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
