package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kuangchangxinxi;

public interface KuangchangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kuangchangxinxi record);

    int insertSelective(Kuangchangxinxi record);

    Kuangchangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kuangchangxinxi record);
	
    int updateByPrimaryKey(Kuangchangxinxi record);
	public Kuangchangxinxi quchongKuangchangxinxi(Map<String, Object> kuangchangmingcheng);
	public List<Kuangchangxinxi> getAll(Map<String, Object> map);
	public List<Kuangchangxinxi> getsykuangchangxinxi1(Map<String, Object> map);
	public List<Kuangchangxinxi> getsykuangchangxinxi3(Map<String, Object> map);
	public List<Kuangchangxinxi> getsykuangchangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kuangchangxinxi> getByPage(Map<String, Object> map);
	public List<Kuangchangxinxi> select(Map<String, Object> map);
//	所有List
}

