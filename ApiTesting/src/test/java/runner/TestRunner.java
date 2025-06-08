package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@CucumberOptions(
		 features="src/test/resources/features",
		 glue="stepDef",
		 tags="@addedItemPresentInventory",
		 plugin= {"json:target/cucumber.json","pretty","html:target/cucumber-reports"},
		 monochrome=true,
		 dryRun=false		 
		 
		)



public class TestRunner extends AbstractTestNGCucumberTests{
  private TestNGCucumberRunner testNGCucumberRunner;
  
  @AfterClass(alwaysRun=true)
  public void tearDownClass() {
	  if(testNGCucumberRunner==null) {
		  return;
	  }
	  
	  File reportOutputDirectory=new File("target/cucumber-reports");
	  List<String> jsonFiles=new ArrayList<>();
	  jsonFiles.add("target/cucumber.json");
	  
	  Configuration config=new Configuration(reportOutputDirectory,"TestAutomation");
	  config.setBuildNumber("1");
	  config.addClassifications("Build Number",config.getBuildNumber());
	  config.addClassifications("Branch Name","API Automation");
	  
	  ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,config);
	  reportBuilder.generateReports();
	  testNGCucumberRunner.finish();
  }
  
  
  
}
