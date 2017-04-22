package com.mulesoft.training.components;

import java.util.List;

import org.apache.log4j.Logger;
import org.mule.api.annotations.param.Payload;
import org.mule.util.UUID;

import com.mulesoft.training.model.Transfer;
import com.mulesoft.training.model.TransferStatus;

public class TransferProcessingComponent {

   private final long WAITTIME = 50;
   private Logger log = Logger.getLogger(TransferProcessingComponent.class);
   
   /**
    * Component expects a payload that contains a list of Transfer objects.
    * Money transfers, represented by Transfer objects, will be processed
    * 
    * @param transfers        List of money transfers
    * @return List<Transfer>  List of processed money transfers
    * @throws Exception
    */
   public List<Transfer> processTransfers(@Payload List<Transfer> transfers) throws Exception {
      log.info("Processing " +transfers.size() +" transfers");
      for (Transfer t : transfers) {
         t = processSingleTransfer(t);
      }

      return transfers;
   }
   
   /**
    * Processed money transfer from one account to another
    * 
    * @param transfer   Money transfer
    * @return Transfer  Processed money transfer
    * @throws Exception
    */
   public Transfer processSingleTransfer(@Payload Transfer transfer) throws Exception {
      // Simulate processing time
      Thread.sleep(WAITTIME);
      transfer.setId(UUID.getUUID());
      transfer.setStatus(TransferStatus.PROCESSED);      
      
      return transfer;
   }
}
