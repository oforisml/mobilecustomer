MobileCustomer is an api that works on port 8080 by default and on the `127.0.01` or `localhost`.


CAPABILITIES
1. fetching all users
2. it also can fetch a user by the user's `id`
3. updates the user's number `msisdn`.
4. updates network plan subscribed to `network_plan`
5. delete individual users



The methods used in the design of this api are
POST, GET, PUT AND DELETE

Now their endpoints follow



GET: 

This can be used to fetch either all the users on the system or a specific user on the system using the individual's `id`
    
To fetch all users, the endpoint is `localhost:8080/api/customers`
    
To fetch an individual user, the `id` is passed as a parameter to the endpoint.
That is `localhost:8080/api/customers/<ID>` where <ID> is the ID of the customer


    
DELETE:

To delete an individual's account, the delete method is implemented and the endpoint is passed the 
`id` of the individual as a parameter.

eg.    `localhost:8080/api/customers/<ID>`

There is not a method for deleting all customers at the same time since no such API is really necessary in the 
real world.


    
PUT

To update a user's details(`msisdn` or `network_plan`), one must pass the `@RequestParameter(s)` to the endpoint of the API
to be able to update it.

Updating a single detail: `localhost:8080/api/customers/<ID>?<@RequestParameter>`

In case of multiple parameters: `localhost:8080/api/customers/<ID>`?`fistParam`=`firstValue`&`secondParam`=`secondValue`

where <@firstRequestParameter> and <@SecondRequestParameter> are the 


    
    
DATA REPRESENTATION

The phone number is represented in the form `(xxx) xxx-xxxx`

Length of phone number can be more than 10 but the format above only takes care of 10 digit numbers excluding country codes.

The `network_plan` too is enumerated with values `MOBILE_POSTPAID` and `MOBILE_PREPAID`



The database attached to this project is actually set to create/drop its table when this program runs to save space during the development state.

To change that, go to `src/main/resources/application.properties` and change `spring.jpa.hibernate.ddl-auto=create-drop` to `spring.jpa.hibernate.ddl-auto=update`
