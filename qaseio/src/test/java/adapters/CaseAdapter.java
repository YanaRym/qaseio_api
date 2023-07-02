package adapters;

import io.restassured.response.Response;
import models.Case;


public class CaseAdapter extends BaseAdapter {
    private static final String CASE_ENDPOINT = "/case/%s";
    private static final String CASE_WITH_ID_ENDPOINT = "/case/%s/%d";

    public Response createCase(String projectCode, Case newCase) {
    return post(String.format(CASE_ENDPOINT, projectCode), converter.toJson(newCase));
    }

    public Response getCase(String projectCode){
        return get(String.format(CASE_ENDPOINT, projectCode));
    }

    public Response deleteCase(String projectCode, int id){
        return delete(String.format(CASE_WITH_ID_ENDPOINT, projectCode, id));
    }

}
