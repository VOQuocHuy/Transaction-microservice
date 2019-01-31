# Transaction-microservice

## Classes

| Object  | Type | Description |
| ------------- | ------------- | ------------- |
| Id  | Long  | Id de la transaction  |
| Ibansour  | String | IBAN source  |
| Ibandest  | String | IBAN destination  |
| type  | String | Type de transaction  |
| montant  | Double | Montant de transaction  |
| date  | Date | Date de transaction  |

## Méthodes

| Method  | Syntax | Description |
| ------------- | ------------- | ------------- |
| get()  |     public Long getId() | Renvoie de la valeur Id de la transaction   |
| set()  |     public void setId() | Définition de la valeur Id de la transaction   |
| get()  |     public String getIbansour() | Retour de la valeur Iban source de la transaction   |
| set()  |     public void setIbansour | Définition de la valeur Iban source de la transaction   |
| get()  |     public String getIbandest() | Retour de la valeur Iban destination de la transaction   |
| set()  |     public void setIbandest() | Définition de la valeur Iban destination de la transaction   |
| get()  |     public String gettype() | Retour de la valeur type de la transaction   |
| set()  |     public void settype() | Définition de la valeur type de la transaction   |
| get()  |     public Double getMontant() | Retour de la valeur montant de la transaction   |
| set()  |     public void setMontant() | Définition de la valeur montant de la transaction   |
| get()  |     public Date getDate() | Retour de la valeur date de la transaction   |
| set()  |     public void setDate() | Définition de la valeur date de la transaction   |

## Repository
| Interface | Description |
| ------------- | ------------- | 
| CompteBancaireRepository |     Création de la couche d'accès aux données| 

## Rest API

| URL  | Method | Format |
| ------------- | ------------- | ------------- |
|/transactions/history  |    **GET** | XML, JSON  |
|/transactions/date     |   **GET**| XML, JSON  |
|/transactions/type     |  **GET**| XML, JSON  |
|/source/{ibansour}/dest/{ibandest}  |    **GET** | XML, JSON  |
|/transactions/delete  |   **DELETE** | XML, JSON  |
|/transactions/new  |    **POST** | XML, JSON  |
|/transactions/update  |    **PUT** | XML, JSON  |
|/virement  |    **GET** | XML, JSON  |




