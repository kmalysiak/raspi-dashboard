package pl.raspi.dashboard.database;

import pl.raspi.dashboard.model.LoadEntryHeader;

import java.util.List;

public interface Database{

  long addEntry(LoadEntryHeader entry);

  void deleteEntry(long id);

  LoadEntryHeader getEntryById(long id);

  void updateEntry(LoadEntryHeader entry);

  List<LoadEntryHeader> getEntries();

  boolean idExist(long id);

}
