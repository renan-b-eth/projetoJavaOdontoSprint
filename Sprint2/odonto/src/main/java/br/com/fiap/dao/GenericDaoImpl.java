package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;

import br.com.fiap.entity.CommitException;
import br.com.fiap.entity.IdNaoEncontradoException;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.util.CollectionUtils;

public abstract class GenericDaoImpl<T,K> implements br.com.fiap.dao.GenericDao<T, K> {

    private EntityManagerFactoryBuilder em;

    private Class<T> clazz;

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManagerFactoryBuilder em) {
        this.em = em;
        //Obter em tempo de execucao o .class da Entidade
        this.clazz = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public void remover(K id) throws IdNaoEncontradoException {
        T entidade = buscar(id);
    }


    public void commit() {

    }
}