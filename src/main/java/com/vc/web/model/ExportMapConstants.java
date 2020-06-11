package com.vc.web.model;

public interface ExportMapConstants {
    String CATEGORY = "[category]";
    String TAG = "[tag]";
    String POST_TITLE = "[postTitle]";

    String PAGE = "[page]";

    String ERROR_404 = "/404";
    String HOME_PAGE = "/";
    String INDEX_PAGE = "/index";
    String CATEGORY_PAGE = "/list/"+CATEGORY;
    String TAG_PAGE = "/list/"+CATEGORY+"/"+TAG;
    String TAG_PAGE_WITH_PAGINATION = "/list/"+CATEGORY+"/"+TAG+"/"+PAGE;
    String POST_TITLE_PAGE = "/post/"+POST_TITLE;

    String EXPORT_MAP_FORMAT = "{ page: '#PATH#' }";

    int PAGE_SIZE = 25;
}
