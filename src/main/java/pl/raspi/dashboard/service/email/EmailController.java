package pl.raspi.dashboard.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import pl.raspi.dashboard.model.EmailTemplateNames;
import pl.raspi.dashboard.model.LoadEntryHeader;
import pl.raspi.dashboard.service.InvoiceService;

@Controller
public class EmailController {

  private final EmailService emailService;
  private final TemplateEngine templateEngine;
  private final InvoiceService invoiceService;

  @Autowired
  public EmailController(EmailService emailService, TemplateEngine templateEngine,
      InvoiceService invoiceService) {
    this.emailService = emailService;
    this.templateEngine = templateEngine;
    this.invoiceService = invoiceService;
  }

  @PostMapping(value = "email/{id}")
  public ResponseEntity<String> send(@PathVariable("id") Long invoiceId,
      @RequestParam(name = "email") String email) {
    LoadEntryHeader invoice = invoiceService.findEntry(invoiceId);
    EmailTemplate template = new EmailTemplate(invoice);

    String body = templateEngine.process(EmailTemplateNames.TEMPLATE, template.template());
    emailService.sendEmail(email, EmailTemplateNames.HEADER_INFO, body);
    return ResponseEntity.ok(body);
  }
}