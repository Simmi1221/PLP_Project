package com.capgemini.onlinehotelbooking.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",glue = {"com.capgemini.onlinehotelbooking"},tags= {"@Function4"})
public class Runner {

}
