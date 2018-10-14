package ru.ql.tt.Base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class CssLocators {
    //------------Authorization------------//


    public static SelenideElement LOGIN = $("#username");
    public static SelenideElement PASSWORD = $("#password");
    public static SelenideElement SUBMIT = $("#_submit");
    public static SelenideElement AVATARCOVER = $("a .avatarCover");
    public static SelenideElement AVATAR_NAME = $(".m-card-user__details span:first-child");
    public static SelenideElement LINK_PROFILE = $(".m-nav__link-wrap span");


    //------------ProfilePage--------------//

    public static SelenideElement AVATAR = $("img.avatar");
    public static SelenideElement BUTTON_CREATE_RESUME = $(".m-portlet__head-title div a");
    public static SelenideElement FIRST_AND_LAST_NAME = $(".m-portlet__head-title span");
    public static SelenideElement TITLE_PROFILE = $(".m-subheader__title");
    public static SelenideElement BLOCK_RESUME = $(".m-portlet:nth-child(2)");
    public static SelenideElement BLOCK_RESUME_TITLE = $(".m-portlet:nth-child(2) .m-portlet__head-text");
    public static SelenideElement BLOCK_RESUME_BUTTON = $(".m-portlet:nth-child(2) button");
    public static SelenideElement BLOCK_RESUME_FAVICON_PLACE = $(".flaticon-user-ok");
    public static SelenideElement BLOCK_RESUME_TEXT_PLACE = $(".m-list-search__result-item-text.post-name");
    public static SelenideElement BLOCK_RESUME_FAVICON_SHORT = $(".flaticon-file-1");
    public static SelenideElement BLOCK_RESUME_TEXT_SHORT = $(".m-list-search__result-item-text.post-description");

    public static SelenideElement PROFILE_RESUME_FIELD_PLACE = $(".m-portlet__body .post-name");
    public static SelenideElement SCHEDULE_WORK_BLOCK = $(".m-portlet:nth-child(3)");
    public static SelenideElement SCHEDULE_WORK_BLOCK_TITLE = $(".m-portlet:nth-child(3) .m-portlet__head-text");
    public static SelenideElement SCHEDULE_WORK_BUTTON_EDIT = $(".m-portlet:nth-child(3) button");
    public static SelenideElement SCHEDULE_WORK_TABLE = $(".m-portlet:nth-child(3) .m-portlet__body");
    public static SelenideElement PROFILE_TABLE_TIME_MONDAY = $(".schedule-monday p");
    public static SelenideElement CONTACTS_BLOCK = $(".m-portlet:nth-child(4)");
    public static SelenideElement CONTACTS_BLOCK_TITLE= $(".m-portlet:nth-child(4) .m-portlet__head-text");
    public static SelenideElement CONTACTS_BLOCK_BUTTON_EDIT= $(".m-portlet:nth-child(4) button");
    public static ElementsCollection CONTACTS_BLOCK_ICONS = $$(".m-portlet:nth-child(4) .inactive-default-icon");
    public static ElementsCollection CONTACTS_BLOCK_TEXT = $$(".m-portlet:nth-child(4) .m-list-search__result-item-text");
    public static SelenideElement PROFILE_CONTACTS_FIELD_PHONE = $(".m-list-search .phone");
    public static SelenideElement PROFILE_CONTACTS_FIELD_SKYPE = $(".m-portlet__body .skype");

    public static SelenideElement BLOCK_DEVICES = $(".m-portlet:nth-child(5)");
    public static SelenideElement BLOCK_DEVICES_BUTTON_ADD = $(".m-portlet:nth-child(5) button");
    public static SelenideElement BLOCK_DEVICES_TITLE = $(".m-portlet:nth-child(5) h3");
    public static ElementsCollection BLOCK_DEVICES_TABLE = $$(".m-portlet:nth-child(5) #environment-container");
    public static SelenideElement POPUP_WINDOWS = $x("//div[contains(@class, 'toast-message')]");


    //------------Window create resume------//

    public static SelenideElement WINDOW_RESUME_FIRST_NAME = $(".user-name p:first-child");
    public static SelenideElement WINDOW_RESUME_LAST_NAME = $(".user-name p:last-child");
    public static SelenideElement WINDOW_RESUME_PLACE = $(".user-position-name p");


    //------------Resume--------------------//

    public static SelenideElement MODAL_WINDOW_EDIT_RESUME = $("#popup-edit-resume .modal-content");
    public static SelenideElement MODAL_WINDOW_EDIT_RESUME_TITLE = $("#popup-edit-resume .modal-title");
    public static SelenideElement MODAL_WINDOW_EDIT_TEXTAREA = $("#popup-edit-resume textarea");
    public static SelenideElement MODAL_WINDOW_EDIT_BUTTON_SAVE = $("#popup-edit-resume .update-post-info");
    public static SelenideElement MODAL_WINDOW_EDIT_TIP_TEXTAREA = $("#popup-edit-resume p");
    public static SelenideElement MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-resume .btn-secondary");
    public static SelenideElement MODAL_RESUME_EDIT_ICON_CROSS = $("#popup-edit-resume .modal-header button");

    //-------------Schedule work------------//
    public static SelenideElement MODAL_WINDOW_EDIT_SCHEDULE_WORK = $("#popup-edit-schedule .modal-content");
    public static SelenideElement MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK = $("#popup-edit-schedule .modal-title");
    public static SelenideElement MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK = $(".all-days-container .field-start-time");
    public static SelenideElement MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK = $(".all-days-container .field-end-time");
    public static SelenideElement MODAL_WINDOW_EDIT_TIME_HOUR_UP = $("tr:first-child td:first-child span");
    public static SelenideElement MODAL_WINDOW_EDIT_TIME_MINUTE_UP = $("tr:first-child td:nth-child(3) span");
    public static SelenideElement MODAL_WINDOW_EDIT_BUTTON_SAVE_SCHEDULE_WORK = $("#popup-edit-schedule .btn-primary");
    public static SelenideElement MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-schedule .modal-footer .btn-secondary");
    public static SelenideElement MODAL_WINDOW_EDIT_ICON_CROSS = $("#popup-edit-schedule .close");


    //-------------Devices------------------//

    public static SelenideElement MODAL_WINDOW_DEVICE = $("#popup-add-environment .modal-content");
    public static SelenideElement MODAL_WINDOW_DEVICE_TITLE = $("#popup-add-environment .modal-title");
    public static SelenideElement TYPE_PC = $("#parentTypeAdd .m-input");
    public static SelenideElement TABLE_FIELD_OS = $(".m-datatable__body tr:first-child td:nth-child(4)");
    public static SelenideElement TABLE_ICON_TRASH = $(".m-datatable__body tr:first-child a:nth-child(2)");
    public static SelenideElement TABLE_ICON_EDIT = $(".m-datatable__body tr:first-child .edit-environment");
    public static SelenideElement BUTTON_DELETE_DEVICE = $("#popup-delete-environment .btn-primary");

    public static SelenideElement TYPE_OS = $("#popup-add-environment [name = 'version-os'");
    public static SelenideElement BUTTON_DEVICE_SAVE = $("#popup-add-environment .btn-primary");
    public static SelenideElement EDIT_WINDOW = $("#popup-delete-environment .modal-content");
    public static SelenideElement EDIT_WINDOW_OS = $("#parentOSAdd .m-input");
    public static SelenideElement EDIT_WINDOW_TITLE = $("#popup-delete-environment h5");
    public static SelenideElement EDIT_WINDOW_VERSION_OS = $("#popup-edit-environment [name='version-os']");
    public static SelenideElement EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-environment .modal-footer .btn-secondary");
    public static SelenideElement EDIT_WINDOW_ICON_CROSS = $("#popup-edit-environment .close");


    //--------------Contacts-----------------//

    public static SelenideElement MODAL_WINDOW_EDIT_CONTACTS = $("#popup-edit-contact .modal-content");
    public static SelenideElement TITLE_MODAL_WINDOW_EDIT_CONTACTS = $("#popup-edit-contact .modal-title");
    public static SelenideElement MODAL_EDIT_PHONE_FIELD = $(".row #phone");
    public static SelenideElement MODAL_EDIT_SKYPE_FIELD = $(".row #skype");
    public static SelenideElement MODAL_EDIT_SAVE_BUTTON = $("#popup-edit-contact .update-contact-info");
    public static SelenideElement MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-contact .modal-footer .btn-secondary");
    public static SelenideElement MODAL_EDIT_ICON_CROSS = $("#popup-edit-contact .close");


}
