package com.SpringMultiDataSource.response.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringMultiDataSource.response.domain.PostpaidInfoResponse;

@Repository
public interface PostpaidInfoResponseRepo<P> extends CrudRepository<PostpaidInfoResponse, Long> {
	public List<PostpaidInfoResponse> findByStatus(String status,Pageable pageable);
}
