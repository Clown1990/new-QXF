package com.qxjs.model.vo.product.product;

public class Product {
    private int productId;

    private int categoryId;
    
    private int groupId;

    private String productName;

    private String productCd;

    private String imgPath;

    private String paramJson;

    private String comment;

    private int enable;
    
    private String categoryCname;;

    private String categoryEname;
    
    private String groupCd;

	public String getGroupCd() {
		return groupCd;
	}

	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getParamJson() {
		return paramJson;
	}

	public void setParamJson(String paramJson) {
		this.paramJson = paramJson;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

}