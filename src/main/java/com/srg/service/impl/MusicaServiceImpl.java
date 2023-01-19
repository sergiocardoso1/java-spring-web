package com.srg.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.srg.dao.MusicaDAO;
import com.srg.domain.Musica;
import com.srg.service.MusicaService;
import com.srg.service.PlaylistService;

public class MusicaServiceImpl implements MusicaService{
	
	@Autowired
	private MusicaDAO musicaDAO;

	@Autowired
	private PlaylistService playlistService;
	
	@Override
	public void inserir(Musica musica, Long playlistid) {
		musica.setPlaylist(playlistService.buscarPorID(playlistid));
		musicaDAO.inserir(musica);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Musica> buscarPorPlaylist(long playlistID) {
		return musicaDAO.buscarPorPlaylist(playlistID);
	}

	@Override
	@Transactional(readOnly = true)
	public Musica buscarPorPlaylistEMusicaID(long playlistID, long musicaID) {
		return musicaDAO.buscarPorPlaylistEMusicaID(playlistID, musicaID);
	}

	@Override
	public void atualizar(Musica musica, long playlistID) {
		musica.setPlaylist(playlistService.buscarPorID(playlistID));
		musicaDAO.atualizar(musica);
		
	}

	@Override
	public void excluir(long playlistID, long musicaID) {
		musicaDAO.excluir(buscarPorPlaylistEMusicaID(playlistID, musicaID).getId());
		
	}

}
