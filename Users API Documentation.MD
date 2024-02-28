# USERS API DOCUMENTATION

This is an API REST aimed to maintain a user Data Base with CRUD methods. There is a Postman collection, in this same repo, that gathers all endpoints and can be easily imported to test the API.


## ENDPOINTS 

* ## `/singin`
    ### `GET`
    This endpoint will first check if there is any user with that email. If there is not, then it will throw a message saying that the email couldn't be founded in the Data Base. If there is a user with that email, then it will verify if the password provided matches the one setted by the user. 

    ### REQUEST PARAM SAMPLE
    `email` amantedelacomida53@aol.com

    `password` LaTabernaDeMoe

    ### REQUEST BODY SAMPLE
    ```
    {
	    "name": "Homero",
        "lastName": "Simpson",
        "address": "Av. Siempreviva 742",
        "city": "Springfield",
        "email": "amantedelacomida53@aol.com"
    }
    ```

    ### RESPONSE SAMPLE
    ```
    amantedelacomida53@aol.com ha sido dado de alta correctamente.
    ```
    or
    ```
    El usuario amantedelacomida53@aol.com no se ha encontrado en nuestra base de datos.
    ```
    or
    ```
    Credenciales invalidas.
    ```

* ## `/findAll`
    ### `GET`
    This method will retrieve a list of all users found in the Data Base.

    ### RESPONSE SAMPLE
    ```
    [
        {
            "name": "Homero",
            "lastName": "Simpson",
            "address": "Av. Siempreviva 742",
            "city": "Springfield",
            "email": "amantedelacomida53@aol.com"
        },
        {
            "name": "Marge",
            "lastName": "Simpson",
            "address": "Av. Siempreviva 742",
            "city": "Springfield",
            "email": "marge.simpson@aol.com"
        }
    ]
    ``` 

* ## `/create`
    ### `POST`
    This endpoint will create -if possible- a new user in the Data Base. The API will first check if amantedelacomida53@aol.com already existed in the Data Base, therefore the response will depend on it.

    ### REQUEST PARAM SAMPLE

    `password` LaTabernaDeMoe

    ### REQUEST BODY SAMPLE
    ```
    {
	    "name": "Homero",
        "lastName": "Simpson",
        "address": "Av. Siempreviva 742",
        "city": "Springfield",
        "email": "amantedelacomida53@aol.com"
    }
    ```

    ### RESPONSE SAMPLE
    ```
    amantedelacomida53@aol.com ha sido dado de alta correctamente.
    ```
    or
    ```
    El usuario amantedelacomida53@aol.com ya se encontraba dado de alta en nuestra base de datos.
    ```

* ## `/update`
    ### `PUT`
    This endpoint will first check ir the superhero on the request body exist on the Data Base. If true, then it will be updated, if not, it will notify that the superhero couldn't be found.

    ### REQUEST PARAM SAMPLE
    `email` amantedelacomida53@aol.com

    ### REQUEST BODY SAMPLE
    ```
    {
        "name": "Batman",
        "city": "Metropolis",
        "power": "Ninguno",
        "wearsCape": true
    }
    ```
    ### RESPONSE SAMPLE
    ```
    amantedelacomida53@aol.com ha sido actualizado correctamente.
    ```
    or
    ```
    El usuario amantedelacomida53@aol.com no se ha encontrado en nuestra base de datos.
    ```
* ## `/updatePassword`
    ### `PUT`
    This endpoint will first check if there is any user with that email. If there is not, then it will throw a message saying that the email couldn't be founded in the Data Base. If there is a user with that email, then it will verify if the password provided matches the one setted by the user. Finally, if everything goes as expected, the new password will be setted for the user.

    ### REQUEST PARAM SAMPLE
    `email` amantedelacomida53@aol.com

    `oldPassword` LaTabernaDeMoe

    `newPassword` LaTabernaDeMoe1

    ### RESPONSE SAMPLE
    ```
    La contraseña de amantedelacomida53@aol.com ha sido actualizada correctamente.
    ```
    or
    ```
    El usuario amantedelacomida53@aol.com no se ha encontrado en nuestra base de datos.
    ```
    or
    ```
    Credenciales invalidas.
    ```


* ## `/delete/{email}`
    ### `DELETE`
    This method will delete the user with email recieved in the `email` param. Response will depend whether the user existed or not in the Data Base.

    ### RESPONSE SAMPLE
    ```
    amantedelacomida53@aol.com ha sido eliminado correctamente de nuestra base de datos.
    ```
    or
    ```
    El usuario amantedelacomida53@aol.com no se ha encontrado en nuestra base de datos.
    ```


* ## `/deleteAll`
    ### `DELETE`
    This endpoint recieves no params. All users on the Data Base will be deleted.

    ### RESPONSE SAMPLE
    ```
    Todos los usuarios fueron eliminados de la base de datos.
    ```

