package com.qxjs.model.vo.collocation;

public class Collocation {
    private int collocationId;

    private int type;

    private String imgPath;

    private int xValue;

    private int yValue;
    
    private int width;
    
    private int height;
    
    private String categoryCname;

	public String getCategoryCname() {
		return categoryCname;
	}

	public void setCategoryCname(String categoryCname) {
		this.categoryCname = categoryCname;
	}

	public int getCollocationId() {
		return collocationId;
	}

	public void setCollocationId(int collocationId) {
		this.collocationId = collocationId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getxValue() {
		return xValue;
	}

	public void setxValue(int xValue) {
		this.xValue = xValue;
	}

	public int getyValue() {
		return yValue;
	}

	public void setyValue(int yValue) {
		this.yValue = yValue;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}