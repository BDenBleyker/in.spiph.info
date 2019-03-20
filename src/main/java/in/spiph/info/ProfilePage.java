/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bennett.DenBleyker
 */
public class ProfilePage extends Page {

    public ProfilePage(String first, String last, String bgImgURL, String profileImgURL, int profileImgSize, String biography) {
        this(new ArrayList(), first, last, bgImgURL, profileImgURL, profileImgSize, biography);
    }

    public ProfilePage(List<Post> posts, String first, String last, String bgImgURL, String profileImgURL, int profileImgSize, String biography) {
        this(posts, "");
        this.setHtml(toHtml(posts, first, last, bgImgURL, profileImgURL, profileImgSize, biography));
    }

    private ProfilePage(List<Post> posts, String html) {
        super(posts, html);
    }

    public static String toHtml(List<Post> posts, String first, String last, String bgImgURL, String profileImgURL, int profileImgSize, String biography) {
        if (bgImgURL.equals("")) {
            bgImgURL = "https://cdn.athemes.com/wp-content/uploads/Original-JPG-Image.jpg";
        }
        if (profileImgURL.equals("")) {
            profileImgURL = "https://eform.etixdubai.com/App_Themes/DefaultNew/images/profile.png";
        }

        String profileImg = "style=\"float:left; margin-bottom:1%; margin-right:0.8%;";
        if (profileImgSize >= 0) {
            profileImg += "height:" + profileImgSize + "px;";
        }
        profileImg += "\" src=\"" + profileImgURL + "\" alt=\"Profile Picture\"";
        
        String postStr = getPostString(posts);

        String result = pageLayout.replace("var_first_var", first);
        result = result.replace("var_last_var", last);
        result = result.replace("var_bgImgURL_var", bgImgURL);
        result = result.replace("var_profileImg_var", profileImg);
        result = result.replace("var_biography_var", biography);
        result = result.replace("var_posts_var", postStr);
        return result;
    }

    private static String getPostString(List<Post> posts) {
        String result = "<p>";
        result = posts.stream().map((post) -> "__" + parseTime(post.getPostTime()) + "__<br>" + post.getContent().toString() + "<br>").reduce(result, String::concat);
        result += "</p>";
        return result;
    }
    
    private static String parseTime(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        int years = now.getYear() - time.getYear();
        int months = now.getMonthValue() - time.getMonthValue();
        int days = now.getDayOfMonth() - time.getDayOfMonth();
        int hours = now.getHour() - time.getHour();
        int minutes = now.getMinute() - time.getMinute();
        
        if (years == 1 && months < 4) {     // 1yr      <   x   <       1.333yr
            return "1 year ago";
        } else if (years >= 1) {            // 1 1/3yr  <=  x
            return time.getMonth().toString() + " " + time.getDayOfMonth() + ", " + time.getYear();
        } else if (months == 1) {           //              x   =       1mo
            return "1 month ago";
        } else if (months > 1) {            // 1mo      <   x   <       1yr
            return months + " months ago";
        } else if (days == 1) {             //              x   =       1d
            return "Yesterday";
        } else if (days > 1) {              // 1d       <   x   <       1mo
            return days + " days ago";
        } else if (hours == 1) {            //              x   =       1hr
            return "1 hour ago";
        } else if (hours > 1) {             // 1hr      <   x   <       1d
            return hours + " hours ago";
        } else if (minutes >= 3) {          // 3min     <=  x   <       1hr
            return minutes + " minutes ago";
        } else if (minutes >= 1) {          // 1min     <=  x   <       3min
            return "Just barely";
        } else {                            //              x   <       1min
            return "Now";
        }
    }
    
    private static String pageLayout = "<!DOCTYPE html>\n"
            + "<html lang=\"en-US\">\n"
            + "    <head>\n"
            + "        <title>var_first_var var_last_var - Spiphi</title>\n"
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
            + "            var_first_var var_last_var\n"
            + "        </h1>\n"
            + "        <div id=\"outsideDiv\">\n"
            + "            <div id=\"infoDiv\">\n"
            + "                <img\n"
            + "                    var_profileImg_var\n"
            + "                >\n"
            + "                <div id=\"biography\">\n"
            + "                    var_biography_var\n"
            + "                </div>\n"
            + "            </div>\n"
            + "            <div>\n"
            + "                var_posts_var\n"
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

    public static ProfilePage testPage = new ProfilePage("Gabe", "FaxMield", "https://cdn.pixabay.com/photo/2018/01/24/18/05/background-3104413_960_720.jpg", "https://www.telegraph.co.uk/content/dam/men/2016/05/24/Untitled-1_trans_NvBQzQNjv4BqqVzuuqpFlyLIwiB6NTmJwfSVWeZ_vEN7c6bHu2jJnT8.jpg?imwidth=450", 100, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. At volutpat diam ut venenatis tellus in. Pretium vulputate sapien nec sagittis aliquam malesuada. A iaculis at erat pellentesque adipiscing commodo elit. At risus viverra adipiscing at in tellus integer. Augue interdum velit euismod in pellentesque massa placerat. Nisl condimentum id venenatis a condimentum vitae. Egestas maecenas pharetra convallis posuere morbi leo. Dapibus ultrices in iaculis nunc. Egestas integer eget aliquet nibh.<br><br>\n\n\n\n"
            + "Malesuada fames ac turpis egestas integer eget aliquet nibh. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Sed blandit libero volutpat sed. Sem viverra aliquet eget sit amet tellus cras adipiscing enim. Urna nunc id cursus metus aliquam eleifend. Porttitor rhoncus dolor purus non enim praesent elementum. Mauris a diam maecenas sed enim ut sem viverra aliquet. Sed felis eget velit aliquet sagittis id. In fermentum posuere urna nec. Etiam non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Quis ipsum suspendisse ultrices gravida dictum. Massa placerat duis ultricies lacus sed turpis. Ac feugiat sed lectus vestibulum mattis ullamcorper. Id porta nibh venenatis cras sed felis. Sodales neque sodales ut etiam sit amet. Purus semper eget duis at tellus at urna. Curabitur vitae nunc sed velit.<br><br>\n\n\n\n"
            + "Vitae nunc sed velit dignissim sodales. Tincidunt id aliquet risus feugiat. Velit euismod in pellentesque massa placerat duis ultricies lacus sed. Viverra adipiscing at in tellus. Donec adipiscing tristique risus nec feugiat. Tempor nec feugiat nisl pretium fusce id velit. Bibendum ut tristique et egestas. Leo integer malesuada nunc vel risus. Mattis vulputate enim nulla aliquet. Mauris pharetra et ultrices neque ornare aenean euismod elementum. Rhoncus dolor purus non enim praesent elementum facilisis leo vel. Magna ac placerat vestibulum lectus mauris ultrices eros in. Convallis convallis tellus id interdum velit laoreet id donec.<br><br>\n\n\n\n"
            + "Molestie ac feugiat sed lectus vestibulum mattis. Enim nec dui nunc mattis enim. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Nibh sit amet commodo nulla facilisi nullam vehicula. Eu mi bibendum neque egestas congue quisque. Massa tincidunt nunc pulvinar sapien. Ultrices tincidunt arcu non sodales neque sodales. Faucibus scelerisque eleifend donec pretium vulputate sapien. Pellentesque eu tincidunt tortor aliquam. A diam sollicitudin tempor id eu nisl nunc mi ipsum. Tincidunt praesent semper feugiat nibh sed pulvinar proin. Ultrices vitae auctor eu augue ut lectus arcu. Quis eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis. Cursus turpis massa tincidunt dui ut ornare lectus sit amet.<br><br>\n\n\n\n"
            + "Tempus egestas sed sed risus pretium quam. In eu mi bibendum neque egestas congue. Sit amet cursus sit amet dictum sit amet justo donec. Pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper. Enim ut sem viverra aliquet eget. Dictum sit amet justo donec. Sed nisi lacus sed viverra tellus in. Eget magna fermentum iaculis eu non. Sollicitudin aliquam ultrices sagittis orci a scelerisque. Sem viverra aliquet eget sit amet tellus cras adipiscing. Ullamcorper malesuada proin libero nunc consequat interdum varius sit. Quam adipiscing vitae proin sagittis nisl rhoncus mattis. Praesent elementum facilisis leo vel fringilla est ullamcorper eget nulla. Platea dictumst quisque sagittis purus sit amet volutpat consequat mauris. Nunc congue nisi vitae suscipit. Et tortor consequat id porta.");

}
