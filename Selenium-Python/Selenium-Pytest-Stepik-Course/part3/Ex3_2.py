import unittest

from selenium import webdriver
from selenium.webdriver.common.by import By
import time

"""
    Тест успешно проходит на странице http://suninjuly.github.io/registration1.html
    Тест падает с ошибкой NoSuchElementException http://suninjuly.github.io/registration2.html
    Используемые селекторы должны быть уникальны
"""

firstname = "firstname"
lastname = "lastname"
email = "mail321@123mail.com"
asserted_text = "Congratulations! You have successfully registered!"

link1 = "http://suninjuly.github.io/registration1.html"
link2 = "http://suninjuly.github.io/registration2.html"

browser = webdriver.Chrome()

def input_fields(link):
    browser.get(link)

    # заполняем поля
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.first").send_keys(firstname)
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.second").send_keys(lastname)
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.third").send_keys(email)

    # Отправляем заполненную форму
    browser.find_element(By.CSS_SELECTOR, "button.btn").click()

    # Проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(1)

    # возвращаем текст из элемента
    return browser.find_element(By.TAG_NAME, "h1").text


class TestElement(unittest.TestCase):
    def test_exist_element(self):
        # проверяем, что ожидаемый текст совпадает с текстом на странице сайта
        self.assertEqual(asserted_text, input_fields(link1), "registration is failed")

    def test_noexist_element(self):
        # проверяем, что ожидаемый текст совпадает с текстом на странице сайта
        self.assertEqual(asserted_text, input_fields(link2), "registration is failed")

if __name__ == "__main__":
    try:
        unittest.main()
    finally:
        # ожидание чтобы визуально оценить результаты прохождения скрипта
        time.sleep(1)
        # закрываем браузер после всех манипуляций
        browser.quit()
