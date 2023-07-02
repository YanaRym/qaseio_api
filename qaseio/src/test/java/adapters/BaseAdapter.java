package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.StringConstants.*;

public class BaseAdapter {

    private static final String TOKEN_VALUE = "60d955b2d6eaf51b8a456fd557b8a289a4c1e4ddf08dba81b79204a267f93f1a";
    private static final String BASE_URL = "https://api.qase.io/v1/";

    protected Gson converter = new Gson();

    protected Response get(String url) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .when()
                        .get(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }


    protected Response post(String url, String body) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    protected Response delete(String url) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .when()
                        .delete(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }
}
