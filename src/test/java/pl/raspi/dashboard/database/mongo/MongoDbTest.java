package pl.raspi.dashboard.database.mongo;

import pl.raspi.dashboard.database.Database;
import pl.raspi.dashboard.database.DatabaseTest;
import pl.raspi.dashboard.model.LoadEntryHeader;

public class MongoDbTest extends DatabaseTest {

  @Override
  public Database getCleanDatabase() {
    return new MongoDatabase(LoadEntryHeader.class, null, true);
  }

  @Override
  public void shouldDeleteSingleInvoiceById() throws Exception {
  }
}
