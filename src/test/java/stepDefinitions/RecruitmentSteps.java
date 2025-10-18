package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;

import java.util.Map;

public class RecruitmentSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CandidatesPage candidatesPage;
    private AddCandidatePage addCandidatePage;
    private CandidateDetailPage candidateDetailPage;

    Faker faker = new Faker();
    private String firstName;
    private String lastName;

    @Given("Navigate to the OrangeHRM demo site")
    public void navigate_to_the_orange_hrm_demo_site() {
        DriverFactory.getDriver().get(ConfigReader.get("base_url"));
    }

    @Then("Login to OrangeHRM demo as Admin \\(use the demo credentials shown on the login page)")
    public void login_to_orange_hrm_demo_as_admin_use_the_demo_credentials_shown_on_the_login_page(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMap(String.class, String.class);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage = new LoginPage();
        loginPage.loginToHrm(username, password);
    }

    @Then("Open Recruitment → Candidates")
    public void open_recruitment_candidates() {
        dashboardPage = new DashboardPage();
        dashboardPage.navigateToRecruitment();
    }

    @Then("Click Add to create a new candidate")
    public void click_add_to_create_a_new_candidate() {
        candidatesPage = new CandidatesPage();
        candidatesPage.addCandidate();
    }

    @And("Fill out the candidate form. Attach a small PDF resume if available")
    public void fill_out_the_candidate_form_attach_a_small_pdf_resume_if_available() {
        addCandidatePage = new AddCandidatePage();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String projectPath = System.getProperty("user.dir");
        addCandidatePage.fillCandidateForm(firstName, lastName, email, projectPath + "\\src\\test\\resources\\testData\\TestSample.docx");
    }

    @Then("Click Save and verify the candidate appears in the list or grid with correct values")
    public void click_save_and_verify_the_candidate_appears_in_the_list_or_grid_with_correct_values() {
        addCandidatePage.saveCandidate();
        candidatesPage.verifyAddedCandidate(firstName, lastName);
    }

    @And("Open the candidate’s details and shortlist the candidate")
    public void open_the_candidate_s_details_and_shortlist_the_candidate() {
        candidatesPage.viewCandidateDetails(firstName, lastName);
        candidateDetailPage = new CandidateDetailPage();
        candidateDetailPage.shortListCandidate();
    }

    @Then("Verify that the candidate is shortlisted")
    public void verify_that_the_candidate_is_shortlisted() {

    }

    @And("Schedule an Interview with two interviewers")
    public void schedule_an_interview_with_two_interviewers() {

    }

    @Then("Mark interview as passed & failed")
    public void mark_interview_as_passed_failed() {

    }

    @And("Search the candidates and see the result")
    public void search_the_candidates_and_see_the_result() {

    }

}
