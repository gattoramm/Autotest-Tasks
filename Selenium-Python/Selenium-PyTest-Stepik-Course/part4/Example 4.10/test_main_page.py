from pages.main_page import MainPage
from pages.login_page import LoginPage
from pages.product_page import ProductPage

link = "http://selenium1py.pythonanywhere.com/"

# 
def test_guest_can_go_to_login_page(browser):
    page = MainPage(browser, link) 
    page.open()
    page.go_to_login_page()
    login_page = LoginPage(browser, browser.current_url)
    login_page.should_be_login_page()

# 
def test_guest_should_see_login_link(browser):
    page = MainPage(browser, link)
    page.open()
    page.should_be_login_link()

# 
def test_guest_can_go_to_login(browser):
    page = LoginPage(browser, link) 
    page.open()
    page.should_be_login_page()

def test_guest_cant_see_product_in_basket_opened_from_main_page(browser):
    page = ProductPage(browser, link)
    page.open()
    page.go_to_basket()
    page.should_not_be_product_in_basket()
    page.should_not_be_success_message_in_basket()

def test_guest_cant_see_product_in_basket_opened_from_product_page(browser):
    link = "http://selenium1py.pythonanywhere.com/en-gb/catalogue/the-city-and-the-stars_95/"
    page = ProductPage(browser, link)
    page = ProductPage(browser, link)
    page.open()
    page.go_to_basket()
    page.should_not_be_product_in_basket()
    page.should_not_be_success_message_in_basket()
