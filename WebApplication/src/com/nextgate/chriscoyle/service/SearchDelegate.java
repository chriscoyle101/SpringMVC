package com.nextgate.chriscoyle.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgate.chriscoyle.service.SearchService;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInfo;

@Service
public class SearchDelegate {

	@Autowired
	private SearchService searchService;

	/*
	 * Setter
	 */
	public SearchService getSearchService(){

		return this.searchService;
	}
	
	/*
	 * Getter
	 */
	public void setSearchService(SearchService searchService){

		this.searchService = searchService;
	}
	
	/*
	 * 
	 */
	public void requestSearchResults(String field, String userInput) throws SQLException{
		
		System.out.println("MODEL DELEGATION CLASS !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		searchService.getSearchResults(field, userInput);
		
		//return searchService.getSearchResults(field, userInput);
	}
	
	public List<ArtistInformation> getResultsList(){
		
		return searchService.getArtistinfoList();
	}
}