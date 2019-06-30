package pl.raspi.dashboard.database.file;

import org.apache.commons.io.FileUtils;
import pl.raspi.dashboard.database.Database;
import pl.raspi.dashboard.database.DatabaseTest;
import pl.raspi.dashboard.database.ObjectMapperHelper;
import pl.raspi.dashboard.database.multifile.Configuration;
import pl.raspi.dashboard.database.multifile.FileCache;
import pl.raspi.dashboard.database.multifile.MultiFileDatabase;
import pl.raspi.dashboard.model.LoadEntryHeader;

import java.io.File;
import java.io.IOException;

public class MultiFileDatabaseTest extends DatabaseTest {

  @Override
  public Database getCleanDatabase() {
    pl.raspi.dashboard.database.multifile.Configuration config = new Configuration(LoadEntryHeader.class.getSimpleName());
    try {
      FileUtils.forceMkdir(new File(config.getJsonFilePath()));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    try {
      FileUtils.cleanDirectory(new File(config.getJsonFilePath()));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ObjectMapperHelper objectMapperHelper = new ObjectMapperHelper(LoadEntryHeader.class);
    FileCache fileCache = new FileCache(objectMapperHelper, config.getJsonFilePath());
    fileCache.getCache().clear();

    Database database = new MultiFileDatabase<LoadEntryHeader>(LoadEntryHeader.class, "\"invoiceId\"");
    return database;
  }
}