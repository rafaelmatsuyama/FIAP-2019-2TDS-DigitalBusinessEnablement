package br.com.fiap.resource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="T_AULA")
@SequenceGenerator(name="AULA", sequenceName="SQ_T_AULA", allocationSize=1)
@XmlRootElement
public class AulaTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AULA")
	private int codigo;
	@Column
	private String materia;
	@Column
	private String professor;
	@Column
	private int sala;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public AulaTO(int codigo, String materia, String professor, int sala) {
		super();
		this.codigo = codigo;
		this.materia = materia;
		this.professor = professor;
		this.sala = sala;
	}
	public AulaTO() {
		super();
	}
}
