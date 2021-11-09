import pytest

from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import math

"""
    открыть страницу 
    ввести правильный ответ 
    нажать кнопку "Отправить" 
    дождаться фидбека о том, что ответ правильный 
    проверить, что текст в опциональном фидбеке полностью совпадает с "Correct!"
    Используйте маркировку pytest для параметризации и передайте в тест список ссылок в качестве параметров: 
        https://stepik.org/lesson/236895/step/1
        https://stepik.org/lesson/236896/step/1
        https://stepik.org/lesson/236897/step/1
        https://stepik.org/lesson/236898/step/1
        https://stepik.org/lesson/236899/step/1
        https://stepik.org/lesson/236903/step/1
        https://stepik.org/lesson/236904/step/1
        https://stepik.org/lesson/236905/step/1
"""

class TestMainPage():

    @classmethod
    def setup_class(self):
        print("\nstart browser for test suite..")
        self.browser = webdriver.Chrome()

    @classmethod
    def teardown_class(self):
        print("quit browser for test suite..")
        self.browser.quit()

    @pytest.mark.parametrize('lesson', ['236895', '236896', '236897', '236898', '236899', '236903', '236904', '236905'])
    def answer():
        return str(math.log(int(time.time())))


    @pytest.mark.parametrize('link', links)
    def test_stepik(self, link, answer):
        link = f'https://stepik.org/lesson/23{lesson}/step/1'
        pass
