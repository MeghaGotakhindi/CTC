package com.api.monitoring.ApiMonitoring.web;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface MonitoringRepository extends JpaRepository<monitor, Long> {

//	@Query("Select * from monitor where Id = 1")
//	List<monitor> selectData();
//	
//	@Query("SELECT t.title FROM Todo t where t.id = :id") 
//    String findTitleById(@Param("id") Long id);
	
	//@Async
	@Query("Select m.url from monitor m where m.id = :id ")
	String findUrl(@Param("id") long id);
	
	@Query("Select m.methodType from monitor m where m.id = :id ")
	String findMethodType(@Param("id") long id);
	
	@Query("Select m.time from monitor m where m.id = :id")
	Long findTime(@Param("id") long id);
	
//	@Query("Select * from monitor m where m.id!=:id")
//	List<monitor> getIds(@Param("id") long id);
	
	@Query("Select m.id from monitor m where m.id != :id and isExecuting = false")
	List<?> findId(@Param("id") long id);
	
//	@Query("Select m.successCount,m.totalRuns from monitor m where m.id = :id")
//	List<monitor> findSuccessCountAndTotalRuns(@Param("id") Long id);
	
	
	
	
	@Query("Select m.successCount from monitor m where m.id = :id")
	float findSuccessCount(@Param("id") long id);
	
	@Query("Select count(m.id) from monitor m where m.statusCode =200")
	long findTotalSuccessCount();
	
	@Query("Select m.totalRuns from monitor m where m.id = :id")
	float findTotalRuns(@Param("id") long id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update monitor m set m.statusCode = :statusCode where m.id = :id")
	public void updateStatusCode(@Param("id") long id,@Param("statusCode") int statusCode );
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update monitor m set m.successCount = :successCount,m.totalRuns =:totalRuns,m.apdex =:apdex  where m.id = :id")
	public void updateApdex(@Param("id") long id,@Param("successCount") float successCount
			,@Param("totalRuns") float totalRuns, @Param("apdex") float apdex
			);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update monitor m set m.isExecuting = :isExecuting where m.id=:id")
	public void updateIsExecuting(@Param("id") long id,@Param("isExecuting") boolean isExecuting
			);
	
	
	
}