from selenium.webdriver.common.by import By


class ProductPageLocators():
    BASKET_FORM = (By.CSS_SELECTOR, "#add_to_basket_form")

    BOOK_NAME = (By.CSS_SELECTOR, ".col-sm-6.product_main > h1")
    BOOK_PRICE = (By.CSS_SELECTOR, ".col-sm-6.product_main > p.price_color")
    