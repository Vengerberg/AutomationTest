package pages;

public enum XPaths {

    // Login XPaths
    LOGIN_EMAIL_FIELD("//form[contains(@action, '/login')]//input[contains(@type, 'email')]"),
    LOGIN_PASSWORD_FIELD("//form[contains(@action, '/login')]//input[contains(@type, 'password')]"),
    LOGIN_BUTTON("//form[contains(@action, '/login')]//button"),
    LOGIN_SIGN_UP_NAME_FIELD("//form[contains(@action, '/signup')]//input[contains(@type, 'text')]"),
    LOGIN_SIGNUP_EMAIL_FIELD("//form[contains(@action, '/signup')]//input[contains(@type, 'email')]"),
    LOGIN_SIGNUP_BUTTON("//form[contains(@action, '/signup')]//button"),
    LOGIN_INVALID_MESSAGE("//p[contains(text(), 'incorrect')]"),
    LOGIN_HOME_BUTTON("//a[contains(text(), 'Home')]"),

    // Account Created XPaths
    ACCOUNT_CREATION_CONFIRMATION_MESSAGE("//p[contains(text(), 'Congratulations')]"),
    ACCOUNT_CREATION_CONTINUE_BUTTON("//a[contains(@data-qa, 'continue-button')]"),

    // Signup XPaths
    SIGNUP_NAME_FIELD("//form//input[contains(@id, 'name')]"),
    SIGNUP_EMAIL_FIELD("//form//input[contains(@id, 'email')]"),
    SIGNUP_PASSWORD_FIELD("//form//input[contains(@id, 'password')]"),
    SIGNUP_BIRTH_DATE_DAY("//form//select[contains(@id, 'days')]"),
    SIGNUP_BIRTH_DATE_MONTH("//form//select[contains(@id, 'month')]"),
    SIGNUP_BIRTH_DATE_YEAR("//form//select[contains(@id, 'year')]"),
    SIGNUP_FIRST_NAME_FIELD("//form//input[contains(@id, 'first_name')]"),
    SIGNUP_LAST_NAME_FIELD("//form//input[contains(@id, 'last_name')]"),
    SIGNUP_ADDRESS_FIELD("//form//input[contains(@id, 'address1')]"),
    SIGNUP_COUNTRY_FIELD("//form//select[contains(@id, 'country')]"),
    SIGNUP_STATE_FIELD("//form//input[contains(@id, 'state')]"),
    SIGNUP_CITY_FIELD("//form//input[contains(@id, 'city')]"),
    SIGNUP_ZIP_FIELD("//form//input[contains(@id, 'zip')]"),
    SIGNUP_MOBILE_PHONE_FIELD("//form//input[contains(@id, 'mobile')]"),
    SIGNUP_CREATE_ACCOUNT_BUTTON("//form//button[contains(@data-qa, 'create-account')]"),
    SIGNUP_EMAIL_EXISTS_MESSAGE("//p[contains(text(), 'Email Address already exist')]"),

    // Product XPaths
    PRODUCT_ADDED_TEXT("//div[contains(@class,'modal show')]"),
    PRODUCT_SEARCH_FIELD("//input[contains(@name, 'search')]"),
    PRODUCT_SEARCH_BUTTON("//button[contains(@id, 'submit_search')]"),

    // Details XPaths
    DETAILS_PRODUCT_ADDED_TEXT("//div[contains(@class,'modal show')]"),
    DETAILS_POPUP_VIEW_CART("//div[contains(@class,'modal show')]//a[contains(@href, '/view_cart')]"),
    DETAILS_PRODUCT_BUTTON("//button[contains(@class,'btn btn-default cart')]"),
    DETAILS_QUANTITY("//input[contains(@id,'quantity')]"),
    DETAILS_PRODUCT_NAME("//div[contains(@class, 'product-information')]//h2"),
    DETAILS_PRODUCT_COST("//div[contains(@class, 'product-information')]//span//span"),
    DETAILS_REVIEW_NAME("//input[contains(@id, 'name')]"),
    DETAILS_REVIEW_EMAIL("//input[contains(@id, 'email')]"),
    DETAILS_COMMENT("//textarea[contains(@name, 'review')]"),
    DETAILS_REVIEW_SUBMIT("//button[contains(text(), 'Submit')]"),
    DETAILS_REVIEW_SUCCESS_MSG("//div[@class='form-row']//span[contains(text(), 'Thank you')]"),

    // Payment XPaths
    PAYMENT_NAME("//input[contains(@name, 'name_on_card')]"),
    PAYMENT_CARD("//input[contains(@name, 'card_number')]"),
    PAYMENT_CVC("//input[contains(@name, 'cvc')]"),
    PAYMENT_EXP_MONTH("//input[contains(@name, 'expiry_month')]"),
    PAYMENT_EXP_YEAR("//input[contains(@name, 'expiry_year')]"),
    PAYMENT_SUBMIT("//button[contains(@id, 'submit')]"),

    // Payment Done XPaths
    PAYMENT_DONE_ORDER_PLACED("//b[contains(text(), 'Order Placed')]"),
    PAYMENT_DONE_CONGRATS_MSG("//p[contains(text(), 'Congratulations')]"),
    PAYMENT_DONE_CONTINUE("//a[contains(@class, 'btn btn-primary')]"),

    // Home XPaths
    HOME_LOGIN_BTN("//*[contains(@href,'/login')]"),
    HOME_CONTINUE_SHOPPING("//div[contains(@class,'modal show')]//button[contains(@class, 'btn-success')]"),
    HOME_PRODUCT_ADDED("//div[contains(@class,'modal show')]"),
    HOME_POPUP_VIEW_CART("//div[contains(@class,'modal show')]//a[contains(@href, '/view_cart')]"),
    HOME_VIEW_CART("//div[contains(@class, 'col-sm-8')]//a[contains(@href, '/view_cart')]"),
    HOME_LOGOUT_BTN("//a[contains(@href, '/logout')]"),
    HOME_DELETE_BTN("//a[contains(@href, '/delete_account')]"),

    // Delete XPaths
    DELETE_ACCOUNT_DELETED_HEADER("//b[contains(text(), 'Account Deleted!')]"),
    DELETE_ACCOUNT_DELETED_MESSAGE("//p[contains(text(), 'account has been permanently deleted')]"),

    // Checkout XPaths
    CHECKOUT_DELIVERY_NAME("//ul[contains(@id, 'address_delivery')]//li[contains(@class, 'address_firstname address_lastname')]"),
    CHECKOUT_DELIVERY_ADDRESS("//ul[contains(@id, 'address_delivery')]//li[contains(@class, 'address_address1 address_address2') and string-length(text()) > 0]"),
    CHECKOUT_DELIVERY_STATE_CITY_ZIP("//ul[contains(@id, 'address_delivery')]//li[contains(@class, 'address_city address_state_name address_postcode')]"),
    CHECKOUT_DELIVERY_COUNTRY("//ul[contains(@id, 'address_delivery')]//li[contains(@class, 'address_country_name')]"),
    CHECKOUT_DELIVERY_PHONE("//ul[contains(@id, 'address_delivery')]//li[contains(@class, 'address_phone')]"),
    CHECKOUT_INVOICE_NAME("//ul[contains(@id, 'address_invoice')]//li[contains(@class, 'address_firstname address_lastname')]"),
    CHECKOUT_INVOICE_ADDRESS("//ul[contains(@id, 'address_invoice')]//li[contains(@class, 'address_address1 address_address2') and string-length(text()) > 0]"),
    CHECKOUT_INVOICE_STATE_CITY_ZIP("//ul[contains(@id, 'address_invoice')]//li[contains(@class, 'address_city address_state_name address_postcode')]"),
    CHECKOUT_INVOICE_COUNTRY("//ul[contains(@id, 'address_invoice')]//li[contains(@class, 'address_country_name')]"),
    CHECKOUT_INVOICE_PHONE("//ul[contains(@id, 'address_invoice')]//li[contains(@class, 'address_phone')]"),
    CHECKOUT_PRODUCT_TOTALS("//table[contains(@class, 'table table-condensed')]//tr[contains(@id, 'product')]//p[contains(@class, 'cart_total_price')]"),
    CHECKOUT_CART_TOTAL("//b[contains(text(), 'Total Amount')]//..//..//..//p[contains(@class, 'cart_total_price')]"),
    CHECKOUT_PLACE_ORDER_BTN("//a[contains(@href, '/payment')]"),

    // Category XPaths
    PRODUCTS("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]"),

    // Cart XPaths
    CART_CHECKOUT_BTN("//a[contains(text(), 'Proceed To Checkout')]"),
    CART_CONTINUE_BTN("//div[contains(@class, 'modal show')]//button"),
    CART_REMOVE_BTN("//a[contains(@class, 'cart_quantity_delete')]"),
    CART_PRODUCTS("//table[contains(@class, 'table table-condensed')]//tr[contains(@id, 'product')]"),
    CART_EMPTY_MSG("//span[contains(@id, 'empty_cart') and contains(@style, 'block')]");

    private String xpath;

    XPaths(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return this.xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}