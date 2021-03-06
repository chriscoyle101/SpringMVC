package com.nextgate.chriscoyle.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nextgate.chriscoyle.service.ArtistInformation;
import com.nextgate.chriscoyle.service.LoginDelegate;
import com.nextgate.chriscoyle.service.SearchDelegate;
import com.nextgate.chriscoyle.view.LoginBean;
import com.nextgate.chriscoyle.view.SearchBean;

@Controller // Controller Annotation Tells Spring To Consider This Class As A Bean
public class SearchController {
	
	@Autowired // Uses Springs Inversion of Control (IoC) Mechanism To Automatically Inject References To Classes. We Don Need The new Keyword
	private SearchDelegate searchDelegate;

	
	/**
	 * Method displaySearch()
	 * This Method Services A Request To View The Search Screen
	 * The [@]RequestMapping Annotation Describes The URL And
	 * Request Type This Method Services e.g:
	 * 
	 * 		URL: localhost:8024/WebApplication/search.html
	 * 		With HTML Form Method "GET" (See JSP Files)
	 * 
	 * Will Get Mapped To This Method By The Dispatcher-Servlet.
	 * 
	 * 1. Create A ModelAndView Object And Specify To The 
	 * 	  Constructor The WebPage(i.e. JSP File) You Want To 
	 * 	  Return To The Browser.
	 * 
	 * 2. Return The Model Reference Which Describes The JSP File 
	 * 	  The Dispatcher-Servlet(aka Front Controller) Should 
	 * 	  Fetch In Order To Return It To The Browser
	 * @return 
	 */
	@RequestMapping(value="/search.html",method=RequestMethod.GET)
	public ModelAndView displaySearch(){

		ModelAndView model = new ModelAndView("search");	// 1
		return model;										// 2
	}
	
	
	
	/**
	 * Method displayResults()
	 * This Method Services A Request To View The Search Results 
	 * Screen The [@]RequestMapping Annotation Describes The URL And
	 * Request Type This Method Services e.g:
	 * 
	 * 		URL: localhost:8024/WebApplication/searchResults.html
	 * 		With HTML Form Method "POST" (See JSP Files)
	 * 
	 * Will Get Mapped To This Method By The Dispatcher-Servlet.
	 * 
	 * The [@]ModelAttribute Annotation Captures The Values The 
	 * User Enters Into The Login Form And Updates Those Values
	 * In The SearchBean Object. 
	 * NOTE:
	 * 		The Caveat Is The "name" Attribute In The HTML Form
	 * 		input Tag Must Exactly Match The Instance Variable 
	 * 		Name In The LoginBean Object For This To Work e.g:
	 * 			JAVA						HTML	
	 * 	private String searchOption;	<input name="searchOption" .../>
	 *  
	 * 1. Create A ModelAndView Object And Specify To The 
	 * 	  Constructor The WebPage(i.e. JSP File) You Want To 
	 * 	  Return To The Browser i.e. ("/results")
	 * 
	 * 2. Send The Users searchOption(bySinger or byAlbum) a
	 * 	  and searchValue(What They Type) To The Database. When 
	 *    The Database Returns, Class SearchServiceImpl Will Set
	 *    These Results In The ArtistInformation Object Ready 
	 *    For Fetching
	 * 
	 * 3. Next Fetch These Results And Store The Results As A 
	 *    List of ArtistInfomration Objects.
	 * 
	 * 4. If The Users Search Option Was bySinger...
	 * 
	 * 5. Then Append To The Model And View Object The "singerInfo"
	 *    Key And The List of Artist Information. The results.jsp 
	 *    Will Use the Key To Determine Which Information To Display
	 *    To The Screen e.g. If Singer Display Only: Name, DOB, Sex
	 *    
	 * 6. Same As Steps 4/5 Except The Key Is No "albumInfo" So The
	 *    results.jsp Will Display: AlbumName, ReleaseYear, RecordCompany
	 * @return 
	 */
	@RequestMapping(value="/searchResults.html",method=RequestMethod.POST)
	public ModelAndView displayResults(@ModelAttribute("searchBean")SearchBean searchBean) throws SQLException{

		ModelAndView model = new ModelAndView("/results");												// 1
		
		searchDelegate.requestSearchResults(searchBean.getSearchOption(), searchBean.getSearchValue());	// 2
		List<ArtistInformation> artistInfo = searchDelegate.getResultsList();							// 3
		
				
		if(searchBean.getSearchOption().equals("singer")){												// 4

			return model.addObject("singerInfo", artistInfo);											// 5
		}
		else if(searchBean.getSearchOption().equals("album_name")){										// 6

			return model.addObject("albumInfo", artistInfo);											// 6
		}
		return null;
	}
}
