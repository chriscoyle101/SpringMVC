package com.nextgate.chriscoyle.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgate.chriscoyle.model.SearchDao;
import com.nextgate.chriscoyle.service.ArtistInformation;
import com.nextgate.chriscoyle.service.SearchService;
import com.nextgate.chriscoyle.webservice.MusicServiceStub.ArtistInfo;
import com.sun.corba.se.impl.orbutil.graph.Node;
import java.text.DateFormat;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	private List<ArtistInformation> artistInfoList = new ArrayList<ArtistInformation>();


	public SearchDao getSearchDao(){

		return this.searchDao;
	}

	public void setSearchDao(SearchDao searchDao){

		this.searchDao = searchDao;
	}

	
	public List<ArtistInformation> getArtistinfoList(){

		return this.artistInfoList;
	}

	
	/**
	 * Method getSearchResults()
	 */
	@Override
	public void getSearchResults(String field, String userInput) throws SQLException {
		
		if(this.artistInfoList.size() > 0){

			for(int i = 0; i < this.artistInfoList.size(); i++){ artistInfoList.remove(i);}
		}

		ArtistInfo[] artistInfo = searchDao.getSearchResults(field, userInput);
		
		Date date;
		DateFormat df = DateFormat.getDateInstance();
		if(artistInfo == null){
			System.out.println("Artist Info Empty:");	
		}
		else{

			for (int i = 0; i < artistInfo.length; i++) {

				ArtistInfo ai = artistInfo[i];

				if(ai != null){

					String name = ai.getName();										// Get Name From musicStub.ArtistInfo
					date = ai.getDob();												// Get Dob  From musicStub.ArtistInfo
					String dob = df.format(date).toString();						// Format The Date To Get Rid Of The Time 
					String sex = ai.getSex();										// Get Sex From musicStub.ArtistInfo
					String albumName = ai.getAlbum_name();							// Get AlbumName From musicStub.ArtistInfo
					String releaseYear = Integer.toString(ai.getRelease_year());	// Get ReleaseYear From musicStub.ArtistInfo
					String recordCompany = ai.getRecord_company();					// Get RecordCompany From musicStub.ArtistInfo

					setArtistInformation(name, dob, sex, albumName, releaseYear, recordCompany); // Set The ArtistInformation Bean With The Returned Data
				}
			}

			if(field.equals("singer")){
				removeDuplicates();
			}
		}	
	}

	
	private void setArtistInformation(String name, String dob, String sex, String album, String releaseYear, String recordCompany){

		ArtistInformation artistInfo = new ArtistInformation();

		artistInfo.setSingerName(name);
		artistInfo.setDob(dob);
		artistInfo.setSex(sex);
		artistInfo.setAlbum(album);
		artistInfo.setReleaseYear(releaseYear);
		artistInfo.setCompany(recordCompany);

		artistInfoList.add(artistInfo);
	}


	private void removeDuplicates(){

		int size = artistInfoList.size();
		for(int i = 1; i < size; i++){

			String singerName = artistInfoList.get(i).getSingerName();
			int j = i;

			if(j > 0 && artistInfoList.get(j - 1).getSingerName().equals(singerName)){

				j--;
				artistInfoList.remove(j);
				size = size -1;
				i = i - 1; 
			}
			else{}
		}	
	}
}
