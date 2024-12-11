#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

import pytest
from pages.menu_page import MenuPage
from selenium.webdriver.support.wait import WebDriver

class TestLogin:

    @pytest.mark.positiveTests
    def test_negative_login(self, driver: WebDriver):
        assert 1==1