package budgetplanner.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import budgetplanner.model.ExpenseManager;
import budgetplanner.model.Months;

@Entity
@Table(name = "monthlyexpensemanager")
public class MonthlyExpenseManagerEntity extends ExpenseManager {
	@Enumerated(value = EnumType.STRING)
	@Column(name = "month")
	Months mese;

//	public MonthlyExpenseManagerEntity(int idExpenseManager,double budget, Months month) {
//		super(idExpenseManager, budget);
//		this.mese = month;
//		
//	}
//	public MonthlyExpenseManagerEntity(int idExpenseManager, double budget) {
//		super(idExpenseManager,budget);
//	}
//
//	public Months getMese() {
//		return mese;
//	}
//
//	public void setMese(Months mese) {
//		this.mese = mese;
//	}
//	

}
