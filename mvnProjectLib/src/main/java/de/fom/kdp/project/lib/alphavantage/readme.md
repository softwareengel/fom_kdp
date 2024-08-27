# Alpha Vantage API  Client - API Key erforderlich 

A client for interacting with the Alpha Vantage API to retrieve stock market  data.

This class provides methods to fetch historical stock data and save it to a file.

## API Key config File 

####################### API KEY BENÖTIGT ##########################

Datei `config.ini` im Projekt - Hauptverzeichnis anlegen 

```
[AlphaVantage]
apiKey=SCRETKEY
```



## Config - Reader  

Der ConfigReader liest die `config.ini` - Datei ein und liefert den Inhalte der Properties.

