/**
 * Licensee: afonscosta(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListHome4AllData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Bedroom...");
		PSM.Bedroom[] pSMBedrooms = PSM.BedroomDAO.listBedroomByQuery(null, null);
		int length = Math.min(pSMBedrooms.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMBedrooms[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Users...");
		PSM.Users[] pSMUserses = PSM.UsersDAO.listUsersByQuery(null, null);
		length = Math.min(pSMUserses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMUserses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Admin...");
		PSM.Admin[] pSMAdmins = PSM.AdminDAO.listAdminByQuery(null, null);
		length = Math.min(pSMAdmins.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMAdmins[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notification...");
		PSM.Notification[] pSMNotifications = PSM.NotificationDAO.listNotificationByQuery(null, null);
		length = Math.min(pSMNotifications.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMNotifications[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Property...");
		PSM.Property[] pSMPropertys = PSM.PropertyDAO.listPropertyByQuery(null, null);
		length = Math.min(pSMPropertys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMPropertys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Shared...");
		PSM.Shared[] pSMShareds = PSM.SharedDAO.listSharedByQuery(null, null);
		length = Math.min(pSMShareds.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMShareds[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Common...");
		PSM.Common[] pSMCommons = PSM.CommonDAO.listCommonByQuery(null, null);
		length = Math.min(pSMCommons.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMCommons[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing InternalAccount...");
		PSM.InternalAccount[] pSMInternalAccounts = PSM.InternalAccountDAO.listInternalAccountByQuery(null, null);
		length = Math.min(pSMInternalAccounts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMInternalAccounts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Private...");
		PSM.Private[] pSMPrivates = PSM.PrivateDAO.listPrivateByQuery(null, null);
		length = Math.min(pSMPrivates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMPrivates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Comment...");
		PSM.Comment[] pSMComments = PSM.CommentDAO.listCommentByQuery(null, null);
		length = Math.min(pSMComments.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMComments[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PropertyType...");
		PSM.PropertyType[] pSMPropertyTypes = PSM.PropertyTypeDAO.listPropertyTypeByQuery(null, null);
		length = Math.min(pSMPropertyTypes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMPropertyTypes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Gender...");
		PSM.Gender[] pSMGenders = PSM.GenderDAO.listGenderByQuery(null, null);
		length = Math.min(pSMGenders.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMGenders[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Expenses...");
		PSM.Expenses[] pSMExpenseses = PSM.ExpensesDAO.listExpensesByQuery(null, null);
		length = Math.min(pSMExpenseses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMExpenseses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing BedroomType...");
		PSM.BedroomType[] pSMBedroomTypes = PSM.BedroomTypeDAO.listBedroomTypeByQuery(null, null);
		length = Math.min(pSMBedroomTypes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMBedroomTypes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Occupation...");
		PSM.Occupation[] pSMOccupations = PSM.OccupationDAO.listOccupationByQuery(null, null);
		length = Math.min(pSMOccupations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMOccupations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Equipment...");
		PSM.Equipment[] pSMEquipments = PSM.EquipmentDAO.listEquipmentByQuery(null, null);
		length = Math.min(pSMEquipments.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMEquipments[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Villa...");
		PSM.Villa[] pSMVillas = PSM.VillaDAO.listVillaByQuery(null, null);
		length = Math.min(pSMVillas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMVillas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Apartment...");
		PSM.Apartment[] pSMApartments = PSM.ApartmentDAO.listApartmentByQuery(null, null);
		length = Math.min(pSMApartments.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMApartments[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ordination...");
		PSM.Ordination[] pSMOrdinations = PSM.OrdinationDAO.listOrdinationByQuery(null, null);
		length = Math.min(pSMOrdinations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMOrdinations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Typology...");
		PSM.Typology[] pSMTypologys = PSM.TypologyDAO.listTypologyByQuery(null, null);
		length = Math.min(pSMTypologys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMTypologys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Folder...");
		PSM.Folder[] pSMFolders = PSM.FolderDAO.listFolderByQuery(null, null);
		length = Math.min(pSMFolders.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMFolders[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Chat...");
		PSM.Chat[] pSMChats = PSM.ChatDAO.listChatByQuery(null, null);
		length = Math.min(pSMChats.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pSMChats[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Bedroom by Criteria...");
		PSM.BedroomCriteria pSMBedroomCriteria = new PSM.BedroomCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMBedroomCriteria.ID.eq();
		pSMBedroomCriteria.setMaxResults(ROW_COUNT);
		PSM.Bedroom[] pSMBedrooms = pSMBedroomCriteria.listBedroom();
		int length =pSMBedrooms== null ? 0 : Math.min(pSMBedrooms.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMBedrooms[i]);
		}
		System.out.println(length + " Bedroom record(s) retrieved."); 
		
		System.out.println("Listing Users by Criteria...");
		PSM.UsersCriteria pSMUsersCriteria = new PSM.UsersCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMUsersCriteria.ID.eq();
		pSMUsersCriteria.setMaxResults(ROW_COUNT);
		PSM.Users[] pSMUserses = pSMUsersCriteria.listUsers();
		length =pSMUserses== null ? 0 : Math.min(pSMUserses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMUserses[i]);
		}
		System.out.println(length + " Users record(s) retrieved."); 
		
		System.out.println("Listing Admin by Criteria...");
		PSM.AdminCriteria pSMAdminCriteria = new PSM.AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMAdminCriteria.ID.eq();
		pSMAdminCriteria.setMaxResults(ROW_COUNT);
		PSM.Admin[] pSMAdmins = pSMAdminCriteria.listAdmin();
		length =pSMAdmins== null ? 0 : Math.min(pSMAdmins.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMAdmins[i]);
		}
		System.out.println(length + " Admin record(s) retrieved."); 
		
		System.out.println("Listing Notification by Criteria...");
		PSM.NotificationCriteria pSMNotificationCriteria = new PSM.NotificationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMNotificationCriteria.ID.eq();
		pSMNotificationCriteria.setMaxResults(ROW_COUNT);
		PSM.Notification[] pSMNotifications = pSMNotificationCriteria.listNotification();
		length =pSMNotifications== null ? 0 : Math.min(pSMNotifications.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMNotifications[i]);
		}
		System.out.println(length + " Notification record(s) retrieved."); 
		
		System.out.println("Listing Property by Criteria...");
		PSM.PropertyCriteria pSMPropertyCriteria = new PSM.PropertyCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMPropertyCriteria.ID.eq();
		pSMPropertyCriteria.setMaxResults(ROW_COUNT);
		PSM.Property[] pSMPropertys = pSMPropertyCriteria.listProperty();
		length =pSMPropertys== null ? 0 : Math.min(pSMPropertys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMPropertys[i]);
		}
		System.out.println(length + " Property record(s) retrieved."); 
		
		System.out.println("Listing Shared by Criteria...");
		PSM.SharedCriteria pSMSharedCriteria = new PSM.SharedCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMSharedCriteria.ID.eq();
		pSMSharedCriteria.setMaxResults(ROW_COUNT);
		PSM.Shared[] pSMShareds = pSMSharedCriteria.listShared();
		length =pSMShareds== null ? 0 : Math.min(pSMShareds.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMShareds[i]);
		}
		System.out.println(length + " Shared record(s) retrieved."); 
		
		System.out.println("Listing Common by Criteria...");
		PSM.CommonCriteria pSMCommonCriteria = new PSM.CommonCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMCommonCriteria.ID.eq();
		pSMCommonCriteria.setMaxResults(ROW_COUNT);
		PSM.Common[] pSMCommons = pSMCommonCriteria.listCommon();
		length =pSMCommons== null ? 0 : Math.min(pSMCommons.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMCommons[i]);
		}
		System.out.println(length + " Common record(s) retrieved."); 
		
		System.out.println("Listing InternalAccount by Criteria...");
		PSM.InternalAccountCriteria pSMInternalAccountCriteria = new PSM.InternalAccountCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMInternalAccountCriteria.ID.eq();
		pSMInternalAccountCriteria.setMaxResults(ROW_COUNT);
		PSM.InternalAccount[] pSMInternalAccounts = pSMInternalAccountCriteria.listInternalAccount();
		length =pSMInternalAccounts== null ? 0 : Math.min(pSMInternalAccounts.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMInternalAccounts[i]);
		}
		System.out.println(length + " InternalAccount record(s) retrieved."); 
		
		System.out.println("Listing Private by Criteria...");
		PSM.PrivateCriteria pSMPrivateCriteria = new PSM.PrivateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMPrivateCriteria.ID.eq();
		pSMPrivateCriteria.setMaxResults(ROW_COUNT);
		PSM.Private[] pSMPrivates = pSMPrivateCriteria.listPrivate();
		length =pSMPrivates== null ? 0 : Math.min(pSMPrivates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMPrivates[i]);
		}
		System.out.println(length + " Private record(s) retrieved."); 
		
		System.out.println("Listing Comment by Criteria...");
		PSM.CommentCriteria pSMCommentCriteria = new PSM.CommentCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMCommentCriteria.ID.eq();
		pSMCommentCriteria.setMaxResults(ROW_COUNT);
		PSM.Comment[] pSMComments = pSMCommentCriteria.listComment();
		length =pSMComments== null ? 0 : Math.min(pSMComments.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMComments[i]);
		}
		System.out.println(length + " Comment record(s) retrieved."); 
		
		System.out.println("Listing PropertyType by Criteria...");
		PSM.PropertyTypeCriteria pSMPropertyTypeCriteria = new PSM.PropertyTypeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMPropertyTypeCriteria.ID.eq();
		pSMPropertyTypeCriteria.setMaxResults(ROW_COUNT);
		PSM.PropertyType[] pSMPropertyTypes = pSMPropertyTypeCriteria.listPropertyType();
		length =pSMPropertyTypes== null ? 0 : Math.min(pSMPropertyTypes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMPropertyTypes[i]);
		}
		System.out.println(length + " PropertyType record(s) retrieved."); 
		
		System.out.println("Listing Gender by Criteria...");
		PSM.GenderCriteria pSMGenderCriteria = new PSM.GenderCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMGenderCriteria.ID.eq();
		pSMGenderCriteria.setMaxResults(ROW_COUNT);
		PSM.Gender[] pSMGenders = pSMGenderCriteria.listGender();
		length =pSMGenders== null ? 0 : Math.min(pSMGenders.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMGenders[i]);
		}
		System.out.println(length + " Gender record(s) retrieved."); 
		
		System.out.println("Listing Expenses by Criteria...");
		PSM.ExpensesCriteria pSMExpensesCriteria = new PSM.ExpensesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMExpensesCriteria.ID.eq();
		pSMExpensesCriteria.setMaxResults(ROW_COUNT);
		PSM.Expenses[] pSMExpenseses = pSMExpensesCriteria.listExpenses();
		length =pSMExpenseses== null ? 0 : Math.min(pSMExpenseses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMExpenseses[i]);
		}
		System.out.println(length + " Expenses record(s) retrieved."); 
		
		System.out.println("Listing BedroomType by Criteria...");
		PSM.BedroomTypeCriteria pSMBedroomTypeCriteria = new PSM.BedroomTypeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMBedroomTypeCriteria.ID.eq();
		pSMBedroomTypeCriteria.setMaxResults(ROW_COUNT);
		PSM.BedroomType[] pSMBedroomTypes = pSMBedroomTypeCriteria.listBedroomType();
		length =pSMBedroomTypes== null ? 0 : Math.min(pSMBedroomTypes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMBedroomTypes[i]);
		}
		System.out.println(length + " BedroomType record(s) retrieved."); 
		
		System.out.println("Listing Occupation by Criteria...");
		PSM.OccupationCriteria pSMOccupationCriteria = new PSM.OccupationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMOccupationCriteria.ID.eq();
		pSMOccupationCriteria.setMaxResults(ROW_COUNT);
		PSM.Occupation[] pSMOccupations = pSMOccupationCriteria.listOccupation();
		length =pSMOccupations== null ? 0 : Math.min(pSMOccupations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMOccupations[i]);
		}
		System.out.println(length + " Occupation record(s) retrieved."); 
		
		System.out.println("Listing Equipment by Criteria...");
		PSM.EquipmentCriteria pSMEquipmentCriteria = new PSM.EquipmentCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMEquipmentCriteria.ID.eq();
		pSMEquipmentCriteria.setMaxResults(ROW_COUNT);
		PSM.Equipment[] pSMEquipments = pSMEquipmentCriteria.listEquipment();
		length =pSMEquipments== null ? 0 : Math.min(pSMEquipments.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMEquipments[i]);
		}
		System.out.println(length + " Equipment record(s) retrieved."); 
		
		System.out.println("Listing Villa by Criteria...");
		PSM.VillaCriteria pSMVillaCriteria = new PSM.VillaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMVillaCriteria.ID.eq();
		pSMVillaCriteria.setMaxResults(ROW_COUNT);
		PSM.Villa[] pSMVillas = pSMVillaCriteria.listVilla();
		length =pSMVillas== null ? 0 : Math.min(pSMVillas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMVillas[i]);
		}
		System.out.println(length + " Villa record(s) retrieved."); 
		
		System.out.println("Listing Apartment by Criteria...");
		PSM.ApartmentCriteria pSMApartmentCriteria = new PSM.ApartmentCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMApartmentCriteria.ID.eq();
		pSMApartmentCriteria.setMaxResults(ROW_COUNT);
		PSM.Apartment[] pSMApartments = pSMApartmentCriteria.listApartment();
		length =pSMApartments== null ? 0 : Math.min(pSMApartments.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMApartments[i]);
		}
		System.out.println(length + " Apartment record(s) retrieved."); 
		
		System.out.println("Listing Ordination by Criteria...");
		PSM.OrdinationCriteria pSMOrdinationCriteria = new PSM.OrdinationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMOrdinationCriteria.ID.eq();
		pSMOrdinationCriteria.setMaxResults(ROW_COUNT);
		PSM.Ordination[] pSMOrdinations = pSMOrdinationCriteria.listOrdination();
		length =pSMOrdinations== null ? 0 : Math.min(pSMOrdinations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMOrdinations[i]);
		}
		System.out.println(length + " Ordination record(s) retrieved."); 
		
		System.out.println("Listing Typology by Criteria...");
		PSM.TypologyCriteria pSMTypologyCriteria = new PSM.TypologyCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMTypologyCriteria.ID.eq();
		pSMTypologyCriteria.setMaxResults(ROW_COUNT);
		PSM.Typology[] pSMTypologys = pSMTypologyCriteria.listTypology();
		length =pSMTypologys== null ? 0 : Math.min(pSMTypologys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMTypologys[i]);
		}
		System.out.println(length + " Typology record(s) retrieved."); 
		
		System.out.println("Listing Folder by Criteria...");
		PSM.FolderCriteria pSMFolderCriteria = new PSM.FolderCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMFolderCriteria.ID.eq();
		pSMFolderCriteria.setMaxResults(ROW_COUNT);
		PSM.Folder[] pSMFolders = pSMFolderCriteria.listFolder();
		length =pSMFolders== null ? 0 : Math.min(pSMFolders.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMFolders[i]);
		}
		System.out.println(length + " Folder record(s) retrieved."); 
		
		System.out.println("Listing Chat by Criteria...");
		PSM.ChatCriteria pSMChatCriteria = new PSM.ChatCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pSMChatCriteria.ID.eq();
		pSMChatCriteria.setMaxResults(ROW_COUNT);
		PSM.Chat[] pSMChats = pSMChatCriteria.listChat();
		length =pSMChats== null ? 0 : Math.min(pSMChats.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pSMChats[i]);
		}
		System.out.println(length + " Chat record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListHome4AllData listHome4AllData = new ListHome4AllData();
			try {
				listHome4AllData.listTestData();
				//listHome4AllData.listByCriteria();
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
