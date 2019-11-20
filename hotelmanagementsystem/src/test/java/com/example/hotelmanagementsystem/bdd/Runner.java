package com.example.hotelmanagementsystem.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",glue = {"com.example.hotelmanagementsystem"},tags= {"@Feature1"})
public class Runner {

}
