package com.easyhome.service.dms;

public interface FindStatusQueryService {

	String FindStatusQuery(String omsMasterId,String date,String version);
	String findMonthStatus(String omsMasterId,String date);
}
