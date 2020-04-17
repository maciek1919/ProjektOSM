Przedmiot: OSM
Projekt: 1
Zadanie: Tworzenie interfejsu graficznego aplikacji

Temat: Diagnostyka ostrej bia³aczce szpikowej: liczba leukocytów, liczba neutrofili, liczba
erytrocytów. Wszystkie wartoœci s¹ liczbami ca³kowitymi.

Zespó³: Maciej Groszyk, Szymon Matysiak

Biblioteki: 
commons lang3 (v. 3.10) - https://commons.apache.org/proper/commons-lang/
jdatepicker - calendar tool (v. 1.3.4) - https://jdatepicker.org/

Uwagi dodatkowe:
-Umo¿liwiliœmy od razu dodanie badania bez koniecznoœci klikania œwie¿o zapisanego pacjenta na liœcie,pacjent automatycznie zaznacza siê w tabeli. 

-Przycisk Anuluj w danych pacjenta i badaniu czyœci dany panel podczas etapu zapisu pacjenta. Podczas etapu edycji
czyœci i blokuje oba panele. Po zapisie pacjenta, zostaje on od razu wypisany i jest gotowy do edycji. 

-Dodane zosta³y podstawowe zabezpieczenia podczas wpisywania danych. Pesel zosta³ zabezpieczony po przez wymagana iloœæ cyfr. Dodaliœmy równie¿ dodatkowe
 zabezpieczenie na 10 cyfre nr Pesel aby zgadza³a siê z p³ci¹. Jednak po konsultacji z dr. Tymonem Rublem postanowi³em zakomentowaæ tê czêœæ kodu
 i jej nie rozbudowywaæ. 

-Rozpoznawanie choroby zosta³o przeprowadzony w sposób taki aby od razu po wpisaniu sprawdza³o czy bia³aczka zostaje wykryta czy nie,
 w przypadku braku, któregoœ z wyników aplikacja informuje nas o braku danych. Aplikacja uznaje wynik za pozytywny w przypadku
 gdy liczba leukocytów i neutrofili jest wiêksza od 100 a liczba erytrocytów mniejsza od 100. S¹ to wartoœciwymyœlone, jednak bardzo ³atwe do zmiany.