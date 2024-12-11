#
# Copyright November 2024 Juan M. Fonseca-Solís.
# Appium/PyTest minimum working example (MWE).
#

from appium.options.android import UiAutomator2Options
from appium import webdriver
from appium.webdriver import Remote
from appium.webdriver.appium_connection import AppiumConnection
from selenium.webdriver.remote.client_config import ClientConfig

APPIUM_HOST = '127.0.0.1'
APPIUM_PORT = 4723

def get_driver(params: dict) -> Remote:
    driver = None
    if params['platform']=='Android':
        return get_android_driver()
    else:
        raise NotImplementedError('Unknown webdriver.')

def get_android_driver() -> Remote:
    options = UiAutomator2Options()
    options.device_name = 'SmallPhoneAPI35'
    options.platform_name = 'Android'
    options.load_capabilities(
        {
            'appium:app': '/usr/local/appium-inspector/ApiDemos-debug.apk'
        }
    )
    client_config = ClientConfig(
        remote_server_addr = f'http://{APPIUM_HOST}:{APPIUM_PORT}',
        ignore_certificates = True
    )
    appium_connector = AppiumConnection(client_config=client_config)
    return Remote(appium_connector, options=options)