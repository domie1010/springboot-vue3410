package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiaoshoujiluMapper;
import com.entity.Xiaoshoujilu;
import com.server.XiaoshoujiluServer;
@Service
public class XiaoshoujiluServerImpi implements XiaoshoujiluServer {
   @Resource
   private XiaoshoujiluMapper gdao;
	@Override
	public int add(Xiaoshoujilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiaoshoujilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiaoshoujilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiaoshoujilu> getsyxiaoshoujilu1(Map<String, Object> map) {
		return gdao.getsyxiaoshoujilu1(map);
	}
	public List<Xiaoshoujilu> getsyxiaoshoujilu2(Map<String, Object> map) {
		return gdao.getsyxiaoshoujilu2(map);
	}
	public List<Xiaoshoujilu> getsyxiaoshoujilu3(Map<String, Object> map) {
		return gdao.getsyxiaoshoujilu3(map);
	}
	
	@Override
	public Xiaoshoujilu quchongXiaoshoujilu(Map<String, Object> account) {
		return gdao.quchongXiaoshoujilu(account);
	}

	@Override
	public List<Xiaoshoujilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiaoshoujilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiaoshoujilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

