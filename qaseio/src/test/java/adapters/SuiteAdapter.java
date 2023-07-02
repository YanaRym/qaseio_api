package adapters;

import io.restassured.response.Response;
import models.Suite;

public class SuiteAdapter extends BaseAdapter {

    private static final String SUITE_API_ENDPOINT = "/suite/%s";
    private static final String SUITE_WITH_ID_API_ENDPOINT = "/suite/%s/%d";


    public Response create(String projectCode, Suite suite) {
        return post(String.format(SUITE_API_ENDPOINT, projectCode), converter.toJson(suite));
    }

    public Response getSpecificSuite(String projectCode, int id) {
        return get(String.format(SUITE_WITH_ID_API_ENDPOINT, projectCode, id));
    }
}
