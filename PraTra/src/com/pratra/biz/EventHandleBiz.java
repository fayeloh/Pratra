package com.pratra.biz;

import java.io.File;

import java.io.IOException;

import com.pratra.dao.UserDAOImpl;
import com.pratra.dao.UserDAOProxy;
import com.pratra.entity.WriUser;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author ��ΰ��
 * @�߼���
 * @�����װ��������ľ������
 */
public class EventHandleBiz {

	private UserDAOProxy userDAOProxy;
	private UserDAOImpl userDAOImpl;
	private WriUser wriUser;

	public EventHandleBiz() {
		init();
	}

	private void init() {
		userDAOProxy = new UserDAOProxy();
	}

	public WriUser insert(WriUser wriUser) {
		return userDAOProxy.insert(wriUser);
	}

	// ���ر�ͷ��һά����
	public String[] getTitle() {
		String[] columnNames = { "id", "״̬", "��ҵλ��", "����", "�⻧����", "��ҵ����", "�������", "�������", "��̯���", "���", "��ͬ���", "��ͬ����",
				"��ֹͬ��", "��ϵ�绰" };
		return columnNames;
	}

	public void shuchu() {
		WriUser wriUser = new WriUser();
		System.out.println(userDAOImpl.query());
	}
	// ���ض�ά���飬���
	// public List<WriUser> getChart(){
	// WriUser wriUser = new WriUser();
	// List<WriUser> tableValues = userDAOImpl.query();
	// Iterator it = tableValues.iterator();
	// Object[][] arr = new Object[2][14];
	// for (int i = 0; i < arr.length; i++) {
	// for (int j = 0; j < arr[1].length; j++) {
	// while(it.hasNext())
	// arr[i][j] = it.next();
	// System.out.println(arr[i][j]); //��ָ���쳣
	// }
	// }
	// List<WriUser> tableValues =new Object[][] {
	// {"1","��", "001", "001","����", "ס��", "13000", "12000", "1200",
	// "1200","001","0828","0828","0660-001"},
	// {"2","��", "002", "002", "����", "ס��","13000", "12000", "1200",
	// "1200","002","0828","0828","0660-002"},
	// {"3","��", "003", "003", "����", "ס��", "13000", "12000", "1200",
	// "1200","003","0828","0828","0660-003"},
	// {"4","��", "004", "004", "С��", "ס��", "13000", "12000", "1200",
	// "1200","004","0828","0828","0660-004"},
	// {wriUser.getId(),wriUser.getState(), wriUser.getPlace(), wriUser.getNo(),
	// wriUser.getName(), wriUser.getKind(), wriUser.getStrar(),
	// wriUser.getInspa(), wriUser.getDiar(), wriUser.getRent(),
	// wriUser.getCono(), wriUser.getCost(), wriUser.getCofi(),
	// wriUser.getPhone()},
	// };
	// return tableValues;
	// }

	// ��ӡ���
	public void print(WriUser wriUser) {
		String[] title = { "id", "״̬", "��ҵλ��", "����", "�⻧����", "��ҵ����", "�������", "�������", "��̯���", "���", "��ͬ���", "��ͬ����",
				"��ֹͬ��", "��ϵ�绰" };
		// �����ļ�
		File file = new File("e:/���Ϲ�����.xls");
		// ׷������
		try {
			file.createNewFile();
			// ����������
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			// ����sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			UserDAOImpl u = new UserDAOImpl();
			Object[][] arr = u.query();// ���ò�ѯ����
			// ��һ����������
			for (int i = 0; i < title.length; i++) {
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			for (int i = 1; i < 17; i++) {
				label = new Label(0, i, (String) arr[i][0]);
				sheet.addCell(label);
				label = new Label(1, i, (String) arr[i][1]);
				sheet.addCell(label);
				label = new Label(2, i, (String) arr[i][2]);
				sheet.addCell(label);
				label = new Label(3, i, (String) arr[i][3]);
				sheet.addCell(label);

				label = new Label(4, i, (String) arr[i][4]);
				sheet.addCell(label);
				label = new Label(5, i, (String) arr[i][5]);
				sheet.addCell(label);
				label = new Label(6, i, (String) arr[i][6]);

				sheet.addCell(label);
				label = new Label(7, i, (String) arr[i][7]);
				sheet.addCell(label);
				label = new Label(8, i, (String) arr[i][8]);
				sheet.addCell(label);
				label = new Label(9, i, (String) arr[i][9]);
				sheet.addCell(label);

				label = new Label(10, i, (String) arr[i][10]);
				sheet.addCell(label);
				label = new Label(11, i, (String) arr[i][11]);
				sheet.addCell(label);
				label = new Label(12, i, (String) arr[i][12]);
				sheet.addCell(label);
				label = new Label(13, i, (String) arr[i][13]);
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
