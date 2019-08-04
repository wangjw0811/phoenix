package com.phoenix.service.impl;

import com.phoenix.service.IDemo;
import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Jims Wang
 * @date 2019-08-04 10:50
 */
@Service(protocol = {"dubbo","rest","webservice"})
@Path("demo")
public class DemoServiceImpl implements IDemo {
    @Override
    @GET
    @Path("{str}")
    public String sayHello(@PathParam("str") String str) {
        return String.format("hello %s",str);
    }
}
