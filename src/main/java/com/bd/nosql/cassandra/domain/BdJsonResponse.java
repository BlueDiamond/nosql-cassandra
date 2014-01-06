package com.bd.nosql.cassandra.domain;


public class BdJsonResponse {
	private UserProfileResponse UserProfileResponse;

	public BdJsonResponse(){
		
	}
	public BdJsonResponse(UserProfileResponse userProfileResponse) {
		super();
		UserProfileResponse = userProfileResponse;
	}

	@Override
	public String toString() {
		return "BdJsonResponse [UserProfileResponse=" + UserProfileResponse + "]";
	}

	public UserProfileResponse getUserProfileResponse() {
		return UserProfileResponse;
	}

	public void setUserProfileResponse(UserProfileResponse userProfileResponse) {
		UserProfileResponse = userProfileResponse;
	}
	
	
}
