package com.srg.service;

import java.util.List;

import com.srg.domain.Musica;

public interface MusicaService {
	public void inserir(Musica musica, Long id);
	public List<Musica> buscarPorPlaylist(long playlistID);
	public Musica buscarPorPlaylistEMusicaID(long playlistID, long musicaID);
	public void atualizar(Musica musica, long playlistID);
	public void excluir(long playlistID,long musicaID);
}
