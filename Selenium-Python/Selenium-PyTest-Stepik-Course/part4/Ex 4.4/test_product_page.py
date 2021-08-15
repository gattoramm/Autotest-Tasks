from pages.product_page import ProductPage
import pytest

link = "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/"
parameters = [
    '?promo=offer0',
    '?promo=offer1',
    '?promo=offer2',
    '?promo=offer3',
    '?promo=offer4',
    '?promo=offer5',
    '?promo=offer6',
    pytest.param('?promo=offer7', marks=pytest.mark.xfail),
    '?promo=offer8',
    '?promo=offer9',
]

 
@pytest.mark.parametrize('parameter', parameters)
def test_guest_can_add_product_to_basket(browser, parameter):
    page = ProductPage(browser, f"{link}{parameter}")

    page.open()
    page.should_be_basket_form()

    page.add_to_basket()
    page.should_be_equal_book_name()
    page.should_be_equal_book_price()