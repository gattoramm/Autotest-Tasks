from pages.product_page import ProductPage

link = "http://selenium1py.pythonanywhere.com/catalogue/the-shellcoders-handbook_209/?promo=newYear"

def test_guest_can_add_product_to_basket(browser):
    page = ProductPage(browser, link)

    page.open()
    page.should_be_basket_form()

    page.add_to_basket()
    page.should_be_equal_book_name()
    page.should_be_equal_book_price()