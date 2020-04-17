Przedmiot: OSM
Projekt: 1
Zadanie: Tworzenie interfejsu graficznego aplikacji

Temat: Diagnostyka ostrej bia�aczce szpikowej: liczba leukocyt�w, liczba neutrofili, liczba
erytrocyt�w. Wszystkie warto�ci s� liczbami ca�kowitymi.

Zesp�: Maciej Groszyk, Szymon Matysiak

Biblioteki: 
commons lang3 (v. 3.10) - https://commons.apache.org/proper/commons-lang/
jdatepicker - calendar tool (v. 1.3.4) - https://jdatepicker.org/

Uwagi dodatkowe:
-Umo�liwili�my od razu dodanie badania bez konieczno�ci klikania �wie�o zapisanego pacjenta na li�cie,pacjent automatycznie zaznacza si� w tabeli. 

-Przycisk Anuluj w danych pacjenta i badaniu czy�ci dany panel podczas etapu zapisu pacjenta. Podczas etapu edycji
czy�ci i blokuje oba panele. Po zapisie pacjenta, zostaje on od razu wypisany i jest gotowy do edycji. 

-Dodane zosta�y podstawowe zabezpieczenia podczas wpisywania danych. Pesel zosta� zabezpieczony po przez wymagana ilo�� cyfr. Dodali�my r�wnie� dodatkowe
 zabezpieczenie na 10 cyfre nr Pesel aby zgadza�a si� z p�ci�. Jednak po konsultacji z dr. Tymonem Rublem postanowi�em zakomentowa� t� cz�� kodu
 i jej nie rozbudowywa�. 

-Rozpoznawanie choroby zosta�o przeprowadzony w spos�b taki aby od razu po wpisaniu sprawdza�o czy bia�aczka zostaje wykryta czy nie,
 w przypadku braku, kt�rego� z wynik�w aplikacja informuje nas o braku danych. Aplikacja uznaje wynik za pozytywny w przypadku
 gdy liczba leukocyt�w i neutrofili jest wi�ksza od 100 a liczba erytrocyt�w mniejsza od 100. S� to warto�ciwymy�lone, jednak bardzo �atwe do zmiany.