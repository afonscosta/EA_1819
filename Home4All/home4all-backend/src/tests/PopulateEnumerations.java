package tests;

import business.entities.*;
import data.*;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class PopulateEnumerations {
    private static void createGender(String gender) throws PersistentException {
        Gender g = GenderDAO.createGender();
        g.setName(gender);
        GenderDAO.save(g);
    }

    private static void createTypology(String typology) throws PersistentException {
        Typology t = TypologyDAO.createTypology();
        t.setName(typology);
        TypologyDAO.save(t);
    }

    private static void createExpenses(String expenses) throws PersistentException {
        Expenses e = ExpensesDAO.createExpenses();
        e.setName(expenses);
        ExpensesDAO.save(e);
    }

    private static void createEquipment(String equipment) throws PersistentException {
        Equipment e = EquipmentDAO.createEquipment();
        e.setName(equipment);
        EquipmentDAO.save(e);
    }

    private static void createBedroomType(String bedtoomType) throws PersistentException {
        BedroomType bt = BedroomTypeDAO.createBedroomType();
        bt.setName(bedtoomType);
        BedroomTypeDAO.save(bt);
    }

    private static void createOccupation(String occupation) throws PersistentException {
        Occupation o = OccupationDAO.createOccupation();
        o.setName(occupation);
        OccupationDAO.save(o);
    }

    private static void createPropertyType(String propertyType) throws PersistentException {
        PropertyType pt = PropertyTypeDAO.createPropertyType();
        pt.setName(propertyType);
        PropertyTypeDAO.save(pt);
    }

    private static void createOrdination(String ordination) throws PersistentException {
        Ordination o = OrdinationDAO.createOrdination();
        o.setName(ordination);
        OrdinationDAO.save(o);
    }

    public static void main(String[] args) {
        try {
            PersistentTransaction t = data.Home4AllPersistentManager.instance().getSession().beginTransaction();
            try {
                // GENDERS
                createGender("female");
                createGender("male");
                createGender("undefined");

                // TYPOLOGIES
                createTypology("T0");
                createTypology("T1");
                createTypology("T2");
                createTypology("T3");
                createTypology("T4");
                createTypology("T5");
                createTypology("T6");
                createTypology("T7");
                createTypology("T8");
                createTypology("T9");
                createTypology("T10");
                createTypology("T10+");

                // Expenses
                createExpenses("water");
                createExpenses("eletricity");
                createExpenses("cableTV");
                createExpenses("internet");
                createExpenses("condominium");
                createExpenses("telephone");
                createExpenses("cleaning");

                // Equipment
                createEquipment("kitchen");
                createEquipment("microwave");
                createEquipment("dishwasher");
                createEquipment("stove");
                createEquipment("fridge");
                createEquipment("washingMachine");
                createEquipment("television");
                createEquipment("cableTV");
                createEquipment("WiFi");
                createEquipment("computer");
                createEquipment("gym");
                createEquipment("pool");
                createEquipment("elevator");
                createEquipment("centralHeating");
                createEquipment("airConditioning");
                createEquipment("garage");
                createEquipment("freeParking");

                // Bedroom Type
                createBedroomType("single");
                createBedroomType("double");
                createBedroomType("multiple");

                // Occupations
                createOccupation("student");
                createOccupation("studentWorker");
                createOccupation("worker");
                createOccupation("retired");
                createOccupation("unemployed");

                // Property Type
                createPropertyType("Bedrooms");
                createPropertyType("Apartment");
                createPropertyType("Villa");

                // Ordination
                createOrdination("Price: lowest first");
                createOrdination("Price: highest first");
                createOrdination("Distance: closest first");
                createOrdination("Distance: farthest first");
                createOrdination("Publication Date: newest first");
                createOrdination("Publication Date: oldest first");
                createOrdination("Advertiser Login: newest first");
                createOrdination("Advertiser Login: oldest first");

                t.commit();
            }
            catch (Exception e) {
                t.rollback();
                e.printStackTrace();
            }
            data.Home4AllPersistentManager.instance().disposePersistentManager();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
