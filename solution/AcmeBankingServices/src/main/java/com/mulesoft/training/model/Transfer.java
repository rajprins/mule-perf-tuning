package com.mulesoft.training.model;

public class Transfer {

   private String id;
   private String fromAccount;
   private String toAccount;
   private Integer amount;
   private TransferStatus status;

   
   // Constructors
   public Transfer() {}

   public Transfer(String id, String fromAccount, String toAccount, Integer amount, TransferStatus status) {
      this.id = id;
      this.fromAccount = fromAccount;
      this.toAccount = toAccount;
      this.amount = amount;
      this.status = status;
   }
   
   
   // Operations
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("ID=");
      sb.append(this.id);
      sb.append(", fromAccount=");
      sb.append(this.fromAccount.toString());
      sb.append(", toAccount=");
      sb.append(this.toAccount.toString());
      sb.append(", amount=");
      sb.append(this.amount.toString());
      sb.append(", status=");
      sb.append(this.status.toString());
      
      return sb.toString();
   }


   // Getters & Setters
   public String getId() {
      return this.id;
   }
   
   public void setId(String id) {
      this.id = id;
   }
   
   public String getFromAccount() {
      return fromAccount;
   }

   public void setFromAccount(String fromAccount) {
      this.fromAccount = fromAccount;
   }

   public String getToAccount() {
      return toAccount;
   }

   public void setToAccount(String toAccount) {
      this.toAccount = toAccount;
   }

   public Integer getAmount() {
      return amount;
   }

   public void setAmount(Integer amount) {
      this.amount = amount;
   }
   
   public void setStatus(TransferStatus status) {
      this.status = status;
   }
   
   public TransferStatus getStatus() {
      return this.status;
   }

}
