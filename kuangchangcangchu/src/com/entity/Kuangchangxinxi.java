package com.entity;

public class Kuangchangxinxi {
    private Integer id;
	private String kuangchangmingcheng;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getKuangchangmingcheng() {
        return kuangchangmingcheng;
    }
    public void setKuangchangmingcheng(String kuangchangmingcheng) {
        this.kuangchangmingcheng = kuangchangmingcheng == null ? null : kuangchangmingcheng.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
