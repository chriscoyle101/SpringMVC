package com.nextgate.chriscoyle.view;

public class SearchBean{
	
	private String searchOption;
	private String searchValue;

	
	public String getSearchOption(){

		return this.searchOption;
	}

	public void setSearchOption(String searchOption){

		this.searchOption = searchOption;
	}

	public String getSearchValue(){
		
		return this.searchValue;
	}

	public void setSearchValue(String value){
		
		this.searchValue = value;
	}
}
