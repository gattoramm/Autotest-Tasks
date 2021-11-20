import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

link = "http://selenium1py.pythonanywhere.com/"


@pytest.fixture
def browser():
    print("\nstart browser for test..")
    print("--------------START--------------")
    browser = webdriver.Chrome()
    yield browser
    print("\nquit browser..")
    print("--------------STOP---------------")
    browser.quit()

@pytest.fixture(autouse=True)
def prepare_data():
    print("\npreparing some critical data for every test")


class TestMainPage1():
    def test_guest_should_see_login_link(self, browser):
        # не передаём как параметр фикстуру prepare_data, но она все равно выполняется
        browser.get(link)
        browser.find_element(By.ID, "login_link")
        print("--------------test_guest_should_see_login_link--------------")

    def test_guest_should_see_basket_link_on_the_main_page(self, browser):
        browser.get(link)
        browser.find_element(By.CSS_SELECTOR, ".basket-mini .btn-group > a")
        print("--------------test_guest_should_see_basket_link_on_the_main_page--------------")
