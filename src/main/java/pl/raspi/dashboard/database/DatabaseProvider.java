package pl.raspi.dashboard.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.raspi.dashboard.database.sql.CompaniesSqlDb;


@Configuration
public class DatabaseProvider {

  private static final String MARIA = "maria";
  private static final String MULTIFILE = "multifile";
  private static final String MONGO = "mongo";
  private static final String MONGO_EMB = "mongo_emb";
  private static final String SQL_DB = "sql_db";

  @Value("${pl.coderstrust.database.MasterDatabase}")
  private String masterDbType;

  @Value("${pl.coderstrust.database.FilterDatabase}")
  private String filterDbType;

  @Value("${pl.coderstrust.database.MasterDatabase.key}")
  private String masterDbKey;

  @Value("${pl.coderstrust.database.FilterDatabase.key}")
  private String filterDbKey;


  @Bean
  public Database invoicesDatabase() {
    return new CompaniesSqlDb();

    }
  }

