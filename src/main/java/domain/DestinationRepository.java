package domain;

import java.util.HashMap;
import java.util.Map;


public class DestinationRepository {

	
	private Map<String, Destination> repository; 
	
	public DestinationRepository() {
		repository = new HashMap<String, Destination>();
		addDestination(new Destination("Luik", 4000, "Omschrijving Luik"));
		addDestination(new Destination("Leuven", 3000, "Omschrijving Leuven"));
		addDestination(new Destination("Antwerpen", 2000, "Omschrijving Antwerpen"));
		addDestination(new Destination("Brussel", 1000, "Omschrijving Brussel"));
		
	}
	
	public void addDestination(Destination destination) {
		repository.put(destination.getCity(), destination);
	}
	
	public Destination getDestination(String name) {
		return repository.get(name);
	}

	public Map<String, Destination>getDestinations() {
		
		return repository;
	}
}
