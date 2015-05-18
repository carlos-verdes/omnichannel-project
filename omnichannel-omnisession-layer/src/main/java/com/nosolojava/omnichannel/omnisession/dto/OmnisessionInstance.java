package com.nosolojava.omnichannel.omnisession.dto;

import java.io.Serializable;

public class OmnisessionInstance implements Serializable{
	private static final long serialVersionUID = -5989712637332750297L;

	private String id;

	private String system;
	private String remoteId;

	
	public OmnisessionInstance() {
		super();
	}
	
	public OmnisessionInstance(String id, String system, String remoteId) {
		super();
		this.id = id;
		this.system = system;
		this.remoteId = remoteId;
	}



	@Override
	public String toString() {
		return "OmnisessionInstance [id=" + id + ", system=" + system
				+ ", remoteId=" + remoteId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getRemoteId() {
		return remoteId;
	}
	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}
	
	
	
	
}
