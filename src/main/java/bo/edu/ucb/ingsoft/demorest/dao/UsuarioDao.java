package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SequenceDao sequenceDao;


    public Usuario crearUsuario (Usuario usuario){
        usuario.setId_owner(sequenceDao.getPrimayKeyForTable("owner"));
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT  INTO person value (?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,usuario.getId_owner());
            stmt.setString(2,usuario.getFirst_name());
            stmt.setString(3, usuario.getLast_name());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getUser_o());
            stmt.setString(6, usuario.getPassword_o());
            stmt.setString(7, String.valueOf(usuario.getDate_of_birth()));
            stmt.setString(8, usuario.getPhone_number());
            stmt.setString(9, usuario.getAddress());
            stmt.setString(10, usuario.getCity());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException sqex){

                }
            }
        }
        return usuario;
    }
    public Usuario findUsuariosById(Integer id_owner) {

        Usuario result = new Usuario();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select a.id_person, a.first_name, a.last_name, a.email, a.date_of_birth, a.phone_number,a.address,a.city, o.id_owner, o.user_o,o.password_o from person a join owner o on a.id_person = o.id_person where id_owner = ?")
        ){ //TRY WITH RESOURCES
            pstmt.setInt(1, id_owner);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setId_owner(rs.getInt("id_owner"));
                result.setFirst_name(rs.getString("first_name"));
                result.setLast_name(rs.getString("last_name"));
                result.setEmail(rs.getString("email"));
                result.setUser_o(rs.getString("user_o"));
                result.setPassword_o(rs.getString("password_o"));
                result.setDate_of_birth(rs.getDate("date_of_brith"));
                result.setPhone_number(rs.getString("phone_number"));
                result.setAddress(rs.getString("address"));
                result.setCity(rs.getString("city"));
            } else {
                result = null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Usuario> findAllUsuarios() {
        List<Usuario> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("select a.id_person, a.first_name, a.last_name, a.email, a.date_of_birth, a.phone_number,a.address,a.city, o.id_owner, o.user_o,o.password_o from person a join owner o on a.id_person = o.id_person where id_owner = ?");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_person(rs.getInt("id_person"));
                usuario.setFirst_name(rs.getString("first_name"));
                usuario.setLast_name(rs.getString("last_name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUser_o(rs.getString("user_o"));
                usuario.setPassword_o(rs.getString("password_o"));
                usuario.setDate_of_birth(rs.getDate("date_of_brith"));
                usuario.setPhone_number(rs.getString("phone_number"));
                usuario.setAddress(rs.getString("address"));
                usuario.setCity(rs.getString("city"));

                result.add(usuario);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return result;
    }


}
