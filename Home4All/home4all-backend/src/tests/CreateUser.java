package tests;

import business.entities.*;
import data.*;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import java.util.Date;

public class CreateUser {
    public static void main(String[] args) {
        try {
            PersistentTransaction t = Home4AllPersistentManager.instance().getSession().beginTransaction();
            try {
                InternalAccount u = InternalAccountDAO.createInternalAccount();
                u.setName("Nome de utilizador");
                u.setEmail("email@email.com");
                u.setPassword("password"); // TODO: hash da password
                u.setAge(20);
                u.setGender(GenderDAO.loadGenderByORMID("female"));
                u.setLastLogin(new Date());
                u.setOccupation(OccupationDAO.getOccupationByORMID("student"));
                u.setPhone("987654321");
                InternalAccountDAO.save(u);

                t.commit();
            }
            catch (Exception e) {
                t.rollback();
                e.printStackTrace();
            }
            Home4AllPersistentManager.instance().disposePersistentManager();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
