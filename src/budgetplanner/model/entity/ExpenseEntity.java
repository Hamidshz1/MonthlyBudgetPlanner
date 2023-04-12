package budgetplanner.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class ExpenseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private int idExpense;
	
	@Column(name = "date")

	private Date date;
	
	@Column(name = "bill")

	private String bill;
	
	@Column(name = "cost")

	private double cost;

	public ExpenseEntity(int idExpense, Date date, String bill, double cost) {
		this.idExpense = idExpense;
		this.date = date;
		this.bill = bill;
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public String getBill() {
		return bill;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		String s = date.toString() + "  ,\n " + bill + " " + cost;
		return s;

	}

	public int getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(int idExpense) {
		this.idExpense = idExpense;
	}

}
