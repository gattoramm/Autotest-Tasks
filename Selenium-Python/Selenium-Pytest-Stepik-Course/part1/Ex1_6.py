from selenium import webdriver
from selenium.webdriver.common.by import By
import time

"""
    Тест успешно проходит на странице http://suninjuly.github.io/registration1.html
    Тест падает с ошибкой NoSuchElementException http://suninjuly.github.io/registration2.html
    Используемые селекторы должны быть уникальны
"""


try:
    # link = "http://suninjuly.github.io/registration1.html"
    link = "http://suninjuly.github.io/registration1.html"
    firstname = "firstname"
    lastname = "lastname"
    email = "mail321@123mail.com"

    browser = webdriver.Chrome()
    browser.get(link)

    # заполняем поля
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.first").send_keys(firstname)
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.second").send_keys(lastname)
    browser.find_element(By.CSS_SELECTOR, ".first_block .form-control.third").send_keys(email)

    # Отправляем заполненную форму
    browser.find_element(By.CSS_SELECTOR, "button.btn").click()

    # Проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(2)

    # записываем в переменную welcome_text текст из элемента
    welcome_text = browser.find_element(By.TAG_NAME, "h1").text

    # проверяем, что ожидаемый текст совпадает с текстом на странице сайта
    assert "Congratulations! You have successfully registered!" == welcome_text

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(2)
    # закрываем браузер после всех манипуляций
    browser.quit()
