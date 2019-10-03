package monitor;

import aluno.Aluno;
import curso.Curso;
import disciplina.Disciplina;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import professor.Professor;

@Entity
public class Monitor {
    @Id
    @GeneratedValue
    private int id;
    private boolean ativo;
    
    @OneToOne
    private Aluno aluno;
    @OneToOne
    private Professor professor;
    @OneToOne
    private Curso curso;
    @OneToOne
    private Disciplina disciplina;
    
    @Lob
    private byte[] digitalDireita;
    
    @Lob
    private byte[] digitalEsquerda;
    
    public int getId() {
        return id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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

    public byte[] getDigitalDireita() {
        return digitalDireita;
    }

    public void setDigitalDireita(byte[] digitalDireita) {
        this.digitalDireita = digitalDireita;
    }

    public byte[] getDigitalEsquerda() {
        return digitalEsquerda;
    }

    public void setDigitalEsquerda(byte[] digitalEsquerda) {
        this.digitalEsquerda = digitalEsquerda;
    }
    
    
}
