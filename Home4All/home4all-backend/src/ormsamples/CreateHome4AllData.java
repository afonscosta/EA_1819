/**
 * Licensee: afonscosta(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateHome4AllData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = PSM.Home4AllPersistentManager.instance().getSession().beginTransaction();
		try {
			PSM.Bedroom pSMBedroom = PSM.BedroomDAO.createBedroom();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : type
			PSM.BedroomDAO.save(pSMBedroom);
			PSM.Users pSMUsers = PSM.UsersDAO.createUsers();
			// Initialize the properties of the persistent object here
			PSM.UsersDAO.save(pSMUsers);
			PSM.Admin pSMAdmin = PSM.AdminDAO.createAdmin();
			// Initialize the properties of the persistent object here
			PSM.AdminDAO.save(pSMAdmin);
			PSM.Notification pSMNotification = PSM.NotificationDAO.createNotification();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : types, allowedOccupations, typologies, newProperties, ordination
			PSM.NotificationDAO.save(pSMNotification);
			PSM.Property pSMProperty = PSM.PropertyDAO.createProperty();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : equipmentIncluded, allowedOccupations, allowedGenders, incomeIncluded, comments, typology, owner
			PSM.PropertyDAO.save(pSMProperty);
			PSM.Shared pSMShared = PSM.SharedDAO.createShared();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : occupations, bedrooms
			PSM.SharedDAO.save(pSMShared);
			PSM.Common pSMCommon = PSM.CommonDAO.createCommon();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : favorites, chats, notifications, properties
			PSM.CommonDAO.save(pSMCommon);
			PSM.InternalAccount pSMInternalAccount = PSM.InternalAccountDAO.createInternalAccount();
			// Initialize the properties of the persistent object here
			PSM.InternalAccountDAO.save(pSMInternalAccount);
			PSM.Private pSMPrivate = PSM.PrivateDAO.createPrivate();
			// Initialize the properties of the persistent object here
			PSM.PrivateDAO.save(pSMPrivate);
			PSM.Comment pSMComment = PSM.CommentDAO.createComment();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : writer
			PSM.CommentDAO.save(pSMComment);
			PSM.PropertyType pSMPropertyType = PSM.PropertyTypeDAO.createPropertyType();
			// Initialize the properties of the persistent object here
			PSM.PropertyTypeDAO.save(pSMPropertyType);
			PSM.Gender pSMGender = PSM.GenderDAO.createGender();
			// Initialize the properties of the persistent object here
			PSM.GenderDAO.save(pSMGender);
			PSM.Expenses pSMExpenses = PSM.ExpensesDAO.createExpenses();
			// Initialize the properties of the persistent object here
			PSM.ExpensesDAO.save(pSMExpenses);
			PSM.BedroomType pSMBedroomType = PSM.BedroomTypeDAO.createBedroomType();
			// Initialize the properties of the persistent object here
			PSM.BedroomTypeDAO.save(pSMBedroomType);
			PSM.Occupation pSMOccupation = PSM.OccupationDAO.createOccupation();
			// Initialize the properties of the persistent object here
			PSM.OccupationDAO.save(pSMOccupation);
			PSM.Equipment pSMEquipment = PSM.EquipmentDAO.createEquipment();
			// Initialize the properties of the persistent object here
			PSM.EquipmentDAO.save(pSMEquipment);
			PSM.Villa pSMVilla = PSM.VillaDAO.createVilla();
			// Initialize the properties of the persistent object here
			PSM.VillaDAO.save(pSMVilla);
			PSM.Apartment pSMApartment = PSM.ApartmentDAO.createApartment();
			// Initialize the properties of the persistent object here
			PSM.ApartmentDAO.save(pSMApartment);
			PSM.Ordination pSMOrdination = PSM.OrdinationDAO.createOrdination();
			// Initialize the properties of the persistent object here
			PSM.OrdinationDAO.save(pSMOrdination);
			PSM.Typology pSMTypology = PSM.TypologyDAO.createTypology();
			// Initialize the properties of the persistent object here
			PSM.TypologyDAO.save(pSMTypology);
			PSM.Folder pSMFolder = PSM.FolderDAO.createFolder();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : properties
			PSM.FolderDAO.save(pSMFolder);
			PSM.Chat pSMChat = PSM.ChatDAO.createChat();
			// Initialize the properties of the persistent object here
			PSM.ChatDAO.save(pSMChat);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateHome4AllData createHome4AllData = new CreateHome4AllData();
			try {
				createHome4AllData.createTestData();
			}
			finally {
				PSM.Home4AllPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
