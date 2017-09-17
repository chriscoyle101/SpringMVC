package com.nextgate.chriscoyle.model;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Repository;

import com.nextgate.chriscoyle.webservice.MusicServiceStub;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.AlbumName;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInfo;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInformation;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.SingerName;

@Repository 
public class SearchDaoImpl implements SearchDao {
	
	private MusicServiceStub mServiceStub;
	
	public SearchDaoImpl() throws AxisFault{
		
		this.mServiceStub = new MusicServiceStub();
	}
	
	
	/**
	 * Method getSearchResults()
	 * 
	 * This Method Returns Artist Information Dependent On
	 * The searchOption(field) The User Chooses And The 
	 * SearchValue(userInput) The User Typed.
	 * 
	 * 1. Create Array of Type ArtistInfo To Hold The ArtistInfo
	 *    Objects Returned From The Database.
	 * 
	 * 2. If The User Chose "singer" As The Option To Search By...
	 * 
	 * 3. Call getField() And Pass the Users Search Option Along 
	 *    With Their Search Value(what They Typed)
	 *    
	 * 4. Now Return Results
	 * 
	 * 5. Same As 3/4 Except The User Has Chosen "album_name" As 
	 *    their Search Option
	 */
	@Override
	public ArtistInfo[] getSearchResults(String field, String userInput){

		ArtistInfo[] ai;										// 1
		String trackRows = "";

		try{
			if (field.equals("singer")){						// 2
				
				ai = getField("singer", userInput); 			// 3
				return(ai);										// 4
			}
			else if (field.equals("album_name")){				// 5
				
				ai = getField("album_name", userInput);			// 5
				return(ai);
			}			
		}catch(Exception exception){
			String error = exception.getMessage();
			if (error == null) error = exception.toString();
			error = "could not get records - " + error;
			trackRows += error;
		}
		return null;	
	}
	
	
	/**
	 * Method getByField()
	 *
	 */
	@Override
	public ArtistInfo[] getField(String field, String useInput) throws Exception {
		
		ArtistInformation artistInformationRef;
		ArtistInfo[] artistInfo;
		
		switch(field){
		case"singer":
        	SingerName singerName = new SingerName();						// Create The SingerName Object
        	singerName.setSingerName(useInput);								// Then Set The Singers Name On That Object
        	artistInformationRef = mServiceStub.getBySinger(singerName);	// Now Make Call To MusicService Passing The SingerName Object
        	artistInfo = artistInformationRef.getArtistInformation();		// Extract ArtistInfo From Returned artistInformationRef Object
			return artistInfo;												// Return The Artist Info Array
		case "album_name": 	
			AlbumName albumName = new AlbumName();							// Create The AlbumName Object
			albumName.setAlbumName(useInput);								// Then Set The Album Name On That Object
			artistInformationRef = mServiceStub.getByAlbum(albumName);		// Now Make Call To MusicService Passing The AlbumName Object
			artistInfo = artistInformationRef.getArtistInformation();		// Extract Artist Info From Returned ArtistInformation Object
			return artistInfo;												// Return The Artist Info Array																			
		}
		return null;
	}
}
