package org.perchatocka.app.manager;

import org.perchatocka.app.App;
import org.perchatocka.app.entity.MaterialEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MaterialEntityManager {
    public static List<MaterialEntity> selectAll() throws SQLException {
        try(Connection c = App.getConnecrion()) {
            String sql = "SELECT * FROM Material";

            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<MaterialEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new MaterialEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getInt("CountInPack"),
                        resultSet.getString("Unit"),
                        resultSet.getDouble("CountInStock"),
                        resultSet.getDouble("MinCount"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Image"),
                        resultSet.getString("MaterialType")
                ));
            }
            return list;
        }
    }
}
