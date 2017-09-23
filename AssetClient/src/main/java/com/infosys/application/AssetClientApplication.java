package com.infosys.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan( basePackages = { "com.infosys.client", "com.infosys.application" })
@PropertySource( "classpath:asset_client.properties" )
public class AssetClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger( AssetClientApplication.class );

    public static void main( String[] args ) {
    	SpringApplication app = new SpringApplication( AssetClientApplication.class );
        app.setBannerMode( Banner.Mode.LOG );
        app.run( args );
        System.out.println( "Asset Client Application started" );
        LOGGER.info( "o;***** Asset Client Application started *****" );
    }
}