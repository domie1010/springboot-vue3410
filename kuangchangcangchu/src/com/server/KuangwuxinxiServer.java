package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kuangwuxinxi;

public interface KuangwuxinxiServer {

  public int add(Kuangwuxinxi po);

  public int update(Kuangwuxinxi po);
  
  
  
  public int delete(int id);

  public List<Kuangwuxinxi> getAll(Map<String,Object> map);
  public List<Kuangwuxinxi> getsykuangwuxinxi1(Map<String,Object> map);
  public List<Kuangwuxinxi> getsykuangwuxinxi2(Map<String,Object> map);
  public List<Kuangwuxinxi> getsykuangwuxinxi3(Map<String,Object> map);
  public Kuangwuxinxi quchongKuangwuxinxi(Map<String, Object> acount);

  public Kuangwuxinxi getById( int id);

  public List<Kuangwuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kuangwuxinxi> select(Map<String, Object> map);
}
//	所有List
