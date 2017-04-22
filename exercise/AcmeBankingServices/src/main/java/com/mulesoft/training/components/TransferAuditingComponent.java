package com.mulesoft.training.components;

import java.util.List;

import org.apache.log4j.Logger;
import org.mule.api.annotations.param.Payload;

import com.mulesoft.training.model.Transfer;
import com.mulesoft.training.model.TransferStatus;

public class TransferAuditingComponent {

   private final long WAITTIME = 1000;
   private Logger log = Logger.getLogger(TransferAuditingComponent.class);
   
   /**
    * Processed a collection of transfers by selecting the transfer with higest
    * amount and auditing the selected money transfer.
    * 
    * @param transfers
    * @return
    * @throws Exception
    */
   public Transfer auditTransferList(@Payload List<Transfer> transfers) throws Exception {
      log.info("Selecting transfer with highest amount for auditing");
      Integer highestAmount = new Integer(0);
      Transfer selectedTransfer = new Transfer();

      for (Transfer t : transfers) {
         if (t.getAmount().compareTo(highestAmount) > 0) {
            highestAmount = t.getAmount();
            selectedTransfer = t;
         }
      }
      
      return auditTransfer(selectedTransfer);
   }
   
   public Transfer auditTransfer(Transfer transfer) throws Exception {
      log.info("Auditing transfer with ID " +transfer.getId());
      
      // simulate processing time
      Thread.sleep(WAITTIME);
      transfer.setStatus(TransferStatus.AUDITED);
      
      return transfer;
   }

}
