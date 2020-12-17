package com.testRunners;



import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.asserts.IAssert;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
				plugin = {"pretty",
						"html:target/cucumber-reports/cucumber.html",
		                "json:target/cucumber-reports/cucumber.json"
						},
		glue= {"com.stepDefinitions"},
		monochrome = true
		
		
		//strict= true
					
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
	
	
	
//	 public static void Extentsreport()	  
//	  {
//	  Reporter.loadXMLConfig("/src/test/resources/Extent-config.xml");
//	  Reporter.setSystemInfo("user", System.getProperty("user.name"));
//	  Reporter.setSystemInfo("os", "Windows");
//	  Reporter.setTestRunnerOutput("Project Natural Report"); }
//
}