package com.ejba.client;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@ApplicationScoped
@Path("example")
public class ExampleResource {

  static String apiUri = "http://server:8080/server";

  @GET
  public Response get(@Context UriInfo uriInfo) throws URISyntaxException {
    MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
    List<String> qValues = queryParams.get("q");

    QueryParamsClient client = RestClientBuilder.newBuilder()
        .baseUri(new URI(apiUri))
        .build(QueryParamsClient.class);

    String content = client.callService(qValues);

    return Response.ok(content).build();
  }
}
