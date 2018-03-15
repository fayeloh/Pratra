package com.fayeloh.tools.excel;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * ��ӡ���
 * 
 * @author lenovo
 * 
 * 
 */
public class JxlExcel {
	/**
	 * ��ӡ�����
	 * 
	 * @param path
	 *            �������·��+����
	 * @param title
	 *            ���ͷ
	 * @param body
	 *            �����
	 */
	public static void print(String path, Object[] title, Object[][] body) {
		// ��ѯ���ͷ��sql��䣺select column_name from information_schema.COLUMNS where
		// table_name='����'
		// �����ļ���
		File file = new File(path);
		try {
			file.createNewFile();
			// ����������
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			// ����sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			// ��ӱ��ͷ
			for (int i = 0; i < title.length; i++) {
				label = new Label(i, 0,  (String) title[i]);// ����n�е�һ��������ݣ��γɱ��ͷ
				sheet.addCell(label);// ��ӵ�sheet��ȥ
			}
			// ׷������
			for (int i = 1; i < body.length; i++) {
				for (int j = 0; j < body[i].length; j++) {

					label = new Label(j, i, (String) body[i][j]);// ��i�е�j��
					sheet.addCell(label);
				}
			}
			// д�������
			workbook.write();
			// �ر���
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
