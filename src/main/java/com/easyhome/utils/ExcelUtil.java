package com.easyhome.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 该类实现了将一组对象转换为Excel表格，并且可以将Excel表格中的数据读入到一组List中
 * 该类利用了BeanUtils框架的反射完成
 * 使用本工具时需要在相应的实体中通过ExcelResources来完成相应的注解
 */
@SuppressWarnings("rawtypes")
public class ExcelUtil {
	private static ExcelUtil eu = new ExcelUtil();
	private ExcelUtil(){
		
	}
	public static ExcelUtil getInstance(){
		return eu;
	}
	
	/**
	 *	通过模板导出Excel到输出流
	 *	@param Map<String, String> datas
	 *	@param String template
	 *	@param OutputStream outStream
	 *	@param List objs
	 *	@param Class clz 
	 *	@param boolean isClassPath   
	 */
	
	public void exportObjToExcelByTemplate(Map<String, String> datas ,String template,OutputStream outStream,List objs,Class clz,boolean isClassPath){
		try {
			ExcelTemplate et = handlerObjToExcel(datas, template, objs, clz,
					isClassPath);
			//输出文件
			et.writeToStream(outStream);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	通过模板导出Excel到文件
	 *	@param Map<String, String> datas
	 *	@param String template
	 *	@param String outPath
	 *	@param List objs
	 *	@param Class clz 
	 *	@param boolean isClassPath   
	 */
	public void exportObjToExcelByTemplate(Map<String, String>datas ,String template,String outPath,List objs,Class clz,boolean isClassPath){
		try {
			ExcelTemplate et = handlerObjToExcel(datas, template, objs, clz,
					isClassPath);
			//输出文件
			et.writeToFile(outPath);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	通过创建新的工作簿导出Excel到文件
	 *	@param String outPath
	 *	@param List objs
	 *	@param Class clz 
	 *	@param boolean isXssf   
	 */
	public void exportObjToExcel(String outPath,List objs,Class clz,boolean isXssf){
		Workbook wb = handlerObjToExcel(objs, clz, isXssf);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outPath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 *	通过创建新的工作簿导出Excel到输出流
	 *	@param OutputStream os
	 *	@param List objs
	 *	@param Class clz 
	 *	@param boolean isXssf   
	 */
	public void exportObjToOutputStream(OutputStream os,List objs,Class clz,boolean isXssf){
		Workbook wb = handlerObjToExcel(objs, clz, isXssf);
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Workbook handlerObjToExcel(List objs, Class clz, boolean isXssf){
		Workbook wb = null;
		try {
			if(isXssf){
				wb = new XSSFWorkbook();
			}else{
				wb = new HSSFWorkbook();
			}
			Sheet sheet = wb.createSheet();
			Row row = sheet.createRow(0);
			List<ExcelHeader> headers = getHeaderList(clz);
			Collections.sort(headers);
			//写标题
			for(int i=0;i<headers.size();i++){
				row.createCell(i).setCellValue(headers.get(i).getTitle());
			}
			//写数据
			Object obj =null;
			for(int i=0;i<objs.size();i++){
				row = sheet.createRow(i+1);
				obj = objs.get(i);
				for(int j=0;j<headers.size();j++){
					row.createCell(j).setCellValue(BeanUtils.getProperty(obj, getMethodName(headers.get(j))));
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	private ExcelTemplate handlerObjToExcel(Map<String, String> datas,
			String template, List objs, Class clz, boolean isClassPath)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		ExcelTemplate et = ExcelTemplate.getInstance();
		if(isClassPath){
			et.readTemplateByClassPath(template);
		}else{
			et.readTemplateByPath(template);
		}
		List<ExcelHeader> headers = getHeaderList(clz);
		Collections.sort(headers);
		//输出标题
		et.createNewRow();
		for(ExcelHeader eh:headers){
			et.createCell(eh.getTitle());
		}
		if(objs != null){
			//输出值
			for(Object obj:objs){
				et.createNewRow();
				for(ExcelHeader eh:headers){
					String mn = getMethodName(eh);
					//BeanUtils.getProperty(obj, mn);
					//Method m = clz.getDeclaredMethod(mn);
					//Object rel = m.invoke(obj);
					et.createCell(BeanUtils.getProperty(obj, mn));
				}	
			}
		}
		et.replaceFinalData(datas);
		return et;
	}
	
	private String getMethodName(ExcelHeader eh) {
		String mn = eh.getMethodName();
		//将mn方法名重写 如将getUsername 转换为username
		mn = mn.substring(3).substring(0,1).toLowerCase()+mn.substring(4);
		return mn;
	}
	
	
	/**
	 * 获取Excel列头部名称
	 * @param Class clz
	 * @return List<ExcelHeader>
	 */
	private List<ExcelHeader> getHeaderList(Class clz){
		List<ExcelHeader> header = new ArrayList<ExcelHeader>();
		Method[] method = clz.getDeclaredMethods();
		for(Method m:method){
			String mn = m.getName();
			if(mn.startsWith("get")){
				if(m.isAnnotationPresent(ExcelResources.class)){
					ExcelResources er = m.getAnnotation(ExcelResources.class);
					header.add(new ExcelHeader(er.title(),er.order(),mn));
				}
				
			}
		}
		return header;
	}
	
	/**
	 * 通过classpath（类路径）将Excel读入到一组List中
	 * @param String classpath
	 * @param Class clz
	 * @return List<Object>
	 */
	public List<Object> readExcelToObjsByClasspath(String classpath , Class clz){
		return this.readExcelToObjsByClasspath(classpath, clz, 0,0);
	}
	
	/**
	 * 通过classpath（类路径）将Excel读入到一组List中
	 * @param String classpath
	 * @param Class clz
	 * @param int readLine读入起始行
	 * @param int tailLine尾部不读行
	 * @return List<Object>
	 */
	public List<Object> readExcelToObjsByClasspath(String classpath , Class clz , int readLine,int tailLine){
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(ExcelUtil.class.getResourceAsStream(classpath));
			return handlerExcelToObjs(wb, clz, readLine,tailLine);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过path（web路径）将Excel读入到一组List中
	 * @param String path
	 * @param Class clz
	 * @return List<Object>
	 */
	public List<Object> readExcelToObjsByPath(String path , Class clz){
		return this.readExcelToObjsByPath(path, clz, 0,0);
	}
	
	/**
	 * 通过path（web路径）将Excel读入到一组List中
	 * @param String path
	 * @param Class clz
	 * @param int readLine读入起始行
	 * @param int tailLine尾部不读行
	 * @return List<Object>
	 */
	public List<Object> readExcelToObjsByPath(String path , Class clz , int readLine,int tailLine){
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new File(path));
			return handlerExcelToObjs(wb, clz, readLine,tailLine);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String getCellValue(Cell cell){
		String o = null;
		switch(cell.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			o = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			o = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			o = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			double cellValue = cell.getNumericCellValue();
			DecimalFormat df=new DecimalFormat("#");
			//o = String.valueOf(cell.getNumericCellValue());
			o = df.format(cellValue);
			break;
		case Cell.CELL_TYPE_STRING:
			o = cell.getStringCellValue();
			break;
		default:
			o = null;
			break;
		}
		return o;
	}
	
	private List<Object> handlerExcelToObjs(Workbook wb,Class clz,int readLine,int tailLine){
		Sheet sheet = wb.getSheetAt(0);
		List<Object> objs = null;
		try {
			Row row = sheet.getRow(readLine);
			objs = new ArrayList<Object>();
			Map<Integer, String> maps = getHeaderMap(row, clz);
			if(maps == null || maps.size()<=0){
				throw new RuntimeException("读取Excel格式不正确，检查是否设置了合适的行");
			}
			Object obj = null;
			System.out.println(sheet.getLastRowNum());
			for(int i = readLine+1;i<=sheet.getLastRowNum()-tailLine;i++){
				row = sheet.getRow(i);
				obj = clz.newInstance();
				for(Cell cell:row){
					int ci = cell.getColumnIndex();
					String mn = maps.get(ci).substring(3);
					mn = mn.substring(0,1).toLowerCase()+mn.substring(1);
					BeanUtils.copyProperty(obj,mn, this.getCellValue(cell));
				}
				objs.add(obj);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	/**
	 * 获取标题列表
	 * @param Row titleRow
	 * @param Class clz
	 * @return Map<Integer, String>
	 */
	private Map<Integer, String> getHeaderMap(Row titleRow,	Class clz){
		List<ExcelHeader> headers = getHeaderList(clz);
		Map<Integer, String> maps = new HashMap<Integer, String>();
		for(Cell cell:titleRow){
			String title = cell.getStringCellValue();
			for(ExcelHeader eh:headers){
				if(eh.getTitle().equals(title.trim())){
					//将注解的get方法 替换为set方法 如getName 替换为setName
					maps.put(cell.getColumnIndex(), eh.getMethodName().replace("get", "set"));
					break;
				}
			}
		}
		return maps;
	}
	
}
