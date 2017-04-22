package com.mulesoft.training.transformers;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import com.mulesoft.training.model.Transfer;
import com.mulesoft.training.model.TransferStatus;

public class StringToTransferListTransformer extends AbstractTransformer {

   /**
    * Transforms a string/text based set of transfers into a list of POJOs
    * 
    * @param payload    The payload of the MuleMessage
    * @param enc        Encoding of the payload
    * 
    * @return a list of Transfer objects
    */
   @Override
   protected List<Transfer> doTransform(Object payload, String enc) throws TransformerException {
      String transfers[] = payload.toString().split("\\r?\\n");
      String transferFields[];
      List<Transfer> transferList = new ArrayList<Transfer>();

      for (String transfer : transfers) {
         transferFields = transfer.split(";");
         
         Transfer t = new Transfer();
         t.setAmount(Integer.parseInt((String)transferFields[0].split("=")[1]));
         t.setFromAccount(transferFields[1].split("=")[1]);
         t.setToAccount(transferFields[2].split("=")[1]);
         t.setStatus(TransferStatus.UNPROCESSED);
         
         transferList.add(t);
      }

      return transferList;
   }

}
