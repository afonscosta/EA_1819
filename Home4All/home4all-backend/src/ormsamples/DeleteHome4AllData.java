/**
 * Licensee: afonscosta(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteHome4AllData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = PSM.Home4AllPersistentManager.instance().getSession().beginTransaction();
		try {
			PSM.Bedroom pSMBedroom = PSM.BedroomDAO.loadBedroomByQuery(null, null);
			// Delete the persistent object
			PSM.BedroomDAO.delete(pSMBedroom);
			PSM.Users pSMUsers = PSM.UsersDAO.loadUsersByQuery(null, null);
			// Delete the persistent object
			PSM.UsersDAO.delete(pSMUsers);
			PSM.Admin pSMAdmin = PSM.AdminDAO.loadAdminByQuery(null, null);
			// Delete the persistent object
			PSM.AdminDAO.delete(pSMAdmin);
			PSM.Notification pSMNotification = PSM.NotificationDAO.loadNotificationByQuery(null, null);
			// Delete the persistent object
			PSM.NotificationDAO.delete(pSMNotification);
			PSM.Property pSMProperty = PSM.PropertyDAO.loadPropertyByQuery(null, null);
			// Delete the persistent object
			PSM.PropertyDAO.delete(pSMProperty);
			PSM.Shared pSMShared = PSM.SharedDAO.loadSharedByQuery(null, null);
			// Delete the persistent object
			PSM.SharedDAO.delete(pSMShared);
			PSM.Common pSMCommon = PSM.CommonDAO.loadCommonByQuery(null, null);
			// Delete the persistent object
			PSM.CommonDAO.delete(pSMCommon);
			PSM.InternalAccount pSMInternalAccount = PSM.InternalAccountDAO.loadInternalAccountByQuery(null, null);
			// Delete the persistent object
			PSM.InternalAccountDAO.delete(pSMInternalAccount);
			PSM.Private pSMPrivate = PSM.PrivateDAO.loadPrivateByQuery(null, null);
			// Delete the persistent object
			PSM.PrivateDAO.delete(pSMPrivate);
			PSM.Comment pSMComment = PSM.CommentDAO.loadCommentByQuery(null, null);
			// Delete the persistent object
			PSM.CommentDAO.delete(pSMComment);
			PSM.PropertyType pSMPropertyType = PSM.PropertyTypeDAO.loadPropertyTypeByQuery(null, null);
			// Delete the persistent object
			PSM.PropertyTypeDAO.delete(pSMPropertyType);
			PSM.Gender pSMGender = PSM.GenderDAO.loadGenderByQuery(null, null);
			// Delete the persistent object
			PSM.GenderDAO.delete(pSMGender);
			PSM.Expenses pSMExpenses = PSM.ExpensesDAO.loadExpensesByQuery(null, null);
			// Delete the persistent object
			PSM.ExpensesDAO.delete(pSMExpenses);
			PSM.BedroomType pSMBedroomType = PSM.BedroomTypeDAO.loadBedroomTypeByQuery(null, null);
			// Delete the persistent object
			PSM.BedroomTypeDAO.delete(pSMBedroomType);
			PSM.Occupation pSMOccupation = PSM.OccupationDAO.loadOccupationByQuery(null, null);
			// Delete the persistent object
			PSM.OccupationDAO.delete(pSMOccupation);
			PSM.Equipment pSMEquipment = PSM.EquipmentDAO.loadEquipmentByQuery(null, null);
			// Delete the persistent object
			PSM.EquipmentDAO.delete(pSMEquipment);
			PSM.Villa pSMVilla = PSM.VillaDAO.loadVillaByQuery(null, null);
			// Delete the persistent object
			PSM.VillaDAO.delete(pSMVilla);
			PSM.Apartment pSMApartment = PSM.ApartmentDAO.loadApartmentByQuery(null, null);
			// Delete the persistent object
			PSM.ApartmentDAO.delete(pSMApartment);
			PSM.Ordination pSMOrdination = PSM.OrdinationDAO.loadOrdinationByQuery(null, null);
			// Delete the persistent object
			PSM.OrdinationDAO.delete(pSMOrdination);
			PSM.Typology pSMTypology = PSM.TypologyDAO.loadTypologyByQuery(null, null);
			// Delete the persistent object
			PSM.TypologyDAO.delete(pSMTypology);
			PSM.Folder pSMFolder = PSM.FolderDAO.loadFolderByQuery(null, null);
			// Delete the persistent object
			PSM.FolderDAO.delete(pSMFolder);
			PSM.Chat pSMChat = PSM.ChatDAO.loadChatByQuery(null, null);
			// Delete the persistent object
			PSM.ChatDAO.delete(pSMChat);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteHome4AllData deleteHome4AllData = new DeleteHome4AllData();
			try {
				deleteHome4AllData.deleteTestData();
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
