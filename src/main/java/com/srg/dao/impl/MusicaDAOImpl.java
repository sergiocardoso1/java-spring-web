package com.srg.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.srg.dao.MusicaDAO;
import com.srg.domain.Musica;

@Repository
public class MusicaDAOImpl implements MusicaDAO {

	@PersistenceContext
	public EntityManager em;

	@Override
	public void inserir(Musica musica) {
		em.persist(musica);

	}

	@Override
	public List<Musica> buscarPorPlaylist(long playlistID) {
		return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
				.setParameter("playlistId", playlistID).getResultList();
	}

	@Override
	public Musica buscarPorPlaylistEMusicaID(long playlistID, long musicaID) {
		return em
				.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId",
						Musica.class)
				.setParameter("playlistId", playlistID).setParameter("musicaId", musicaID).getSingleResult();
	}

	@Override
	public void atualizar(Musica musica) {
		em.merge(musica);
	}

	@Override
	public void excluir(long musicaId) {
		em.remove(em.getReference(Musica.class, musicaId));
	}

}
