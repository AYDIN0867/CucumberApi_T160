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
  #      donen Response'un,
  #
  #
  #      ve Response Body'sindeki,
  #      "title" in "API" oldugunu
  #      "UserId" degerinin 100 den kucuk oldugunu
  #      "body" nin "API" kelimesi icerdigini test edin
  #
  #
  #
  #     */

  #