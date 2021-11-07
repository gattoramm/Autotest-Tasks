from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import os

"""
    Открыть страницу http://suninjuly.github.io/file_input.html
    Заполнить текстовые поля: имя, фамилия, email
    Загрузить файл. Файл должен иметь расширение .txt и может быть пустым
    Нажать кнопку "Submit"
"""

link = "http://suninjuly.github.io/file_input.html"
firstname = "firstname"
lastname = "lastname"
email = "mail321@123mail.com"

browser = webdriver.Chrome()

try:
    browser.get(link)

    # заполняем поля
    browser.find_element(By.NAME, "firstname").send_keys(firstname)
    browser.find_element(By.NAME, "lastname").send_keys(lastname)
    browser.find_element(By.NAME, "email").send_keys(email)

    # выбираем файл
    current_dir = os.path.abspath(os.path.dirname(__file__))
    file_path = os.path.join(current_dir, 'file.txt')

    # загружаем файл
    browser.find_element(By.ID, "file").send_keys(file_path)

    # отправляем заполненную форму
    browser.find_element(By.CSS_SELECTOR, "button.btn").click()

    # проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(2)

    # Получает ответ
    print(browser.switch_to.alert.text.split()[-1])

    browser.switch_to.alert.accept()

except Exception as error:
    print(f'Trace error: {error}')

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(2)
    # закрываем браузер после всех манипуляций
    browser.quit()
