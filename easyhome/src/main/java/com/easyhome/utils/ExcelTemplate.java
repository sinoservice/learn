package com.easyhome.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 基于模板的excel导出工具，主要功能有数据按章模板的样式输出到文件和输出流
 * 若插入序号，需要在excel中定义一个标识为sernum 的单元格样式
 * 若要替换固定单元格内容，需在传入Map参数，Map中存储着替换的内容，在模板单元格以#开头
 * 若要从设定的地方开始写入，在模板中定义一个 datas 的样式，即开始写入值的单元格
 * 如果要设定列相对应的格式，可以对应单元各种设置 styles 的样式
 * 默认样式为defaulStyles ，如果没有则 样式为datas样式
 */
public class ExcelTemplate {
	/**
	 * 数据开始位置 
	 */
	private final static String DATA_LINE = "datas";
	/**
	 * 默认样式 
	 */
	private final static String DEFAULT_STYLE ="defaultStyle";
	/**
	 * 列样式 
	 */
	private final static String STYLE = "styles";
	/**
	 * 插入序号起始位置 
	 */
	private final static String SER_NUM = "sernum";
	private static ExcelTemplate et = new ExcelTemplate();
	private Workbook wb;
	private Sheet sheet;
	/**
	 * 数据初始化行数 
	 */
	private int initColIndex;
	/** 
	 * 数据初始化列数 
	 */
	private int initRowIndex;
	/** 
	 * 当前行数 
	 */
	private int curColIndex;
	/** 
	 * 当前列数 
	 */
	private int curRowIndex;
	/** 
	 * 当前行对象 
	 */
	private Row curRow;
	/**
	 * 最后一行行号
	 */
	private int lastRowIndex;
	/**
	 *	初始化样式
	 */
	private CellStyle defaultStyle;
	/**
	 * 默认行高 
	 */
	private float rowHeight;
	/**
	 *	存储某一行的样式 
	 */
	private Map<Integer, CellStyle> styles = new HashMap<Integer, CellStyle>();
	/**
	 * 序号的列 
	 */
	private int serColIndex;
	private ExcelTemplate(){
		
	}
	
	public static ExcelTemplate getInstance(){
		return et;
	}
	
	/**
	 * 基于类路径加载模板 （与java代码放在一起）
	 * @param String path
	 * @return ExcelTemplate
	 */
	public ExcelTemplate readTemplateByClassPath(String path){
		try {
			wb = WorkbookFactory.create(ExcelTemplate.class.getResourceAsStream(path));
			initTemplate();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板格式错误！，请检查");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板不存在！，请检查");
		}
		return this;
	}
	
	/**
	 * 将Excel文件写入到文件
	 * @param String filePath
	 */
	public void writeToFile(String filePath){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("写入的文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("写入数据失败"+e.getMessage());
		}finally{
			if(fos !=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	/**
	 * 将Excel文件写入到输出流
	 * @param OutputStream os 
	 */
	public void writeToStream(OutputStream os){
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("写入流失败");
		}
	}

	/**
	 * 基于文件加载模板 （与web代码放在一起）
	 * @param String path
	 * @return ExcelTemplate
	 */
	public ExcelTemplate readTemplateByPath(String path){
		try {
			wb = WorkbookFactory.create(new File(path));
			initTemplate();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板格式错误！，请检查"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板不存在！，请检查"+e.getMessage());
		}
		return this;
	}
	
	/**
	 *	创建单元格 ，一下是他的多个重载 方便多种写入单元格值的
	 * 	@param String value
	 */
	public void createCell(String value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(int value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(boolean value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(Date value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(double value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(float value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	public void createCell(Calendar value){
		Cell cell = curRow.createCell(curColIndex);
		setCellStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}
	
	/**
	 * 设置单元格样式 
	 * @param Cell cell
	 */
	private void setCellStyle(Cell cell){
		if(styles.containsKey(curColIndex)){
			cell.setCellStyle(styles.get(curColIndex));
		}else{
			cell.setCellStyle(defaultStyle);
		}
	}
	
	/**
	 * 创建excel行
	 */
	public void createNewRow(){
		if(lastRowIndex>curRowIndex && curRowIndex != initRowIndex){
			sheet.shiftRows(curRowIndex, lastRowIndex, 1, true, true);
			lastRowIndex++;
		}
		curRow = sheet.createRow(curRowIndex);
		curRow.setHeightInPoints(rowHeight);
		curRowIndex++;
		curColIndex = initColIndex;
	}
	
	/**
	 *	初始化Excel模板 
	 */
	private void initTemplate(){
		sheet = wb.getSheetAt(0);
		initConfigData();
		lastRowIndex = sheet.getLastRowNum();
		curRow = sheet.createRow(curRowIndex);
	}
	
	/**
	 *	插入序号 
	 */
	public void insertSer(){
		int index = 1;
		Row row = null;
		Cell cell = null;
		for(int i = initRowIndex;i<curRowIndex;i++){
			row = sheet.getRow(i);
			cell = row.createCell(serColIndex);
			setCellStyle(cell);
			cell.setCellValue(index++);
		}
	}
	
	/**
	 * 替换固定的值如Excel标题，创建日期等
	 * Map<String, String> datas
	 */
	public void replaceFinalData(Map<String, String> datas){
		if(datas == null){
			return;
		}
		for(Row row:sheet){
			for(Cell cell:row){
				if(cell.getCellType() != Cell.CELL_TYPE_STRING) {
					continue;
				}
				String str = cell.getStringCellValue().trim();
				if(str.startsWith("#")){
					if(datas.containsKey(str.substring(1))){
						cell.setCellValue(datas.get(str.substring(1)));
					}
				}
			}
		}
	}

	/**
	 * 初始化配置数据 包括写如值的起始，终止位置，出入序号，设置行高，替换固定的位置值
	 * 
	 */
	private void initConfigData() {
		boolean findData = false;
		boolean findSer = false;
		for(Row row:sheet){
			if(findData) {
				break;
			}
			for(Cell cell:row){
				if(cell.getCellType() != Cell.CELL_TYPE_STRING) {
					continue;
				}
				String str = cell.getStringCellValue().trim();
				if(str.equals(SER_NUM)){
					serColIndex = cell.getColumnIndex();
					findSer = true;
				}
				if(str.equals(DATA_LINE)){
					initColIndex = cell.getColumnIndex();
					initRowIndex = row.getRowNum();
					curColIndex = initColIndex;
					curRowIndex = initRowIndex;
					findData = true;
 					defaultStyle = cell.getCellStyle();
					rowHeight = row.getHeightInPoints();
					initStyles();
					break;
				}
			}
		}
		if(!findSer){
			initSer();
		}
	}

	/**
	 * 初始化序号 
	 */
	private void initSer() {
		for(Row row:sheet){
			for(Cell cell:row){
				if(cell.getCellType() != Cell.CELL_TYPE_STRING) {
					continue;
				}
				String str = cell.getStringCellValue().trim();
				if(str.equals(SER_NUM)){
					serColIndex = cell.getColumnIndex();
				}
			}
		}
		
	}

	/**
	 *	初始化样式 
	 */
	private void initStyles() {
		styles = new HashMap<Integer, CellStyle>();
		for(Row row:sheet){
			for(Cell cell:row){
				if(cell.getCellType() != Cell.CELL_TYPE_STRING) {
					continue;
				}
				String str = cell.getStringCellValue().trim();
				if(str.equals(DEFAULT_STYLE)){
					defaultStyle = cell.getCellStyle();
				}
				if(str.equals(STYLE)){
					styles.put(cell.getColumnIndex(), cell.getCellStyle());
				}
			}
		}
	}
}
