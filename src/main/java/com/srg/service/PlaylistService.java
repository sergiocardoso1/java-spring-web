package com.srg.service;

import java.util.List;

import com.srg.domain.Playlist;

public interface PlaylistService {
	public void inserir(Playlist playlist);
	public List<Playlist> buscar();
	public Playlist buscarPorID(long id);
	public void atualizar(Playlist playlist);
	public void excluir(long id);
}
