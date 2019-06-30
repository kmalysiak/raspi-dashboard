package pl.raspi.dashboard.service.filters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.raspi.dashboard.database.Database;
import pl.raspi.dashboard.model.LoadEntryHeader;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceByCompanyFilter implements EntriesFilter<LoadEntryHeader> {

  @Qualifier("filterWithCompanies")
  Database<Company> dbCompanies;

  private InvoiceByCompanyFilter(@Qualifier("companiesDatabase") Database<Company> dbCompanies) {
    this.dbCompanies = dbCompanies;
  }

  @Override
  public boolean hasField(LoadEntryHeader entry, long companyId) {
    return hasBuyerOrSeller(entry, companyId);
  }

  @Override
  public boolean hasObject(LoadEntryHeader entry, Object company) {
    return hasBuyerOrSeller(entry, (Company) company);
  }

  @Override
  public boolean hasObjectById(LoadEntryHeader entry, long companyId) {
    return hasBuyerOrSeller(entry, dbCompanies.getEntryById(companyId));
  }

  @Override
  public List<LoadEntryHeader> filterByField(List<LoadEntryHeader> entries, long companyId) {
    return entries.stream()
        .filter(line -> hasBuyerOrSeller(line, companyId))
        .collect(Collectors.toList());
  }

  private boolean hasBuyerOrSeller(LoadEntryHeader entry, long filterId) {
    return entry.getSeller().getId() == filterId
        || entry.getBuyer().getId() == filterId;
  }

  private boolean hasBuyerOrSeller(LoadEntryHeader entry, Company company) {
    return entry.getSeller().equals(company)
        || entry.getBuyer().equals(company);
  }
}
