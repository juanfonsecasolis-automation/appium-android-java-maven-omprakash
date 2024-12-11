# appium-python-pytest
2024 Juan M. Fonseca-Solís

# Set up [1]
```
sudo apt-get install python3-venv
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

# Run [1]
```
source .venv/bin/activate 
pytest -m <testSuite> --browser='Chrome' --html=reports/report.html -n auto --headless='True'
deactive
```

# References
1. https://github.com/juanfonsecasolis-automation/python-selenium-pytest
2. https://github.com/appium/python-client