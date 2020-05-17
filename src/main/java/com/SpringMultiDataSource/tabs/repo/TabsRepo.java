package com.SpringMultiDataSource.tabs.repo;

import org.springframework.stereotype.Repository;

import com.SpringMultiDataSource.tabs.domain.TabsInfoResponse;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

@Repository
public interface TabsRepo extends JpaRepository<TabsInfoResponse, Long>  {
	@Procedure(name = "TabsInfoResponse.getInfo")
	public Map<String,Integer> getInfo(@Param("s_subno") String subno);
}
