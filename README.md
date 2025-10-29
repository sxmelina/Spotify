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
<img width="1906" height="836" alt="image" src="https://github.com/user-attachments/assets/ccdcf881-15a8-44aa-86e2-e4a82ada1fca" />

<img width="1438" height="651" alt="image" src="https://github.com/user-attachments/assets/11d86ef5-2165-4744-a2b4-7dc8cea602ad" />


