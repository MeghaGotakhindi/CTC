package com.api.monitoring.ApiMonitoring.web;

//import java.io.Serializable;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitor")
public class monitor {
	
	@Id
	@GeneratedValue
	private long Id;
	private String monitorName;
	private String methodType;
	private String url;
	private Long time;
	private String eMail;
	private int statusCode;
	private float apdex;
	private float totalRuns;
	private float successCount;
	
	
	protected monitor() {
		
	}


	public monitor(Long id, String monitorName, String methodType, String url,
			int statusCode,Long time, String eMail,float apdex,
			float totalRuns,float successCount
			) {
		super();
		Id = id;
		this.monitorName = monitorName;
		this.methodType = methodType;
		this.url =url;
		this.time = time;
		this.eMail = eMail;
		this.statusCode=statusCode;
		this.apdex = apdex;
		this.totalRuns = totalRuns;
		this.successCount = successCount;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}
	
	

	public float getTotalRuns() {
		return totalRuns;
	}


	public void setTotalRuns(float totalRuns) {
		this.totalRuns = totalRuns;
	}


	public float getSuccessCount() {
		return successCount;
	}


	public void setSuccessCount(float successCount) {
		this.successCount = successCount;
	}


	public float getApdex() {
		return apdex;
	}


	public void setApdex(float apdex) {
		this.apdex = apdex;
	}


	public void setId(long id) {
		Id = id;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMonitorName() {
		return monitorName;
	}


	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}


	public String getMethodType() {
		return methodType;
	}


	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Long getTime() {
		return time;
	}


	public void setTime(Long time) {
		this.time = time;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	@Override
	public String toString() {
		return "monitor [Id=" + Id + ", monitorName=" + monitorName + ", methodType=" + methodType + ", url=" + url
				+ ", time=" + time + ", eMail=" + eMail + ", statusCode=" + statusCode + ", apdex=" + apdex
				+ ", totalRuns=" + totalRuns + ", successCount=" + successCount + "]";
	}


	

//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (Id ^ (Id >>> 32));
//		result = prime * result + Float.floatToIntBits(apdex);
//		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
//		result = prime * result + ((methodType == null) ? 0 : methodType.hashCode());
//		result = prime * result + ((monitorName == null) ? 0 : monitorName.hashCode());
//		result = prime * result + statusCode;
//		result = prime * result + ((time == null) ? 0 : time.hashCode());
//		result = prime * result + ((url == null) ? 0 : url.hashCode());
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		monitor other = (monitor) obj;
//		if (Id != other.Id)
//			return false;
//		if (Float.floatToIntBits(apdex) != Float.floatToIntBits(other.apdex))
//			return false;
//		if (eMail == null) {
//			if (other.eMail != null)
//				return false;
//		} else if (!eMail.equals(other.eMail))
//			return false;
//		if (methodType == null) {
//			if (other.methodType != null)
//				return false;
//		} else if (!methodType.equals(other.methodType))
//			return false;
//		if (monitorName == null) {
//			if (other.monitorName != null)
//				return false;
//		} else if (!monitorName.equals(other.monitorName))
//			return false;
//		if (statusCode != other.statusCode)
//			return false;
//		if (time == null) {
//			if (other.time != null)
//				return false;
//		} else if (!time.equals(other.time))
//			return false;
//		if (url == null) {
//			if (other.url != null)
//				return false;
//		} else if (!url.equals(other.url))
//			return false;
//		return true;
//	}
//

	
	
	
	

}
