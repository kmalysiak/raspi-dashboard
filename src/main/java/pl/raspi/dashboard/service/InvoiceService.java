package pl.raspi.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.raspi.dashboard.database.Database;
import pl.raspi.dashboard.model.LoadEntryHeader;
import pl.raspi.dashboard.service.pdfservice.PdfGenerator;

@Service
public class InvoiceService extends AbstractService<LoadEntryHeader> {


  @Autowired
  public InvoiceService(@Qualifier("invoicesDatabase") Database<LoadEntryHeader> dbInvoices,
      PdfGenerator pdfGenerator) {
    super.entriesDb = dbInvoices;
    super.pdfGenerator = pdfGenerator;
  }
}
