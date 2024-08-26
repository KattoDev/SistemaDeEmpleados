package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Assistance {

  public void updateCheckin(Connection dbConnection, User user) {
    String uploadQuery = "UPDATE users SET usr_checkinHour = ? WHERE usr_id = ?";
    LocalDateTime localtime = LocalDateTime.now();

    try (PreparedStatement pstmt = dbConnection.prepareStatement(uploadQuery)) {
      pstmt.setString(1, localtime.toString());
      pstmt.setInt(2, user.getId());

      pstmt.executeUpdate();

      System.out.println("!DEBUG Se ha actualizado la hora de entrada");
    } catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }

  public void updateCheckout(Connection dbConnection, User user) {
    String uploadQuery = "UPDATE users SET usr_checkoutHour = ? WHERE usr_id = ?";
    LocalDateTime localtime = LocalDateTime.now();

    try (PreparedStatement pstmt = dbConnection.prepareStatement(uploadQuery)) {
      pstmt.setString(1, localtime.toString());
      pstmt.setInt(2, user.getId());

      pstmt.executeUpdate();
      System.out.println("!DEBUG: Se ha actualizado la hora de salida");
    } catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }

  public void GenerateReport() {}

  public void EmployeeStatus() {}
}
