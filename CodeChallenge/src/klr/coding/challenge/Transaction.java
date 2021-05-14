package klr.coding.challenge;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private Long id;
	private String sourceAccount;
	private String targetAccount;
	private BigDecimal amount;
	private String category;
	private Date time;

	public Transaction() {
		super();
	}
	public Transaction(Long id, String sourceAccount, String targetAccount,
			BigDecimal amount, String category, Date time) {
		super();
		this.id = id;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
		this.category = category;
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public String getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(String targetAccount) {
		this.targetAccount = targetAccount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
