package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KuangwuxinxiMapper;
import com.entity.Kuangwuxinxi;
import com.server.KuangwuxinxiServer;
@Service
public class KuangwuxinxiServerImpi implements KuangwuxinxiServer {
   @Resource
   private KuangwuxinxiMapper gdao;
	@Override
	public int add(Kuangwuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kuangwuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kuangwuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kuangwuxinxi> getsykuangwuxinxi1(Map<String, Object> map) {
		return gdao.getsykuangwuxinxi1(map);
	}
	public List<Kuangwuxinxi> getsykuangwuxinxi2(Map<String, Object> map) {
		return gdao.getsykuangwuxinxi2(map);
	}
	public List<Kuangwuxinxi> getsykuangwuxinxi3(Map<String, Object> map) {
		return gdao.getsykuangwuxinxi3(map);
	}
	
	@Override
	public Kuangwuxinxi quchongKuangwuxinxi(Map<String, Object> account) {
		return gdao.quchongKuangwuxinxi(account);
	}

	@Override
	public List<Kuangwuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kuangwuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kuangwuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

