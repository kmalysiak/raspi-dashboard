package pl.raspi.dashboard.service.email;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import pl.raspi.dashboard.model.LoadEntryHeader;

public class EmailTemplateTest {

  @Test
  public void shouldContainsStringContext() {
    LoadEntryHeader invoice = new InvoiceBuilder(1, "Buyer", "Seller").build();
    EmailTemplate emailTemplate = new EmailTemplate(invoice);
    String body = emailTemplate.template().toString();
    assertThat(body, containsString("context"));
  }
}