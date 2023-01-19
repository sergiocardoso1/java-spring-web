package com.srg.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.srg.dao.PlaylistDAO;
import com.srg.domain.Playlist;

@Repository
public class PlaylistDAOImpl implements PlaylistDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void inserir(Playlist playlist) {
		em.persist(playlist);
		
	}

	@Override
	public List<Playlist> buscar() {
		return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
	}

	@Override
	public Playlist buscarPorID(long id) {
		return em.find(Playlist.class,id);
	}

	@Override
	public void atualizar(Playlist playlist) {
		em.merge(playlist);
	
	}

	@Override
	public void excluir(long id) {
		em.remove(em.getReference(Playlist.class, id));
	}
	
}
