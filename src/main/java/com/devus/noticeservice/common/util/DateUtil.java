package com.devus.noticeservice.common.util;

import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static DateTimeFormatter getDateTimeFormat() {
		return DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	}
}
