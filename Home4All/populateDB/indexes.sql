drop index email_users_index;

drop index discriminator_property_index;

drop index district_address_index;

drop index city_address_index;

drop index path_photo_index;


CREATE INDEX email_users_index
ON users(email);


CREATE INDEX discriminator_property_index
ON property(discriminator);


CREATE INDEX district_address_index
ON address(district);


CREATE INDEX city_address_index
ON address(city);


CREATE INDEX path_photo_index
ON photo(path);

