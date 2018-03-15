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
 * �־ò�
 * @author lenovo
 *
 */
public class CategoryDao {
	QueryRunner qr = new TxQueryRunner();
	/**
	 * ��map�е�Ԫ��ӳ�䵽category��
	 */
	private Category toCategory(Map<String,Object> map){
		//�����Զ���װ��Ԫ���ȷ�װ
		Category category = CommonUtils.toBean(map, Category.class);
		String pid = (String) map.get("pid");
		//�ֶ���װ��Ԫ��
		if(pid!=null){
			Category parent = new Category();//ʹ��һ��������������pid
			parent.setCid(pid);
			category.setParent(parent);
		}
		return category;
	}
	/**
	 * �����mapӳ���һ��list
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
	 * �������з���
	 * @return
	 * @throws SQLException 
	 */
	public List<Category> findAll() throws SQLException{
		//��ѯһ������
		String sql="select * from t_category where pid is null";//��Ϊһ������û�и���
		List<Map<String,Object>> map = qr.query(sql, new MapListHandler());
	    List<Category> parents = toCategoryList(map);
		/*
		 *��������һ�����࣬�õ��������ࡢ
		 *
		 */
	    for(Category parent:parents){
	    	//��ѯ�����ӷ���
	    	List<Category> children = findByParent(parent.getCid());
	    	//�����һ������
	    	parent.setChildren(children);
	    }
		return parents;
	}
	/**
	 * ͨ������������ӷ���
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
