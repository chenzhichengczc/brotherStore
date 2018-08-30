package com.brother.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;

public interface IBaseDao<T> {
    public abstract List<T> findAll(Object paramObject);

    public abstract T get(Serializable paramSerializable);

    public abstract void insert(T paramT);

    public abstract void update(T paramT);

    public abstract void deleteById(Serializable paramSerializable);

    public abstract void delete(Serializable[] paramArrayOfSerializable);

    public abstract int count(Map paramMap);

    public abstract void findAllHandler(Object paramObject, ResultHandler paramResultHandler);
}
