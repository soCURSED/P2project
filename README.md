

Create E-commerce website where users can buy products ( amazon clone )


Classes Domains :

E-commerce Website :
- Product Class: ID, name, price , categoryID , ArrayList < Comment >.
- Category : ID , name.
- Merchant : ID , name.
- MerchantStock : ID , productid , merchantid , stock
- Cart class: ID, userid, ArrayList < Product >.
- User Class : id , username , password , email , role , balance.
- Comment  : id, userid , message , rate
- PurchaseHistory : id , userid , productid , price


----------


Validation : 

Product Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).
- price ( must not be empty , must be positive number  ).
- categoryID ( must not be empty , have to be 3 character long ).

Category Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).

Merchant Class :
- id ( must not be empty , have to be 3 character long ).
- name ( must not be empty , have to be 3 length long ).

MerchantStock Class :
- id ( must not be empty , have to be 3 character long ).
- productid ( must not be empty , have to be 3 character long ).
- merchantid ( must not be empty , have to be 3 length long ).
- stock  ( must not be empty , have to be more than 10 at start ).

Cart Class :
- id ( must not be empty , have to be 3 character long ).
- userid ( must not be empty , have to be 3 character long ).
- ArrayList < Product > ( initialize in the constructor ).

User Class : 
- id ( must not be empty , have to be 3 character long ).
- username ( must not be empty , have to be 5 length long ).
- password ( must not be empty , have to be 6 length long , must have characters and digits ).
- email  ( must not be empty , must be valid email ).
- role  ( must not be empty , have to be in ( “Admin”,”Customer”) ).
- balance ( must not be empty , have to be positive ).

Comment Class : 
- id ( must not be empty , have to be 3 character long ).
- userid ( must not be empty , have to be 5 length long ).
- message  ( must not be empty , have to be 6 length long  ).
- rate ( must not be empty , must be a number between 1 - 5 ).

PurchaseHistory Class : 
- id ( must not be empty , have to be 3 character long ).
- userid ( must not be empty , have to be 3 character long ).
- productid  ( must not be empty , have to be 3 character long  ).
- price ( must not be empty , must be a positive number ).

----------

- Use project Lombok 
- Use Service layer


----------



- Create endpoint for getting and adding and deleting updating  a  Product.
- Create endpoint for getting and adding and deleting updating  a  Category.
- Create endpoint for getting and adding and deleting updating  a  Merchant.
- Create endpoint for getting and adding and deleting updating  a  MerchantStock.
- Create endpoint for getting and adding and deleting updating  a  User.
- Create endpoint for getting  a  Cart.
- Create endpoint for getting  a  Comment.
- Create endpoint for getting  a  PurchaseHistory.


----------


- Create endpoint where user can add product to  a cart.
- this endpoint should accept a userid and productid both should be valid or return bad request 
----------
- Create endpoint where user can remove product from  a cart
- this endpoint should accept a userid and productid both should be valid or return bad request
----------
- Create endpoint where user can add product to a merchantStock
- this endpoint should accept a productid and merchantid  and stock
----------
- Create endpoint where user can buy a product directly without a cart
- this endpoint should accept userid , product id , merchantid.
- check if the merchant have the product in stock or return bad request.
- reduce the stock from the MerchantStock.
- deducted the price of the product from the user balance.
- if balance is less than the product price return bad request.
- add to the PurchaseHistory about this purchase.
----------
- Create endpoint where user can buy a a product with a cart
- this endpoint should accept a cart object.
- the user should have the balance to buy all the products.
- check if the merchant have the product in stock or return bad request.
- reduce the stock from the MerchantStock. 
- deducted the price of the products from the user balance.
- add to the PurchaseHistory about this purchase.
----------
- Create endpoint where user can post comment on product
- this endpoint should accept user id , product id , comment object
- verify that the user bought the product before or return bad request
----------
- Create endpoint where user can get all the comments for a product
- this endpoint should accept product id and it should be valid or return bad request
----------
- Create endpoint where user can get all the rate 5 products
----------
- Create endpoint where user can get all PurchaseHistory
----------





