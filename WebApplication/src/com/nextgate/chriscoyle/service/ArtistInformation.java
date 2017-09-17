package com.nextgate.chriscoyle.service;

public class ArtistInformation {

	private String singerName;
	private String dob;
	private String sex;
	private String album;
	private String releaseYear;
	private String company;

	// -------------------------- //
	// 		GETTER METHODS
	// -------------------------- //

	public String getSingerName(){

		return this.singerName;
	}

	public String getDob(){

		return this.dob;
	}

	public String getSex(){

		return this.sex;
	}

	public String getAlbum(){

		return this.album;
	}

	public String getReleaseYear(){

		return this.releaseYear;
	}

	public String getCompany(){

		return this.company;
	}

	// -------------------------- //
	// 		SETTER METHODS
	// -------------------------- //

	public void setSingerName(String singerName){

		this.singerName = singerName;
	}

	public void setDob(String dateOfBirth){

		this.dob = dateOfBirth;
	}

	public void setSex(String sex){

		this.sex = sex;
	}

	public void setAlbum(String album){

		this.album = album;
	}

	public void setReleaseYear(String releaseYear){

		this.releaseYear = releaseYear;
	}

	public void setCompany(String recordCompany){

		this.company = recordCompany;
	}
}
