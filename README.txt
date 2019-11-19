Åpne hele mappen som et intelij prosjekt.
maven skal laste ned alle dependencies automagisk.
Det kan hende du vil få en popup nederst til høyre.
Trykk på "import changes" hvis dette forekommer.

For å starte applikasjonen trykk på run i main()
Main() burde da åpne et nettleser vindu for Localhost 8080.
Hvis dette ikke forekommer, vennligst trykk run på main og manuelt skriv inn: http://localhost:8080 i URL feltet til din nettleser.
Viktig at det ikke er en kjørende applikasjon på port 8080 fra før. Siden dette vil hindre applikasjonen i å starte.

For å kjøre tester naviger til src/test/java deretter marker alle tester, høyreklikk og trykk run.

Det har blitt benyttet Dummy Data i Prototypen.
Det ligger inne to brukere fra før.
Av brukertypene:
Arrangør: ola@gmail.com passord: test1.
Deltager: petter@gmail.com passord: test2.
Det ligger knapper for å logge inn som begge disse to brukerne på innloggingssiden. samt to dummy arrangement med dummy løp som tilhører ola@gmail.com.
Det ligger i tillegg ferdig utfylt informasjon i registreringsskjema for både deltaker og arrangør. Dette kan byttes ut hvis bruker av prototypen ønsker egen profil.
