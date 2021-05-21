package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaDao {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Persona crearPersona (Persona persona) {
        persona.setId_person(sequenceDao.getPrimayKeyForTable("person"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, persona.getId_person());
            stmt.setString(2, persona.getFirst_name());
            stmt.setString(3, persona.getLast_name());
            stmt.setString(4, persona.getEmail());
            stmt.setString(5, String.valueOf(persona.getDate_of_birth()));
            stmt.setString(6, persona.getPhone_number());
            stmt.setString(7, persona.getAddress());
            stmt.setString(8, persona.getCity());
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
        return persona;
    }

    public Persona findPersonaById(Integer id_person) {

        Persona result = new Persona();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select id_person, first_name, last_name, email, date_of_birth, phone_number,address,city  from person " +
                    "where id_person = ?")
        ){ //TRY WITH RESOURCES
            pstmt.setInt(1, id_person);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_person(rs.getInt("id_person"));
                result.setFirst_name(rs.getString("first_name"));
                result.setLast_name(rs.getString("last_name"));
                result.setEmail(rs.getString("email"));
                result.setDate_of_birth(rs.getDate("date_of_brith"));
                result.setPhone_number(rs.getString("phone_number"));
                result.setAddress(rs.getString("address"));
                result.setCity(rs.getString("city"));
            } else { // si no hay valores de BBDD
                result = null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Persona> findAllPersonas() {
        List<Persona> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT persona_id, nombre, apellido FROM persona");
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId_person(rs.getInt("id_person"));
                persona.setFirst_name(rs.getString("first_name"));
                persona.setLast_name(rs.getString("last_name"));
                persona.setEmail(rs.getString("email"));
                persona.setDate_of_birth(rs.getDate("date_of_brith"));
                persona.setPhone_number(rs.getString("phone_number"));
                persona.setAddress(rs.getString("address"));
                persona.setCity(rs.getString("city"));

                result.add(persona);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
