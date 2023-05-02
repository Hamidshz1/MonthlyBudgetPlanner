<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">

			<a class="navbar-brand" href="#"> <i
				class="fa-solid fa-comments-dollar"></i>Budget Planner
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/MonthlyBudgetPlanner/index.jsp"> <i
							class="fa-solid fa-house"></i>Home
					</a></li>

					<li class="nav-item">
						<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
							<c:if test="${not empty loginUser }">
								<li class="nav-item"><a class="nav-link active"
									href="/MonthlyBudgetPlanner/add_expense.jsp"> <i
										class="fa-solid fa-right-to-bracket"></i>Add Planner
								</a></li>

								<li class="nav-item"><a class="nav-link active"
									href="/MonthlyBudgetPlanner/view_expense.jsp" tabindex="-1"> <i
										class="fa-solid fa-user-plus"></i>View Planner
								</a></li>

								<li class="nav-item"><a class="nav-link active" href="#">
										<i class="fa-solid fa-circle-user"></i>${loginUser.username}
								</a></li>

								<li class="nav-item"><a class="nav-link active"
									href="../Logout" tabindex="-1"> <i
										class="fa-solid fa-user-plus"></i>Logout
								</a></li>
							</c:if>
							<c:if test="${empty loginUser }">
								<li class="nav-item"><a class="nav-link active"
									href="/MonthlyBudgetPlanner/login.jsp"> <i class="fa-solid fa-right-to-bracket"></i>Login
								</a></li>

								<li class="nav-item"><a class="nav-link active"
									href="/MonthlyBudgetPlanner/register.jsp" tabindex="-1"> <i
										class="fa-solid fa-user-plus"></i>Register
								</a></li>
							</c:if>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</header>

<style>
header {
	position: fixed;
	top: 0;
	width: 100%;
}
</style>
