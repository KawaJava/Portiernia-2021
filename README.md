# Aplikacja "Portiernia (2021)"
## Opis
Program ten był moim pierwszym większym projektem napisanym w języku Java. Zrealizowanym w latach 2020 - 2021. W tamtym czasie znałem jedynie podstawy języka Java i relacyjnych baz danych. Dzisiaj aplikacja wyglądałaby zupełnie inaczej - użyłbym zupełnie innych technologii do napisania takiego programu i znacząco uprościłbym działanie aplikacji. Jednak, po napisaniu tego programu byłem bardzo dumny z tego, że udało mi się napisać taką aplikację i dlatego wstawiam ją na githuba.

## Instalacja

 1. Aby zainstalować program należy sklonować to repozytorium na komputer.
 2. Aby aplikacja działała poprawnie, należy zainstalować program MySQL Workbench i utworzyć w nim bazę danych o nazwię "portiernia". Należy też pobrać [instalator bazy danych](https://github.com/KawaJava/Portiernia-instalator-bazy-danych).
 3. Po zainstalowaniu należy otworzyć aplikację w IDE i ręcznie dodać pliki jar znajdujące się w folderze lib, który znajduje się w katalogu dist dostępnym w folderze z aplikacją. 
 4. W pliku textfile.txt podać nazwę użytkownika i hasło do bazy danych. 
 5. Zbudować i uruchomić aplikację.
 6. Do pierwszego zalogowania użyć loginu "root" i hasła "password".


## Instrukcja obsługi

Dokładny opis działania aplikacji znajduje się na [mojej stronie internetowej](https://kawajava.github.io/).

Aplikacja podzielona jest na trzy współpracujące ze sobą moduły:

 - Okno ustawienia
 - Okno edycji bazy danych
 - Okno wypożyczenia

Po zalogowaniu się jako admin można przejść do jednego z trzech wyżej opisanych modułów (mają dostęp tylko do okna wydawania/odbierania kluczy, natomiast mogą edytować bazę danych).

### Okno ustawienia

Dostęp do tego okna mają tylko admini.

### Okno edycji bazy danych

Dostęp do tego okna mają admini oraz moderatorzy.

### Okno wypożyczenia

Dostęp do tego okna mają wszyscy zarejestrowani użytkownicy.


## Możliwe problemy

### Problemy z pocztą (brak możliwości automatycznego wysłania emaila)
W tej wersji aplikacji nie ma możliwości wysyłania powiadomień email. Postaram się jak najszybciej naprawić ten problem.


## Możliwy rozwój

 - Z użyciem frameworka Spring Boot i biblioteki Lombok można znacząco zmniejszyć ilość kodu i usprawnić działanie aplikacji. W tym celu należy dodać klasy i obiekty odpowiadające tabelom z bazy danych, dokonać mapowania i wstrzyknąć odpowiednie zależności. Pozwoli to na pozbycie się wielu powtarzających się linijek kodu i zachować zasadę DRY. 
 - Po przebudowaniu programu na aplikację webową można połączyć ją z systemem USOS, aby zsynchronizować plany zajęć, dane wykładowców itp. Dzięki temu aplikacja będzie mogła pobierać dane z zewnętrznego serwisu i brak konieczności wprowadzania tych samych informacji w samej aplikacji.
