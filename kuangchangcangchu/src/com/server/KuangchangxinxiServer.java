package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kuangchangxinxi;

public interface KuangchangxinxiServer {

  public int add(Kuangchangxinxi po);

  public int update(Kuangchangxinxi po);
  
  
  
  public int delete(int id);

  public List<Kuangchangxinxi> getAll(Map<String,Object> map);
  public List<Kuangchangxinxi> getsykuangchangxinxi1(Map<String,Object> map);
  public List<Kuangchangxinxi> getsykuangchangxinxi2(Map<String,Object> map);
  public List<Kuangchangxinxi> getsykuangchangxinxi3(Map<String,Object> map);
  public Kuangchangxinxi quchongKuangchangxinxi(Map<String, Object> acount);

  public Kuangchangxinxi getById( int id);

  public List<Kuangchangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kuangchangxinxi> select(Map<String, Object> map);
}
//	所有List
