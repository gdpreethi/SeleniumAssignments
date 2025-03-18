package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/resources/features/login.feature"},glue="stepDefinitions",publish=true)
public class LeafTapsTC1 extends AbstractTestNGCucumberTests{

}
