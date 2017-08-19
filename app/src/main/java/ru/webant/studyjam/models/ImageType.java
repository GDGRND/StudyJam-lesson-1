package ru.webant.studyjam.models;

public enum ImageType {
    THUMBNAIL("Standard Thumbnail"),
    THUMBNAIL_LARGE("thumbLarge"),
    FULL_IMAGE("superJumbo");

    private String imageType;

    ImageType(String imageType) {
        this.imageType = imageType;
    }

    public static ImageType fromString(String name) {
        for (ImageType imageType : values()) {
            if (name.equals(imageType.imageType)) {
                return imageType;
            }
        }
        return THUMBNAIL_LARGE;
    }

}
