package com.SpringMultiDataSource.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.SpringMultiDataSource.response.domain.PostpaidInfoResponse;
import com.SpringMultiDataSource.response.repo.PostpaidInfoResponseRepo;
//import com.SpringMultiDataSource.request.domain.PostpaidInfoRequest;
import com.SpringMultiDataSource.tabs.domain.TabsInfoResponse;
//import com.SpringMultiDataSource.request.repo.PostpaidInfoRequestRepo;
import com.SpringMultiDataSource.tabs.repo.TabsRepo;

@Service
public class PostpaidInfoService {
	private Logger logger = Logger.getLogger(PostpaidInfoService.class);

	 @Autowired
	 PostpaidInfoResponseRepo<PostpaidInfoResponse> postpaidInfoRepo;

	@Autowired
	TabsRepo tabsRepo;

	@Value("${QueryResulLimit}")
	private int queryResultLimit;

	 @Transactional
	 public List<PostpaidInfoResponse> getPostpaidInfoRequest(String status) throws
	 Exception{
	 Pageable pageable = PageRequest.of(0, queryResultLimit);
	 return postpaidInfoRepo.findByStatus(status,pageable);
	 }

	@Transactional
	public Map<String,Integer> getInfoTabs(String subno) throws Exception {
		return tabsRepo.getInfo(subno);
	}
	
	

}
