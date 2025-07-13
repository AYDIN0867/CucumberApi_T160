package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;


public class CollectApistepDefinitions {
String url="";
Response response;

    @Given("kullanici sorgu icin {string} adresine gider")
    public void kullanici_sorgu_icin_adresine_gider(String collectApiUrl) {
      url= ConfigReader.getProperty(collectApiUrl);

    }
    @Then("kullanici path parametresi yerine {string} girer")
    public void kullanici_path_parametresi_yerine_girer(String pathParams) {

        url=url+"/"+pathParams;


    }
    @Then("kullanici query parametrelerine il icin {string} ilce icin {string} girer")
    public void kullanici_query_parametrelerine_il_icin_ilce_icin_girer(String il, String ilce) {

        url=url+"?"+"il="+il+"&"+"ilce="+ilce;


    }
    @Then("kullanici header degerleri ile bir GET request yapar ve response degeri kaydeder")
    public void kullanici_header_degerleri_ile_bir_get_request_yapar_ve_response_degeri_kaydeder() {

        response= RestAssured.given().when().header("authorization","apikey "+ConfigReader.getProperty("apiKeyCode")).get(url);

    }
    @Then("kullanici donen response degerini yazidirir")
    public void kullanici_donen_response_degerini_yazidirir() {

        response.prettyPrint();

    }










}
