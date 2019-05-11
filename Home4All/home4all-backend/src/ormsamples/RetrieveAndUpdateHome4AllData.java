/**
 * Licensee: afonscosta(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateHome4AllData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = PSM.Home4AllPersistentManager.instance().getSession().beginTransaction();
		try {
			PSM.Bedroom pSMBedroom = PSM.BedroomDAO.loadBedroomByQuery(null, null);
			// Update the properties of the persistent object
			PSM.BedroomDAO.save(pSMBedroom);
			PSM.Users pSMUsers = PSM.UsersDAO.loadUsersByQuery(null, null);
			// Update the properties of the persistent object
			PSM.UsersDAO.save(pSMUsers);
			PSM.Admin pSMAdmin = PSM.AdminDAO.loadAdminByQuery(null, null);
			// Update the properties of the persistent object
			PSM.AdminDAO.save(pSMAdmin);
			PSM.Notification pSMNotification = PSM.NotificationDAO.loadNotificationByQuery(null, null);
			// Update the properties of the persistent object
			PSM.NotificationDAO.save(pSMNotification);
			PSM.Property pSMProperty = PSM.PropertyDAO.loadPropertyByQuery(null, null);
			// Update the properties of the persistent object
			PSM.PropertyDAO.save(pSMProperty);
			PSM.Shared pSMShared = PSM.SharedDAO.loadSharedByQuery(null, null);
			// Update the properties of the persistent object
			PSM.SharedDAO.save(pSMShared);
			PSM.Common pSMCommon = PSM.CommonDAO.loadCommonByQuery(null, null);
			// Update the properties of the persistent object
			PSM.CommonDAO.save(pSMCommon);
			PSM.InternalAccount pSMInternalAccount = PSM.InternalAccountDAO.loadInternalAccountByQuery(null, null);
			// Update the properties of the persistent object
			PSM.InternalAccountDAO.save(pSMInternalAccount);
			PSM.Private pSMPrivate = PSM.PrivateDAO.loadPrivateByQuery(null, null);
			// Update the properties of the persistent object
			PSM.PrivateDAO.save(pSMPrivate);
			PSM.Comment pSMComment = PSM.CommentDAO.loadCommentByQuery(null, null);
			// Update the properties of the persistent object
			PSM.CommentDAO.save(pSMComment);
			PSM.PropertyType pSMPropertyType = PSM.PropertyTypeDAO.loadPropertyTypeByQuery(null, null);
			// Update the properties of the persistent object
			PSM.PropertyTypeDAO.save(pSMPropertyType);
			PSM.Gender pSMGender = PSM.GenderDAO.loadGenderByQuery(null, null);
			// Update the properties of the persistent object
			PSM.GenderDAO.save(pSMGender);
			PSM.Expenses pSMExpenses = PSM.ExpensesDAO.loadExpensesByQuery(null, null);
			// Update the properties of the persistent object
			PSM.ExpensesDAO.save(pSMExpenses);
			PSM.BedroomType pSMBedroomType = PSM.BedroomTypeDAO.loadBedroomTypeByQuery(null, null);
			// Update the properties of the persistent object
			PSM.BedroomTypeDAO.save(pSMBedroomType);
			PSM.Occupation pSMOccupation = PSM.OccupationDAO.loadOccupationByQuery(null, null);
			// Update the properties of the persistent object
			PSM.OccupationDAO.save(pSMOccupation);
			PSM.Equipment pSMEquipment = PSM.EquipmentDAO.loadEquipmentByQuery(null, null);
			// Update the properties of the persistent object
			PSM.EquipmentDAO.save(pSMEquipment);
			PSM.Villa pSMVilla = PSM.VillaDAO.loadVillaByQuery(null, null);
			// Update the properties of the persistent object
			PSM.VillaDAO.save(pSMVilla);
			PSM.Apartment pSMApartment = PSM.ApartmentDAO.loadApartmentByQuery(null, null);
			// Update the properties of the persistent object
			PSM.ApartmentDAO.save(pSMApartment);
			PSM.Ordination pSMOrdination = PSM.OrdinationDAO.loadOrdinationByQuery(null, null);
			// Update the properties of the persistent object
			PSM.OrdinationDAO.save(pSMOrdination);
			PSM.Typology pSMTypology = PSM.TypologyDAO.loadTypologyByQuery(null, null);
			// Update the properties of the persistent object
			PSM.TypologyDAO.save(pSMTypology);
			PSM.Folder pSMFolder = PSM.FolderDAO.loadFolderByQuery(null, null);
			// Update the properties of the persistent object
			PSM.FolderDAO.save(pSMFolder);
			PSM.Chat pSMChat = PSM.ChatDAO.loadChatByQuery(null, null);
			// Update the properties of the persistent object
			PSM.ChatDAO.save(pSMChat);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Bedroom by BedroomCriteria");
		PSM.BedroomCriteria pSMBedroomCriteria = new PSM.BedroomCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMBedroomCriteria.ID.eq();
		System.out.println(pSMBedroomCriteria.uniqueBedroom());
		
		System.out.println("Retrieving Users by UsersCriteria");
		PSM.UsersCriteria pSMUsersCriteria = new PSM.UsersCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMUsersCriteria.ID.eq();
		System.out.println(pSMUsersCriteria.uniqueUsers());
		
		System.out.println("Retrieving Admin by AdminCriteria");
		PSM.AdminCriteria pSMAdminCriteria = new PSM.AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMAdminCriteria.ID.eq();
		System.out.println(pSMAdminCriteria.uniqueAdmin());
		
		System.out.println("Retrieving Notification by NotificationCriteria");
		PSM.NotificationCriteria pSMNotificationCriteria = new PSM.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMNotificationCriteria.ID.eq();
		System.out.println(pSMNotificationCriteria.uniqueNotification());
		
		System.out.println("Retrieving Property by PropertyCriteria");
		PSM.PropertyCriteria pSMPropertyCriteria = new PSM.PropertyCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMPropertyCriteria.ID.eq();
		System.out.println(pSMPropertyCriteria.uniqueProperty());
		
		System.out.println("Retrieving Shared by SharedCriteria");
		PSM.SharedCriteria pSMSharedCriteria = new PSM.SharedCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMSharedCriteria.ID.eq();
		System.out.println(pSMSharedCriteria.uniqueShared());
		
		System.out.println("Retrieving Common by CommonCriteria");
		PSM.CommonCriteria pSMCommonCriteria = new PSM.CommonCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMCommonCriteria.ID.eq();
		System.out.println(pSMCommonCriteria.uniqueCommon());
		
		System.out.println("Retrieving InternalAccount by InternalAccountCriteria");
		PSM.InternalAccountCriteria pSMInternalAccountCriteria = new PSM.InternalAccountCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMInternalAccountCriteria.ID.eq();
		System.out.println(pSMInternalAccountCriteria.uniqueInternalAccount());
		
		System.out.println("Retrieving Private by PrivateCriteria");
		PSM.PrivateCriteria pSMPrivateCriteria = new PSM.PrivateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMPrivateCriteria.ID.eq();
		System.out.println(pSMPrivateCriteria.uniquePrivate());
		
		System.out.println("Retrieving Comment by CommentCriteria");
		PSM.CommentCriteria pSMCommentCriteria = new PSM.CommentCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMCommentCriteria.ID.eq();
		System.out.println(pSMCommentCriteria.uniqueComment());
		
		System.out.println("Retrieving PropertyType by PropertyTypeCriteria");
		PSM.PropertyTypeCriteria pSMPropertyTypeCriteria = new PSM.PropertyTypeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMPropertyTypeCriteria.ID.eq();
		System.out.println(pSMPropertyTypeCriteria.uniquePropertyType());
		
		System.out.println("Retrieving Gender by GenderCriteria");
		PSM.GenderCriteria pSMGenderCriteria = new PSM.GenderCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMGenderCriteria.ID.eq();
		System.out.println(pSMGenderCriteria.uniqueGender());
		
		System.out.println("Retrieving Expenses by ExpensesCriteria");
		PSM.ExpensesCriteria pSMExpensesCriteria = new PSM.ExpensesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMExpensesCriteria.ID.eq();
		System.out.println(pSMExpensesCriteria.uniqueExpenses());
		
		System.out.println("Retrieving BedroomType by BedroomTypeCriteria");
		PSM.BedroomTypeCriteria pSMBedroomTypeCriteria = new PSM.BedroomTypeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMBedroomTypeCriteria.ID.eq();
		System.out.println(pSMBedroomTypeCriteria.uniqueBedroomType());
		
		System.out.println("Retrieving Occupation by OccupationCriteria");
		PSM.OccupationCriteria pSMOccupationCriteria = new PSM.OccupationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMOccupationCriteria.ID.eq();
		System.out.println(pSMOccupationCriteria.uniqueOccupation());
		
		System.out.println("Retrieving Equipment by EquipmentCriteria");
		PSM.EquipmentCriteria pSMEquipmentCriteria = new PSM.EquipmentCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMEquipmentCriteria.ID.eq();
		System.out.println(pSMEquipmentCriteria.uniqueEquipment());
		
		System.out.println("Retrieving Villa by VillaCriteria");
		PSM.VillaCriteria pSMVillaCriteria = new PSM.VillaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMVillaCriteria.ID.eq();
		System.out.println(pSMVillaCriteria.uniqueVilla());
		
		System.out.println("Retrieving Apartment by ApartmentCriteria");
		PSM.ApartmentCriteria pSMApartmentCriteria = new PSM.ApartmentCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMApartmentCriteria.ID.eq();
		System.out.println(pSMApartmentCriteria.uniqueApartment());
		
		System.out.println("Retrieving Ordination by OrdinationCriteria");
		PSM.OrdinationCriteria pSMOrdinationCriteria = new PSM.OrdinationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMOrdinationCriteria.ID.eq();
		System.out.println(pSMOrdinationCriteria.uniqueOrdination());
		
		System.out.println("Retrieving Typology by TypologyCriteria");
		PSM.TypologyCriteria pSMTypologyCriteria = new PSM.TypologyCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMTypologyCriteria.ID.eq();
		System.out.println(pSMTypologyCriteria.uniqueTypology());
		
		System.out.println("Retrieving Folder by FolderCriteria");
		PSM.FolderCriteria pSMFolderCriteria = new PSM.FolderCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMFolderCriteria.ID.eq();
		System.out.println(pSMFolderCriteria.uniqueFolder());
		
		System.out.println("Retrieving Chat by ChatCriteria");
		PSM.ChatCriteria pSMChatCriteria = new PSM.ChatCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pSMChatCriteria.ID.eq();
		//pSMChatCriteria.common.eq();
		System.out.println(pSMChatCriteria.uniqueChat());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateHome4AllData retrieveAndUpdateHome4AllData = new RetrieveAndUpdateHome4AllData();
			try {
				retrieveAndUpdateHome4AllData.retrieveAndUpdateTestData();
				//retrieveAndUpdateHome4AllData.retrieveByCriteria();
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
