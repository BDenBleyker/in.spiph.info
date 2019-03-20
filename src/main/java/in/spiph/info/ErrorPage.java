/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info;

import java.util.ArrayList;

/**
 *
 * @author Bennett.DenBleyker
 */
public class ErrorPage extends Page {

    int statusCode = 0;
    String details = "";

    public ErrorPage(int statusCode, String details) {
        super(new ArrayList(), "");
        this.statusCode = statusCode;
        this.details = details;
        this.html = toHtml(statusCode, details);
    }

    public ErrorPage(String details) {
        this(0, details);
    }

    public ErrorPage(int statusCode) {
        this(statusCode, "");
    }

    private static String toHtml(int statusCode, String details) {
        String bgImg = (Math.random() > 0.5 ? "https://images.pexels.com/photos/1145434/pexels-photo-1145434.jpeg"
                : "https://cdn12.picryl.com/photo/2016/12/31/construction-crane-hoisting-jib-crane-architecture-buildings-7617f8-1024.jpg");
        boolean isError = statusCode >= 400 && statusCode < 600;
        String detailsHtml = "<p>" + details + "</p>";
        String header = (isError ? (statusCode == 418 ? "I'm a teapot Code" : "Error") : "Status") + (statusCode > 0 ? " " + statusCode : "");

        return fromTemplate(header, header, bgImg, detailsHtml, "");
    }
}
