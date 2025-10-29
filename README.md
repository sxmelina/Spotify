# Spotify - Spring Boot MVC Aplikacija

## Clanovi tima
- Student A: Melina Salijević
- Student B: Sedina Tutmić
- Student C: Esada Durmić

## Opis aplikacije
Spotify muzicka platforma za pregled albuma i pjesama sa Spotify brendom i dizajnom.

## Modeli
- **Album**: id, naziv, zanr, godinaIzdanja, izvodjac, slika
- **Pjesma**: id, naziv, trajanje, godinaIzdanja, albumId

## Relacija
1:N (Jedan album ima vise pjesama)

## Rute
- `/a` - Lista albuma
- `/b` - Lista pjesama
- `/a/action/{id}` - Pjesme odredjenog albuma

## Tehnologije
- Spring Boot 3.x
- Thymeleaf
- Maven
- Java 17

## Pokretanje
1. Otvorite projekat u IntelliJ IDEA
2. Pokrenite SpotifyApplication.java
3. Otvorite browser: http://localhost:8080/a

## Screenshot
<img width="1918" height="1077" alt="image" src="https://github.com/user-attachments/assets/243a72bc-9f9c-4ec4-a118-2a90d0ed4f8e" />
<img width="1918" height="1075" alt="image" src="https://github.com/user-attachments/assets/3647e716-16a3-4a01-a876-3cd72cc8bb0a" />

