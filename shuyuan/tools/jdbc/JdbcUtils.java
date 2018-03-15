package com.fayeloh.tools.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * �������ݿ⣬ʹ�ñ���������Ҫ��c3p0-config.xml�ļ�
 * @author lenovo
 *
 */
public class JdbcUtils {
	//����ʽ����ģʽ
	private static DataSource ds = new ComboPooledDataSource();
	/*
	 * ��������ʱ����con��ֵ
	 * �ر�����ʱ����con��ֵΪnull
	 * �����ڿ�������ʱ���ö��dao�������connection,�̱߳�����
	 */
	private static ThreadLocal<Connection> t1 =new ThreadLocal<Connection>();
	//ȡ������Դ
	public static DataSource getDataSource(){
		return ds;
	}
	//ȡ�����ݿ�����
	public static Connection getConnection() throws SQLException{
		Connection con = t1.get();//��ȡ��ǰ�̵߳�����
		if(con != null)return con;  //����������ӣ����ص�ǰ����
		return ds.getConnection();  //���������ӣ������ݿ����ӳز����µ�����
	}
	/*
	 * ��������
	 */
	public static void beginTransaction() throws SQLException{
		Connection con = t1.get();//��ȡ��ǰ�̵߳�����
		if(con!=null)throw new SQLException("�Ѿ����������񣬲����ظ�����");
		con = ds.getConnection();
		con.setAutoCommit(false);//�����ֶ��ύ
		t1.set(con); //�ѵ�ǰ�������ӷŵ�t1��
	}
	/*
	 * �ع�����
	 */
	public static void rollbackTransaction() throws SQLException{
		Connection con = t1.get();//��ȡ��ǰ�̵߳�����
		if(con==null)throw new SQLException("����δ���������ܻع�");
		con.rollback();//���ûع�
		con.close();//�ر����� 
		con = null;
		t1.remove(); //�ѵ�ǰ�����Ƴ�
	}
	/*
	 * �ύ����
	 */
	public static void commitTransaction() throws SQLException{
		Connection con = t1.get();//��ȡ��ǰ�̵߳�����
		if(con==null)throw new SQLException("�Ѿ����������񣬲����ύ");
		con.commit();//�����ύ
		con.close();//�ر�����
		con = null;
		t1.set(con); //�ѵ�ǰ�������ӷŵ�t1��
	}
	/**
	 * �Ͽ�����
	 * @param connection
	 * @throws SQLException
	 */
	public static void releaseConnection(Connection connection) throws SQLException{
		Connection con = t1.get();//��ȡ��ǰ�̵߳�����
		if(connection != con){//�����ǰ���������뵱ǰ�������Ӳ�ͬ
			if(connection!=null && !connection.isClosed()){//�����ǰ�������δ���ӣ��ر�֮
				connection.close();
			}
		}
	}
}
