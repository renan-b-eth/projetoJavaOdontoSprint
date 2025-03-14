package br.com.fiap.dao;

import br.com.fiap.entity.CommitException;
import br.com.fiap.entity.IdNaoEncontradoException;


public interface GenericDao<T,K> {

    T salvar(T entidade);


    T buscar(K id) throws IdNaoEncontradoException;

    void commit() throws CommitException;

}