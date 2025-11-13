# Spotify - Spring Boot MVC Aplikacija

## Clanovi tima
- Student A: Melina Salijević
- Student B: Sedina Tutmić
- Student C: Esada Durmić

## Opis aplikacije
Mini platforma za pregled albuma i pjesama inspirisana Spotify-em, uz mogućnost dodavanja korisnika koji mogu lajkati albume i tako ih dodati u svoju kolekciju. 
Lajkanje je simbolično implementirano - korisnik se bira ručno preko svog ID-a u sklopu listaalbuma.html. U realnoj situaciji, to bi se implementiralo omogućavanjem log-ina, ili biranjem dostupnih korisnika drop-down listom ili slično.
IPlatforma je implementirana u Spring Boot-u i koristi MySQL bazu, Thymeleaf za frontend sloj i JPA/Hibernate za rad s entitetima.

## Modeli
U početnoj verziji projekta postojala su dva modela:
- **Album**: id, naziv, zanr, godinaIzdanja, izvodjac, slika
- **Pjesma**: id, naziv, trajanje, godinaIzdanja, albumId
Za potrebe zadatka dodan je novi model:
- **Korisnik**: id, username, email, lista lajkovanih albuma

## Relacija
- **album - pjesma:** 1:N (Jedan album ima više pjesama)
  
- **korisnik - album:** N:N (Više korisnika može imati više albuma)
Hibernate automatski generiše pomoćnu tabelu:
**korisnik_likes**
---------------------
korisnik_id (FK → korisnik)
album_id    (FK → album)

## Controllers
Pored regularnog AppControllera kojim se dohavataju i prikazuju albumi i pjesme, u ovom zadatku dodani su:

1. Obični MVC kontroler – KorisnikController
Omogućava:
- prikaz liste korisnika
- dodavanje novog korisnika (forma)
- prikaz profila i lajkovanih albuma
- uređivanje korisnika
Koristi Thymeleaf HTML stranice:
- korisnici.html
- korisnik_form.html
- korisnik_detail.html

2️. REST kontroler – KorisnikRestController
Omogućava rad preko JSON API-ja:
- GET /api/korisnici – vraća sve korisnike
- GET /api/korisnici/{id} – vraća korisnika po ID-u
- POST /api/korisnici – dodaje korisnika
- PUT /api/korisnici/{id} – ažurira
- DELETE /api/korisnici/{id} – briše

## Baza podataka
Za razliku od prethodnog dijela zadatka, u projektu se sada koristi MySQL (ne in-memory DemoData file).
Program (JPA) automatski kreira tabele, a potrebni podaci, poput imena albuma i pjesama, uneseni su putem upita u MySQL Workbench-a.

## Web rute
- `/albumi` – lista svih albuma  
- `/a/action/{id}` – pjesme iz odabranog albuma  
- `/pjesme` – lista svih pjesama  
- `/korisnici` – lista korisnika  
- `/korisnici/new` – dodavanje korisnika  
- `/korisnici/{id}` – detalji korisnika + lajkovani albumi  
- `/korisnici/{id}/edit` – uređivanje korisnika  
- `/album/{id}/like` (POST) – lajkanje albuma od strane korisnika  

## REST rute
- `/api/korisnici` – svi korisnici (JSON)  
- `/api/korisnici/{id}` – korisnik po ID-u (JSON)  
- `/api/korisnici` (POST) – dodavanje korisnika  
- `/api/korisnici/{id}` (PUT) – uređivanje  
- `/api/korisnici/{id}` (DELETE) – brisanje  

## Tehnologije
- Spring Boot 3.x
- Thymeleaf
- Maven
- Java 17

## Pokretanje
1. Otvorite projekat u IntelliJ IDEA
2. Pokrenite SpotifyApplication.java
3. Otvorite browser: http://localhost:8080/albumi

## Screenshot
![Početna stranica sa albumima](https://raw.githubusercontent.com/sxmelina/Spotify/refs/heads/lab2/screenshots/Screenshot%202025-11-13%20005302.png)
![Dodavanje novog korisnika](https://raw.githubusercontent.com/sxmelina/Spotify/refs/heads/lab2/screenshots/Screenshot%202025-11-13%20005326.png)
![Svi korisnici](https://raw.githubusercontent.com/sxmelina/Spotify/refs/heads/lab2/screenshots/Screenshot%202025-11-13%20005317.png)








