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
 * @author 罗伟凡
 * @逻辑层
 * @此类封装的是事务的具体操作
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

	// 返回表头，一维数组
	public String[] getTitle() {
		String[] columnNames = { "id", "状态", "物业位置", "房号", "租户名称", "物业类型", "建筑面积", "套内面积", "公摊面积", "租金", "合同编号", "合同起日",
				"合同止日", "联系电话" };
		return columnNames;
	}

	public void shuchu() {
		WriUser wriUser = new WriUser();
		System.out.println(userDAOImpl.query());
	}
	// 返回二维数组，表格
	// public List<WriUser> getChart(){
	// WriUser wriUser = new WriUser();
	// List<WriUser> tableValues = userDAOImpl.query();
	// Iterator it = tableValues.iterator();
	// Object[][] arr = new Object[2][14];
	// for (int i = 0; i < arr.length; i++) {
	// for (int j = 0; j < arr[1].length; j++) {
	// while(it.hasNext())
	// arr[i][j] = it.next();
	// System.out.println(arr[i][j]); //空指针异常
	// }
	// }
	// List<WriUser> tableValues =new Object[][] {
	// {"1","满", "001", "001","张三", "住房", "13000", "12000", "1200",
	// "1200","001","0828","0828","0660-001"},
	// {"2","满", "002", "002", "李四", "住房","13000", "12000", "1200",
	// "1200","002","0828","0828","0660-002"},
	// {"3","满", "003", "003", "王五", "住房", "13000", "12000", "1200",
	// "1200","003","0828","0828","0660-003"},
	// {"4","满", "004", "004", "小明", "住房", "13000", "12000", "1200",
	// "1200","004","0828","0828","0660-004"},
	// {wriUser.getId(),wriUser.getState(), wriUser.getPlace(), wriUser.getNo(),
	// wriUser.getName(), wriUser.getKind(), wriUser.getStrar(),
	// wriUser.getInspa(), wriUser.getDiar(), wriUser.getRent(),
	// wriUser.getCono(), wriUser.getCost(), wriUser.getCofi(),
	// wriUser.getPhone()},
	// };
	// return tableValues;
	// }

	// 打印表格
	public void print(WriUser wriUser) {
		String[] title = { "id", "状态", "物业位置", "房号", "租户名称", "物业类型", "建筑面积", "套内面积", "公摊面积", "租金", "合同编号", "合同起日",
				"合同止日", "联系电话" };
		// 创建文件
		File file = new File("e:/资料管理表格.xls");
		// 追加数据
		try {
			file.createNewFile();
			// 创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			// 创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			UserDAOImpl u = new UserDAOImpl();
			Object[][] arr = u.query();// 调用查询方法
			// 第一行设置列名
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
