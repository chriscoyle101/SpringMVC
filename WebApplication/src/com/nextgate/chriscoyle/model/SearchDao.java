package com.nextgate.chriscoyle.model;

import java.sql.SQLException;

import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInfo;

public interface SearchDao {

	public ArtistInfo[] getSearchResults(String field, String userInput) throws SQLException;
	
	public ArtistInfo[] getField(String field, String useInput) throws Exception;
}
