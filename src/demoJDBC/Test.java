package demoJDBC;

import ma.projet.beans.Client;
import ma.projet.connexion.Connexion;
import ma.projet.service.ClientService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Connexion c=new Connexion();
		ClientService cs = new ClientService(); // Création des clients cs.create(new client("SAFI", "ali"));
//		cs.create(new Client("y1", "a1"));
//		cs.create(new Client("y2", "a2"));
//		cs.create(new Client("y3", "a3"));
//		cs.create(new Client("y4", "a4"));
		// Afficher le client dont id = 3 client
//		Client c = cs.findById(3);
//		System.out.println(c.getNom() + " " + c.getPrenom());
//		// Supprimer le client dont id = 3
//		cs.delete(cs.findById(3));
		// Modifier le client dont id = 2
//		Client cc = cs.findById(2);
//		cc.setNom("nouveau nom");
//		cc.setPrenom("nouveau Prénom");
//		cs.update(c);
		Client c = cs.findById(13);
		System.out.println(c.getNom() + " " + c.getPrenom());
		// Afficher la liste des clients
		for (Client cl : cs.findAll())
			System.out.println(cl.getNom());
		
//		// Supprimer le client dont id = 3
		cs.delete(cs.findById(13));
		
		//Connexion.closeConnection();

	}
}
