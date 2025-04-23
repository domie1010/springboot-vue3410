package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiaoshoujilu;

public interface XiaoshoujiluServer {

  public int add(Xiaoshoujilu po);

  public int update(Xiaoshoujilu po);
  
  
  
  public int delete(int id);

  public List<Xiaoshoujilu> getAll(Map<String,Object> map);
  public List<Xiaoshoujilu> getsyxiaoshoujilu1(Map<String,Object> map);
  public List<Xiaoshoujilu> getsyxiaoshoujilu2(Map<String,Object> map);
  public List<Xiaoshoujilu> getsyxiaoshoujilu3(Map<String,Object> map);
  public Xiaoshoujilu quchongXiaoshoujilu(Map<String, Object> acount);

  public Xiaoshoujilu getById( int id);

  public List<Xiaoshoujilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiaoshoujilu> select(Map<String, Object> map);
}
//	所有List
