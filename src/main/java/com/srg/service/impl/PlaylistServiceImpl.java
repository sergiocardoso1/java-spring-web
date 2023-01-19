package com.srg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.srg.dao.PlaylistDAO;
import com.srg.domain.Playlist;
import com.srg.service.PlaylistService;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	private PlaylistDAO playlistDAO;
	
	@Override
	public void inserir(Playlist playlist) {
		playlistDAO.inserir(playlist);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Playlist> buscar() {
		return playlistDAO.buscar();
	}

	@Override
	@Transactional(readOnly = true)
	public Playlist buscarPorID(long id) {
		return playlistDAO.buscarPorID(id);
	}

	@Override
	public void atualizar(Playlist playlist) {
		playlistDAO.atualizar(playlist);
	}

	@Override
	public void excluir(long id) {
		playlistDAO.excluir(id);
		
	}

}
