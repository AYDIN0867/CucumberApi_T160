package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

import static org.junit.Assert.*;

public class JPHStepdefinitions {
    String url="";
    Response response;
    JsonPath resJP;

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String ConfigBaseurl) {
        url+= ConfigReader.getProperty(ConfigBaseurl);

    }
    @Then("kullanici pathparametresi olarak {string} girer")
    public void kullanici_pathparametresi_olarak_girer(String pathParams) {

    url=url+"/"+pathParams;

    }
    @Then("kullanici bir GET request yaparak donen response degerini kaydeder")
    public void kullanici_bir_get_request_yaparak_donen_response_degerini_kaydeder() {

        response= RestAssured.given().when().get(url);

    }
    @Then("kullanici response statusCode degerinin {int} oldugunu dogrular")
    public void kullanici_response_status_code_degerinin_oldugunu_dogrular( int expstatsuCode) {

        assertEquals(expstatsuCode,response.getStatusCode());

    }
    @Then("kullanici response content type degerinin {string} oldugunu dogrular")
    public void kullanici_response_content_type_degerinin_oldugunu_dogrular(String expContentType) {

        assertEquals(expContentType,response.getContentType());

    }
    @Then("kullanici response degerini jsonPath olarak kaydeder")
    public void kullanici_response_degerini_json_path_olarak_kaydeder() {

       resJP=response.jsonPath();

    }
    @Then("kullanici response değerindeki {string} keyinin degerinin {string} oldugunu dogrular")
    public void kullanici_response_değerindeki_keyinin_degerinin_oldugunu_dogrular(String expKey, String expValue) {

        assertEquals(expValue,resJP.getString(expKey));

    }

}
