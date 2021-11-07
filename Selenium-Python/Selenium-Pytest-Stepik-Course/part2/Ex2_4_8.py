from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
import math

"""
    Открыть страницу http://suninjuly.github.io/explicit_wait2.html
    Дождаться, когда цена дома уменьшится до $100 (ожидание нужно установить не меньше 12 секунд)
    Нажать на кнопку "Book"
    Решить уже известную нам математическую задачу (используйте ранее написанный код) и отправить решение
"""

link = "http://suninjuly.github.io/explicit_wait2.html"
whaiting_price = "$100"

browser = webdriver.Chrome()

try:
    browser.get(link)

    # ожидаем нужной цены
    WebDriverWait(browser, 13).until(EC.text_to_be_present_in_element((By.ID, "price"), whaiting_price))

    # нажимаем кнопку
    browser.find_element(By.ID, "book").click()

    # определяем значение переменной
    value = int(browser.find_element(By.ID, "input_value").text)

    # считаем формулу
    result = str(math.log(abs(12*math.sin(value))))

    # вписываем результат
    browser.find_element(By.ID, "answer").send_keys(result)

    # Отправляем зданные
    browser.find_element(By.ID, "solve").click()

    # проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(1)

    # Получает ответ
    print(browser.switch_to.alert.text.split()[-1])

    browser.switch_to.alert.accept()

except Exception as error:
    print(f'Trace error: {error}')

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(1)
    # закрываем браузер после всех манипуляций
    browser.quit()
