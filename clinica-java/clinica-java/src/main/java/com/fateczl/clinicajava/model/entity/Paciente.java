package com.fateczl.clinicajava.model.entity;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
@NamedStoredProcedureQuery
(
		name = "Paciente.spCrudPaciente",
		procedureName = "sp_crudpaciente",
		parameters = 
		{
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "cod", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "idPac", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "nomePac", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "CPF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "enderecoPac", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "numPac", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Celular", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "sexo", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "saida", type = String.class)
		}
)
public class Paciente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idPac;
	
	@Column
	private String nomePac;
	
	@Column
	private String CPF;
	
	@Column
	private String enderecoPac;
	
	@Column
	private String numPac;
	
	@Column
	private String celular;
	
	@Column
	private String sexo;
	
	@Column
	private String email;
	
	@Transient
	private int cod;
	
	@Transient
	private String saida;
		
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public int getIdPac() {
		return idPac;
	}
	public void setIdPac(int idPac) {
		this.idPac = idPac;
	}
	public String getNomePac() {
		return nomePac;
	}
	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEnderecoPac() {
		return enderecoPac;
	}
	public void setEnderecoPac(String enderecoPac) {
		this.enderecoPac = enderecoPac;
	}
	public String getNumPac() {
		return numPac;
	}
	public void setNumPac(String numPac) {
		this.numPac = numPac;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Paciente [idPac=" + idPac + ", nomePac=" + nomePac + ", CPF=" + CPF + ", enderecoPac=" + enderecoPac
				+ ", numPac=" + numPac + ", celular=" + celular + ", sexo=" + sexo + ", email=" + email + ", cod=" + cod
				+ ", saida=" + saida + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(CPF, celular, cod, email, enderecoPac, idPac, nomePac, numPac, saida, sexo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(celular, other.celular) && cod == other.cod
				&& Objects.equals(email, other.email) && Objects.equals(enderecoPac, other.enderecoPac)
				&& idPac == other.idPac && Objects.equals(nomePac, other.nomePac)
				&& Objects.equals(numPac, other.numPac) && Objects.equals(saida, other.saida)
				&& Objects.equals(sexo, other.sexo);
	}
	
	
	
	
}
