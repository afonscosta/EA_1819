from faker import Faker
import numpy as np
import hashlib
import requests

# psql -U postgres -f .\populate_db.sql
output_filename = 'populate_db.sql'
output = open(output_filename, 'w+')

# Configs - Users
users_quantity = 10
users_password = '12345678'
user_descriminators = ['InternalAccount', 'Common']
user_desc_probabilities = [0.6, 0.4]
genders = ['female', 'male', 'undefined']
genders_probabilities = [0.45, 0.45, 0.1]
occupations = ['student', 'studentWorker', 'worker', 'retired', 'unemployed']
occupations_probabilities = [0.4, 0.3, 0.2, 0.05, 0.05]
min_age = 18
max_age = 70
blocked_probability = 0.1

# Configs - Properties
props_quantity = 10
props_descriminators = ['Shared', 'Apartment', 'Vila']
props_descriminators_probabilities = [0.4, 0.3, 0.3]
props_allowed_genders_probabilities = [0.35, 0.35, 0.3]
props_typologies = ['T0', 'T1', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7', 'T8', 'T9', 'T10', 'T10+']
props_typologies_probabilities = [0.05, 0.2, 0.4, 0.13, 0.05, 0.05, 0.04, 0.03, 0.02, 0.01, 0.01, 0.01]
props_limit_min_age_probability = 0.5
props_limit_max_age_probability = 0.5
props_allowed_smokers_probability = 0.4
props_allowed_pets_probability = 0.6
props_genders_quantity = [0, 1, 2, 3, 4, 5, 6]
props_genders_probabilities = [0.35, 0.32, 0.16, 0.1, 0.05, 0.01, 0.01]
props_smokers_quantity = [0, 1, 2, 3, 4]
props_smokers_probabilities = [0.5, 0.3, 0.1, 0.05, 0.05]
props_pets_quantity = [0, 1, 2, 3]
props_pets_probabilities = [0.4, 0.4, 0.15, 0.05]
props_total_access_probability = 0.5
props_furnished_probability = 0.5
props_sell_price = [100000,500000]
props_rent_price = [350,850]
props_sold_probability = 0.3

# Configs - Addresses
addresses_quantity = props_quantity

# Configs - Complaints
complaints_quantity = 10

# Configs - Bedrooms
bedrooms_per_shared = [1, 2, 3, 4]
bedrooms_per_shared_probabilities = [0.5, 0.35, 0.1, 0.05]
bedrooms_types = ['single', 'double', 'multiple']
bedrooms_types_probabilities = [0.4, 0.4, 0.2]
bedrooms_furnished_probability = 0.5
bedrooms_people_amount = [2, 3, 4, 5, 6, 7, 8]
bedrooms_people_amount_probabilities = [0.35, 0.15, 0.25, 0.05, 0.1, 0.05, 0.05]
bedrooms_area = [30, 100]
bedrooms_private_bathroom_probability = 0.5
bedrooms_rent_price = [150, 400]
bedrooms_sold_probability = 0.3

# Configs - Property_Occupation
property_occupations_qt = [0, 1, 2, 3, 4, 5]
property_occupations_probabilities = [0.1, 0.2, 0.3, 0.2, 0.1, 0.1]
property_occupations2_qt = [1, 2, 3, 4, 5] # Allowed
property_occupations2_probabilities = [0.1, 0.2, 0.4, 0.2, 0.1]

# Configs - Property_Equipment
equipments = ['kitchen', 'microwave', 'dishwasher', 'stove', 'fridge', 'washingMachine', 'television', 'cableTV', 'WiFi', 'computer', 'gym', 'pool', 'elevator', 'centralHeating', 'airConditioning', 'garage', 'freeParking']
equipments_probabilities = [0.06, 0.06, 0.06, 0.06, 0.06, 0.06, 0.06, 0.06, 0.06, 0.06, 0.05, 0.05, 0.06, 0.06, 0.06, 0.06, 0.06]
property_equipments_qt = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
property_equipments_probabilities = [0.05, 0.05, 0.05, 0.05, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.05, 0.05, 0.05, 0.05]

# Configs - Pets
pets = ['cão', 'gato', 'rato', 'tartaruga', 'papagaio']
pets_probabilities = [0.4, 0.4, 0.08, 0.08, 0.04]

# Configs - Photos
images_quantity = 13
images_bedroom = [7, 8, 9, 10]
images_per_property = [4, 8]
images_per_bedroom = [1, 2]



def get_boolean(true_probability):
    return np.random.choice([True, False], 1, p=[true_probability, 1 - true_probability])[0]

def get_boolean_str(true_probability):
    return np.random.choice(['true', 'false'], 1, p=[true_probability, 1 - true_probability])[0]


# Limpar Base de Dados
output.write("\c home4alldb\n\n")
output.write("-- CLEAN DATABASE\n")
output.write("DELETE FROM Photo;\n")
output.write("ALTER SEQUENCE photo_id_seq RESTART WITH 1;\n")
output.write("ALTER SEQUENCE new_image_id RESTART WITH 1;\n")
output.write("DELETE FROM Pet;\n")
output.write("ALTER SEQUENCE pet_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Property_Equipment;\n")
output.write("DELETE FROM Property_Occupation;\n")
output.write("DELETE FROM Property_Occupation2;\n")
output.write("DELETE FROM Bedroom;\n")
output.write("ALTER SEQUENCE bedroom_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Complaint;\n")
output.write("ALTER SEQUENCE complaint_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Property;\n")
output.write("ALTER SEQUENCE property_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Users;\n")
output.write("ALTER SEQUENCE users_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Address;\n")
output.write("ALTER SEQUENCE address_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM MultipleRoom;\n")
output.write("ALTER SEQUENCE multipleroom_id_seq RESTART WITH 1;\n")
output.write("DELETE FROM Notification;\n")
output.write("ALTER SEQUENCE notification_id_seq RESTART WITH 1;\n")

fake = Faker('pt_PT')

# Populate users
# (id, discriminator, email, name, password, gendername, occupationname, age, phone, lastlogin, blocked)
output.write('\n-- POPULATE Users\n')
output.write(f'''INSERT INTO Users VALUES (default, 'Admin', 'admin@home4all.net', 'Admin', '{hashlib.sha256(b'_admin*pass_')}', NULL, NULL, NULL, NULL, NULL, NULL);\n\n''')

for i in range(users_quantity):
    discriminator = np.random.choice(user_descriminators, 1, p=user_desc_probabilities)[0]
    email = fake.email()
    if discriminator=='InternalAccount':
        m = hashlib.sha256()
        m.update(users_password.encode())
        password = "'" + m.digest().hex() + "'"
    else:
        password = 'null'

    age = np.random.randint(min_age, max_age)
    phone = fake.phone_number()
    if phone.startswith('(351)'):
        phone = phone[5:]
    phone = phone.replace(' ','')
    last_login = fake.date_between(start_date="-30d", end_date="today")
    gender_name = np.random.choice(genders, 1, p=genders_probabilities)[0]
    if gender_name == 'female':
        name = fake.name_female()
    elif gender_name == 'male':
        name = fake.name_male()
    else:
        name = fake.name()
    occupation_name = np.random.choice(occupations, 1, p=occupations_probabilities)[0]
    blocked = get_boolean_str(blocked_probability)
    
    output.write(f'''INSERT INTO Users VALUES (default, '{discriminator}', '{email}', '{name}', {password}, '{gender_name}', '{occupation_name}', {age}, '{phone}', DATE '{last_login}', {blocked});\n\n''')


# Populate Address (id, district, city, completeaddress, coordlat, coordlng)
def reverse_geocode(latitude, longitude):
    sensor = 'false'
    base = "https://maps.googleapis.com/maps/api/geocode/json?"
    params = "latlng={lat},{lon}&sensor={sen}&size=640x640&key={key}".format(
        lat=latitude,
        lon=longitude,
        sen=sensor,
        key="AIzaSyDtZzBGMqTFWjndSRR-kEzpwBMdHodA5Ac"
    )
    url = "{base}{params}".format(base=base, params=params)
    response = requests.get(url)
    result = response.json()['results']
    if result and len(result) > 0:
        result = result[0]
        for addr_comp in result['address_components']:
            if 'locality' in addr_comp['types'] and 'political' in addr_comp['types']:
                city = addr_comp['long_name']
            if 'administrative_area_level_1' in addr_comp['types'] and 'political' in addr_comp['types']:
                district = addr_comp['long_name']
        address = result['formatted_address']
        return district, city, address
    else:
        return None, None, None

def gen_address():
    city = None
    i = 0
    while city == None and i < 8:
        lat, lng = fake.local_latlng(country_code="PT", coords_only=True)
        district, city, address = reverse_geocode(lat, lng)
        i += 1
    if i==8:
        raise Exception('ERRO: Problema ao gerar morada')
    
    return district, city, address, lat, lng

output.write('\n-- POPULATE Address\n')
for i in range(addresses_quantity):
    # TODO: substituir geração da morada
    district, city, address, lat, lng = ('Lisboa', 'Carnaxide', 'R. Portal das Terras 14A, 2790-121 Carnaxide, Portugal', '38.72706', '-9.24671')
    # district, city, address, lat, lng = gen_address()
    output.write(f'''INSERT INTO Address VALUES (default, '{district}', '{city}', '{address}', '{lat}', '{lng}');\n\n''')


# Populate properties
# (id, discriminator, addressid, gendername, typologyname, usersid, name, description, area, allowedminage, allowedmaxage, allowedsmoker, allowedpets, publishdate, blocked, females, males, smokers, petsquantity, totalaccess, furnished, availability, sellprice, rentprice, sold)

output.write('\n-- POPULATE Property\n')
shared_properties = {}
pets_per_property = []
for i in range(props_quantity):
    discriminator = np.random.choice(props_descriminators, 1, p=props_descriminators_probabilities)[0]
    name = fake.company()
    description = fake.text(max_nb_chars=254)
    address_id = i + 1
    user_id = np.random.randint(users_quantity) + 1
    typology = np.random.choice(props_typologies, 1, p=props_typologies_probabilities)[0]
    area = np.random.randint(1000)
    if get_boolean(props_limit_min_age_probability):
        min_age_aux = np.random.randint(min_age, min_age + 20)
        allowed_min_age = "'" + str(min_age_aux) + "'"
    else:
        min_age_aux = min_age
        allowed_min_age = 'null'
    if get_boolean(props_limit_max_age_probability):
        allowed_max_age = "'" + str(np.random.randint(int(min_age_aux) + 5, max_age)) + "'"
    else:
        allowed_max_age = 'null'
    allowed_smokers = get_boolean_str(props_allowed_smokers_probability)
    allowed_pets = get_boolean_str(props_allowed_pets_probability)
    allowed_gender = np.random.choice(props_genders_quantity, 1, p=props_genders_probabilities)[0]
    publish_date = fake.date_between(start_date="-4y", end_date="today")
    blocked = get_boolean_str(blocked_probability)

    if discriminator == 'Shared':
        females = np.random.choice(props_genders_quantity, 1, p=props_genders_probabilities)[0]
        males = np.random.choice(props_genders_quantity, 1, p=props_genders_probabilities)[0]
        smokers = np.random.choice(props_smokers_quantity, 1, p=props_smokers_probabilities)[0]
        pets_quantity = np.random.choice(props_pets_quantity, 1, p=props_pets_probabilities)[0]
        total_access = get_boolean_str(props_total_access_probability)
        
        furnished = 'null'
        availability = 'null'
        sell_price = 'null'
        rent_price = 'null'
        sold = 'null'

        shared_properties[i+1] = [] # i+1 é o id da Property
        pets_per_property.append(pets_quantity)
    else:
        furnished = get_boolean_str(props_furnished_probability)
        availability = "date '" + str(fake.date_between(start_date="today", end_date="+30d")) + "'"
        sell_price = np.random.randint(props_sell_price[0], props_sell_price[1])
        rent_price = np.random.randint(props_rent_price[0], props_rent_price[1])
        sold = get_boolean_str(props_sold_probability)

        females = 'null'
        males = 'null'
        smokers = 'null'
        pets_quantity = 'null'
        total_access = 'null'
        
        pets_per_property.append(0)

    output.write(f'''INSERT INTO Property VALUES (default, '{discriminator}', {address_id}, '{gender_name}', '{typology}', {user_id}, '{name}', '{description}', {area}, {allowed_min_age}, {allowed_max_age}, {allowed_smokers}, {allowed_pets}, date '{publish_date}', {blocked}, {females}, {males}, {smokers}, {pets_quantity}, {total_access}, {furnished}, {availability}, {sell_price}, {rent_price}, {sold});\n\n''')

# Populate Complaint (id, description, propertyid)
output.write('\n-- POPULATE Complaint\n')
for i in range(complaints_quantity):
    property_id = np.random.randint(props_quantity) + 1
    description = fake.text(max_nb_chars=254)
    
    output.write(f'''INSERT INTO Complaint VALUES (default, '{description}', {property_id});\n\n''')

# Populate Bedroom (id, bedroomtypename, furnished, peopleamount, area, privatebathroom, availability, rentprice, sold, propertyid)
output.write('\n-- POPULATE Bedroom\n')
id_bedroom = 1
for property_id in shared_properties:
    bedrooms_quantity = np.random.choice(bedrooms_per_shared, 1, p=bedrooms_per_shared_probabilities)[0]
    for i in range(bedrooms_quantity):
        shared_properties[property_id].append(id_bedroom)
        id_bedroom += 1
        bedroom_type_name = np.random.choice(bedrooms_types, 1, p=bedrooms_types_probabilities)[0]
        furnished = get_boolean_str(bedrooms_furnished_probability)
        if bedroom_type_name == 'single':
            people_amount = 1
        elif bedroom_type_name == 'double':
            people_amount = 2
        else:
            people_amount = np.random.choice(bedrooms_people_amount, 1, p=bedrooms_people_amount_probabilities)[0]
        area = np.random.randint(bedrooms_area[0], bedrooms_area[1])
        private_bathroom = get_boolean_str(bedrooms_private_bathroom_probability)
        availability = fake.date_between(start_date="today", end_date="+30d")
        rent_price = np.random.randint(bedrooms_rent_price[0], bedrooms_rent_price[1])
        sold = get_boolean_str(bedrooms_sold_probability)
    
        output.write(f'''INSERT INTO Bedroom VALUES (default, '{bedroom_type_name}', {furnished}, {people_amount}, {area}, {private_bathroom}, DATE '{availability}', {rent_price}, {sold}, {property_id});\n\n''')

# Populate Property_Occupation (propertyid, occupationname)
output.write('\n-- POPULATE Property_Occupation\n')
n_occupations = np.random.choice(property_occupations_qt, props_quantity, p=property_occupations_probabilities)
for i, n in enumerate(n_occupations):
    occupations_names = np.random.choice(occupations, n, replace=False, p=occupations_probabilities)
    for o in occupations_names:
        output.write(f'''INSERT INTO Property_Occupation VALUES ({i+1}, '{o}');\n\n''')

# Populate Property_Occupation2 (propertyid, occupationname)
output.write('\n-- POPULATE Property_Occupation2\n')
n_occupations = np.random.choice(property_occupations2_qt, props_quantity, p=property_occupations2_probabilities)
for i, n in enumerate(n_occupations):
    occupations_names = np.random.choice(occupations, n, replace=False, p=occupations_probabilities)
    for o in occupations_names:
        output.write(f'''INSERT INTO Property_Occupation2 VALUES ({i+1}, '{o}');\n\n''')

# Populate Property_Equipment (propertyid, equipmentname)
output.write('\n-- POPULATE Property_Equipment\n')
n_equipments = np.random.choice(property_equipments_qt, props_quantity, p=property_equipments_probabilities)
for i, n in enumerate(n_equipments):
    equipments_names = np.random.choice(equipments, n, replace=False, p=equipments_probabilities)
    for o in equipments_names:
        output.write(f'''INSERT INTO Property_Equipment VALUES ({i+1}, '{o}');\n\n''')

# Populate Pet (id, type, propertyid)
output.write('\n-- POPULATE Pet\n')
for i, n in enumerate(pets_per_property):
    pets_names = np.unique(np.random.choice(pets, n, p=pets_probabilities))
    for p in pets_names:
        output.write(f'''INSERT INTO Pet VALUES (default, '{p}', {i+1});\n\n''')

# Populate Photo (id, path, bedroomid, propertyid)
output.write('\n-- POPULATE Photo\n')
for i in range(props_quantity):
    # Property
    n_images = np.random.randint(images_per_property[0], images_per_property[1])
    images = np.random.choice(list(range(1, images_quantity+1)), n_images, replace=False)
    id_property = i+1
    for image in images:
        output.write(f'''INSERT INTO Photo VALUES (default, 'image_{image}.txt', null, {id_property});\n\n''')
    # Bedrooms
    if id_property in shared_properties:
        for id_bedroom in shared_properties[id_property]:
            n_images = np.random.randint(images_per_bedroom[0], images_per_bedroom[1])
            images = np.random.choice(images_bedroom, n_images, replace=False)
            for image in images:
                output.write(f'''INSERT INTO Photo VALUES (default, 'image_{image}.txt', {id_bedroom}, null);\n\n''')

    

# images_quantity = 13
# images_bedroom = [7, 8, 9, 10]
# images_per_property = [4, 8]
# images_per_bedroom = [1, 2]

# TODO: Notification e MultipleRoom

output.close()

print('Now you just have to run:\n    $ psql -U postgres -f .\populate_db.sql')