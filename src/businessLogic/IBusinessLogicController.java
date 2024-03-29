package businessLogic;

import java.util.List;

import businessLogic.journeyPoint.Hotel;
import businessLogic.journeyPoint.TouristicSite;
import businessLogic.stay.Stay;
import businessLogic.stay.StayProfile;

public interface IBusinessLogicController {
	/**
	 * 
	 * @return all hotel registered in the system.
	 */
	public abstract List<Hotel> getAllHotels();
	
	/**
	 * 
	 * @return all tourist sites that are historical registered in the system.
	 */
	public abstract List<TouristicSite> getAllHistoricalSites();
	
	/**
	 * 
	 * @return all tourist sites that are activities registered in the system.
	 */
	public abstract List<TouristicSite> getAllActivitySites();
	
	/**
	 * Fetch in the system for every tourist sites with matching description keywords
	 * @param keywords words to describe what to look for in the description of activities
	 * @return a list of a tourist sites, sorted by accuracy.
	 */
	public abstract List<TouristicSite> searchForTouristicSites(String keywords);
	
	/**
	 * Compute several plan a stay with matching criteria.
	 * @param stayDuration duration of the stay
	 * @param minimumPrice minimum price of the stay.
	 * @param maximumPrice maximum price of the stay.
	 * @param profile profile of the stay
	 * @param quality quality or comfort of the stay
	 * @param keywords words to describe what to look for in the description of activities
	 * @return a list of stay plans
	 */
	public abstract List<Stay> searchPlansForAStay(int stayDuration, double minimumPrice, double maximumPrice, StayProfile profile, double quality, String keywords);
}
