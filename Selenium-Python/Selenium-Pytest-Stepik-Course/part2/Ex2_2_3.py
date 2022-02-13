from selenium import webdriver
from selenium.webdriver.common.by import By
import time


def test_sum_numbers():
    """
        Открыть страницу http://suninjuly.github.io/selects1.html
        Посчитать сумму заданных чисел
        Выбрать в выпадающем списке значение равное расчитанной сумме
        Нажать кнопку "Submit"
    """
    # link = "http://suninjuly.github.io/selects1.html"
    link = "http://suninjuly.github.io/selects2.html"
    browser = webdriver.Chrome(r'..\drivers\chromiumdriver98\chromedriver')
    try:
        browser.get(link)
        # определяем числа
        first_num = int(browser.find_element(By.ID, "num1").text)
        second_num = int(browser.find_element(By.ID, "num2").text)
        # считаем сумму
        sum = str(first_num + second_num)
        # выбираем результат из выпадающего списка
        browser.find_element(By.ID, "dropdown").click()
        browser.find_element(By.CSS_SELECTOR, f'[value="{sum}"]').click()
        # Отправляем заполненную форму
        browser.find_element(By.CSS_SELECTOR, "button.btn").click()
        # Проверяем, что смогли зарегистрироваться
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


if __name__ == "__main__":
    test_sum_numbers()
