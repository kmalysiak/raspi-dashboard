package pl.raspi.dashboard.database.memory;

import pl.raspi.dashboard.database.Database;
import pl.raspi.dashboard.database.DatabaseTest;
import pl.raspi.dashboard.model.LoadEntryHeader;

public class InMemoryDatabaseTest extends DatabaseTest {

  @Override
  public Database getCleanDatabase() {
    return new InMemoryDatabase(LoadEntryHeader.class);
  }
}