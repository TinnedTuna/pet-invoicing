package org.turner.services;

import java.util.Date;
import org.turner.model.Invoice;
import org.turner.model.Pet;
import org.turner.model.Reminder;

/**
 *
 * @author turner
 */
public interface PdfService {
  
  public void renderInvoice(Invoice invoice);
  public void renderReminder(Reminder reminder);
  public void renderCertificate(Pet pet, Date cremationDate);
  
}
