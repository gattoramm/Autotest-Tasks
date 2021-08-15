from .base_page import BasePage
from .locators import ProductPageLocators


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
        book_name = self.browser.find_element(*ProductPageLocators.BOOK_NAME).text

        assert book_name == "The shellcoder's handbook", f"wrong product name: {book_name} != The shellcoder's handbook"

    # Проверка стоимости товара после добавления в корзину 
    def should_be_equal_book_price(self):
        book_price = self.browser.find_element(*ProductPageLocators.BOOK_PRICE).text[1:]

        assert book_price == "9.99", f"wrong product cost: {book_price} != 9.99"