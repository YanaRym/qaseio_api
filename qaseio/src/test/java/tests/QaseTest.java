package tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import models.Case;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.net.HttpURLConnection.HTTP_OK;

public class QaseTest {

    @Test
    public void getProjectTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .title("AQA20")
                .code("AQA202")
                .build();
        String codeOfProject = new ProjectAdapter().createProject(project).body().path("result.code");
        Assert.assertTrue(codeOfProject.equalsIgnoreCase(project.getCode()));
    }

    @Test
    public void createSuiteTest() {
        String projectCode = "AQA20";
        Suite suite = Suite.builder()
                .title("Smoke")
                .description("This is the smoke test")
                .build();
        int resultId = new SuiteAdapter().create(projectCode, suite).body().path("result.id");
        Assert.assertTrue(resultId != 0);
    }

    @Test
    public void getSpecificSuiteTest(){
        String projectCode = "AQA20";
        int id = 3;
        int statusCode = new SuiteAdapter().getSpecificSuite(projectCode, id).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void createCaseTest() {
        String projectCode = "AQA20";
        Case newCase = Case.builder()
                .title("Test case")
                .code(projectCode)
                .description("This is a test")
                .build();
        int resultCode = new CaseAdapter().createCase(projectCode, newCase).statusCode();
        Assert.assertEquals(resultCode, HTTP_OK);
    }


    @Test
    public void getCaseTest() {
        int statusCode = new CaseAdapter().getCase("AQA20").statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    void deleteCaseTest() {
        int statusCode = new CaseAdapter().deleteCase("AQA20", 4).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
