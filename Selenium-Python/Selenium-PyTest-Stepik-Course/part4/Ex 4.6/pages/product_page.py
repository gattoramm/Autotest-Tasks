from .base_page import BasePage
from .locators import ProductPageLocators
from selenium.webdriver.support.ui import WebDriverWait
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support import expected_conditions as EC


class ProductPage(BasePage):

    # Проверка наличия формы корзины
    def should_be_basket_form(self):
        assert self.is_element_present(\
            *ProductPageLocators.BASKET_FORM), "Basket Form is not presented"

    # Добавление товара в корзину
    def add_to_basket(self):
        link = self.browser.find_element(*ProductPageLocators.BASKET_FORM)
        link.click()
        # Расчет значения для alert'а
        self.solve_quiz_and_get_code()

    # Проверка названия товара после добавления в корзину 
    def should_be_equal_book_name(self):
        book_name_before = self.browser.find_element(\
            *ProductPageLocators.BOOK_NAME_BEFORE_ADD_TO_BASKET).text
        book_name_after = self.browser.find_element(\
            *ProductPageLocators.BOOK_NAME_AFTER_ADD_TO_BASKET).text

        assert book_name_before == book_name_after, \
            f"wrong product name: {book_name_after} != {book_name_before}"

    # Проверка стоимости товара после добавления в корзину 
    def should_be_equal_book_price(self):
        book_price_before = self.browser.find_element(\
            *ProductPageLocators.BOOK_PRICE_BEFORE_ADD_TO_BASKET).text
        book_price_after = self.browser.find_element(\
            *ProductPageLocators.BOOK_PRICE_AFTER_ADD_TO_BASKET).text

        assert book_price_before == book_price_after, \
            f"wrong product cost: {book_price_after} != {book_price_before}"
        
    # Проверка элемента - не появляется
    def should_not_be_success_message(self):
        assert self.is_not_element_present(\
            *ProductPageLocators.SUCCESS_MESSAGE),\
                "Success message is presented, but should not be"

    # Проверка элемента - исчезает  
    def should_be_success_message(self):
        assert self.is_disappeared(*ProductPageLocators.SUCCESS_MESSAGE),\
            "Success message is not presented, but should be"
