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
	String findUrl(@Param("id") Long id);
	
	@Query("Select m.methodType from monitor m where m.id = :id ")
	String findMethodType(@Param("id") Long id);
	
	@Query("Select m.time from monitor m where m.id = :id")
	Long findTime(@Param("id") Long id);
	
//	@Query("Select m.successCount,m.totalRuns from monitor m where m.id = :id")
//	List<monitor> findSuccessCountAndTotalRuns(@Param("id") Long id);
	
	@Query("Select m.successCount from monitor m where m.id = :id")
	float findSuccessCount(@Param("id") Long id);
	
	@Query("Select m.totalRuns from monitor m where m.id = :id")
	float findTotalRuns(@Param("id") Long id);
	
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
	
	
}
