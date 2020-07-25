package com.sda.cezklosowski.ztmstats;

import com.sda.cezklosowski.ztmstats.inbound.DataProvider;
import com.sda.cezklosowski.ztmstats.model.ZtmData;

/*
    1. Utwórz nowy projekt mavenowy (archetyp quickstart) - ztm-stats. Pakietem głównym niech będzie: com.sda.<twoje imię>.ztmstats
2. Dodaj dependencję
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.11.1</version>
    </dependency>

3. Utwórz pakiet model, w którym umieścisz dwie klasy: ZtmData zawierającą pola LocalDateTime oraz List<Vehicle>. Utwórz klasę Vehicle z polami: line, speed,delay. Używając adnotacji @JsonIgnoreProperties oraz  @JsonProperty dopasuj pola odpowiednio do struktry pliku json spod adresu "https://ckan2.multimediagdansk.pl/gpsPositions". Są to adnotacje z dependencji której użyliśmy.
4. Utwórz pakiet inbound, a w nim klasę DataMapper, która przyjmie Stringa z jsonem i zwróci ZtmData. Wewnątrz użyj ObjectMapper.readValue.
5. Napisz test jednostkowy tej klasy. W tym celu użyj fragmentu json, upewniając się, że struktura została zachowana.
6. Utwórz w inbound klasę ZtmRawDataProvider. Powinna posiadać metode requestCurrentData zwracającą String i otrzymującą jako argument String z adresem strony. Wewnątrz niej utwórz obiekt URL wskazujący na podany adres i wczytaj jego zawartość. Podpowiedź: https://www.techiedelight.com/read-contents-of-url-into-string-java/
7. Utwórz w inbound klasę ZtmDataProvider, w której stworzysz metodę łączącą dwie poprzednie klasy. Przekaż argument "https://ckan2.multimediagdansk.pl/gpsPositions" do RawProvidera, a rezultat zapytania do Mappera. Odpal raz w mainie i wydrukuj wynik (dodaj toString w potrzebne miejsca). Działa?
8. Utwórz pakiet core i w nim klasę DataStorage mającą pole LocalDateTime oraz List<Vehicle>. Utwórz metodę update otrzymującą ZtmData, która będzie ustawiać te pola na podstawie otrzymanych danych i drukować informację do konsoli o uaktualnienie danych, wraz z aktualnym czasem oraz czasem z ZtmData.
9. Utwórz w inbound klasę QueryThread rozszerzającą klasę Thread. Powinna posiadać pole typu DataStorage, którego wartość będzie przekazana poprzez konstruktor. Nadpisz metodę start, aby drukowała do konsoli przy pomocy getName() informację, o rozpoczęciu działania i aktualnym czasie. Natomiast w nadpisanej metodzie run umieścimy logikę działania. Powinna pobrać dane przy pomocy ZtmDataProvider i umieścić je w klasie DataStorage. Cała czynność powinna być powtarzalna w pętli z Thread.sleep(30000) (czyli jedno zapytanie na pół minuty).
10. Utwórz w core klasę UIThread, rozszerzającą Thread. Ponownie w metodzie start zaloguj nazwę wątku i aktualny czas, a w konstuktorze przekaż DataStorage. Natomiast w metodzie run utwórz menu pozwalające na wybór opcji przez użytkownika poprzez wprowadzenie liczby. Póki co potrzebujemy opcji pozwalającej na wydrukowanie wszystkich pojazdów z DataStorage.
11. Utwórz oba wątki w main, przekaż im DataStorage, uruchom je. Sprawdź czy rezultaty są takie, jak oczekiwalibyśmy.
12. W core utwórz klasę Calculator. Utórz metody:
- obliczającą średnią prędkość wszystkich pojazdów
- obliczającą średnią prędkość pojazdów danej linii (pogrupuj je liniami)
- utwórz kolejną metodę obliczającą średnią prędkość pojazdów z podanej do metody linii.
Dodaj do UIThread odpowiednie opcje.
13. Zastanówmy się nad możliwymi metodami wyłączenia aplikacji.
     */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Hello World!");
        DataProvider dataProvider = new DataProvider();
        ZtmData ztmData = dataProvider.getZtmData();
        System.out.println(ztmData);
    }
}
