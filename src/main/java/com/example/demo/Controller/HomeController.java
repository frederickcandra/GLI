package com.example.demo.Controller;


import com.example.demo.Model.ProfileModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

        private List<ProfileModel> profileList = new ArrayList<>();
        @GetMapping("/home")
        public String home(Model model) {
                model.addAttribute("profiles", profileList);
                return "home";
        }

        @PostMapping("/submitProfile")
        public String submitProfile(
                @RequestParam("name") String name,
                @RequestParam("age") int age,
                @RequestParam("gender") String gender,
                Model model) {

                ProfileModel profile = new ProfileModel();
                profile.setName(name);
                profile.setAge(age);
                profile.setGender(gender);

                profileList.add(profile);

                model.addAttribute("profiles", profileList);
                return "home";
        }
    }