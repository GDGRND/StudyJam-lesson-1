package ru.webant.studyjam.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vdaron on 12.08.17.
 */

public class Article {

    private String section;

    private String title;
    @SerializedName("abstract")
    private String description;
    private String url;
    @SerializedName("created_date")
    private Date createdDate;
    private ArrayList<Multimedia> multimedia;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Nullable
    public Multimedia getImageByType(ImageType imageType) {
        if (multimedia != null && !multimedia.isEmpty()) {
            for (Multimedia image : multimedia) {
                ImageType type = ImageType.fromString(image.getFormat());
                if (type.equals(imageType)) {
                    return image;
                }
            }
        }
        return null;
    }

}
