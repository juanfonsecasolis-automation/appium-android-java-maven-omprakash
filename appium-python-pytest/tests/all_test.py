#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

import pytest
from pages.menu_page import MenuPage
from appium.webdriver import Remote
from appium.webdriver.appium_service import AppiumService

class TestMenu:

    @pytest.mark.positiveTests
    def test_menu(self, appium_service: AppiumService, driver: Remote):
        assert 1==1