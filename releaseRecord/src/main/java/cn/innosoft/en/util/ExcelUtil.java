package cn.innosoft.en.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.innosoft.en.util.EnUtil;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.biff.RowsExceededException;

/**
 * Excel的工具类
 * 
 * @author ye
 *
 */
public class ExcelUtil {

	/**
	 * 输入excel文件的绝对路径
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		 ReadExcel("C:/Users/ye/Desktop/8月4周/数据导出/假设指定名单2.xlsx");
		// CreateExcel("ExcelTest5");
		 //creatWorkbookByfilePath("D:/金华市废水处理氧化亚氮排放清单.xls");
	}

	
	
	public static Workbook  creatWorkbookByfilePath(String filePath) throws IOException{
		boolean isE2010 = false; // 判断是否是excel2010格式
		InputStream input = null;
		Workbook wb = null;
		if (filePath.endsWith("xlsx")) {
			isE2010 = true;
		}
		input = new FileInputStream(filePath); // 建立输入流
		wb = null;
		// 根据文件格式(2003或者2013)来初始化
		if (isE2010) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		return wb;
	}
	/**
	 * Excel文件读取（以每一个单元格输出）
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void ReadExcel(String fileName) throws IOException {
		boolean isE2010 = false; // 判断是否是excel2010格式
		InputStream input = null;
		Workbook wb = null;
		if (fileName.endsWith("xlsx")) {
			isE2010 = true;
		}
		try {
			input = new FileInputStream(fileName); // 建立输入流
			wb = null;
			// 根据文件格式(2003或者2013)来初始化
			if (isE2010) {
				wb = new XSSFWorkbook(input);
			} else {
				wb = new HSSFWorkbook(input);
			}
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);// 获得表单
				Iterator<Row> rows = sheet.rowIterator(); // 获得第i个表单的迭代器
				while (rows.hasNext()) {
					Row row = rows.next(); // 获得行数据
					System.out.println("============================");
					System.out.println("SheetName: " + sheet.getSheetName());
					System.out.println("Row: #" + row.getRowNum()); // 获得行号从0开始
					Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
					while (cells.hasNext()) {
						Cell cell = cells.next();
						System.out.println("Cell: #" + cell.getColumnIndex());
						//if (cell.getColumnIndex()!=0){
							
							switch (cell.getCellType()) { // 根据cell中的类型来输出数据
							case HSSFCell.CELL_TYPE_NUMERIC:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									double d = cell.getNumericCellValue();
									Date date = HSSFDateUtil.getJavaDate(d);
									SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
									System.out.println(dformat.format(date));
								} else {
									HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
									String orgCode = dataFormatter.formatCellValue(cell);
									System.out.println("data"+dataFormatter.formatCellValue(cell));
								}
								break;
							case HSSFCell.CELL_TYPE_STRING:							
								System.out.println("string"+cell.getStringCellValue());
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN:
								System.out.println(cell.getBooleanCellValue());
								break;
							case HSSFCell.CELL_TYPE_FORMULA:
								System.out.println("for"+cell.getCellFormula());
								break;
							default:
								System.out.println("unsuported sell type");
								break;
							}
						//}
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			input.close();
			((FileInputStream) wb).close();
		}
	}

	// 创建Excel
	public static void CreateExcel(String fileName) throws IOException {
		Workbook[] wbs = new Workbook[] { new HSSFWorkbook(), new XSSFWorkbook() };
		System.out.println("********创建开始**************");
		for (int i = 0; i < wbs.length; i++) {
			Workbook wb = wbs[i];
			Sheet sheet = wb.createSheet("专家库");
			for (int rowNum = 1; rowNum < 100; rowNum++) {
				Row row = sheet.createRow(rowNum);
				for (int cloumn = 0; cloumn < 9; cloumn++) {
					Cell cell = row.createCell(cloumn, Cell.CELL_TYPE_STRING);
					CellStyle cellStyle = wb.createCellStyle();
					DataFormat format = wb.createDataFormat();
					cellStyle.setDataFormat(format.getFormat("@"));
					cell.setCellStyle(cellStyle);
				}
			}
			// Save
			String filename = fileName + ".xls";
			if (wb instanceof XSSFWorkbook) {
				filename = filename + "x";
				System.out.println("*********创建" + filename + "完成***********");
			}
			FileOutputStream out = new FileOutputStream(filename);
			wb.write(out);
			out.close();
		}
	}

	/**
	 * 读取excel中单元格信息（以excel中展示的样子进行输出）
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void ReadExcel2(String fileName) throws IOException {
		boolean isE2010 = false; // 判断是否是excel2010格式
		InputStream input = null;
		Workbook wb = null;
		if (fileName.endsWith("xlsx")) {
			isE2010 = true;
		}
		try {
			input = new FileInputStream(fileName); // 建立输入流
			if (isE2010) {
				wb = new XSSFWorkbook(input);
			} else {
				wb = new HSSFWorkbook(input);
			}
			// 获取sheet数目
			for (int t = 0; t < wb.getNumberOfSheets(); t++) {
				Sheet sheet = wb.getSheetAt(t);
				Row row = null;
				int lastRowNum = sheet.getLastRowNum();
				// 循环读取
				for (int i = 0; i <= lastRowNum; i++) {
					row = sheet.getRow(i);
					if (row != null) {
						// 获取每一列的值
						for (int j = 0; j < row.getLastCellNum(); j++) {
							Cell cell = row.getCell(j);
							String value = getCellValue(cell);
							if (!value.equals("")) {
								System.out.print(value + " | ");
							}
						}
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((FileInputStream) wb).close();
		}
	}

	// 读取单元格信息
	private static String getCellValue(Cell cell) {
		Object result = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				result = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Date date = HSSFDateUtil.getJavaDate(d);
					SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
					result = dformat.format(date);
				} else {
					HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
					result = dataFormatter.formatCellValue(cell);
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_ERROR:
				result = cell.getErrorCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			default:
				break;
			}
		}
		return result.toString();
	}

	// ==================================================转换EXCEL==============================================================
	public static MyClass[] myClass;// 存放跨行信息
	public static int class_len = 0;// 跨行类数组长度

	public static void makeExcel(Document doc, WritableSheet sheet) {
		myClass = new MyClass[1000];// 定义数组长度100，数组扩容没有做。
		class_len = 0;
		int[] columns = new int[1000];
		NodeList list_tr = doc.getFirstChild().getChildNodes();// 获取所有的<tr>节点
		for (int i = 0; i < list_tr.getLength(); i++) {
			NodeList list_td = list_tr.item(i).getChildNodes();// 获取当前tr下的所有<td>节点
			int x = 0, y = i;// 默认从第0列，第i行填充单元格
			// 获取 myClass 数组的MyClass对象，代表前面几行有多少个跨行单元格
			for (int k = 0; k < ExcelUtil.class_len; k++) {
				MyClass t_class = ExcelUtil.myClass[k];
				x += t_class.colspan;// 初始列数从跨行单元格的宽度（即单元格所跨的列数）开始，多个则累加
				t_class.count--;// 剩余需跨行数减1
				if (t_class.count <= 0) {
					ExcelUtil.delClassList(k);// 函数第k个元素
					k--;// 循环定位回当前删除元素的前一个元素
				}
			}
			for (int j = 0; j < list_td.getLength(); j++) {
				try {
					Element node = (Element) list_td.item(j);
					String rowspan = node.getAttribute("rowspan");// 跨行数
					String colspan = node.getAttribute("colspan");// 跨列数
					String text = node.getTextContent();
					rowspan = "".equals(rowspan) ? "1" : rowspan;// 默认跨1行
					colspan = "".equals(colspan) ? "1" : colspan;// 默认跨1列
					WritableCellFormat headerFormat = new WritableCellFormat();
					headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
					WritableCellFormat wcf_tip = new WritableCellFormat();
					wcf_tip.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
					wcf_tip.setBackground(jxl.format.Colour.GREY_25_PERCENT);
					WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
					WritableCellFormat wcf_title = new WritableCellFormat(wf_title);
					wcf_title.setAlignment(jxl.format.Alignment.CENTRE);
					sheet.mergeCells(x, y, x + Integer.parseInt(colspan) - 1, y + Integer.parseInt(rowspan) - 1);// 合并单元格
					if (text.length() + 5 > columns[x]) {
						columns[x] = text.length() + 5;
						sheet.setColumnView(x, columns[x]);
					}
					// 单端单元格内容是否是数字，正则不好写，直接用try，catch代替
					try {
						double d_text = Double.parseDouble(text);

						jxl.write.Number number = new jxl.write.Number(x, y, d_text, headerFormat);// 数字格式
						sheet.addCell(number);
					} catch (Exception ex) {
						Label label;
						if (x == 0 && y == 0)
							label = new Label(x, y, text, wcf_title);
						else if (x == 0 && y == 1)
							label = new Label(x, y, text, wcf_tip);// 一般文本格式
						else
							label = new Label(x, y, text, headerFormat);
						sheet.addCell(label);
					}
					x += Integer.parseInt(colspan);// 列坐标增加
					if (Integer.parseInt(rowspan) >= 2) {// 如果要跨行，加入myClass数组中
						MyClass tClass = new MyClass(Integer.parseInt(colspan), Integer.parseInt(rowspan) - 1);
						myClass[class_len++] = tClass;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}
	
	// 关键报表专用（基于poi）
	public static void makeExcelByPivotalReport(Document doc, HSSFSheet sheet,String hideTr,String cityTr,HSSFWorkbook wb) {
		myClass = new MyClass[1000];// 定义数组长度100，数组扩容没有做。
		class_len = 0;
		int[] columns = new int[1000];
		NodeList list_tr = doc.getFirstChild().getChildNodes();// 获取所有的<tr>节点
		Map<String,String> hideMap = EnUtil.jsonToMap(hideTr);
		Map<String,String> cityMap = EnUtil.jsonToMap(cityTr);
		for (int i = 0; i < list_tr.getLength(); i++) {
			NodeList list_td = list_tr.item(i).getChildNodes();// 获取当前tr下的所有<td>节点
			int x = 0, y = i;// 默认从第0列，第i行填充单元格
			// 获取 myClass 数组的MyClass对象，代表前面几行有多少个跨行单元格
			for (int k = 0; k < ExcelUtil.class_len; k++) {
				MyClass t_class = ExcelUtil.myClass[k];
				x += t_class.colspan;// 初始列数从跨行单元格的宽度（即单元格所跨的列数）开始，多个则累加
				t_class.count--;// 剩余需跨行数减1
				if (t_class.count <= 0) {
					ExcelUtil.delClassList(k);// 函数第k个元素
					k--;// 循环定位回当前删除元素的前一个元素
				}
			}
			HSSFRow row=sheet.createRow(y+4);      
			for (int j = 0; j < list_td.getLength(); j++) {
				Element node = (Element) list_td.item(j);
				String rowspan = node.getAttribute("rowspan");// 跨行数
				String colspan = node.getAttribute("colspan");// 跨列数
				String text = node.getTextContent();
				rowspan = "".equals(rowspan) ? "1" : rowspan;// 默认跨1行
				colspan = "".equals(colspan) ? "1" : colspan;// 默认跨1列
				Cell cell = row.createCell(j);  
				cell.setCellValue(text);;
				sheet.addMergedRegion(new CellRangeAddress(y , y + Integer.parseInt(rowspan) - 1,x, x + Integer.parseInt(colspan) - 1));
				if( cityMap.get(String.valueOf(y+4)) != null ){
					HSSFCellStyle cellStyle=wb.createCellStyle();
					cellStyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);
					cellStyle.setFillForegroundColor(new HSSFColor.LIGHT_TURQUOISE().getIndex());
					cell.setCellStyle(cellStyle);
				}
				 x += Integer.parseInt(colspan);// 列坐标增加
				 if (Integer.parseInt(rowspan) >= 2) {// 如果要跨行，加入myClass数组中
						MyClass tClass = new MyClass(Integer.parseInt(colspan), Integer.parseInt(rowspan) - 1);
						myClass[class_len++] = tClass;
					}
			}

		}
		Set<String> rowNums = hideMap.keySet();
		for(String rowNum : rowNums){
			sheet.getRow(Integer.valueOf(rowNum)).setZeroHeight(true);;
		}
//		Set<String> rowStyleNums = cityMap.keySet();
//		for(String rowStyleNum : rowStyleNums){
//			CellStyle cellStyle=wb.createCellStyle();
//			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//			cellStyle.setFillForegroundColor(new HSSFColor.LIGHT_TURQUOISE().getIndex());
//			sheet.getRow(Integer.valueOf(rowStyleNum)).setRowStyle(cellStyle);;
//		}
	}
	
	// 关键报表专用
	public static void makeExcelByPivotalReport(Document doc, WritableSheet sheet,String hideTr,String cityTr) {
		myClass = new MyClass[1000];// 定义数组长度100，数组扩容没有做。
		class_len = 0;
		int[] columns = new int[1000];
		NodeList list_tr = doc.getFirstChild().getChildNodes();// 获取所有的<tr>节点
		Map<String,String> hideMap = EnUtil.jsonToMap(hideTr);
		Map<String,String> cityMap = EnUtil.jsonToMap(cityTr);
		for (int i = 0; i < list_tr.getLength(); i++) {
			NodeList list_td = list_tr.item(i).getChildNodes();// 获取当前tr下的所有<td>节点
			int x = 0, y = i;// 默认从第0列，第i行填充单元格
			// 获取 myClass 数组的MyClass对象，代表前面几行有多少个跨行单元格
			for (int k = 0; k < ExcelUtil.class_len; k++) {
				MyClass t_class = ExcelUtil.myClass[k];
				x += t_class.colspan;// 初始列数从跨行单元格的宽度（即单元格所跨的列数）开始，多个则累加
				t_class.count--;// 剩余需跨行数减1
				if (t_class.count <= 0) {
					ExcelUtil.delClassList(k);// 函数第k个元素
					k--;// 循环定位回当前删除元素的前一个元素
				}
			}
			for (int j = 0; j < list_td.getLength(); j++) {
				try {
					Element node = (Element) list_td.item(j);
					String rowspan = node.getAttribute("rowspan");// 跨行数
					String colspan = node.getAttribute("colspan");// 跨列数
					String text = node.getTextContent();
					rowspan = "".equals(rowspan) ? "1" : rowspan;// 默认跨1行
					colspan = "".equals(colspan) ? "1" : colspan;// 默认跨1列
					WritableCellFormat headerFormat = new WritableCellFormat();
					headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
					headerFormat.setAlignment(jxl.format.Alignment.CENTRE);
					WritableCellFormat wcf_tip = new WritableCellFormat();
					wcf_tip.setVerticalAlignment(VerticalAlignment.CENTRE);// 垂直居中
					wcf_tip.setAlignment(jxl.format.Alignment.CENTRE);
					wcf_tip.setBackground(jxl.format.Colour.LIGHT_TURQUOISE);
					WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
					WritableCellFormat wcf_title = new WritableCellFormat(wf_title);
					wcf_title.setAlignment(jxl.format.Alignment.CENTRE);
					if(text.equals("填报1") || text.equals("初审通过1") || text.equals("终审通过1")){
						int x1 = 0;
						int y1 = 0;
					if(text.equals("填报1")){
							text = "填报";
							x1 = 2;
							y1 = 2;
						}else if(text.equals("初审通过1")){
							text = "初审通过";
							x1 = 5;
							y1 = 2;
						}else if(text.equals("终审通过1")){
							text = "终审通过";
							x1 = 8;
							y1 = 2;
						}
						sheet.mergeCells(x1, y1, x1 + Integer.parseInt(colspan) - 1, y1 + Integer.parseInt(rowspan) - 1);// 合并单元格
						if (text.length() + 5 > columns[x1]) {
							columns[x1] = text.length() + 5;
							sheet.setColumnView(x1, columns[x1]);
						}
						// 单端单元格内容是否是数字，正则不好写，直接用try，catch代替
						try {
							if( cityMap.get(String.valueOf(y)) != null ){
								Label label;
								label = new Label(x1, y1, text, wcf_tip);
								sheet.addCell(label);
							}else{
								double d_text = Double.parseDouble(text);
								
								jxl.write.Number number = new jxl.write.Number(x1, y1, d_text, headerFormat);// 数字格式
								sheet.addCell(number);
							}
						} catch (Exception ex) {
							Label label;
							if (x == 0 && y == 0){
								label = new Label(x1, y1, text, wcf_title);
							}else if(cityMap.get(String.valueOf(y)) != null ){
								label = new Label(x1, y1, text, wcf_tip);
							}else{
								label = new Label(x1, y1, text, headerFormat);
							}
							sheet.addCell(label);
						}
						x += Integer.parseInt(colspan);// 列坐标增加
						if (Integer.parseInt(rowspan) >= 2) {// 如果要跨行，加入myClass数组中
							MyClass tClass = new MyClass(Integer.parseInt(colspan), Integer.parseInt(rowspan) - 1);
							myClass[class_len++] = tClass;
						}
					}else{
						sheet.mergeCells(x, y, x + Integer.parseInt(colspan) - 1, y + Integer.parseInt(rowspan) - 1);// 合并单元格
						if (text.length() + 5 > columns[x]) {
							columns[x] = text.length() + 5;
							sheet.setColumnView(x, columns[x]);
						}
						// 单端单元格内容是否是数字，正则不好写，直接用try，catch代替
						try {
							if( cityMap.get(String.valueOf(y)) != null ){
								Label label;
								label = new Label(x, y, text, wcf_tip);
								sheet.addCell(label);
							}else{
								double d_text = Double.parseDouble(text);
								
								jxl.write.Number number = new jxl.write.Number(x, y, d_text, headerFormat);// 数字格式
								sheet.addCell(number);
							}
						} catch (Exception ex) {
							Label label;
							if (x == 0 && y == 0){
								label = new Label(x, y, text, wcf_title);
							}else if(cityMap.get(String.valueOf(y)) != null){
								label = new Label(x, y, text, wcf_tip);
							}else{
								label = new Label(x, y, text, headerFormat);
							}
							sheet.addCell(label);
						}
						x += Integer.parseInt(colspan);// 列坐标增加
						if (Integer.parseInt(rowspan) >= 2) {// 如果要跨行，加入myClass数组中
							MyClass tClass = new MyClass(Integer.parseInt(colspan), Integer.parseInt(rowspan) - 1);
							myClass[class_len++] = tClass;
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
//		for(int i =  0; i<sheet.getRows(); i++){
//			if(hideMap.get(String.valueOf(i)) != null){
//				try {
//					sheet.setRowView(i, false);
//				} catch (RowsExceededException e) {
//					e.printStackTrace();
//				};
//			}
//		}
	}

	public static class MyClass// 存在跨行显示的单元格信息
	{
		public int colspan = 0;// 跨行单元格，对应所跨的列数，一般单元格为1
		public int count = 0;// 剩余几行需要跨行，一般单元格剩余0行需要跨行

		public MyClass(int colspan, int count)// 构造函数
		{
			this.colspan = colspan;
			this.count = count;
		}
	}

	public static void delClassList(int n)// 删除数组中指定位置的元素
	{
		for (int i = n; i < class_len - 1; i++) {
			myClass[i] = myClass[i + 1];
		}
		class_len--;// 数组长度减1
	}

	/**
	 * 替换为空
	 * 
	 * @param content
	 * @param s
	 * @return
	 */
	public static String toXlsString(String content, String s, String replaceString) {
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(content);
		StringBuffer str = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(str, replaceString);
		}
		m.appendTail(str);
		content = str.toString();
		return content;
	}

	public static String toXlsStringRepalceValue(String content, String s, String value) {
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(content);
		StringBuffer str = new StringBuffer();
		while (m.find()) {
			String a = m.group(0);
			Pattern p1 = Pattern.compile("value=\"(.+?)\"");
			Matcher m1 = p1.matcher(a);
			String t = "";
			while (m1.find()) {
				t = m1.group(1);
			}
			if (t.length() > 0) {
				t = t.replaceAll("<", "@");
				t = t.replaceAll(">", "#");
			}
			m.appendReplacement(str, value.replace("-", t));
		}
		m.appendTail(str);
		content = str.toString();
		return content;
	}
}
