Feature: Nöbetci Eczane Sorgulama

  Scenario: İstanbul ili Uskudar ilceye ait nöbetci eczane sorgusu

  #  curl --request GET \
  #  --url 'https://api.collectapi.com/health/dutyPharmacy?ilce=Yenimahalle&il=Ankara' \
  #  --header 'authorization: apikey 149HAnFBrae9F8tK0RpqcC:54VcJjiM9D4Dim44o2p9Ty' \
  #  --header 'content-type: application/json'

    Given kullanici sorgu icin "collectApiUrl" adresine gider
    Then kullanici path parametresi yerine "health/dutyPharmacy" girer
    Then kullanici query parametrelerine il icin "istanbul" ilce icin "üsküdar" girer
    Then kullanici header degerleri ile bir GET request yapar ve response degeri kaydeder
    Then kullanici donen response degerini yazidirir
