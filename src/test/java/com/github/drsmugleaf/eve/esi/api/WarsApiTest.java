/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 0.8.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.github.drsmugleaf.eve.esi.api;

import com.github.drsmugleaf.eve.esi.ApiException;
import com.github.drsmugleaf.eve.esi.model.BadGateway;
import com.github.drsmugleaf.eve.esi.model.BadRequest;
import com.github.drsmugleaf.eve.esi.model.GetWarsWarIdKillmails200Ok;
import com.github.drsmugleaf.eve.esi.model.GetWarsWarIdKillmailsUnprocessableEntity;
import com.github.drsmugleaf.eve.esi.model.GetWarsWarIdOk;
import com.github.drsmugleaf.eve.esi.model.GetWarsWarIdUnprocessableEntity;
import com.github.drsmugleaf.eve.esi.model.InternalServerError;
import com.github.drsmugleaf.eve.esi.model.ServiceUnavailable;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WarsApi
 */
@Ignore
public class WarsApiTest {

    private final WarsApi api = new WarsApi();

    
    /**
     * List wars
     *
     * Return a list of wars  --- Alternate route: &#x60;/dev/wars/&#x60;  Alternate route: &#x60;/legacy/wars/&#x60;  Alternate route: &#x60;/v1/wars/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWarsTest() throws ApiException {
        String datasource = null;
        String ifNoneMatch = null;
        Integer maxWarId = null;
        String userAgent = null;
        String xUserAgent = null;
        List<Integer> response = api.getWars(datasource, ifNoneMatch, maxWarId, userAgent, xUserAgent);

        // TODO: test validations
    }
    
    /**
     * Get war information
     *
     * Return details about a war  --- Alternate route: &#x60;/dev/wars/{war_id}/&#x60;  Alternate route: &#x60;/legacy/wars/{war_id}/&#x60;  Alternate route: &#x60;/v1/wars/{war_id}/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWarsWarIdTest() throws ApiException {
        Integer warId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String userAgent = null;
        String xUserAgent = null;
        GetWarsWarIdOk response = api.getWarsWarId(warId, datasource, ifNoneMatch, userAgent, xUserAgent);

        // TODO: test validations
    }
    
    /**
     * List kills for a war
     *
     * Return a list of kills related to a war  --- Alternate route: &#x60;/dev/wars/{war_id}/killmails/&#x60;  Alternate route: &#x60;/legacy/wars/{war_id}/killmails/&#x60;  Alternate route: &#x60;/v1/wars/{war_id}/killmails/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWarsWarIdKillmailsTest() throws ApiException {
        Integer warId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String userAgent = null;
        String xUserAgent = null;
        List<GetWarsWarIdKillmails200Ok> response = api.getWarsWarIdKillmails(warId, datasource, ifNoneMatch, page, userAgent, xUserAgent);

        // TODO: test validations
    }
    
}
