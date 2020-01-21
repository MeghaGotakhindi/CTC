package com.api.monitoring.ApiMonitoring.web;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableAsync
@EnableScheduling
@Service
public class MonitoringBusinessLogic {
	
	monitor monitors;
	@Autowired
	MonitoringRepository monitoringRepository;

//	private String url;
//	private String methodType;
//	
//    @Value("${jobs.enabled:true}")
//    private boolean isEnabled;
//    
//		public int monitorUrls(String url,String methodType,boolean isStarted) throws InterruptedException {
//			if(url==null) {
//				this.isEnabled = false;
//			}
//			this.isEnabled=isStarted;
//			this.url = url;
//			this.methodType = methodType;
//			int statusCode = 0;
//			this.runUrl();
//			return statusCode;
//		}
		
	
		
	    
	    
//	    @Async
//	    @Scheduled(fixedRate=4000)
//	    public void scheduleMonitoringUrls() throws InterruptedException {
//	    	if(isEnabled) {
//	    		long id = 1;
//		    	try {
//					long endTime;
//					long startTime = System.currentTimeMillis();
//					int statusCode = sendHttpRequests();
//					System.out.println(endTime = System.currentTimeMillis() - startTime);
//					System.out.println(statusCode+" ");
//					monitoringRepository.updateStatusCode(id, statusCode);
//					//return statusCode;
//					
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		   
//	    	}else {
//	    		return;
//	    	}
//		
//	    	
//	    }

		public void reschedule(long id) {
			//List<monitor> m = monitoringRepository.getIds(id);
			// this.scheduler.new;
			// final ScheduledFuture<?> runnerHandle = new this.scheduler();
		    //scheduler.scheduleAtFixedRate(runner, time,time, SECONDS);
			
			
			this.scheduler =  Executors.newScheduledThreadPool(1);
			List<?> ids = monitoringRepository.findId(3);
			for(Object id1: ids) {
				this.runUrl((long)id1, false);
			}
			
			
			
		}
		
	    
	    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	    
	    public void runUrl(long id,boolean stop) {
	    	//long id =1;
	    	System.out.println(id+" from bl");
	    	String url = monitoringRepository.findUrl(id);
	    	System.out.println(url);
	    	String methodType = monitoringRepository.findMethodType(id);
	    	System.out.println(methodType);
	    	Long time = monitoringRepository.findTime(id);
	    	System.out.println(time);
	    	
	    	 if(!scheduler.isTerminated()) {
	    		 
	    	 
	    	
	    	final Runnable runner = new Runnable() {
	    		public void run() {
	    			//System.out.println("aaa");
					//int statusCode;
					try {
						monitoringRepository.updateIsExecuting(id, false);
						int statusCode = sendHttpRequests(url,methodType);
						System.out.println(statusCode+"  "+id);
						monitoringRepository.updateStatusCode(id, statusCode);
						float successCount=monitoringRepository.findSuccessCount(id);
						float totalRuns = monitoringRepository.findTotalRuns(id);
						if(statusCode==200) {
							successCount++;
						}
						totalRuns++;
						float apdex = calculateApdex(successCount,totalRuns);
						
						monitoringRepository.updateApdex(id, successCount, totalRuns, apdex);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("cought");
						e.printStackTrace();
					}
					
	    		}
	    	};
	    	final ScheduledFuture<?> runnerHandle = 
	    			scheduler.scheduleAtFixedRate(runner, time,time, SECONDS);
	    	if(!runnerHandle.isCancelled()) {
	    		scheduler.schedule(new Runnable() {
		    		public void run() {
		    			//runnerHandle.cancel(false);
		    			runnerHandle.notify();
//		    			if(stop) {
//		    				runnerHandle.cancel(true);
//		    				try {
//								runnerHandle.wait(60);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//		    			}runUrl(4,false);
		    		}
		    	}, time, SECONDS);
	    	}
	    	
	    	
	    }
	    	  if(stop==true) {
	                //runnerHandle.cancel(true);
	                //scheduler.shutdown();
	               
	                try {
	                    scheduler.awaitTermination(5, SECONDS);
	                    
	                    scheduler.shutdown();
	                    
	                    monitoringRepository.updateIsExecuting(id, stop);
	                    
	                    if(scheduler.isTerminated()) {
	                    	//runUrl(4,false);
	                    }
	                    //scheduler.shutdownNow();
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                //id++;
	                this.reschedule(id+1);
	               
	            }
	    	
	    }
	    private String userAgent="Mozilla/5.0";
	    public int sendHttpRequests(String url,String methodType) throws Exception {
		   try {
			  
			   URL urlInstance = new URL(url);
			  
				HttpURLConnection connection= (HttpURLConnection)urlInstance.openConnection();
				connection.setRequestMethod(methodType);
				connection.setRequestProperty("Accept", this.userAgent);
				int responseCode = connection.getResponseCode();
				
				return responseCode;
			   
		   }catch(Exception e) {
			   System.out.println("");
		   }return 0;
			
		}
	 public float calculateApdex(float successCount,float totalRuns) {
		 if(totalRuns!=0) {
			 return successCount/totalRuns;
		 }
		 return 0;
	 }
	 
	
	

}