package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PerfilDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SequenceDao sequenceDao;

    public Perfil crearPerfil(Perfil perfil) {
        perfil.setId_person(sequenceDao.getPrimayKeyForTable("persona"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO person VALUES (?,?,?,?) ");
            stmt.setInt(1, perfil.getId_person());
            stmt.setString(2, perfil.getFirst_name());
            stmt.setString(3, perfil.getLast_name());
            stmt.setString(4, perfil.getEmail());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }
        return perfil;
    }


    public Perfil findPerfilById(Integer id_owner) {

        Perfil result = new Perfil();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select a.id_owner, a.first_name, a.last_name, a.email from person a join owner o on a.id_person = o.id_person where id_owner = ?")
        ) { //TRY WITH RESOURCES
            pstmt.setInt(1, id_owner);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_owner(rs.getInt("id_owner"));
                result.setFirst_name(rs.getString("first_name"));
                result.setLast_name(rs.getString("last_name"));
                result.setEmail(rs.getString("email"));

            } else {
                result = null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Perfil findPetById(Integer id_owner) {
        Perfil result = new Perfil();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT  o.id_owner, m.name ,m.sex, m.date_of_birth, t.type_pet FROM person p JOIN owner  o ON o.id_person = p.id_person JOIN pet m ON m.id_owner = o.id_owner JOIN pet_type t ON t.id_pet = m.id_pet where id_owner = ?")
        ) { //TRY WITH RESOURCES
            pstmt.setInt(1, id_owner);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_owner(rs.getInt("id_owner"));
                result.getNamep(rs.getString("name"));
                result.getSex(rs.getString("sex"));
                result.getDate_of_birthp(rs.getDate("date_of_birth"));
                result.getType_pet(rs.getString("type_pet"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
}
