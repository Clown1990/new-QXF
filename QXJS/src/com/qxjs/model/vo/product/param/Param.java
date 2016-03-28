package com.qxjs.model.vo.product.param;

public class Param {
    private int paramId;

    private int categoryId;

    private String cname;

    private String ename;

    private int level;
    
    private String categoryCname;
    private String categoryEname;
    
	public String getCategoryEname() {
		return categoryEname;
	}

	public void setCategoryEname(String categoryEname) {
		this.categoryEname = categoryEname;
	}

	public String getCategoryCname() {
		return categoryCname;
	}

	public void setCategoryCname(String categoryCname) {
		this.categoryCname = categoryCname;
	}

	public int getParamId() {
		return paramId;
	}

	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}