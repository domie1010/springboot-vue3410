package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kuangwuxinxi;

public interface KuangwuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kuangwuxinxi record);

    int insertSelective(Kuangwuxinxi record);

    Kuangwuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kuangwuxinxi record);
	
    int updateByPrimaryKey(Kuangwuxinxi record);
	public Kuangwuxinxi quchongKuangwuxinxi(Map<String, Object> kuangwubianhao);
	public List<Kuangwuxinxi> getAll(Map<String, Object> map);
	public List<Kuangwuxinxi> getsykuangwuxinxi1(Map<String, Object> map);
	public List<Kuangwuxinxi> getsykuangwuxinxi3(Map<String, Object> map);
	public List<Kuangwuxinxi> getsykuangwuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kuangwuxinxi> getByPage(Map<String, Object> map);
	public List<Kuangwuxinxi> select(Map<String, Object> map);
//	所有List
}

