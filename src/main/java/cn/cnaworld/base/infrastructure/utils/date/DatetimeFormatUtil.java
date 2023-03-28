package cn.cnaworld.base.infrastructure.utils.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Lucifer
 */
public class DatetimeFormatUtil {
	
	private DatetimeFormatUtil() {
		
	}
	/**
	 * 在某一个时间点上加时间
	 * @param field Calendar.HOUR
	 * @param amount 2
	 */
	public static Date dateTimeAdd(Date date,int field, int amount) {
		//在某一个时间点上加两小时的写法
    	Calendar calendar = Calendar.getInstance();
    	//此处setTime为Date类型
    	calendar.setTime(date);
    	//加上两小时
    	calendar.add(field,amount);
    	return calendar.getTime();
	}
	
	/**
	 * 在某一个时间点上加时间
	 */
	public static Date currentDateTime() {
		long nowMillis = System.currentTimeMillis();
    	return new Date(nowMillis);
	}
	
}
