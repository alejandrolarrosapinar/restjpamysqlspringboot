package jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jpa.Util.Util;


/**
 * The persistent class for the tpedidos database table.
 * 
 */
@Entity
@Table(name="tpedidos")
@NamedQuery(name="Tpedido.findAll", query="SELECT t FROM Tpedido t")
public class Tpedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Tcliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Tcliente tcliente;

	public Tpedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	public Tcliente getTcliente() {
		return this.tcliente;
	}

	public void setTcliente(Tcliente tcliente) {
		this.tcliente = tcliente;
	}

	@Override
	public String toString() {
		return "Tpedido [id=" + id + ", fecha=" + Util.formateaFecha(fecha) + ", tcliente=" + tcliente + "]";
	}

	
}