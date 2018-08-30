package com.brother.base.impl;

import com.brother.base.IBaseDao;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;




public class BaseDao<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

    private String ns;

    @Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }



    public String getNs() {
        return ns;
    }

    public void setNs(String ns){
        this.ns = ns;
    }

    @Override
    public List<T> findAll(Object paramObject) {
        // TODO Auto-generated method stub
        return getSqlSession().selectList(this.ns + ".findAll", paramObject);
    }

    @Override
    public T get(Serializable paramSerializable) {
        return getSqlSession().selectOne(this.ns + ".get", paramSerializable);
    }

    @Override
    public void insert(T paramT) {
        getSqlSession().insert(this.ns + ".insert", paramT);

    }

    @Override
    public void update(T paramT) {
        getSqlSession().update(this.ns + ".update", paramT);

    }

    @Override
    public void deleteById(Serializable paramSerializable) {
        getSqlSession().delete(this.ns + ".deleteById", paramSerializable);

    }

    @Override
    public void delete(Serializable[] paramArrayOfSerializable) {
        getSqlSession().delete(this.ns + ".delete", paramArrayOfSerializable);

    }

    @Override
    public int count(Map paramMap) {
        return ((Integer)getSqlSession().selectOne(this.ns + ".count", paramMap)).intValue();
    }

    @Override
    public void findAllHandler(Object paramObject, ResultHandler paramResultHandler) {
        // TODO Auto-generated method stub

    }

}
