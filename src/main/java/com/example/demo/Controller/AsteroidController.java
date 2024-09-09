package com.example.demo.Controller;

import com.example.demo.Service.AsteroidService;
import com.example.demo.Model.AsteroidModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AsteroidController {

    @Autowired
    private AsteroidService asteroidService;

    @GetMapping("/")
    public String index(@RequestParam(name = "startDate", defaultValue = "2015-09-07") String startDate,
                        @RequestParam(name = "endDate", defaultValue = "2015-09-08") String endDate,
                        Model model) {
        List<AsteroidModel> asteroidData = asteroidService.getAsteroids(startDate, endDate);
        model.addAttribute("asteroidData", asteroidData);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "asteroid";
    }
}
