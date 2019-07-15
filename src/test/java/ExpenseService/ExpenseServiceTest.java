package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ExpenseService.Expense.ExpenseType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project=new Project(ProjectType.INTERNAL, "Project A");
        // when
        ExpenseType expenseType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertThat(expenseType. INTERNAL_PROJECT_EXPENSE).isEqualTo(ExpenseType.INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project=new Project(ProjectType.INTERNAL, "Project A");
        // when
        ExpenseType expenseType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertThat(expenseType.EXPENSE_TYPE_A).isEqualTo(EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project=new Project(ProjectType.INTERNAL, "Project B");
        // when
        ExpenseType expenseType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertThat(expenseType.EXPENSE_TYPE_B).isEqualTo(EXPENSE_TYPE_B);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project=new Project(ProjectType.INTERNAL, "Project B");
        // when
        ExpenseType expenseType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertThat(expenseType.OTHER_EXPENSE).isEqualTo(OTHER_EXPENSE);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        Project project=new Project(ProjectType.UNEXPECTED_PROJECT_TYPE, "Project A");
        // when+then
        Assertions.assertThrows(UnexpectedProjectTypeException.class,()->ExpenseService.getExpenseCodeByProjectTypeAndName(project));


    }
}