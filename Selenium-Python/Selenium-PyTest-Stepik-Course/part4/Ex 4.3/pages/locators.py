from selenium.webdriver.common.by import By


class ProductPageLocators():
    BASKET_FORM = (By.CSS_SELECTOR, "#add_to_basket_form")

    BOOK_NAME_BEFORE_ADD_TO_BASKET = (By.CSS_SELECTOR, ".col-sm-6.product_main > h1")
    BOOK_NAME_AFTER_ADD_TO_BASKET = (By.CSS_SELECTOR, "div.alertinner strong")
    
    BOOK_PRICE_BEFORE_ADD_TO_BASKET = (By.CSS_SELECTOR, ".col-sm-6.product_main > p.price_color")
    BOOK_PRICE_AFTER_ADD_TO_BASKET = (By.CSS_SELECTOR, ".alert-info .alertinner strong")
    