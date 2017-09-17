package com.nextgate.chriscoyle.service;

import java.sql.SQLException;
import java.util.List;

import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInfo;

	public interface SearchService{
			
		public void getSearchResults(String field, String userInput) throws SQLException;
		
		public List getArtistinfoList();
	}


