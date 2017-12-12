package rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import domain.Destination;
import domain.DestinationRepository;

import org.springframework.cloud.client.discovery.DiscoveryClient;



@RestController
public class DestinationController {

    DestinationRepository repository;
    RestTemplate template; 
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
    
    public DestinationController () {
    	repository = new DestinationRepository();
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public @ResponseBody String getInfo() {
    	return "Destination service"; 
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getDestinations")
	public @ResponseBody Collection<Destination> getDestinations() {	
		return this.repository.getDestinations().values();
	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/getPlaces") 
    public @ResponseBody List<String> getPlaces() {
    	List<String> out = new ArrayList<String>();
    	for (Destination dest : this.repository.getDestinations().values() ) {
    		out.add(dest.getCity());
    	}
    	return out;
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getDestination")
	public @ResponseBody Destination getDestination(@RequestParam(value="name") String name) {
    	System.out.println("Ge zit erin");
		return repository.getDestination(name);
	}

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/addDestination")
    public ResponseEntity<String> addDestination(@RequestBody Destination destination) {
    	repository.addDestination(destination);
    	System.out.println("Place added in REST project: " + destination);
    	return null;
	}
	
}