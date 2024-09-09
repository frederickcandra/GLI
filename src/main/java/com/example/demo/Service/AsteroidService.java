package com.example.demo.Service;

import com.example.demo.Model.AsteroidModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AsteroidService {

    private static final String API_KEY = "ZoLehhpqZedlTAwMJmrLlegPfoPc7rF2OFhlLKqS"; // Replace with your API Key
    private static final String API_URL = "https://api.nasa.gov/neo/rest/v1/feed?start_date=%s&end_date=%s&api_key=" + API_KEY;

    public List<AsteroidModel> getAsteroids(String startDate, String endDate) {
        String url = String.format(API_URL, startDate, endDate);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        List<AsteroidModel> asteroids = new ArrayList<>();
        if (response != null && response.containsKey("near_earth_objects")) {
            Map<String, Object> nearEarthObjects = (Map<String, Object>) response.get("near_earth_objects");

            for (Object dateObject : nearEarthObjects.values()) {
                List<Map<String, Object>> asteroidsList = (List<Map<String, Object>>) dateObject;

                for (Map<String, Object> asteroidObject : asteroidsList) {
                    String name = (String) asteroidObject.get("name");
                    boolean isPotentiallyHazardous = (boolean) asteroidObject.get("is_potentially_hazardous_asteroid");
                    double magnitude = (double) asteroidObject.get("absolute_magnitude_h");

                    AsteroidModel asteroid = new AsteroidModel(name, isPotentiallyHazardous, magnitude);
                    asteroids.add(asteroid);
                }
            }
        }
        return asteroids;
    }
}
