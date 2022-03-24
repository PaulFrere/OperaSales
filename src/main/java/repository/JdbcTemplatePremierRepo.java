package repository;

import entity.Premier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcTemplatePremierRepo implements PremierRepo {

    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcTemplatePremierRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public List<Premier> getAll(){
        final String sql = "SELECT * FROM opera;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql);
        List<Premier> result = new ArrayList<>();
        while (sqlRowSet.next()){
            result.add(parse(sqlRowSet));
        }
        return result;
    }

    @Override
    public Premier get(String name){
        final String sql = "SELECT * FROM premieres WHERE name = ?;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, name);
        sqlRowSet.next();
        return parse(sqlRowSet);
    }

    @Override
    public boolean save(Premier premier){
        final String sql ="INSERT INTO opera ("+
                "name, " +
                "annotation, " +
                "age_category, " +
                "place, " +
                "tickets" +
                ") VALUES (?, ?, ?, ?, ?);";
        final int updateRows = jdbc.update(
                sql,
                premier.getName(),
                premier.getAnnotation(),
                premier.getAgeCategory(),
                premier.getPlace(),
                premier.getTickets()
        );
        return updateRows == 1;
    }
    private static Premier parse(SqlRowSet result){
        final String name = result.getString("name");
        final String annotation = result.getString("annotation");
        final int age_category = result.getInt("age_category");
        final int place = result.getInt("place");
        final int tickets = result.getInt("ticket");
        return new Premier(name, annotation, age_category, place, tickets);
    }
}
