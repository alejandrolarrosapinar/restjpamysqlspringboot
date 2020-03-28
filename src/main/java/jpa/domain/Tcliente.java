package jpa.domain;

import java.io.Serializable;
import javax.persistence.*;

import javax.persistence.CascadeType;

import jpa.Util.Util;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tclientes database table.
 * 
 */
@Entity
@Table(name="tclientes")
@NamedQuery(name="Tcliente.findAll", query="SELECT t FROM Tcliente t")
public class Tcliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to Tpedido
	@OneToMany(mappedBy="tcliente", fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Tpedido> tpedidos;

	public Tcliente(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	public Tcliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public List<Tpedido> getTpedidos() {
		return this.tpedidos;
	}

	public void setTpedidos(List<Tpedido> tpedidos) {
		this.tpedidos = tpedidos;
	}

	public Tpedido addTpedido(Tpedido tpedido) {
		getTpedidos().add(tpedido);
		tpedido.setTcliente(this);

		return tpedido;
	}

	public Tpedido removeTpedido(Tpedido tpedido) {
		getTpedidos().remove(tpedido);
		tpedido.setTcliente(null);

		return tpedido;
	}

	@Override
	public String toString() {
		return "Tcliente [id=" + id + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", fechaNacimiento=" + Util.formateaFecha(fechaNacimiento) + ", nombre=" + nombre + ", tpedidos=" + tpedidos + "]";
	}
	
	

}