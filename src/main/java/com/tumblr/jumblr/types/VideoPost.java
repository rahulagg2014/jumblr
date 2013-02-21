package com.tumblr.jumblr.types;

import java.io.File;
import java.util.Map;

/**
 * This class represents a post of type "video"
 * @author jc
 */
public class VideoPost extends Post {

    private Video[] player;
    private String caption;
    private String embed;
    private File data;

    /**
     * Get the videos from this post
     * @return the videos
     */
    public Video[] getVideos() {
        return this.player;
    }

    /**
     * Get the caption from this post
     * @return String caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Set the embed code for this post
     * @param embed the Embed HTML for this post
     * @throws IllegalArgumentException if data is already set
     */
    public void setEmbedCode(String embed) {
        if (data != null) {
            throw new IllegalArgumentException("Cannot supply both data & embed");
        }
        this.embed = embed;
    }

    /**
     * Set the data for this post
     * @param file the file to read from
     * @throws IllegalArgumentException source is already set
     */
    public void setData(File file) {
        if (embed != null) {
            throw new IllegalArgumentException("Cannot supply both embed & data");
        }
        this.data = file;
    }

    /**
     * Set the caption for this post
     * @param caption the caption to set
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Get the details for this post (in addition to the base details)
     * @return details of this post
     */
    @Override
    public Map<String, Object> detail() {
        Map<String, Object> details = super.detail();
        details.put("caption", caption);
        details.put("embed", embed);
        details.put("data", data);
        details.put("type", "video");
        return details;
    }

}
