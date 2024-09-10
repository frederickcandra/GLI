package com.example.demo.Controller;

import com.example.demo.Model.ProfileModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

        private List<ProfileModel> profileList = new ArrayList<>();

        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved profiles")
        })
        @GetMapping("/home")
        public List<ProfileModel> getProfiles() {
                return profileList;  // Mengembalikan list profile sebagai JSON
        }

        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Profile successfully submitted and retrieved")
        })
        @PostMapping("/submitProfile")
        public List<ProfileModel> submitProfile(@RequestBody ProfileModel profile) {

                // Memeriksa nilai default jika tidak diberikan
                if (profile.getName() == null) {
                        profile.setName("Unknown");
                }
                if (profile.getAge() == null) {
                        profile.setAge(0);
                }
                if (profile.getGender() == null) {
                        profile.setGender("Unknown");
                }

                // Menambahkan profile ke dalam list
                profileList.add(profile);

                // Mengembalikan list profile terbaru sebagai JSON
                return profileList;
        }
}
