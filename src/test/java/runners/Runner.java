package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key= Constants.FEATURES_PROPERTY_NAME,value="src/test/resources/features")
@ConfigurationParameter(key= Constants.GLUE_PROPERTY_NAME,value= "stepdefinitions")
@ConfigurationParameter(key= Constants.FILTER_TAGS_PROPERTY_NAME,value="")
@ConfigurationParameter(key= Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value="false")
@ConfigurationParameter(key=Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/standart-report/htmlRapor.html")
//eger burası true iken eksik adım olup olmadıgını kontrol eder
// testlerin çalıştıgını değil çalıştırmak için tekrar false yapilir


public class Runner {
/*
Cucumber 'daki Runner Class'i icinde hicbir kod yazilmaz
Görevi TestNG'deki .xml dosyalari gibi toplu calistirmayi
saglmaktir.Runner class'i görevini kullanacagimiz notasyonlar ile gerceklestirir

 */


}
