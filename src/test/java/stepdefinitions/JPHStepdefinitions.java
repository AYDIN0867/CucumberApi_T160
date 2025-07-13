package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

import static org.junit.Assert.*;

public class JPHStepdefinitions {
    String url="";
    Response response;
    JsonPath resJP;
    JSONObject reqbody=new JSONObject();
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

    @Then("kullanici POST request yapabilmek icin {string},{string},{int} {int} degerleri ile reqbody olusturur")
    public void kullanici_post_request_yapabilmek_icin_degerleri_ile_reqbody_olusturur(String title,String body ,int userId, int id) {

       reqbody.put("title",title);
       reqbody.put("body",body);
       reqbody.put("userId",userId);
       reqbody.put("id",id);

    }
    @Then("kullanici hazirlanan reqbody ile bir POST request yapar ve response objesine kaydeder")
    public void kullanici_hazirlanan_reqbody_ile_bir_post_request_yapar_ve_response_objesine_kaydeder() {
     response=RestAssured.given().contentType(ContentType.JSON).when().body(reqbody.toString()).post(url);



    }
    @Then("kullanici {string} header degerinin {string} oldugunu dogrular")
    public void kullanici_header_degerinin_oldugunu_dogrular(String expHeaderKey, String expHeaderValue) {

        assertEquals(expHeaderValue,response.getHeader(expHeaderKey));

    }
    @Then("kullanici userid degerinin {int} ldugunu dogrular")
    public void kullanici_userid_degerinin_ldugunu_dogrular(int userId) {

        assertEquals(userId,resJP.getInt("userId"));

    }
    @Then("kullanici id degerinin {int} oldugunu dogrular")
    public void kullanici_id_degerinin_oldugunu_dogrular(int id) {

        assertEquals(id,resJP.getInt("id"));

    }
    @Then("kullanici {string} degerinin {string} oldugunu dogrular")
    public void kullanici_degerinin_oldugunu_dogrular(String bodyKey, String bodyValue) {

        assertEquals(bodyValue,resJP.getString(bodyKey));


    }











}
