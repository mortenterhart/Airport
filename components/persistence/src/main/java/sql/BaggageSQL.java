package sql;

import base.Baggage;
import base.BaggageType;
import engine.LogEngine;
import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaggageSQL {

    Database instance;

    public BaggageSQL(Database instance) {
        this.instance = instance;
    }

    public void dropTableBaggage(LogEngine logEngine) {
        String sqlStatement = "DROP TABLE baggage IF EXISTS";
        logEngine.write("main.Database", "dropTableBaggage", "-", sqlStatement);
        instance.update(sqlStatement);
    }

    public void createTableBaggage(LogEngine logEngine) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE baggage").append(" ( ");
        sqlStringBuilder.append("uuid VARCHAR(36) NOT NULL").append(",");
        sqlStringBuilder.append("content VARCHAR(50000) NOT NULL").append(",");
        sqlStringBuilder.append("weight INT NOT NULL").append(",");
        sqlStringBuilder.append("baggage TEXT NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        logEngine.write("main.Database", "createTableBaggage", "-", sqlStringBuilder.toString());
        instance.update(sqlStringBuilder.toString());
    }


    public String buildInsertSQLStatement(Baggage baggage) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO baggage (uuid,content,weight) VALUES (");
        sqlStringBuilder.append("'").append(baggage.getUUID()).append("'").append(",");
        sqlStringBuilder.append("'").append(baggage.getContent()).append("'").append(",");
        sqlStringBuilder.append(baggage.getWeight()).append(",");
        sqlStringBuilder.append("'").append(baggage.getBaggageType()).append("'");
        sqlStringBuilder.append(")");
        return sqlStringBuilder.toString();
    }

    public void insert(Baggage baggage, LogEngine logEngine) {
        System.out.println(baggage.hashCode());
        logEngine.write("main.Database", "insert", "baggage = " + baggage.getUUID(), buildInsertSQLStatement(baggage));
        instance.update(buildInsertSQLStatement(baggage));
    }

    public String buildUpdateSQLStatement(Baggage baggage) {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE baggage SET content = '").append(baggage.getContent()).append("'").append(",");
        sqlStringBuilder.append("weight = '").append(baggage.getWeight()).append("'").append(",");
        sqlStringBuilder.append("baggage = '").append(baggage.getBaggageType()).append("'").append(",");
        sqlStringBuilder.append("WHERE uuid = '").append(baggage.getUUID()).append("'");
        return sqlStringBuilder.toString();
    }

    public ArrayList<Baggage> buildSelectSQLStatement() throws SQLException {

        ArrayList<Baggage> allbagages = new ArrayList<Baggage>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM baggage");
        Statement statement = instance.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sb.toString());
        while (rs.next()) {
            String id = rs.getString("uuid");
            String content = rs.getString("content");
            int weight = rs.getInt("weight");
            BaggageType type = BaggageType.valueOf(rs.getString("baggage"));
            allbagages.add(new Baggage(id, content, weight, type));
        }

        statement.close();

        return allbagages;

    }
}