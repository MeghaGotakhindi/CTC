package com.api.monitoring.ApiMonitoring.web;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MonitoringController {

	@Autowired
	MonitoringRepository monitoringRepository;
	
	@Autowired
	MonitoringBusinessLogic monitoringBL;
	
	@PostMapping("/add")
	public monitor createMonitor(@RequestBody monitor monitors  ) {
		return monitoringRepository.save(monitors);
	}
	
	@GetMapping("/runUrls/{id}")
	public monitor runUrls(@PathVariable long id) {
		System.out.println(id+"before");
		monitoringBL.runUrl(id,false);
		System.out.println(id+" id from controller");
		return monitoringRepository.findById(id).get();
		
	}
	
	  @GetMapping("/stop/{id}")
	    public monitor stopUrls(@PathVariable long id) {
	        monitoringBL.runUrl(id, true);
	        return monitoringRepository.findById(id).get();
	    }
	
	@GetMapping("/findOne/{id}")
	public monitor getOneMonitor(@PathVariable long id ) {
		return monitoringRepository.findById(id).get();
	}
	
	@GetMapping("/get")
	public List<monitor> getAllMonitors() throws InterruptedException {
		
		
		
		return monitoringRepository.findAll();
	}
	
	@PutMapping(path="/update")
	public String updateMonitor(@RequestBody monitor monitors)
	{
		monitoringRepository.save(monitors);
		System.out.println("update success");
		return "updated";
		
	}
	@DeleteMapping(path="/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		System.out.println("deleting");
		monitoringRepository.deleteById(id);
		return "deleted";
	}
	
	@GetMapping(path="/getTotalCounts")
	public Long getTotalCounts() {
		
		return monitoringRepository.count();
	}
	
	@GetMapping(path="/getSuccessCounts")
	public long getSuccessCounts() {
		return monitoringRepository.findTotalSuccessCount();
	}
	
//	@GetMapping(path="/getAverageApdex")
//	public long getAverageApdex() {
//		return monitoringBL.calculateAverageApdex();
//	}
//	
//	@GetMapping(path="/getFailureCount")
//	public long getFailureCount() {
//		return monitoringBL.calculateFailures();
//	}
	

}