package budgetplanner.model.entity;
// bisogna fare i metodi che interagiscono con database come login 
import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	@ManyToOne
	@JoinColumn(name = "id_expense_manager")

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
