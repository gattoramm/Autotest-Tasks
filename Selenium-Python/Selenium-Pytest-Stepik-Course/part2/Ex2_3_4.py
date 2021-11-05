from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import math

"""
    Открыть страницу http://suninjuly.github.io/alert_accept.html
    Нажать на кнопку
    Принять confirm
    На новой странице решить капчу для роботов, чтобы получить число с ответом
"""

try:
    link = "http://suninjuly.github.io/alert_accept.html"

    browser = webdriver.Chrome()
    browser.get(link)

    # нажимаем кнопку
    browser.find_element(By.CSS_SELECTOR, "button.btn").click()

    # принимаем confirm
    confirm = browser.switch_to.alert
    confirm.accept()

    # определяем значение переменной
    value = int(browser.find_element(By.ID, "input_value").text)

    # считаем формулу
    result = str(math.log(abs(12*math.sin(value))))

    # вписываем результат
    browser.find_element(By.ID, "answer").send_keys(result)

    # отправляем заполненную форму
    browser.find_element(By.CSS_SELECTOR, "button.btn").click()

    # проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(2)

    # Получает ответ
    print(browser.switch_to.alert.text.split()[-1])
except Exception as error:
    print(f'Trace error: {error}')

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(2)
    # закрываем браузер после всех манипуляций
    browser.quit()
