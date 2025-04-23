package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KuangchangxinxiMapper;
import com.entity.Kuangchangxinxi;
import com.server.KuangchangxinxiServer;
@Service
public class KuangchangxinxiServerImpi implements KuangchangxinxiServer {
   @Resource
   private KuangchangxinxiMapper gdao;
	@Override
	public int add(Kuangchangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kuangchangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kuangchangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kuangchangxinxi> getsykuangchangxinxi1(Map<String, Object> map) {
		return gdao.getsykuangchangxinxi1(map);
	}
	public List<Kuangchangxinxi> getsykuangchangxinxi2(Map<String, Object> map) {
		return gdao.getsykuangchangxinxi2(map);
	}
	public List<Kuangchangxinxi> getsykuangchangxinxi3(Map<String, Object> map) {
		return gdao.getsykuangchangxinxi3(map);
	}
	
	@Override
	public Kuangchangxinxi quchongKuangchangxinxi(Map<String, Object> account) {
		return gdao.quchongKuangchangxinxi(account);
	}

	@Override
	public List<Kuangchangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kuangchangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kuangchangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

