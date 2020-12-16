package com.stepDefinitions;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.reusableFunctions.SeleniumUtilities;

public class CustomSoftAssert extends SoftAssert {
	
	SeleniumUtilities sutil;
	String filename;
	public CustomSoftAssert(WebDriver driver,String filename)
	{
		sutil = new SeleniumUtilities(driver);
		this.filename = filename;
	}
	
	@Override
    public void onAssertFailure(IAssert<?> a, AssertionError ex) {
	 Random rand = new Random();
	 sutil.to_take_screenshot(filename+ rand.nextInt()  + ".png");
    }
	
	
	 
	 

}
