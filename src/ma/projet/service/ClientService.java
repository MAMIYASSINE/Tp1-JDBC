package ma.projet.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ma.projet.beans.Client;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

public class ClientService implements IDao {

	Connexion c = new Connexion();

	@Override
	public boolean create(Client c1) {
		// TODO Auto-generated method stub
		String nom = c1.getNom();
		String prenom = c1.getPrenom();
		String requete = "INSERT INTO client(nom,prenom) VALUES (?, ?)";
		try {
			Connection conn = c.getConnection();
			PreparedStatement stmt = conn.prepareStatement(requete);
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			int resultats = stmt.executeUpdate();
			stmt.close();
			return resultats > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Client c1) {
		int id = c1.getId();
		String requete = "DELETE FROM client WHERE id=?";
		try {
			Connection conn = c.getConnection();
			PreparedStatement stmt = conn.prepareStatement(requete);
			stmt.setInt(1, id);
			int result = stmt.executeUpdate();
			stmt.close();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Client findById(int id) {
		Client c1 = null;
		String requete = "SELECT * FROM client WHERE id = ?";
		try {
			Connection conn = c.getConnection();
			PreparedStatement stmt = conn.prepareStatement(requete);
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					c1 = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
				}
				rs.close();
				stmt.close();
				return c1; // Returns the client if found, or null if not found
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // Consider handling or logging the exception more gracefully
		}
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		List<Client> l = new ArrayList<>();
		String requete = "SELECT * FROM client ";
		try {
			Connection conn = c.getConnection();
			PreparedStatement stmt = conn.prepareStatement(requete);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				l.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")));
			}
			rs.close();
			stmt.close();
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
