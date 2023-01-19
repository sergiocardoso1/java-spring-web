package com.srg.dao;

import java.util.List;

import com.srg.domain.Musica;

public interface MusicaDAO {
	
	public void inserir(Musica musica);
	public List<Musica> buscarPorPlaylist(long playlistID);
	public Musica buscarPorPlaylistEMusicaID(long playlistID, long musicaID);
	public void atualizar(Musica musica);
	public void excluir(long musicaID);
}
