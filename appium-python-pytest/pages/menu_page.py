#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

from pages.base_page import BasePage
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriver, WebElement

class MenuPage(BasePage):

    def __init__(self, driver: WebDriver):
        super().__init__(driver)

    def _verify_page_loaded_correctly(self):
        pass
