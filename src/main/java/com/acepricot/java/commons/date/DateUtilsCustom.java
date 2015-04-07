/**
 * 
 */
package com.acepricot.java.commons.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;




/**
 * @author quixy
 *
 */
public class DateUtilsCustom {
	
    
    /**
     * <p>Checks if two calendars represent the same day ignoring time.</p>
     * @param cal1  the first calendar, not altered, not null
     * @param cal2  the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }
    
    
    public static boolean isSameDay(Date date1, Date date2) {
    	date1 = DateUtils.truncate(date1, Calendar.DATE);
		date2 = DateUtils.truncate(date2, Calendar.DATE);
	    return date1.compareTo(date2) == 0 ? true : false;
    }
   
    
    /**
     * <p>Checks if a calendar date is today.</p>
     * @param cal  the calendar, not altered, not null
     * @return true if cal date is today
     * @throws IllegalArgumentException if the calendar is <code>null</code>
     */
    public static boolean isToday(Calendar cal) {
        return isSameDay(cal, Calendar.getInstance());
    }
    
    
    /**
     * <p>Checks if the first calendar date is before the second calendar date ignoring time.</p>
     * @param cal1 the first calendar, not altered, not null.
     * @param cal2 the second calendar, not altered, not null.
     * @return true if cal1 date is before cal2 date ignoring time.
     * @throws IllegalArgumentException if either of the calendars are <code>null</code>
     */
    public static boolean isBeforeDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        if (cal1.get(Calendar.ERA) < cal2.get(Calendar.ERA)) return true;
        if (cal1.get(Calendar.ERA) > cal2.get(Calendar.ERA)) return false;
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) return true;
        if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) return false;
        return cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR);
    }
    
    
    public static boolean isBeforeDay(Date date1, Date date2) {
    	date1 = DateUtils.truncate(date1, Calendar.DATE);
		date2 = DateUtils.truncate(date2, Calendar.DATE);
	    return date1.compareTo(date2) < 0 ? true : false;
    }
    
    
    /**
     * <p>Checks if the first calendar date is after the second calendar date ignoring time.</p>
     * @param cal1 the first calendar, not altered, not null.
     * @param cal2 the second calendar, not altered, not null.
     * @return true if cal1 date is after cal2 date ignoring time.
     * @throws IllegalArgumentException if either of the calendars are <code>null</code>
     */
    public static boolean isAfterDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        if (cal1.get(Calendar.ERA) < cal2.get(Calendar.ERA)) return false;
        if (cal1.get(Calendar.ERA) > cal2.get(Calendar.ERA)) return true;
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) return false;
        if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) return true;
        return cal1.get(Calendar.DAY_OF_YEAR) > cal2.get(Calendar.DAY_OF_YEAR);
    }
    
    
    public static boolean isAfterDay(Date date1, Date date2) {
    	date1 = DateUtils.truncate(date1, Calendar.DATE);
    	date2 = DateUtils.truncate(date2, Calendar.DATE);
        return date1.compareTo(date2) > 0 ? true : false;
    }
    
   
    /**
     * <p>Checks if a calendar date is after today and within a number of days in the future.</p>
     * @param cal the calendar, not altered, not null
     * @param days the number of days.
     * @return true if the calendar date day is after today and within days in the future .
     * @throws IllegalArgumentException if the calendar is <code>null</code>
     */
    public static boolean isWithinDaysFuture(Calendar cal, int days) {
        if (cal == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar today = Calendar.getInstance();
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DAY_OF_YEAR, days);
        return (isAfterDay(cal, today) && ! isAfterDay(cal, future));
    }
    
    
    public static Date getFirstDayOfTheYear(int year) {
    	
    	// get first day of the year
		Calendar firstDayOfThisYear = Calendar.getInstance();
		firstDayOfThisYear.clear();
		firstDayOfThisYear.set(Calendar.YEAR, year);
		firstDayOfThisYear.set(Calendar.DAY_OF_YEAR, 1);
		
		return firstDayOfThisYear.getTime();
    }
 
 
    public static Date getLastDayOfTheYear(int year) {
    	
    	// get last day of the year
    	Calendar lastDayOfThisYear = Calendar.getInstance();
		lastDayOfThisYear.clear();
		lastDayOfThisYear.set(Calendar.YEAR, year);
		lastDayOfThisYear.set(Calendar.DAY_OF_YEAR, 1);
		lastDayOfThisYear.add(Calendar.YEAR,1);
		lastDayOfThisYear.add(Calendar.MILLISECOND,-1);
		
		return lastDayOfThisYear.getTime();
    }
    
    public static Date getFirstMonthOfTheYear(int year) {
    	
    	// get first month of the year
    	Calendar firstMonthOfTheYear = Calendar.getInstance();
    	firstMonthOfTheYear = org.apache.commons.lang3.time.DateUtils.truncate(firstMonthOfTheYear, Calendar.MONTH);    	
		firstMonthOfTheYear.set(Calendar.YEAR, year);
		firstMonthOfTheYear.set(Calendar.MONTH, firstMonthOfTheYear.getActualMinimum(Calendar.MONTH));
		
		return firstMonthOfTheYear.getTime();
    }
    
    public static Date getLastMonthOfTheYear(int year) {
    	
    	// get first month of the year
    	Calendar lastMonthOfTheYear = Calendar.getInstance();
    	lastMonthOfTheYear = org.apache.commons.lang3.time.DateUtils.truncate(lastMonthOfTheYear, Calendar.MONTH);    	
		lastMonthOfTheYear.set(Calendar.YEAR, year);
		lastMonthOfTheYear.set(Calendar.MONTH, lastMonthOfTheYear.getActualMaximum(Calendar.MONTH));
		
		return lastMonthOfTheYear.getTime();
    }
    
    public static Date getFirstDayOfTheWeek(Date date, Locale locale) {
    	
    	// Locale must be used here, because it affects the start of the week
    	
    	date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
    	
    	Calendar firstDayOfTheWeek = Calendar.getInstance(locale);
    	firstDayOfTheWeek.setTime(date);    	
		firstDayOfTheWeek.set(Calendar.DAY_OF_WEEK, firstDayOfTheWeek.getFirstDayOfWeek());
		
		return firstDayOfTheWeek.getTime();
    }
    
    public static Date getLastDayOfTheWeek(Date date, Locale locale) {
    	
    	// Locale must be used here, because it affects the start of the week
    	
    	date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
    	
    	Calendar firstDayOfTheWeek = Calendar.getInstance(locale);
    	firstDayOfTheWeek.setTime(date);    	
		firstDayOfTheWeek.set(Calendar.DAY_OF_WEEK, firstDayOfTheWeek.getFirstDayOfWeek());
		firstDayOfTheWeek.add(Calendar.WEEK_OF_YEAR, 1);
		firstDayOfTheWeek.add(Calendar.DATE, -1);
		
		return firstDayOfTheWeek.getTime();
    }

    public static Date getFirstDayOfTheMonth(Date date) {
    	
    	date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
    	
    	Calendar firstDayOfTheMonth = Calendar.getInstance();
    	firstDayOfTheMonth.setTime(date);    	
		firstDayOfTheMonth.set(Calendar.DATE, firstDayOfTheMonth.getActualMinimum(Calendar.DATE));
		
		return firstDayOfTheMonth.getTime();
    }
    
    public static Date getLastDayOfTheMonth(Date date) {
    	
    	date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
    	
    	Calendar lastDayOfTheMonth = Calendar.getInstance();
    	lastDayOfTheMonth.setTime(date);  
		lastDayOfTheMonth.set(Calendar.DATE, lastDayOfTheMonth.getActualMaximum(Calendar.DATE));
		
		return lastDayOfTheMonth.getTime();
    }
    
    public static Date getBeginOfDay(Date day) {
    	return DateUtils.truncate(day, Calendar.DATE);		
    }
    
    public static Date getEndOfDay(Date day) {
    	
        if (day == null) day = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE,      cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND,      cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        
        return cal.getTime();
    }
    
    
	public static final Date getToday() {
		return DateUtils.truncate(new Date(), Calendar.DATE);		
	}
	
	public static final Date getYesterday() {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(getToday());
	    cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	public static final Date getTomorrow() {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(getToday());
	    cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
		
	public static final Date getDay(Date date) {
		return DateUtils.truncate(date, Calendar.DATE);
	}
    
	public static final Date getMonth(Date date) {
		return DateUtils.truncate(date, Calendar.MONTH);
	}
	
}
