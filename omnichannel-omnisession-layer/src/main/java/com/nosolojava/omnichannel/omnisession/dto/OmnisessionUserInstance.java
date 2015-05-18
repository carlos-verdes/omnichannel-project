package com.nosolojava.omnichannel.omnisession.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OmnisessionUserInstance implements Serializable {
	private static final long serialVersionUID = -4516670563368672957L;

	String userId;

	List<OmnisessionInstance> sessions = new ArrayList<OmnisessionInstance>();

	public OmnisessionUserInstance() {
		super();
	}

	public OmnisessionUserInstance(String userId) {
		super();
		this.userId = userId;
	}

	public OmnisessionUserInstance(String userId,
			List<OmnisessionInstance> sessions) {
		super();
		this.userId = userId;
		this.sessions = sessions;
	}

	public void addSession(OmnisessionInstance session) {
		this.sessions.add(session);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OmnisessionUserInstance other = (OmnisessionUserInstance) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OmnisessionUserInfo [userId=" + userId + ", sessions="
				+ sessions + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<OmnisessionInstance> getSessions() {
		return sessions;
	}

	public void setSessions(List<OmnisessionInstance> sessions) {
		this.sessions = sessions;
	}

}
