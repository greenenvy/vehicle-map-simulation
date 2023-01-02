# Simulacija kretanja vozila po mapi

Primer funckioniše tako sto se simuliraju 3 vozila koja kreću sa random fiksiranih taksi stajališta ka jednoj od 10 definisanih adresa. Nakon sto dođu do adrese, voze ka destinaciji koja se takođe bira iz skupa od 10 adresa tako da se destinacija uvek razlikuje od polazišta. Kada vozilo dođe do kraja rute, kreće nazad ka nekom od 5 taxi stajališta koja su definisana. Kompletna logika simulacije se nalazi u **simulation.py** locust skripti.

Za dobijanje geoJSON-a koji je korišćen za primer, upotrebljen je OSM routing servis:
https://project-osrm.org/

### Instrukcije za pokretanje:

- Backend se nalazi u folderu: **vehicle-simulation-example-backend** i pokreće se kao i ostali primeri dosad
- Frontend se nalazi u folderu: **vehicle-simulation-example-frontend** i pokreće se komandom **npm start** (pre toga odraditi **npm install**)
- Locust skripta se nalazi folderu **locust**

Za pokretanje locust skripte je neophodno imati instaliran python (poželjno neku od novijih verzija): https://www.python.org/downloads/

Nakon toga, potrebno je instalirati pip alat koji će vam omogućiti da instalirate eksterne biblioteke u lokalni virutelni environment: https://pip.pypa.io/en/stable/installation/

Kreiranje lokalnog virtual environment-a je poželjno da uradite u ovom projektu (pozicionirati se u prevučen projekat). Kreiranje i aktivacija:

Linux i MacOS:\
**virtualenv vehicle-simulation**\
**source vehicle-simulation/bin/activate**

Windows:\
**virtualenv vehicle-simulation**\
**vehicle-simulation\Scripts\activate** -> Ako koristite cmd\
**source vehicle-simulation\Scripts\activate** -> Ako koristite git bash

Nakon aktivacije virtualenv okruženja, instalirati sledeće biblioteke:\
**pip3 install locust**\
**pip3 install requests**

Pre pokretanja Locust skripte pokrenuti **Backend** pa **Frontend**.

Locust skriptu pokrenuti komandom:\
**locust -f locust/simulation.py --headless -u 3 -r 1 --run-time 30m**

### Promena port-a

- Za Backend promeniti port u **application.properties** fajlu
- Za Frontend promeniti port u **proxy.conf.json** fajlu
- Za Locust skriptu promeniti vrednosti port-a gde god se isti pominje u samom fajlu
