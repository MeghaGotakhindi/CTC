package com.api.monitoring.ApiMonitoring.web;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MonitoringController {

	@Autowired
	MonitoringRepository monitoringRepository;
	
	@Autowired
	MonitoringBusinessLogic monitoringBL;
	
	@PostMapping("/ApiMonitoring/monitor")
	public monitor createMonitor(@RequestBody monitor monitors  ) {
		return monitoringRepository.save(monitors);
	}
	
	@GetMapping("/ApiMonitoring/{id}")
	public monitor runUrls(@PathVariable long id) {
		
		monitoringBL.runUrl(id);
		return monitoringRepository.findById(id).get();
		
	}
	
	@GetMapping("/ApiMonitoring")
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
	

}
