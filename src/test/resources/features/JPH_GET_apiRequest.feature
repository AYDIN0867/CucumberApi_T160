Feature: JPH GET Request

  # https://jsonplaceholder.typicode.com/posts/44 endpointine
  # bir GET request gönderdiğimizde dönen response'un
  #status code'unun 200 oldugunu,
  #content type degerinin "application/json; charset=utf-8" ve
  # "title" degerinin "optio dolor molestias sit" oldugunu test edin


Scenario: JPH Get Request

  Given kullanici "JPHUrl" adresine gider
  Then kullanici pathparametresi olarak "posts/44" girer
  Then kullanici bir GET request yaparak donen response degerini kaydeder
  Then kullanici response statusCode degerinin 200 oldugunu dogrular
  Then kullanici response content type degerinin "application/json; charset=utf-8" oldugunu dogrular
  Then kullanici response degerini jsonPath olarak kaydeder
  Then kullanici response değerindeki "title" keyinin degerinin "optio dolor molestias sit" oldugunu dogrular