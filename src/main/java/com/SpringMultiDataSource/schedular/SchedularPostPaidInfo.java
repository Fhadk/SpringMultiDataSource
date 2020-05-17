package com.SpringMultiDataSource.schedular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.SpringMultiDataSource.response.domain.PostpaidInfoResponse;
import com.SpringMultiDataSource.service.PostpaidInfoService;
import com.SpringMultiDataSource.tabs.domain.TabsInfoResponse;

@Component
public class SchedularPostPaidInfo {
	private Logger logger = Logger.getLogger(SchedularPostPaidInfo.class);
	private static Map<String,Integer> tabsInfoResponse;
	private static List<PostpaidInfoResponse> postpaidRequest;
	
	
	@Autowired
	PostpaidInfoService postPaidService;
	
	@Value("${InfoRequestStatus}")
	private String status;
	
//	@Async
	@Scheduled(cron = "*/15 * * * * *") // midnight 0 0 * * * * Live(everyFiveMintues) */300 * * * * * Running */15 * * * * *
	public void cronJob() {
		System.out.println(LocalDate.now() + " " + LocalTime.now() + "  Schedular Strated PostpaidInfo !!!");		
		try {
//			tabsInfoResponse = postPaidService.getInfoTabs("3214406262");
//			for(TabsInfoResponse res: tabsInfoResponse) {
//				logger.debug("FreeMinsOnNet = " + res.S_FREE_ON_MIN 
//					+ " FreeMinsOffNet = " + res.S_FREE_OFF_MIN
//					+ " UsedOffMin = " + res.S_USED_OFF_MIN);    
//			}
			
//			tabsInfoResponse.forEach((k, v) -> System.out.println((k + ":" + v)));
			
			
			
			
			
			postpaidRequest = postPaidService.getPostpaidInfoRequest(status);
			for(PostpaidInfoResponse req: postpaidRequest) {
				logger.debug("ShortCode = " + req.getShortcode() 
					+ " Subno = " + req.getSubno()
					+ " Message = " + req.getMessage());
			
			
			}
			
			
			
			
			
		} catch (Exception e) {
			logger.error(" Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
