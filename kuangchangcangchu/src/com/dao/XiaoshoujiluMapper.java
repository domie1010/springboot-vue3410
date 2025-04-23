package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiaoshoujilu;

public interface XiaoshoujiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoshoujilu record);

    int insertSelective(Xiaoshoujilu record);

    Xiaoshoujilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiaoshoujilu record);
	
    int updateByPrimaryKey(Xiaoshoujilu record);
	public Xiaoshoujilu quchongXiaoshoujilu(Map<String, Object> xiaoshoudanhao);
	public List<Xiaoshoujilu> getAll(Map<String, Object> map);
	public List<Xiaoshoujilu> getsyxiaoshoujilu1(Map<String, Object> map);
	public List<Xiaoshoujilu> getsyxiaoshoujilu3(Map<String, Object> map);
	public List<Xiaoshoujilu> getsyxiaoshoujilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiaoshoujilu> getByPage(Map<String, Object> map);
	public List<Xiaoshoujilu> select(Map<String, Object> map);
//	所有List
}

