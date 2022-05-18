package fr.diginamic.banque;

import fr.diginamic.banque.dao.impl.BanqueDao;
import fr.diginamic.banque.dao.impl.ClientDao;
import fr.diginamic.banque.dao.impl.CompteDao;
import fr.diginamic.banque.dao.impl.OperationDao;
import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.Client;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;
import fr.diginamic.banque.dao.impl.FactoryDao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBanque {

    public static FactoryDao BANQUE;

    public static void main(String[] args) {
        try {
            TestBanque.BANQUE = new FactoryDao("banque");
            BanqueDao banqueDao = new BanqueDao(TestBanque.BANQUE);
            CompteDao compteDao = new CompteDao(TestBanque.BANQUE);
            ClientDao clientDao = new ClientDao(TestBanque.BANQUE);
            OperationDao operationDao = new OperationDao(TestBanque.BANQUE);

            Banque ca = new Banque();
            ca.setNom("Crédit Agricole");
            banqueDao.add(ca);

            Banque cm = new Banque();
            cm.setNom("Crédit mutuelle");
            banqueDao.add(cm);

            Adresse adresse = new Adresse(8, "Impasse de la Souye", 56000, "Vannes");
            Client client = new Client("John","Doe", LocalDate.of(2015, 1, 28));
            client.setAdresse(adresse);
            client.setBanque(ca);

            clientDao.add(client);

            Adresse adresse2 = new Adresse(8, "Square des Rochelets", 44100, "Nantes");
            Client client2 = new Client("Antoine","Clain",LocalDate.of(2004, 6, 24));
            client2.setAdresse(adresse2);
            client2.setBanque(cm);

            clientDao.add(client2);

            Compte compte = new Compte("AEF1201",8796.00);
            compteDao.add(compte);

            Compte compte2 = new Compte("ABP400",7852.00);
            compteDao.add(compte2);

            client.getComptes().add(compte);
            compteDao.update(compte);

            client2.getComptes().add(compte);
            client2.getComptes().add(compte2);
            clientDao.update(client2);


            Compte assurance = new AssuranceVie("2564897C", 3000, LocalDate.of(2010,03,28), 1.0);
            compteDao.add(assurance);

            Compte livret = new LivretA("156486D", 1200.67, 2.0);
            compteDao.add(livret);

            client2.getComptes().add(livret);
            clientDao.update(client2);

            Operation operation = new Virement(LocalDateTime.now(), 1000.0, "Salaire mars", "Antoine");
            operation.setCompte(livret);
            operationDao.add(operation);

            Operation operation2 = new Virement(LocalDateTime.now(), 3000.0, "Salaire mars", "Nathan");
            operation2.setCompte(assurance);
            operationDao.add(operation2);

            Operation operation3 = new Operation(LocalDateTime.now(), 157, "opération");

            operation3.setCompte(compte2);
            operationDao.add(operation3);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
