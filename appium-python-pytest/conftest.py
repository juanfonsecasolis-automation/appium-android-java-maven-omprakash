#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

import pytest
from helpers.driver_manager import get_driver
from appium.webdriver.appium_service import AppiumService
from pages.base_page import BasePage

APPIUM_HOST = '127.0.0.1'
APPIUM_PORT = 4723

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
    params['appium_host'] = APPIUM_HOST
    params['appium_port'] = APPIUM_PORT
    return params

# fixture's below are shared across all tests [2]
@pytest.fixture(scope='session')
def appium_service():
    service = AppiumService()
    service.start(
        args = ['--address', APPIUM_HOST, '-p', str(APPIUM_PORT)],
        timeout_ms = 2e4
    )
    yield
    service.stop()

@pytest.fixture()
def driver(params):
    # set-up
    driver = get_driver(params)
    yield driver
    # teardown
    driver.stop_client()