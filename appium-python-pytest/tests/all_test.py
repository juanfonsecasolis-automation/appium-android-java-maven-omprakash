#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

import pytest
from pages.menu_page import MenuPage
from appium.webdriver import Remote

class TestMenu:

    @pytest.mark.positiveTests
    def test_menu(self, driver: Remote):
        assert 1==1