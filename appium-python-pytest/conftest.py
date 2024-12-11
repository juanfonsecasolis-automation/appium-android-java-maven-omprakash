#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

import pytest
from helpers.driver_manager import get_driver
from pages.base_page import BasePage

def pytest_addoption(parser):

    parser.addoption(
        "--platform", 
        action="store", 
        default="Android", 
        help="Platform to execute the tests (for instance, Android).") 
     
@pytest.fixture
def params(request):
    params = {}
    params['platform'] = request.config.getoption("--platform")
    return params

@pytest.fixture()
def driver(params):
    # set-up
    driver = get_driver(params)
    yield driver
    # teardown
    driver.stop_client()