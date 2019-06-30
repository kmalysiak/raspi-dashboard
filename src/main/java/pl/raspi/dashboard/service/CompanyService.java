package pl.raspi.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.raspi.dashboard.database.Database;

@Service
public class CompanyService extends AbstractService<Company> {

  @Autowired
  public CompanyService(@Qualifier("companiesDatabase") Database<Company> dbCompanies) {
    super.entriesDb = dbCompanies;
  }
}

