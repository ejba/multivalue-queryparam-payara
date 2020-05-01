package com.ejba.server;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("example")
public class ExampleResource {

  @GET
  public Response get(@QueryParam("q") List<String> queryParameters) {
    return Response.ok(queryParameters.toString()).build();
  }
}
