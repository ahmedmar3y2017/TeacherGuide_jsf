package com.app.ClientService;

import com.app.Entities.Employee;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testClient {

    public static void main(String[] args) {


        // client Test
        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target("http://localhost:9090/rest").path("employees");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        System.out.println(response.getStatus());

        System.out.println(response.readEntity(List.class));
//        System.out.println(Arrays.toString( employees.toArray(new Employee[employees.size()]) ));


    }


}
