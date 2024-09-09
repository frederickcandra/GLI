package com.example.demo.Model;

import lombok.Data;

@Data
public class AsteroidModel {

        private String name;
        private boolean isPotentiallyHazardous;
        private double magnitude;

        public AsteroidModel(String name, boolean isPotentiallyHazardous, double magnitude) {
            this.name = name;
            this.isPotentiallyHazardous = isPotentiallyHazardous;
            this.magnitude = magnitude;
        }


}

