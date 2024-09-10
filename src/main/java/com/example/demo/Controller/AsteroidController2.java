package com.example.demo.Controller;

import com.example.demo.Service.AsteroidService;
import com.example.demo.Model.AsteroidModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "AsteroidController2", description = "Asteroid Application Controller")
public class AsteroidController2{

    @Autowired
    private AsteroidService asteroidService;

    @GetMapping("/json")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Test")})
    public List<AsteroidModel> index(@RequestParam(name = "startDate", defaultValue = "2015-09-07") String startDate,
                                     @RequestParam(name = "endDate", defaultValue = "2015-09-08") String endDate) {
        return asteroidService.getAsteroids(startDate, endDate);
    }
}
