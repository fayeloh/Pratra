package com.goods.category.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.jdbc.TxQueryRunner;
import com.goods.category.entity.Category;

/**
 * 持久层
 * @author lenovo
 *
 */
public class CategoryDao {
	QueryRunner qr = new TxQueryRunner();
	/**
	 * 将map中的元素映射到category中
	 */
	private Category toCategory(Map<String,Object> map){
		//将能自动封装的元素先封装
		Category category = CommonUtils.toBean(map, Category.class);
		String pid = (String) map.get("pid");
		//手动封装父元素
		if(pid!=null){
			Category parent = new Category();//使用一个父分类来拦截pid
			parent.setCid(pid);
			category.setParent(parent);
		}
		return category;
	}
	/**
	 * 将多个map映射成一个list
	 * @param list
	 * @return
	 */
	private List<Category> toCategoryList(List<Map<String,Object>> maplist){
		List<Category> CategoryList = new ArrayList<Category>();
		for(Map<String,Object> map:maplist){
			Category c = toCategory(map);
			CategoryList.add(c);
		}
		return CategoryList;
	}
	/**
	 * 返回所有分类
	 * @return
	 * @throws SQLException 
	 */
	public List<Category> findAll() throws SQLException{
		//查询一级分类
		String sql="select * from t_category where pid is null";//因为一级分类没有父类
		List<Map<String,Object>> map = qr.query(sql, new MapListHandler());
	    List<Category> parents = toCategoryList(map);
		/*
		 *遍历所有一级分类，得到二级分类、
		 *
		 */
	    for(Category parent:parents){
	    	//查询所有子分类
	    	List<Category> children = findByParent(parent.getCid());
	    	//分配给一级分类
	    	parent.setChildren(children);
	    }
		return parents;
	}
	/**
	 * 通过父分类查找子分类
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	private List<Category> findByParent(String pid) throws SQLException{
		String sql="select * from t_category where pid=? order by orderBy";
		List<Map<String,Object>> maplist = qr.query(sql, new MapListHandler(),pid);
		return toCategoryList(maplist);
	}
}
