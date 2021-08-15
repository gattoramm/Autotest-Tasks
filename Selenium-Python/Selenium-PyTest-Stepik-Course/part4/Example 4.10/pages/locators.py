from selenium.webdriver.common.by import By

class MainPageLocators():
    LOGIN_LINK = (By.CSS_SELECTOR, "#login_link")
    
class LoginPageLocators():
    LOGIN_URL = (By.CSS_SELECTOR, "#login_link")
    LOGIN_FORM = (By.CSS_SELECTOR, "#login_form")
    REGISTER_FORM = (By.CSS_SELECTOR, "#register_form")

class ProductPageLocators():
    BASKET_FORM = (By.CSS_SELECTOR, "#add_to_basket_form")
    PRODUCT_IN_BASKET = (By.CSS_SELECTOR, ".basket_summary")
    PRODUCT_TEXT_IN_BASKET = (By.CSS_SELECTOR, ".col-sm-4 h3 a")

    BOOK_NAME_BEFORE_ADD_TO_BASKET = (By.CSS_SELECTOR, ".col-sm-6.product_main > h1")
    BOOK_NAME_AFTER_ADD_TO_BASKET = (By.CSS_SELECTOR, "div.alertinner strong")
    
    BOOK_PRICE_BEFORE_ADD_TO_BASKET = (By.CSS_SELECTOR, ".col-sm-6.product_main > p.price_color")
    BOOK_PRICE_AFTER_ADD_TO_BASKET = (By.CSS_SELECTOR, ".alert-info .alertinner strong")

    SUCCESS_MESSAGE = (By.CSS_SELECTOR, "#messages > div:nth-child(1) > div")

class BasePageLocators():
    LOGIN_LINK = (By.CSS_SELECTOR, "#login_link")
    LOGIN_LINK_INVALID = (By.CSS_SELECTOR, "#login_link")

    BASKET_LINK = (By.CSS_SELECTOR, ".btn-group > a.btn.btn-default")