package beans;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import businessLogic.IBusinessLogicController;
import businessLogic.journeyPoint.Hotel;
import businessLogic.journeyPoint.TouristicSite;
import businessLogic.stay.Stay;
import spring.springContainer;

@ManagedBean
@SessionScoped
public class IndexBean {
	
	private IBusinessLogicController controller = springContainer.getBeanOfClass(IBusinessLogicController.class);
	private List<Hotel> hotels;
	private List<TouristicSite> historicalSites;
	private List<TouristicSite> activities;
	private String query;
	private List<TouristicSite> results;
	private Stay selectedStay;
	
	public IndexBean() {
		setHotels(controller.getAllHotels());
		setHistoricalSites(controller.getAllHistoricalSites());
		setActivities(controller.getAllActivitySites());
	}
	
	
	public String startHotels() {
		return "hotels?faces-redirect=true";
	}
	
	public String startCreateYourDreamTrip() {
		return "form?faces-redirect=true";
	}
	
	public String startHistoricalSites() {
		return "toursticsites?faces-redirect=true";
	}
	
	public String startSearch() {
		search();
		return "search?faces-redirect=true";
	}


	public IBusinessLogicController getController() {
		return controller;
	}


	public void setController(IBusinessLogicController controller) {
		this.controller = controller;
	}
	
	
	public void search() {
		results = controller.searchForTouristicSites(query);
	}
	
	public String printHotelComfort(Hotel hotel) {
		double comfort = hotel.getConfort() * 5;
		return String.valueOf((int) comfort);
	}

	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	public List<TouristicSite> getHistoricalSites() {
		return historicalSites;
	}


	public void setHistoricalSites(List<TouristicSite> historicalSites) {
		this.historicalSites = historicalSites;
	}


	public List<TouristicSite> getActivities() {
		return activities;
	}


	public void setActivities(List<TouristicSite> activities) {
		this.activities = activities;
	}


	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}


	public List<TouristicSite> getResults() {
		return results;
	}


	public void setResults(List<TouristicSite> results) {
		this.results = results;
	}


	public Stay getSelectedStay() {
		return selectedStay;
	}


	public void setSelectedStay(Stay selectedStay) {
		this.selectedStay = selectedStay;
	}

}

