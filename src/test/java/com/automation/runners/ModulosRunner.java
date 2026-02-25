package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * ModulosRunner - Executes only @modulos scenarios.
 * Usage: mvn test -Dtest=ModulosRunner
 */
@CucumberOptions(
    features = "Scenarios/modulos",
    glue = {"com.automation.features"},
    plugin = {
        "pretty",
        "html:target/reports/modulos-report.html",
        "json:target/reports/modulos-report.json",
        "junit:target/reports/modulos-junit.xml"
    },
    tags = "@modulos",
    monochrome = true,
    dryRun = false,
    publish = false
)
public class ModulosRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
