package com.goods.category.servies;

import java.awt.image.RasterFormatException;
import java.sql.SQLException;
import java.util.List;

import com.goods.category.dao.CategoryDao;
import com.goods.category.entity.Category;

/**
 * 业务层
 * @author lenovo
 *
 */
public class CategoryServies {
	CategoryDao categoryDao = new CategoryDao();
	/*
	 * 寻找所有模块分类
	 * */
	public List<Category> findAll(){
		try {
			return categoryDao.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
