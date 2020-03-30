package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import jpa.domain.Tcliente;
import jpa.domain.Tpedido;
import jpa.domain.Tusuario;

public class Service {

	private EntityManagerFactory emf;
	private EntityManager em;

	public Service() {
		emf = Persistence.createEntityManagerFactory("jpaEjemplo");
		em= emf.createEntityManager();
		
	}
	
	public Tcliente obtenerClienteById(int id) {
		return em.find(Tcliente.class, id);
	}
	
	public Tcliente obtenerClienteByNombre(String nombre) {
		Query query = em.createQuery("FROM Tcliente where nombre=:nombre");
		query.setParameter("nombre", nombre);
		
		Tcliente resultado=(Tcliente) query.getSingleResult();
		return resultado;
	}

	public void insertarCliente(Tcliente cliente) {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
		em.persist(cliente);
		em.close();
		em.getTransaction().commit();
	}
	
	public void actualizarCliente(Tcliente cliente) {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
		em.merge(cliente);
		em.close();
		em.getTransaction().commit();
	}
	
	public void begin() {
		em.getTransaction().begin();
	}
	
	public void commit() {
		em.getTransaction().commit();
	}
	
	public void cerrarEntityManager() {
		em.close();
		emf.close();
	}

	public void insertPedidos(List<Tpedido> listaPedidos, Tcliente cliente) {
		/*for(Tpedido p : listaPedidos) {
			cliente.addTpedido(p);
		}
		insertarCliente(cliente);*/
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
		for(Tpedido p : listaPedidos) {
			p.setTcliente(cliente);
			
			em.persist(p);
		}
		em.getTransaction().commit();
	}

	public List<Tusuario> obtenerUsuarios() {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		return (List<Tusuario>)em.createQuery("FROM Tusuario").getResultList();
	}

	public List<Tpedido> obtenerPedidos() {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		return (List<Tpedido>)em.createQuery("FROM Tpedido").getResultList();

	}

	public List<Tcliente> obtenerClientes() {
		if(!em.isOpen()) {
			em = emf.createEntityManager();
		}
		return (List<Tcliente>)em.createQuery("FROM Tcliente").getResultList();
	}

	public void insertarPedido(Tpedido pedido) {
		if(!em.isOpen()) {
			
			em=emf.createEntityManager();
		}
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
		em.close();
		
	}

	public Tusuario logging(Tusuario usuario) {
		Query query =em.createQuery("FROM Tusuario where login = :login and pass=:pass");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("pass", usuario.getPass());
		try {
			return (Tusuario) query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}
	}
	

}
