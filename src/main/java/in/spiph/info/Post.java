/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info;

import java.time.LocalDateTime;

/**
 *
 * @author Bennett.DenBleyker
 */
public class Post {
    
    private static final String SPACE_VALUE = "%20";
    
    LocalDateTime postTime;
    String content;
    
    public Post(LocalDateTime postTime, String content) {
        this.postTime = postTime;
        this.content = content.replaceAll(" ", SPACE_VALUE);
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public String getContent() {
        return content.replaceAll(SPACE_VALUE, " ");
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public void setContent(String content) {
        this.content = content.replaceAll(" ", SPACE_VALUE);
    }

    @Override
    public String toString() {
        return "Post{" + "postTime=" + postTime + ", content=" + content + '}';
    }
    
}
