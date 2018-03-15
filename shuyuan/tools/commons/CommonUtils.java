package com.fayeloh.tools.commons;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
/**
 * СС����
 * @author lenovo
 * �õ����似��
 *
 */
public class CommonUtils {
	private static String hex[] = {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	//����32λ���ظ��ַ�����������������֤��
	public static String uuid(){
		UUID uuid= UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}
	/**
	 * ��map��װ��ָ����javabean��
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T>T toBean(Map<String,Object> map,Class<T> clazz){
		/*
		 * ͨ��clazz����ʵ��
		 * �ý�map�����ݷ�װ��bean��
		 */
		try {
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);//ע��ת����
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
	
}
