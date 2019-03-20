/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bennett.DenBleyker
 */
public class Page {

    protected static final String TEMPLATE;

    static {
        String template = "";
        try (Scanner stdIn = new Scanner(new FileInputStream(new File("src/main/resources/HtmlTemplate.html")))) {
            while (stdIn.hasNextLine()) {
                template += stdIn.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, "HTML template does not exist", ex);
        }
        TEMPLATE = template;
    }

    List<Post> posts;
    String html;

    public Page(List<Post> posts, String html) {
        if (posts.toString().startsWith("[{postTime")) {
            System.out.println(posts.toString());
            this.posts = Arrays.asList(new Gson().fromJson(posts.toString(), Post[].class));
        } else {
            this.posts = posts;
        }
        this.html = html;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public static Page valueOf(LinkedTreeMap ltm) {
        //System.err.println(ltm.keySet().toString());
        List<Post> posts = new ArrayList();
        posts.addAll((ArrayList<Post>) ltm.get("posts"));
        return new Page(posts, ltm.get("html").toString());
    }

    public static String fromTemplate(String title, String header, String bgImg, String info, String otherInfo) {
        return TEMPLATE
                .replace("var_title_var", title)
                .replace("var_header_var", header)
                .replace("var_bg_img_var", bgImg)
                .replace("var_info_var", info)
                .replace("var_other_info_var", otherInfo);
    }
}
