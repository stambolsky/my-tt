package ru.ql.tt.Base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CssLocators {
    //------------Authorization------------//


    public static SelenideElement LOGIN = $("#username");
    public static SelenideElement PASSWORD = $("#password");
    public static SelenideElement SUBMIT = $("#_submit");
    public static SelenideElement AVATARCOVER = $("a .avatarCover");
    public static SelenideElement AVATAR_NAME = $(".m-card-user__details span:first-child");
    public static SelenideElement LINK_PROFILE = $(".m-nav__link-wrap span");


    //------------ProfilePage--------------//

    public static SelenideElement NAME_USER = $("//span[@id='headerName']");
    public static SelenideElement AVATAR = $("img.avatar");
    public static SelenideElement BUTTON_CREATE_RESUME = $(".m-portlet__head-title div a");
    public static SelenideElement HEADER = $("//div[contains(@class,'m-portlet__head m-stack m-stack--ver m-stack--general')]");
    public static SelenideElement LOGO = $("//div[@class='m-portlet']//div[@class='avatarCover']");
    public static SelenideElement FIRST_AND_LAST_NAME = $("//span[@id='headerName']");
    public static SelenideElement PROFILE_BUTTON_CREATE_RESUME = $("//a[@class='btn btn-brand m-btn']");
    public static SelenideElement BLOCK_MENU = $("//div[@class='m-stack__item m-stack__item--left m-stack--ver m-stack__item--middle m-stack__item--fluid']");
    public static SelenideElement TITLE_PROFILE = $(".m-subheader__title");
    public static SelenideElement BLOCK_RESUME = $(".m-portlet:nth-child(2)");
    public static SelenideElement BLOCK_RESUME_TITLE = $(".m-portlet:nth-child(2) .m-portlet__head-text");
    public static SelenideElement BLOCK_RESUME_BUTTON = $(".m-portlet:nth-child(2) button");
    public static SelenideElement BLOCK_RESUME_FAVICON_PLACE = $(".flaticon-user-ok");
    public static SelenideElement BLOCK_RESUME_TEXT_PLACE = $(".m-list-search__result-item-text.post-name");
    public static SelenideElement BLOCK_RESUME_FAVICON_SHORT = $(".flaticon-file-1");
    public static SelenideElement BLOCK_RESUME_TEXT_SHORT = $(".m-list-search__result-item-text.post-description");

    public static SelenideElement BLOCK_SCHEDULE_WORK = $("//div[@id='m_tabs_6_1']/div[@class='m-portlet'][2]");
    public static SelenideElement PROFILE_RESUME_FIELD_PLACE = $("//span[@class='m-list-search__result-item-text post-name']");
    public static SelenideElement PROFILE_RESUME_BUTTON_EDIT = $("//button[@type='button'][contains(text(),'Редактировать резюме')]");
    public static SelenideElement PROFILE_RESUME_SHORT_RESUME = $("//span[@class='m-list-search__result-item-text post-description']");
    public static SelenideElement SCHEDULE_WORK_BLOCK = $(".m-portlet:nth-child(3)");
    public static SelenideElement SCHEDULE_WORK_BLOCK_TITLE = $(".m-portlet:nth-child(3) .m-portlet__head-text");
    public static SelenideElement SCHEDULE_WORK_BUTTON_EDIT = $(".m-portlet:nth-child(3) button");
    public static SelenideElement SCHEDULE_WORK_TABLE = $(".m-portlet:nth-child(3) .m-portlet__body");
    public static SelenideElement PROFILE_TABLE_TIME_MONDAY = $("//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']");
    public static SelenideElement CONTACTS_BLOCK = $(".m-portlet:nth-child(4)");
    public static SelenideElement CONTACTS_BLOCK_TITLE= $(".m-portlet:nth-child(4) .m-portlet__head-text");
    public static SelenideElement CONTACTS_BLOCK_BUTTON_EDIT= $(".m-portlet:nth-child(4) button");
    public static ElementsCollection CONTACTS_BLOCK_ICONS = $$(".m-portlet:nth-child(4) .inactive-default-icon");
    public static ElementsCollection CONTACTS_BLOCK_TEXT = $$(".m-portlet:nth-child(4) .m-list-search__result-item-text");
    public static SelenideElement PROFILE_CONTACTS_FIELD_PHONE = $("//a//span[@class='m-list-search__result-item-text phone']");
    public static SelenideElement PROFILE_CONTACTS_FIELD_SKYPE = $("//span[contains(@class,'m-list-search__result-item-text skype')]");
    public static SelenideElement PROFILE_CONTACTS_FIELD_EMAIL = $("//span[@class='m-list-search__result-item-text corporate-email']");

    public static SelenideElement BLOCK_DEVICES = $(".m-portlet:nth-child(5)");
    public static SelenideElement BLOCK_DEVICES_BUTTON_ADD = $(".m-portlet:nth-child(5) button");
    public static SelenideElement BLOCK_DEVICES_TITLE = $(".m-portlet:nth-child(5) h3");
    public static ElementsCollection BLOCK_DEVICES_TABLE = $$(".m-portlet:nth-child(5) #environment-container");


    //------------Window create resume------//

    public static SelenideElement WINDOW_RESUME_FIRST_NAME = $("//div[@class='fields']//div[3]/p[1]");
    public static SelenideElement WINDOW_RESUME_LAST_NAME = $("//div[@class='fields']//div[3]/p[2]");
    public static SelenideElement WINDOW_RESUME_PLACE = $("//div[@class='fields']//div[4]");


    //------------Resume--------------------//

    public static SelenideElement MODAL_WINDOW_EDIT_RESUME = $("#popup-edit-resume .modal-content");
    public static SelenideElement MODAL_WINDOW_EDIT_RESUME_TITLE = $("#popup-edit-resume .modal-title");
    public static SelenideElement MODAL_WINDOW_EDIT_TEXTAREA = $("//textarea[@id='post-description']");
    public static SelenideElement MODAL_WINDOW_EDIT_BUTTON_SAVE = $("//div[@id='popup-edit-resume']//button[2]");
    public static SelenideElement MODAL_WINDOW_EDIT_TIP_TEXTAREA = $("//form[@class='post-info']//div[3]");
    public static SelenideElement MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-resume .modal-footer button:first-child");
    public static SelenideElement MODAL_RESUME_EDIT_ICON_CROSS = $("//div[@id='popup-edit-resume']//button[@class='close']");

    //-------------Schedule work------------//
    public static SelenideElement MODAL_WINDOW_EDIT_SCHEDULE_WORK = $("#popup-edit-schedule .modal-content");
    public static SelenideElement MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK = $("#popup-edit-schedule .modal-title");
    public static SelenideElement MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK = $("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]");
    public static SelenideElement MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK = $("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]");
    public static SelenideElement MODAL_WINDOW_EDIT_TIME_HOUR_UP = $("//tbody//tr[1]//td[1]/a");
    public static SelenideElement MODAL_WINDOW_EDIT_TIME_MINUTE_UP = $("//tbody//tr[1]//td[3]/a");
    public static SelenideElement MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME = $("//div[@id='popup-edit-schedule']//button[2]");
    public static SelenideElement MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE = $("#popup-edit-schedule .modal-footer button:first-child");
    public static SelenideElement MODAL_WINDOW_EDIT_ICON_CROSS = $("//div[@id='popup-edit-schedule']//div[@class='modal-header']//button");


    //-------------Devices------------------//

    public static SelenideElement MODAL_WINDOW_DEVICE = $("#popup-add-environment .modal-content");
    public static SelenideElement MODAL_WINDOW_DEVICE_TITLE = $("#popup-add-environment .modal-title");
    public static SelenideElement MODAL_WINDOW_DEVICE_BUTTON_CLOSE_NOT_SAVE = $("#popup-add-environment .modal-footer button:first-child");
    public static SelenideElement BUTTON_ADD_DEVICES = $("//span[contains(text(),'Добавить устройство')]");
    public static SelenideElement TYPE_PC = $("//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]");
    public static SelenideElement TYPE_PHONE = $("//div[@id='parentTypeAdd']//option[@value='6'][contains(text(),'Телефон')]");
    public static SelenideElement PRODUCER_FIELD = $("//div[@id='popup-add-environment']//input[@name='manufacturer-device']");
    public static SelenideElement TABLE_FIELD_TYPE_PHONE = $("//td[contains(text(),'Телефон')]");
    public static SelenideElement TABLE_FIELD_TYPE_PC  = $("//td[contains(text(),'ПК')]");
    public static SelenideElement TABLE_TYPE_PRODUSER = $("//td[contains(text(),'APPLE')]");
    public static SelenideElement TABLE_ICON_TRASH = $("//tr[@class='m-datatable__row'][1]//a[2]");
    public static SelenideElement TABLE_ICON_EDIT = $("//tr[@class='m-datatable__row'][1]//a[1]");
    public static SelenideElement BUTTON_DELETE_DEVICE = $("//div[@id='popup-delete-environment']//div[@class='modal-footer']//button[2]");
    public static SelenideElement TABLE_MESSAGE_EMPTY = $("//div[@class='alert m-alert--default col-lg-12 no-items']");

    public static SelenideElement TYPE_OS_LINUX = $("//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]");
    public static SelenideElement BUTTON_DEVICE_SAVE = $("//div[@id='popup-add-environment']//button[@name='save']");
    public static SelenideElement EDIT_WINDOW_OS_ANDROID = $("//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]");
    public static SelenideElement EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE = $("//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]");
    public static SelenideElement EDIT_WINDOW_ICON_CROSS = $("//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']");


    //--------------Contacts-----------------//

    public static SelenideElement BUTTON_EDIT_CONTACTS = $("//button[contains(text(),'Редактировать контакты')]");
    public static SelenideElement MODAL_WINDOW_EDIT_CONTACTS = $("#popup-edit-contact .modal-content");
    public static SelenideElement MODAL_WINDOW_EDIT_CONTACTS_CLOSE_NOT_SAVE = $("#popup-edit-contact .modal-footer button:first-child");
    public static SelenideElement TITLE_MODAL_WINDOW_EDIT_CONTACTS = $("#popup-edit-contact .modal-title");
    public static SelenideElement MODAL_EDIT_PHONE_FIELD = $("//input[@id='phone']");
    public static SelenideElement MODAL_EDIT_SKYPE_FIELD = $("//input[@id='skype']");
    public static SelenideElement MODAL_EDIT_SAVE_BUTTON = $("//div[@id='popup-edit-contact']//button[2]");
    public static SelenideElement MODAL_EDIT_EMAIL = $("//input[@id='corporate-email']");
    public static SelenideElement MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE = $("//div[@id='popup-edit-contact']//button[contains(text(),'Закрыть без сохранения')]");
    public static SelenideElement MODAL_EDIT_ICON_CROSS = $("//div[@id='popup-edit-contact']//button[@class='close']");


}
