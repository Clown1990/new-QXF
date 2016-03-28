package com.qxjs.model.vo.product.category;

public class Category {
    private int categoryId;

    private String categoryCname;;

    private String categoryEname;

    private int level;

    private int enable;

	public String getCategoryCname() {
		return categoryCname;
	}

	public void setCategoryCname(String categoryCname) {
		this.categoryCname = categoryCname;
	}

	public String getCategoryEname() {
		return categoryEname;
	}

	public void setCategoryEname(String categoryEname) {
		this.categoryEname = categoryEname;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

}