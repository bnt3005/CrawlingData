package nova.devday;

import java.util.Calendar;

import ch.ivyteam.ivy.environment.Ivy;

public class CronJobService {
	
	private static final String COMMA = ",";
	private static final String DAY_CRAWLING_DATA = "com_nova_devday_day_crawling_data";
	private static final String TIME_CRAWLING_DATA = "com_nova_devday_time_crawling_data";
	
	public CronJobService() {
	}
	
	public static CronJobService createInstance() {
		return new CronJobService();
	}
	
	public boolean checkToRunCrawlingData(){
		Calendar calendar = Calendar.getInstance();
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);
		
		String[] daysDownloadZipCode = Ivy.var().get(DAY_CRAWLING_DATA).trim().split(COMMA);
	
		if(daysDownloadZipCode.length == 1 && daysDownloadZipCode[0].equalsIgnoreCase("0")){
			return checkTimeRunCrawlingData(currentHour, currentMinute);
		} else {
			for (String dayDownload : daysDownloadZipCode) {
				if (String.valueOf(currentDay).equalsIgnoreCase(dayDownload.trim())) {
					return checkTimeRunCrawlingData(currentHour, currentMinute);
				}
			}
		}
		return Boolean.FALSE;
	}

	private boolean checkTimeRunCrawlingData(int currentHour, int currentMinute) {
		if (String.valueOf(currentHour).equalsIgnoreCase(Ivy.var().get(TIME_CRAWLING_DATA).trim()) && String.valueOf(currentMinute).equalsIgnoreCase("0")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
