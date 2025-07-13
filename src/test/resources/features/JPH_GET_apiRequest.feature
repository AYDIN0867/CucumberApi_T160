Feature: JPH GET Request

  # https://jsonplaceholder.typicode.com/posts/44 endpointine
  # bir GET request gönderdiğimizde dönen response'un
  #status code'unun 200 oldugunu,
  #content type degerinin "application/json; charset=utf-8" ve
  # "title" degerinin "optio dolor molestias sit" oldugunu test edin


Scenario: US001_TC01_JPH_GetRequest

  Given kullanici "JPHUrl" adresine gider
  Then kullanici pathparametresi olarak "posts/44" girer
  Then kullanici bir GET request yaparak donen response degerini kaydeder
  Then kullanici response statusCode degerinin 200 oldugunu dogrular
  Then kullanici response content type degerinin "application/json; charset=utf-8" oldugunu dogrular
  Then kullanici response degerini jsonPath olarak kaydeder
  Then kullanici response değerindeki "title" keyinin degerinin "optio dolor molestias sit" oldugunu dogrular




  # /*
  #
  #        https://jsonplaceholder.typicode.com/posts/70 url'ine  asagidaki body ile
  #         bir POST request gonderdigimizde DONEN response'in
  #         status code'unun 200,ve content type'inin application/json; charset=utf-8
  #         Connection header degerinin "keep-alive"
  #         ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

  #          Request Body                               Expected Data
  #           {                                        {
  #              "title":"Ahmet",                        "title":"Ahmet",
  #              "body":"Merhaba",                        "body":"Merhaba",
  #               "userId":10,                              "userId":10,
  #               "id":70                                     "id":70
  #              }                                          }
  #

  Scenario: JPH adresine bir POST request yaparak response ve request body karşılaştırılması

    Given kullanici "JPHUrl" adresine gider
    Then  kullanici pathparametresi olarak "posts/70" girer
    #metod post oldugu icin body olusturuyoruz
    Then kullanici POST request yapabilmek icin "Ahmet","Merhaba",10 70 degerleri ile reqbody olusturur
    Then kullanici hazirlanan reqbody ile bir POST request yapar ve response objesine kaydeder
    Then kullanici response statusCode degerinin 200 oldugunu dogrular
    Then kullanici response content type degerinin "application/json; charset=utf-8" oldugunu dogrular
    Then kullanici "Conncetion" header degerinin "keep-alive" oldugunu dogrular
    Then kullanici response degerini jsonPath olarak kaydeder
    Then kullanici userid degerinin 10 ldugunu dogrular
    Then kullanici id degerinin 70 oldugunu dogrular
    Then kullanici "title" degerinin "Ahmet" oldugunu dogrular
    Then kullanici "body" degerinin "Merhaba" oldugunu dogrular

