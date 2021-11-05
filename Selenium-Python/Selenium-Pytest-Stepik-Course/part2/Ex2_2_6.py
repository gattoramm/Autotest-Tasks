from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import math

"""
    Открыть страницу http://SunInJuly.github.io/execute_script.html.
    Считать значение для переменной x.
    Посчитать математическую функцию от x.
    Проскроллить страницу вниз.
    Ввести ответ в текстовое поле.
    Выбрать checkbox "I'm the robot".
    Переключить radiobutton "Robots rule!".
    Нажать на кнопку "Submit".
"""

try:
    link = "http://SunInJuly.github.io/execute_script.html"

    browser = webdriver.Chrome()
    browser.get(link)

    # определяем значение переменной
    value = int(browser.find_element(By.ID, "input_value").text)

    # считаем формулу
    result = str(math.log(abs(12*math.sin(value))))

    # вписываем результат
    browser.find_element(By.ID, "answer").send_keys(result)

    # скроллим вниз до кнопки Submit
    button = browser.find_element(By.CSS_SELECTOR, ".btn.btn")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)

    # выбираем checkbox
    browser.find_element(By.ID, "robotCheckbox").click()

    # переключаем radiobutton
    browser.find_element(By.ID, "robotsRule").click()

    # Отправляем заполненную форму
    button.click()

    # Проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(2)

    # Получает ответ
    print(browser.switch_to.alert.text.split()[-1])

except Exception as error:
    print(f'Trace error: {error}')

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(1)
    # закрываем браузер после всех манипуляций
    browser.quit()
