package com.example.libraryhtn.controller.dto.request;

import org.apache.commons.lang3.StringUtils;

public record BookFilter(
        String title,
        String creator,
        String tags,
        Boolean isRead,
        String impressions
) {

    public Boolean isEmpty() {
        return title == null
                && creator == null
                && tags == null
                && isRead == null
                && impressions == null;
    }

    public Boolean isBlank() {
        return isEmpty()
                || (StringUtils.isBlank(title)
                    && StringUtils.isBlank(creator)
                    && StringUtils.isBlank(tags)
                    && isRead == null
                    && StringUtils.isBlank(impressions));
    }

    public Boolean hasTitle() {
        return title != null && !StringUtils.isBlank(title);
    }

    public Boolean hasCreator() {
        return creator != null && !StringUtils.isBlank(creator);
    }

    public Boolean hasTags() {
        return tags != null && !StringUtils.isBlank(tags);
    }

    public Boolean hasIsRead() {
        return isRead != null;
    }

    public Boolean hasImpressions() {
        return impressions != null && !StringUtils.isBlank(impressions);
    }

}
