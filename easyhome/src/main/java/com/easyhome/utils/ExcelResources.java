package com.easyhome.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用来在对象的get方法上加入的annotation，通过annotation说明某个属性对应的标题
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
	/**
	 * 属性的标题名称
	 */
	String title();
	/**
	 * 表题的顺序，即，行标题在单元格Row中的顺序起始值为1
	 */
	int order() default 9999;
}
