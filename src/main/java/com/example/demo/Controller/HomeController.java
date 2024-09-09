package com.example.demo.Controller;


import com.example.demo.Model.ProfileModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {

            List<ProfileModel> profileList = new ArrayList<>();

            ProfileModel pm1 = new ProfileModel();
            pm1.setId(1);
            pm1.setAge(23);
            pm1.setGender("male");
            pm1.setName("Candra");

            ProfileModel pm2 = new ProfileModel();
            pm2.setId(2);
            pm2.setAge(27);
            pm2.setGender("female");
            pm2.setName("Laras");

            ProfileModel pm3 = new ProfileModel();
            pm3.setId(3);
            pm3.setAge(30);
            pm3.setGender("male");
            pm3.setName("Adi");

            profileList.add(pm1);
            profileList.add(pm2);
            profileList.add(pm3);

            model.addAttribute("profiles", profileList);
            return "home";
        }
    }