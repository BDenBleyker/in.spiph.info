/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info;

import java.util.ArrayList;

/**
 *
 * @author bennett.denbleyker
 */
public class HomePage extends Page {
    
    public HomePage() {
        this("");
    }
    
    public HomePage(String bgImg) {
        super(new ArrayList(), "");
        this.setHtml(toHtml(bgImg));
    }
    
    public static String toHtml(String bgImgURL) {
        if (bgImgURL.equals("")) {
            bgImgURL = "https://cdn.athemes.com/wp-content/uploads/Original-JPG-Image.jpg";
        }
        return fromTemplate("Home", "Home page", bgImgURL, "<p>This is your home page. Welcome.</p>", "");
    }
    
    private static String pageLayout = "<!DOCTYPE html>\n"
            + "<html lang=\"en-US\">\n"
            + "    <head>\n"
            + "        <title>Home - Spiphi</title>\n"
            + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">\n"
            + "        <style>\n"
            + "            body {\n"
            + "                background-image: url(\"var_bgImgURL_var\");\n"
            + "                background-repeat: no-repeat;\n"
            + "                background-attachment: fixed;\n"
            + "                background-position: center center;\n"
            + "                background-size: cover;\n"
            + "                -webkit-background-size: cover;\n"
            + "                -moz-background-size: cover;\n"
            + "                -o-background-size: cover;\n"
            + "                margin-top: 0.8%;\n"
            + "                margin-left: 0.8%;\n"
            + "                margin-right: 0.8%;\n"
            + "                margin-bottom: 0.8%;\n"
            + "                padding-bottom: 1%;\n"
            + "            }\n"
            + "            h1 {\n"
            + "                background-color: #fff;\n"
            + "                text-align: center;\n"
            + "                margin-left: 10%;\n"
            + "                margin-right: 10%;\n"
            + "                margin-top: 0%;\n"
            + "                font-family: \"Times New Roman\", Times, Georgia, serif;\n"
            + "            }\n"
            + "            p {\n"
            + "                text-align: center;\n"
            + "                font-family: courier;\n"
            + "                -ms-user-select: none;\n"
            + "                -webkit-user-select: none;\n"
            + "                -moz-user-select: -moz-none;\n"
            + "            }\n"
            + "            div {\n"
            + "                padding-left: 0.5%;\n"
            + "                padding-right: 0.5%;\n"
            + "            }\n"
            + "            .menuItem {\n"
            + "               \n"
            + "            }\n"
            + "            #menu {\n"
            + "                border-right: 6px solid #FCF6C4;\n"
            + "                border-left: 6px solid #FCF6C4;\n"
            + "                border-radius: 12px;\n"
            + "                background-color: rgba(255, 255, 200, 0.2);\n"
            + "                text-align: right;\n"
            + "                margin-left: 40%;\n"
            + "                margin-right: 10%;\n"
            + "                padding-top: 0.005%;\n"
            + "                padding-right: 0.5%;\n"
            + "                font-family: \"Times New Roman\", Times, Georgia, serif;\n"
            + "            }\n"
            + "            #outsideDiv {\n"
            + "                background-color: rgba(255, 255, 255, 0.5);\n"
            + "                margin-left: 10%;\n"
            + "                margin-right: 10%;\n"
            + "            }\n"
            + "            #homeLink {\n"
            + "                color: blue;\n"
            + "                font-variant: petite-caps;\n"
            + "                font-size: 65%;\n"
            + "                text-decoration: underline overline blue;\n"
            + "            }\n"
            + "            #top {\n"
            + "                font-size: 300%;\n"
            + "                font-variant-caps: small-caps;\n"
            + "                font-weight: 600;\n"
            + "            }\n"
            + "            #biography {\n"
            + "            }\n"
            + "        </style>\n"
            + "    </head>\n"
            + "    <body>\n"
            + "        <h3 id=\"menu\">\n"
            + "            <a href=\"spiphin://home\" id=\"homeLink\" class=\"menuItem\">\n"
            + "                Home\n"
            + "            </a>\n"
            + "        </h3>\n"
            + "        <h1 id=\"top\">\n"
            + "            Home\n"
            + "        </h1>\n"
            + "        <div id=\"outsideDiv\">\n"
            + "            <div id=\"infoDiv\">\n"
            + "                 <p>This is your home page. Welcome.</p>\n"
            + "            </div>\n"
            + "            <div>\n"
            + "                \n"
            + "            </div>\n"
            + "            <br>\n"
            + "            <br>\n"
            + "            <br>\n"
            + "        </div>\n"
            + "        <h1>\n"
            + "            <a href=\"spiphin://home\" id=\"homeLink\">\n"
            + "                Home\n"
            + "            </a>\n"
            + "        </h1>\n"
            + "        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
            + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\" integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\" crossorigin=\"anonymous\"></script>\n"
            + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\" integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\" crossorigin=\"anonymous\"></script>\n"
            + "   </body>\n"
            + "</html>";
}
